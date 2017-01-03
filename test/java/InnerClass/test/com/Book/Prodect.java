package com.Book;

public class Prodect extends Book{
	Book book;
	String supervision,actor;

	
	public Prodect(){}
	public Prodect(String code, String title, String supervision, String actor, int rent_sum) {
		super(code, title, rent_sum);
		this.supervision = supervision;
		this.actor = actor;
	}

	
	String getSupervision() {return supervision;}
	void setSupervision(String supervision) {this.supervision = supervision;}
	
	String getActor() {return actor;}
	void setActor(String actor) {this.actor = actor;}
	
	
	//코드조회용
	public boolean setProdect(String code){
		if(this.code.equals(code)){return true;}
		else {return false;}
	}
	
	
	//출력용
	public void display(){
		super.pdisplay1();
		System.out.print
		(supervision+"\t"+actor+"\t");
		super.pdisplay2();
		System.out.println("");
	}
	
}
