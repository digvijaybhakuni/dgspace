/**
 * 
 */
package com.dgstack.eg.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import com.dgstack.eg.event.MyAppEvent;
import com.dgstack.eg.event.MyAppEventListener;

/**
 * @author dbhakuni
 *
 */
@Controller
public class EventController {
	
	private static final Object OBJECT = new Object();

	@Autowired
	private MyAppEventListener eventListener;
	
	@Autowired
    private ApplicationEventPublisher eventPublisher;
	
	@GetMapping("/stream")
	public SseEmitter getNotification() throws IOException {
		SseEmitter emitter = new SseEmitter();
		eventListener.addEmitter(emitter);
		return emitter;
	}

	@PostMapping("/createEvent")
	@ResponseBody
	public void pubMsg(@RequestBody String msg) throws IOException {
		eventPublisher.publishEvent(new MyAppEvent(OBJECT, msg));
	}

}
