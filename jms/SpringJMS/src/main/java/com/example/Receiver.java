package com.example;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

	@JmsListener(destination="mailbox", containerFactory="myFactory")
	public void receiveMessage(Message<Email> msg) throws Exception{
		
		System.out.println(msg.getHeaders());
	
	}
	
}
