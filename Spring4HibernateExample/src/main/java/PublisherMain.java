import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.websystique.spring.event.Publisher;


public class PublisherMain {

	
	public static void main(String ar[]){
		AnnotationConfigApplicationContext  context = new AnnotationConfigApplicationContext();
		context.scan("com.websystique.spring"); 
		context.refresh();
		Publisher publisher = (Publisher) context.getBean("publisher");
		publisher.publish("Hello World !!");		
	}

	
	
}
