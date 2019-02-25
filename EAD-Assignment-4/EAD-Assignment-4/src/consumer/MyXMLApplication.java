package consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.metacube.messageService.MessageService;

public class MyXMLApplication {
	/*
	 * sends  message of given service type
	 * @param, service type
	 * @param message to send
	 * @param the receiver 
	 */
	public void sendMessage(String service,String message, String receiver)
	{
	
		//connects with XML file to get the object from factory
	    ApplicationContext factory = new ClassPathXmlApplicationContext("configurator/applicationContext.xml");
		
		
		//gets the object according to the requested service
		MessageService messageService = (MessageService)factory.getBean(service);
		
		//sends the message
		messageService.sendMessage(message , receiver);
	}

}
