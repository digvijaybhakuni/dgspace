package com.dgstack.eg.jaxrx;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

//@ApplicationPath("/api/*")
public class JerseyApp extends ResourceConfig {
	public JerseyApp() {
		System.out.println("Hello Wrold");
		packages(true, "com.dgstack.eg.jaxrx.api");
	}
}
