package com.websystique.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component(value="publisher")
public class Publisher implements ApplicationContextAware{
	
	private ApplicationContext ctx ;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
		this.ctx=applicationContext;
		
	}
	public void publish(String message){
		ctx.publishEvent(new MessageEvent(this, message));
	}
}
