package com.dgstack.redisdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootApplication
/**
 * Main Application Class
 */
public class RedisdemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(RedisdemoApplication.class, args);
    }

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

}
