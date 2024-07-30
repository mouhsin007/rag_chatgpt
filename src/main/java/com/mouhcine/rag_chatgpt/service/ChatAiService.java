package com.mouhcine.rag_chatgpt.service;

import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@BrowserCallable
@AnonymousAllowed
public class ChatAiService {
    private ChatClient _chatClient;
    private SimpleVectorStore vectorStore;
    @Value("classpath:/prompts/prompt-template.st")
    private Resource promptResource;

    public ChatAiService(ChatClient.Builder builder, SimpleVectorStore vectorStore) {
        this._chatClient = builder.build();
        this.vectorStore = vectorStore;
    }

    public String ask(String question){
        List<Document> documents = vectorStore.similaritySearch(question);
        List<String> context = documents.stream().map(Document::getContent).toList();
        PromptTemplate promptTemplate = new PromptTemplate(promptResource);
        Prompt prompt = promptTemplate.create(Map.of("context", context, "question", question));

        return  _chatClient.prompt(prompt)
                .call().content();
    }
}
