/**
 * 
 */
package com.dgstack.reactor.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dgstack.reactor.service.ReactService;

import reactor.core.publisher.Mono;

/**
 * @author dbhakuni
 *
 */
@RestController
public class ReactController {

	@Autowired
	private ReactService reactService; 
	
	@GetMapping("one")
	public Mono<String> getOne(){
		return reactService.getOne().log();
	}
	
	
}
