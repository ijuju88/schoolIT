package com.ClassStary;

import java.util.Scanner;

public class AccountTest {
	public static void main(String[] args){
		
		Account acc=new Account("123-123",10000);
		
		acc.Accountacc("10-111");
		acc.dispasit(5000);
		acc.whihdraw(20000);	
		acc.whihdraw(100);
}
}

class Account{
	String accNum;
	int balance;
	
	
	Account(){}
	Account(String accNum, int balance)
	
	{this.accNum=accNum; this.balance=balance;}
	
	
	String Accountacc(String accNum){return this.accNum=accNum;}
	
	//int dispasit(int amount){return this.balance=balance+amount;}
	
	void dispasit(int amount){balance+=amount; display();}
	void whihdraw(int amount){
		if(amount>balance)
		{
			System.out.println("돈없다고!!!");	
		}else balance-=amount; display();
	}
	
	void display(){
		System.out.println("───────────────────────");
		System.out.println(accNum+", "+balance);
		}
}
