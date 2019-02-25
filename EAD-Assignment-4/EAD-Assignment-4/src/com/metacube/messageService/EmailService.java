package com.metacube.messageService;

public class EmailService implements MessageService{

	@Override
	public void sendMessage(String message, String receiver)
	{
		System.out.println("Email sended to "+receiver+" with message: \n"+message);
	}
}
