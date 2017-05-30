/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.websock.ejb;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.ws.rs.container.AsyncResponse;

/**
 *
 * @author dbhakuni
 */
@Stateless
@Asynchronous
public class AsyncBean implements AsyncBeanLocal {

    @Asynchronous
    public void compute(final AsyncResponse response) {
        int sum = 0;
        try {
            for (int i = 0; i < 10; i++) {
                sum += i;
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(AsyncBean.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println(" Finally Thread Group  " + Thread.currentThread());
            response.resume(Integer.valueOf(sum));
        }
    }
}
