package com.Inhertest;

public class DmbCellPhone extends CellPhone {
	int channel;
	
	public DmbCellPhone(String model, String color, int channel)
	{this.model=model; this.color=color; this.channel=channel;}
	
	void turenOnDmb()
	{System.out.println("채널"+channel+"번 DMB방송중");}
	void turenOffDmb()
	{System.out.println("DMB방송끝");}
	void changeChannelDmb(int channel){
		System.out.println("채널"+channel+"번으로 바꿈");
	}
}
