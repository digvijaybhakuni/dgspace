/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.websock.app;

import com.dgstack.websock.ejb.AsyncBeanLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Asynchronous;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author digvijayb
 */
@Path("async")
public class AsyncResouce {
    
    @EJB
    private AsyncBeanLocal abl;
    
    
    @GET
    @Path("/index")
    public String index(){
        System.out.println(" Thread Group  " + Thread.currentThread());
        return "Async Resource";
    }
    
    @GET
    @Path("suspended")
    public void suspended(@Suspended AsyncResponse response){
        System.out.println(" METHOD IS START  " + Thread.currentThread());
        abl.compute(response);
        System.out.println(" METHOD IS DONE " + Thread.currentThread());
    }
    
    
}
