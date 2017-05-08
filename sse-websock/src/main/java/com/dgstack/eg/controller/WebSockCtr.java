package com.dgstack.eg.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.dgstack.eg.event.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

import com.dgstack.eg.event.Message;


public class WebSockCtr{

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        System.out.println("Input :: "+ message.getText());
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }

   /* @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage info(Message message) throws Exception {
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }*/

}