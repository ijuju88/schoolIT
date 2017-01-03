package com.Proddunt;

import java.util.Scanner;

public class Book extends Proddunt {
	

	String author, bookTitle;
	
	Scanner sc=new Scanner(System.in);
	int index = 0;
	Book bo[]=new Book[6];
	 
	public Book(int id, int price, String comment, 
			String productor, String author, String bookTitle) {
		super(id, price, comment, productor);
		this.author=author; this.bookTitle=bookTitle;}
	
	public Book() {}

	@Override
	public void Scr() {
		super.setDate();
		System.out.print("책제목>>");
		author=sc.next();
		System.out.print("저자>>");
		bookTitle=sc.next();
		bo[index++]=new Book(id, price, comment, productor, author, bookTitle);
	}

}
