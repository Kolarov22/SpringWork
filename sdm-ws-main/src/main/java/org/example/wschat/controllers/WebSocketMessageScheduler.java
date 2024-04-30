package org.example.wschat.controllers;

import org.example.wschat.dto.Auction;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WebSocketMessageScheduler {
    private final SimpMessagingTemplate messagingTemplate;
    public WebSocketMessageScheduler(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
    @Scheduled(fixedDelay = 1000)
    public void sendMessageToWebSocketClients() {

    }
}
