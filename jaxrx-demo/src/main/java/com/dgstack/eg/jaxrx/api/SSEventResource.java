/**
 * 
 */
package com.dgstack.eg.jaxrx.api;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.glassfish.jersey.media.sse.SseBroadcaster;
import org.glassfish.jersey.media.sse.SseFeature;

/**
 * @author dbhakuni
 *
 */
@Singleton @Path("events")
public class SSEventResource {

	private final SseBroadcaster broadcaster = new SseBroadcaster();
	
	private final ConcurrentMap<String, EventOutput> EVENTMANAGER = new ConcurrentHashMap<>();
	
	@POST
	@Path("ssevents/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String broadcastMessage(String message, final @PathParam("id") String id) {
		OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
		OutboundEvent event = eventBuilder.name("message").mediaType(MediaType.TEXT_PLAIN_TYPE)
				.data(String.class, "A Message Recived").build();
		broadcaster.broadcast(event);
		EventOutput eventOut = EVENTMANAGER.get(id);
		System.out.println("event "+eventOut+" by id "+id);
		if(eventOut != null && !eventOut.isClosed()){
			OutboundEvent.Builder eventBuilder2 = new OutboundEvent.Builder();
			OutboundEvent obe = eventBuilder2.name("message").mediaType(MediaType.TEXT_PLAIN_TYPE)
					.data(String.class, message).build();
			try {
				eventOut.write(obe);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "Message '" + message + "' has been broadcast.";
	}

	@GET
	@Path("ssevents/{id}")
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput listenToBroadcast(final @PathParam("id") String id) {
		final EventOutput eventOutput = new EventOutput();
		//this.broadcaster.add(eventOutput);
		
		System.out.println("ID for event "+id);
		EVENTMANAGER.put(id, eventOutput);
		System.out.println("SIZE "+ EVENTMANAGER.size());
		return eventOutput;
	}
	
	
	
	@GET
	@Produces(SseFeature.SERVER_SENT_EVENTS)
	public EventOutput getServerSentEvents() {
		final EventOutput eventOutput = new EventOutput();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					for (int i = 0; i < 10; i++) {
						// ... code that waits 1 second
						final OutboundEvent.Builder eventBuilder = new OutboundEvent.Builder();
						eventBuilder.name("message-to-client");
						eventBuilder.data(String.class, "Hello world " + i + "!");
						final OutboundEvent event = eventBuilder.build();
						eventOutput.write(event);
					}
				} catch (IOException e) {
					throw new RuntimeException("Error when writing the event.", e);
				} finally {
					try {
						eventOutput.close();
					} catch (IOException ioClose) {
						throw new RuntimeException("Error when closing the event output.", ioClose);
					}
				}
			}
		}).start();
		return eventOutput;
	}

}
