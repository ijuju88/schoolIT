package com.Proddunt;

import java.util.Scanner;

public abstract class Proddunt {
	int id=0, price;
	String comment, productor;
	Scanner sc=new Scanner(System.in);
	
	public Proddunt(){}
	public Proddunt(int id, int price, String comment, String productor) 
	{this.id = id;this.price = price;this.comment = comment;this.productor = productor;}

	public abstract void Scr();
	 
	public void setDate(){
		id+=id;
		System.out.print("상품설명>>");
		comment=sc.next();
		System.out.print("생산자>>");
		productor=sc.next();
		System.out.print("가격>>");
		price=sc.nextInt();
	}
	public void display(){
		System.out.print(id+"\t"+comment+"\t"+productor+"\t"+price);
	 }
}

