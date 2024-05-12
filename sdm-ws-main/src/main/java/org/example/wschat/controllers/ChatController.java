package org.example.wschat.controllers;

import org.example.wschat.dto.Auction;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;
    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat.sendAuction")
    public void sendMessage(Auction auction) {
        messagingTemplate.convertAndSend("/topic/auctions", auction);
        System.out.println(auction.toString());
    }


    @Scheduled(fixedRate = 1000)
    public void checkAuctions() {

    }


}
