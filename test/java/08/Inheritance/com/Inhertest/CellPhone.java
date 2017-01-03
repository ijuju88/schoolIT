package com.Inhertest;

public class CellPhone {
	String model, color;
	
	CellPhone(){}
	CellPhone(String model, String color)
	{this.model=model; this.color=color;}
	
	void powerOn(){System.out.println("전원 On");}
	void powerOff(){System.out.println("전원 Off");}
	void bell(){System.out.println("벨~~레렐레~");}
	void sendvoice(String message)
	{System.out.println("자기 : "+message);}
	void receiveVoice(String message)
	{System.out.println("상대방 : "+message);}
	void hangUp()
	{System.out.println("뚜~우~뚜우");}
}
