package com.Except;

public class AccountExample {

	public static void main(String[] args) {
		Account ac=new Account();
		
		//예금하기
		ac.deposit(10000);
		System.out.println("예금액 : "+ac.getBalance());
		
		//출금
		try {
			ac.withdraw(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class Account{
	private long balance;
	
	public Account() {}
	public long getBalance(){return balance;}
	public void deposit(int money){balance+=money;}
	
	public void withdraw(int money) throws Exception{
		if(balance<money){System.out.println("잔고부족"+(money-balance)+" 모자람");}
		balance-=money;
	}
}