package com.test;

class Account{
	private int balance;
	static final int MIN_BALANCE=0;
	static final int MAX_BALANCE=1000000;
	
	public void setBalance(int balance){
		int bal=0; bal+=balance;
		if(bal>=MIN_BALANCE && bal<=MAX_BALANCE){this.balance=bal;}
	}
	
	public int getBalance(){return balance;}
	
}

public class AccountEx {
	 public static void main(String[] args){
		 Account account=new Account();
		 
		 account.setBalance(10000);
		 System.out.println("잔고 : "+account.getBalance());
		 
		 account.setBalance(-100);
		 System.out.println("잔고 : "+account.getBalance());
		 
		 account.setBalance(300000);
		 System.out.println("잔고 : "+account.getBalance());
	 }
}
