package com.test;
//싱글톤문제
class ShopService{
	private static ShopService shop=new ShopService();
	
	public static ShopService getInstance(){return shop;}
	
	private ShopService(){}
}

public class ShopServiceEx {
	public static void main(String[] args){
		
		ShopService shop1=ShopService.getInstance();
		ShopService shop2=ShopService.getInstance();
		
		if(shop1==shop2)System.out.println("같은객체");
		else System.out.println("다른객체");
	}
}
