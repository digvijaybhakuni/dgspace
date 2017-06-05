/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jee7.restapi;

import com.dgstack.jee7.NewSessionBean;
import com.dgstack.jee7.ejb.ProjectEjb;
import com.dgstack.jee7.java.ParseJson;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 *
 * @author digvijayb
 */
@Path("projects")
public class Projects {

    @EJB
    NewSessionBean bean;
    
    @EJB
    ProjectEjb projectBean;

    @GET
    @Path("name/{name}") @Produces(MediaType.TEXT_HTML) 
    public String name(@PathParam("name") String name) {
        
        bean.businessMethod();
        
        return "name DIGGU : " + name;
    }
    
    @POST
    @Path("submit")
    @Consumes(MediaType.TEXT_PLAIN) 
    @Produces(MediaType.TEXT_PLAIN)
    public String test(final String postInput){
        final ParseJson parseJson = new ParseJson();
        parseJson.streamJson(postInput);
        return "DONE";
    }
    
    @GET
    @Path("test")
    @Produces(MediaType.TEXT_PLAIN)
    public String index(){
        return "ReSR";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allProject(){
        List<String> lst = projectBean.getAllProject();
        return Response.ok(lst).build();
        //response.resume(lst);
       
    }
    
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public void add(@FormParam("name") String name, @Suspended AsyncResponse response) {
        response.resume(projectBean.addProject(name));
        bean.businessMethod();
    }
    
    
               

}
