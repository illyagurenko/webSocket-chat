package com.example.webSocket_chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
// данная конфигурация включает поддержку WebSocket и активирует брокер сообщений
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    // метод настраивает, как сообщения будут ходить между клиентом и сервером
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config){
        // создаем брокер, который подписывается на адреса с /topic
        config.enableSimpleBroker("/topic");
        // сообщения от клиента к серверу будут через .../app/...
        config.setApplicationDestinationPrefixes("/app");
    }

    // точка входа в WebSocket
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        // адрес к которому клиент обратиться
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }
}
