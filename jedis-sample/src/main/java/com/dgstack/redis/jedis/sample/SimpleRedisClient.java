/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.redis.jedis.sample;

import redis.clients.jedis.Jedis;

/**
 *
 * @author dbhakuni
 */
public class SimpleRedisClient {
    
    public static void main(String[] args) {
        
        Jedis jedis = new Jedis("localhost", 6379);
        
        jedis.append("redis.sample.myname", "Digvijay");
        
        
        String str = jedis.get("redis.sample.myname");
        String type = jedis.type("redis.sample.myname");
        
        System.out.println("str > "+ str);
        System.out.println("type > "+type);
                
                
    }
    
    
}
