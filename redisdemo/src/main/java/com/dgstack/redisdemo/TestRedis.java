/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dgstack.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

/**
 *
 * @author dbhakuni
 */
public class TestRedis implements CommandLineRunner {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void run(String... strings) throws Exception {
        ValueOperations<String, String> ops = this.stringRedisTemplate.opsForValue();
        String key = "spring.boot.redis.test";
        if (!this.stringRedisTemplate.hasKey(key)) {
            ops.set(key, "diggu");
        }
        System.out.println("Found key " + key + ", value=" + ops.get(key));
    }

    private void usingHash() {

    }

}
