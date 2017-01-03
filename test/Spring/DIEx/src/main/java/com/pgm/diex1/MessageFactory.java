package com.pgm.diex1;

public class MessageFactory {
	public MessageFactory() {}
	private static MessageFactory factory=new MessageFactory();
	public static MessageFactory getInstance(){
		return factory;
	}
	
	public Ibean createMessage(String str){
		if(str.equals("kr"))return new Messagekr();
		else return new MessageBean();
	}
}
