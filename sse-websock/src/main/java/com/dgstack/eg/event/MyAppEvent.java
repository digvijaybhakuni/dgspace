package com.dgstack.eg.event;

import org.springframework.context.ApplicationEvent;

public class MyAppEvent extends ApplicationEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public MyAppEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
