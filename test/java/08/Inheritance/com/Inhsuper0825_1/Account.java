package com.Inhsuper0825_1;

public class Account {
	//final String accNum="11-22";
	String accNum;
	int balance;

	//set함수를 사용못함
	public Account(String accNum){this.accNum=accNum;}
	
	public final void setNum(String accNum)
	{this.accNum=accNum;}
	public void setBalance(int balance)
	{this.balance=balance;}
	
	public void display()
	{System.out.println(accNum+"\t"+balance);}
}
