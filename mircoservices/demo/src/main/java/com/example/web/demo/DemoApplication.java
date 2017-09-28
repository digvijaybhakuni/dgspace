package com.example.web.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.web.client.model.TestModel;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("")
	public String index(){
		return "index";
	}


	@GetMapping("test")
	public TestModel test(){
		TestModel tm = new TestModel();
		tm.setName("This test service :"+ System.currentTimeMillis());
		return tm;
	}

}
