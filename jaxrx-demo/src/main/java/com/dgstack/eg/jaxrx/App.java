/**
 * 
 */
package com.dgstack.eg.jaxrx;

import static io.undertow.servlet.Servlets.servlet;

import java.io.File;
import java.nio.file.Paths;

import javax.servlet.ServletException;

import org.glassfish.jersey.servlet.ServletContainer;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.handlers.PathHandler;
import io.undertow.server.handlers.resource.FileResourceManager;
import io.undertow.server.handlers.resource.PathResourceManager;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;

import static io.undertow.Handlers.resource;

/**
 * @author dbhakuni
 *
 */
public class App {

	private static Undertow server;

	public static void main(String[] args) throws ServletException {
		startContainer(9090);
	}

	public static void stopContainer() {
		server.stop();
	}

	public static void startContainer(int port) throws ServletException {
		io.undertow.servlet.api.ServletContainer servletContainer = Servlets.defaultContainer();
		//FileResourceManager fileResource = new FileResourceManager(new File("C:\\dgwork\\dgspace\\jaxrx-demo\\src\\main\\webapp"), 1000);
		DeploymentInfo di = Servlets.deployment().setClassLoader(App.class.getClassLoader()).setContextPath("/jaxrx")
				//.setResourceManager(fileResource)
				.setDeploymentName("jaxrx-demo-1.0")
				.addServlets(servlet("jerseyServlet", ServletContainer.class).setLoadOnStartup(1)
						.setAsyncSupported(true).addInitParam("javax.ws.rs.Application", JerseyApp.class.getName())
						.addMapping("/api/*"))
				.addWelcomePage("index.html");

		DeploymentManager manager = servletContainer.addDeployment(di);

		manager.deploy();
		PathHandler path = Handlers.path(Handlers.redirect("/jaxrx")).addPrefixPath("/jaxrx", manager.start());
		
		//HttpHandler contentPath  = resource(new PathResourceManager(Paths.get("C:\\dgwork\\dgspace\\jaxrx-demo\\src\\main\\webapp"), 100));
		server = Undertow.builder().addHttpListener(port, "localhost").setHandler(path).build();

		server.start();
	}
}
