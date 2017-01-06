/**
 * 
 */
package com.dgstack.eg.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author dbhakuni
 *
 */
@Component
public class MyAppEventListener {
	
	final List<SseEmitter> objList = Collections.synchronizedList(new ArrayList<SseEmitter>());
	
	@EventListener
	public void myAppEventHandler(MyAppEvent appEvent) throws IOException{
		objList.forEach(e-> {
			try {
				e.send(appEvent.getMessage());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
	}

	
	public void addEmitter(SseEmitter emitter) throws IOException{
		emitter.onCompletion(() -> {objList.remove(emitter);});
		objList.add(emitter);
	}
	

}
