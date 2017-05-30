/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.websock.app;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

/**
 *
 * @author dbhakuni
 */
@Path("suspended")
public class SuspendedResource {
    
    @Inject
    private Executor executor;
    
    @GET
    @Path("/")
    public String index(){
        return "index";
    }
    
    
    @GET
    @Path("call")
    public void call(@Suspended final AsyncResponse response){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                String str = new MockService().service("Async Ops > ");
                response.resume(str);
            }
        });
    }
}
