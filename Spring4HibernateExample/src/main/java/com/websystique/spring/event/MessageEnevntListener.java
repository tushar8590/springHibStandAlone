package com.websystique.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component(value="messageEventListener")
public class MessageEnevntListener implements ApplicationListener<MessageEvent>{

	public void onApplicationEvent(MessageEvent event) {
		MessageEvent envt = (MessageEvent) event;
		System.out.println("Received "+event.getMessage());
	}

}
