package com.Inhertest;

public class DmbCellPhoneEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//DmbCellPhone객체생성
		DmbCellPhone dmb1=new DmbCellPhone("스마트폰", "red", 10);
		
		//CellPhone으로부터 상속받은 필드
		System.out.println("모델 : "+dmb1.model);
		System.out.println("색상 : "+dmb1.color);
		
		//DmbCellPhone의 필드
		System.out.println("채널 : "+dmb1.channel);
		
		//CellPhone으로부터 상속받은 필드
		dmb1.powerOn();
		dmb1.bell();
		dmb1.sendvoice("하이!!");
		dmb1.receiveVoice("그래~~-^-");
		dmb1.sendvoice("그랭^^*");
		dmb1.hangUp();
		
		//DmbCellPhone 메소드 호출
		dmb1.turenOnDmb();
		dmb1.changeChannelDmb(12);
		dmb1.turenOffDmb();
	}

}
