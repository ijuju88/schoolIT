package com.test;

public class Accountt {
	String accNum, name;
	int balance;
	
	Accountt(){}
	

	Accountt(String accNum, String name, int balance) {
		this.accNum = accNum;
		this.name=name;
		this.balance = balance;
	}

	
	void dispasit(int amount){balance+=amount; display();}
	void whihdraw(int amount){
		if(amount>balance)
		{
			System.out.println("돈없다고!!!");	
		}else balance-=amount; display();
	}
	
	void display(){
		System.out.println("───────────────────────────────────────────────");
		System.out.print("계좌번호 : "+accNum+"\t");
		System.out.print("  이     름 : "+name+"\t");
		System.out.println("  현재금액 : "+balance);
		}
}
