/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.jee7;
import com.dgstack.jee7.java.ParseJson;
import java.io.StringReader;
import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonReaderFactory;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;


/**
 *
 * @author digvijayb
 */
@Path("test")
public class TestClass {
    
    @POST
    @Path("json")
    public JsonObject test(final String postInput){
        
        final JsonReader jsonReader = Json.createReader(new StringReader(postInput));
        JsonObject readObject = jsonReader.readObject();
        ParseJson parseJson = new ParseJson();
        parseJson.streamJson(postInput);
        JsonArrayBuilder arrBuilder = Json.createArrayBuilder();
        parseJson.list.forEach(e -> arrBuilder.add(e));
        //readObject.put("KEYS", arrBuilder.build());
        JsonObjectBuilder obj = Json.createObjectBuilder().add("KEYS", arrBuilder);
        return obj.build();
    }
    
    
    
    @GET
    @Path("/")
    public String index(){
        return "INDEX";
    }
    
}
