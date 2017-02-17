/**
 * 
 */
package com.dgstack.reactor.service;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

/**
 * @author dbhakuni
 *
 */
@Service
public class ReactService {

	public Mono<String> getOne(){
		try{
			return Mono.defer(() -> Mono.justOrEmpty(slowMethod()));
		}finally {
			System.out.println("Mono Return");
		}
	}
	
	private String slowMethod(){
		try {
			Thread.sleep(1000);
			System.out.println("Wake Up");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "This Is the Responce";
	}
	
}
