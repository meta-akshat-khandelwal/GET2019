package com.metacube.messageService;

public class TwitterService implements MessageService{
	/*
	*sends message 
	*@param,message
	*@param, receiver
	*/
	@Override
	public void sendMessage(String message, String receiver)
	{
		System.out.println("Twitter message sended to "+receiver+" with message: \n"+message);
	}
}
