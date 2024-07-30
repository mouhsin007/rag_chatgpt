package com.mouhcine.rag_chatgpt.web;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class RagController {
    private ChatClient _chatClient;

    public RagController(ChatClient.Builder builder) {
        this._chatClient = builder.build();
    }

    @GetMapping(value = "/ask",produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(String question){
        return  _chatClient.prompt().user(question)
                .call().content();
    }
}
