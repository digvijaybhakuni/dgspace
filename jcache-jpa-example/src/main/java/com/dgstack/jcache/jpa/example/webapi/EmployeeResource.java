/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jcache.jpa.example.webapi;

import com.dgstack.jcache.jpa.example.model.Employee;
import com.dgstack.jcache.jpa.example.service.EmployeeService;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author digvijayb
 */
@Path("employee")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {
    
    @Inject
    private EmployeeService employeeService;
    
    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(final Employee emp){
        
        System.out.println("com.dgstack.jcache.jpa.example.webapi.EmployeeResource.save()");
        System.out.println("from service");
        final Employee e = employeeService.save(emp);
        
        return Response.ok(e).build();
    }
    
    
    @Path("/name/{name}")
    @GET
    public Response employeeByName(@PathParam("name") final String name){
        
        System.out.println("com.dgstack.jcache.jpa.example.webapi.EmployeeResource.employeeByName()");
        System.out.println("from service");
        final List<Employee> employees = employeeService.getEmployeeByName(name);
        
        return Response.ok(employees).build();
    }
    
}
