package com.example.webSocket_chat.controller;

import com.example.webSocket_chat.config.WebSocketConfig;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

// обрабатывает запросы
@Controller
public class ChatController {
    // указание эндпоинта
    @MessageMapping("/hello")
    // разошлет всем кто подписан на данную тему
    @SendTo("/topic/greetings")
    public String handleMessage(String message){
        return message;
    }
}
