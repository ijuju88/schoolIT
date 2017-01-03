package com.Proddunt;

import java.util.Scanner;

public class ConversationNBook extends Book {
	String language;
	int index = 0;
	Scanner sc=new Scanner(System.in);
	
	public ConversationNBook
	(int id, int price, String comment, String productor, 
	String author, String bookTitle, String language) {
		super(id, price, comment, productor, author, bookTitle);
		this.language=language;}
	public ConversationNBook() {}
	
	
	
}
