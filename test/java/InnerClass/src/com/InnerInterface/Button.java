package com.InnerInterface;

import javax.swing.ButtonModel;

public class Button {
	OnClickListeener listener;
	
	void setOnClickListeener(OnClickListeener listener)
	{this.listener=listener;}
	
	void touch(){listener.onClick();}
	
	interface OnClickListeener{void onClick();}
}


class CallListener implements Button.OnClickListeener{

	@Override
	public void onClick() 
	{System.out.println("전화를 겁니당!");}
	
}

class MessageListener implements Button.OnClickListeener{

	@Override
	public void onClick() 
	{System.out.println("메세지를 보냅니당!");}
	
}