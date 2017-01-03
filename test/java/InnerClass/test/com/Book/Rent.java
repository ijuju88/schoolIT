package com.Book;

public class Rent {
	Member member;
	Book book;
	Prodect prodect;
	
	public Rent(){}
	public Rent(Member member, Book book) {
		super();
		this.member = member;
		this.book = book;
	}
	
	public Rent(Member member, Prodect prodect) {
		super();
		this.member = member;
		this.prodect = prodect;
	}
	
	//책대여시 아디와 코드 조회
	public boolean returnBook(String id, String code){
		if(member.getId().equals(id) && this.book.getCode().equals(code)){
		book.setRent_state(false);return true;}
		else{return false;}
	}
	
	//영화대여시 아디와 코드조회
	public boolean returnProdect(String id, String dcode){
		if(member.getId().equals(id) && this.prodect.getCode().equals(dcode)){
		prodect.setRent_state(false);return true;}
		else{return false;}
	}
	
	
	//책출력용
	public void dispaly1(){
		System.out.println(book.getCode()+"\t"+book.getTitle()+"\t"+book.getAuthor()+"\t"+member.getName()+"\t"+member.getTel());
	}
	
	public void dispaly2(){
		System.out.println(prodect.getCode()+"\t"+prodect.getTitle()+"\t"+prodect.getSupervision()+"\t"+member.getName()+"\t"+member.getTel());
	}
	
}
