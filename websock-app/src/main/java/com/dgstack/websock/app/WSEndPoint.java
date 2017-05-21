/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.websock.app;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * @author digvijayb
 */
@ServerEndpoint("/wsresource")
public class WSEndPoint {
    
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
