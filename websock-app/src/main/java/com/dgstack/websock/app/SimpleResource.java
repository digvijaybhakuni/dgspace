/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.websock.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;



/**
 *
 * @author digvijayb
 */
@Path("simple")
public class SimpleResource {
    
   private MockService service;
    
   @Path("call")
   @GET
   public Response call(){
       if(service == null){
           service = new  MockService();
       }
       String val =  service.service(new String("TEST ME SIMPLE"));  
       return Response.ok(val, MediaType.TEXT_PLAIN).build();
   }
   
}
