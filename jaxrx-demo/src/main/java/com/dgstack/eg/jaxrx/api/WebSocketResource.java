package com.dgstack.eg.jaxrx.api;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/wsresource")
public class WebSocketResource {
    
    @OnOpen
    public void openSession(Session session){
        System.out.println("opening session >> "+ session);
    }


    @OnMessage
    public String message(String msg, Session session){
        System.out.println("Messaging " + msg);

        return "Message : "+msg;
    }

    @OnClose
    public void closeSession(Session session){
        System.out.println("closing session >> "+ session);
    }

    public void error(Throwable e, Session session){
        System.out.println("Error " + e.getMessage());
    }

}