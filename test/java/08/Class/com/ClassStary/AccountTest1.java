package com.ClassStary;

import java.util.Scanner;

public class AccountTest1 {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		boolean run=true;
		
		String accnum;
		int num, mon, accdis, accwhi;
		
		Account1 acc=new Account1();
		Scanner sc=new Scanner(System.in);
		
		
		while (run) {
			System.out.println("────────────────────────────────────────");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.입금 | 4.출금 | 5.종료");
			System.out.println("────────────────────────────────────────");
			System.out.print("선택> ");
			num=sc.nextInt();
			
			if(num==1)
			{
	
				System.out.print("계좌번호> ");
				accnum=sc.next();
				System.out.print("금액입력> ");
				mon=sc.nextInt();
				
				acc=new Account1(accnum, mon);

				
				acc.display();
				
				continue;
			}
			if(num==2){
				
				
				
				
			}
			if(num==3)
			{
				System.out.print("입금액> ");
				accdis=sc.nextInt();
				acc.dispasit(accdis);
				continue;
			}
			
			if(num==4)
			{
				System.out.print("출금액> ");
				accwhi=sc.nextInt();
				acc.whihdraw(accwhi);
				continue;
			}
			
			if(num==5)
			{
				run=false;
			}
			
		}
		
}
}

class Account1{
	String accNum;
	int balance;
	
	Account1(){}
	

	Account1(String accNum, int balance) {
		this.accNum = accNum;
		this.balance = balance;
	}

	/*String Accountacc(String accNum){return this.accNum=accNum;}
	int Accountmon(int balance){return this.balance=balance;}*/
	
	
	void dispasit(int amount){balance+=amount; display();}
	void whihdraw(int amount){
		if(amount>balance)
		{
			System.out.println("돈없다고!!!");	
		}else balance-=amount; display();
	}
	
	void display(){
		System.out.println("────────────────────────────────────────");
		System.out.println("계좌번호 : "+accNum);
		System.out.println("현재금액 : "+balance);
		}
}
