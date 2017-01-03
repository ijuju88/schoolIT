package com.InnerInterface;

import javax.activation.MailcapCommandMap;

public class ButtonEx {

	
		public static void main(String[] args){
			Button bu=new Button();
			bu.setOnClickListeener(new CallListener());
			bu.touch();
			
			bu.setOnClickListeener(new MessageListener());
			bu.touch();
		}
}
