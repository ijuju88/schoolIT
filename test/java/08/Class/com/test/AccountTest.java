package com.test;
import java.util.Scanner;


public class AccountTest {
	public static void main(String[] args){
	
		boolean run=true;
	
	String accnum, name;
	int num, mon, accdis, accwhi, index=0;
	
	Accountt[] acc=new Accountt[100];
	Scanner sc=new Scanner(System.in);
	
	
	while (run) {
		System.out.println("───────────────────────────────────────────────");
		System.out.println("───1.계좌생성 | 2.계좌목록 | 3.입금 | 4.출금 | 5.종료─────");
		System.out.println("───────────────────────────────────────────────");
		System.out.print("선택> ");
		num=sc.nextInt();
		
		if(num==1)
		{

			System.out.print("계좌번호> ");
			accnum=sc.next();
			System.out.print("성함입력> ");
			name=sc.next();
			System.out.print("금액입력> ");
			mon=sc.nextInt();
			
			acc[index++]=new Accountt(accnum, name , mon);

			
			System.out.println("계좌생성완료!");
			
			continue;
		}
		if(num==2){
				for (int i = 0; i < index; i++) {
					acc[i].display();
				}
			
			
		}
		if(num==3)
		{
			boolean flag=false;
			System.out.print("계좌번호> ");
			accnum=sc.next();
			System.out.print("입금액> ");
			accdis=sc.nextInt();
			
			
			for (int i = 0; i < index; i++) {
				if(acc[i].accNum.equals(accnum)){
					acc[i].dispasit(accdis);
				flag=true;
				break;
				}
			}
			if(!flag){
			System.out.println("계좌생성이 안되었습니다.");

			}continue;

		}
		
		if(num==4){
			boolean flag1=false;
			System.out.print("계좌번호> ");
			accnum=sc.next();
			System.out.print("출금액> ");
			accwhi=sc.nextInt();

			for (int i = 0; i < index; i++) {
				if(acc[i].accNum.equals(accnum)){
					acc[i].whihdraw(accwhi);
					flag1=true;
					break;
				}
			}
			if(!flag1){
			System.out.println("계좌생성이 안되었습니다.");
			}
			continue;
		}
		
		if(num==5)
		{
			run=false;
		}
		
	}
	
}
}