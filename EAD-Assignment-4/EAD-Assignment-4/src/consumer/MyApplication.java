package consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.metacube.messageService.MessageService;

import configurator.DIConfiguration;

public class MyApplication {

	/*
	 * sends  message of given service type
	 * @param, service type
	 * @param message to send
	 * @param the receiver 
	 */
	public void sendMessage(String service, String message, String receiver)
	{
		//connects with the java file which acts as a factory class with spring annotations
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DIConfiguration.class);
		
		//gets the object of requested message service
		MessageService messageService = (MessageService)applicationContext.getBean(service);
		
		//sends the message to receiver with the given message
		messageService.sendMessage(message, receiver);
	}
}
