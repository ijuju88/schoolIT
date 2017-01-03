package com.Book;


//책등록
public class  Book {
	String code, title, author,publisher;
	int rent_sum;
	boolean rent_state;
	
	public Book(){}
	
	public Book(String code, String title, String author, String publisher,int rent_sum) 
	{
		this.code = code;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.rent_sum = rent_sum;
	}

	public Book(String code, String title, int rent_sum) {
		this.code = code;
		this.title = title;
		this.rent_sum = rent_sum;
	}

	//여기도 나중에 불려와야하니깐~~
	String getCode() {return code;}
	void setCode(String code) {this.code = code;}

	String getTitle() {return title;}
	void setTitle(String title) {this.title = title;}
	
	String getAuthor() {return author;}
	void setAuthor(String author) {this.author = author;}
	
	String getPublisher() {return publisher;}
	void setPublisher(String publisher) {this.publisher = publisher;}
	
	boolean isRent_state() {return rent_state;}
	void setRent_state(boolean rent_state) {this.rent_state = rent_state;}

	int getRent_sum() {return rent_sum;}
	void setRent_sum(int rent_sum) {this.rent_sum = rent_sum;}

	
	//코드조회용
	public boolean setBook(String code){
		if(this.code.equals(code)){return true;}
		else {return false;}
		
	}
	
	
	//출력용
	public void display(){
		System.out.println(code+"\t"+title+"\t"+author+"\t"+publisher+"\t"+rent_state+"\t"+rent_sum);
	}
	
	//출력용(영화용)
	public void pdisplay1(){
		System.out.print(code+"\t"+title+"\t");
	}
	
	public void pdisplay2(){
		System.out.print(rent_state+"\t"+rent_sum);
	}
}
