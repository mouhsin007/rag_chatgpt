package com.mouhcine.rag_chatgpt.web;

import com.mouhcine.rag_chatgpt.service.ChatAiService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class RagController {
    private ChatAiService chatAiService;

    public RagController(ChatAiService builder) {
        this.chatAiService = builder;
    }

    @GetMapping(value = "/ask",produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(String question){
        return  chatAiService.ask(question);
    }
}
