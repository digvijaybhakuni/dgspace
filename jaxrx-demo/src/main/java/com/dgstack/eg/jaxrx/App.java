/**
 * 
 */
package com.dgstack.eg.jaxrx;

import static io.undertow.servlet.Servlets.servlet;

import javax.servlet.ServletException;

import org.glassfish.jersey.servlet.ServletContainer;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.PathHandler;
import io.undertow.servlet.Servlets;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;


/**
 * @author dbhakuni
 *
 */
public class App {

	private static Undertow server;
	
	public static void main(String[] args) throws ServletException {
        startContainer(9090);
    }
	
	public static void stopContainer(){
        server.stop();
    }
	
	public static void startContainer(int port) throws ServletException {
		io.undertow.servlet.api.ServletContainer servletContainer = Servlets.defaultContainer();

		DeploymentInfo di = Servlets.deployment().setClassLoader(App.class.getClassLoader()).setContextPath("/jaxrx")
				.setDeploymentName("jaxrx-demo-1.0")
				.addServlets(servlet("jerseyServlet", ServletContainer.class).setLoadOnStartup(1).setAsyncSupported(true)
						.addInitParam("javax.ws.rs.Application", JerseyApp.class.getName()).addMapping("/api/*"));;

        DeploymentManager manager = servletContainer.addDeployment(di);
       
        manager.deploy();
        PathHandler path = Handlers.path(Handlers.redirect("/jaxrx"))
                .addPrefixPath("/jaxrx", manager.start());

        server =
                Undertow
                        .builder()
                        .addHttpListener(port, "localhost")
                        .setHandler(path)
                        .build();

        server.start();
    }
}
