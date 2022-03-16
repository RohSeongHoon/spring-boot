//package com.devagit.springbootstudy.controller;
//
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.logging.Logger;
//
//
//public class WebSocketHandler extends TextWebSocketHandler {
//    private static final Logger LOG =Logger.getGlobal();
//    @Override
//    public void handleTextMessage(WebSocketSession webSocketSession, TextMessage message) throws Exception{
//        String input = message.getPayload();
//        LOG.info(input);
//        TextMessage textMessage = new TextMessage("테스트");
//        webSocketSession.sendMessage(textMessage);
//    }
//
//}
