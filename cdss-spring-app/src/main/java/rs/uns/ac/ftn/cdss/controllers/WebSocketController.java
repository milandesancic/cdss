package rs.uns.ac.ftn.cdss.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class WebSocketController {
	 private final SimpMessagingTemplate template;

	    @Autowired
	    WebSocketController(SimpMessagingTemplate template){
	        this.template = template;
	    }

//	    @MessageMapping("/send/message")
	    public void onReceivedMesage(String message){
	        this.template.convertAndSend("/chat",  new SimpleDateFormat("HH:mm:ss").format(new Date())+"- "+message);
	    }
}
