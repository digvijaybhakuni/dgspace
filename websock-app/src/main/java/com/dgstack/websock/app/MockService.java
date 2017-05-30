/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.websock.app;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author digvijayb
 */
public class MockService {
 
    static AtomicInteger  counter =new  AtomicInteger(1);
    
    public String service(Object any){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MockService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (String.valueOf(any) + counter.incrementAndGet());
    }
    
}
