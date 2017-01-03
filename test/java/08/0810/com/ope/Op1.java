package com.ope;

public class Op1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//나머지
		int re=5%2; 
		System.out.println(re);
		
		//문자열연결
		String sts="Java";
		String sts1=sts+(8+2)+" 프로그램"; //문자열 연결
		String sts2=" 입니당"; 
		
		System.out.println(sts1+sts2);
		
		//대입연산자
		int a=0;
		a+=10; //=>a=a+1
		
		System.out.println(a);	
		
		//증감연산자
		
		/*int aa=0;
	    aa++; //aa에 1+ 
		System.out.println(aa);	
		
		int aa1=0;
		++aa1; //1+ 시키고 aa1증가
		System.out.println(aa1);*/
		
		int aa=1;
		int bb=1;
		
		bb=++aa;
		System.out.println(bb+", "+aa);
		bb=aa++;
		System.out.println(bb+", "+aa);
		
		//비교연산자
		System.out.println(aa==bb);
		System.out.println(aa>bb);
		System.out.println(aa<bb);
		System.out.println(aa>=bb);
		System.out.println(aa<=bb);
		System.out.println(aa!=bb);
		
		if(aa<bb)
		{
			
			System.out.println("aa는 bb보다 크네요 ㅇ0ㅇ");
			
		}
		else System.out.println("aa는 bb보다 작아용 >-<");
		
		
		//논리연산자 ! &&, ||
		
		aa=10;
		int cc=4;
		
		System.out.println(aa>bb && !(aa<cc));
		
		System.out.println(aa>bb & aa<cc);
		/*
			비트 논리 연산자 - &, |, ^(xor), ~(not),
			예)
			 00000110    
			    &          => 00000010 (둘개다 1이면 1)
			 00000010
		 */
		
		System.out.println(aa&bb);
		System.out.println(aa|bb);
		System.out.println(~bb);
		
		
		//시프트연산자(제곱) >>, <<, >>>
		
		System.out.println(aa>>2); //10의 >> 2번 ㅋㅋ
		System.out.println(bb<<=1); 
		
		//조건연산  (if~else 같음 ㅋ)
		//조건식 ? (참)값,연산식 : (거짓)값,연산식 ;
		
		System.out.println(aa>bb ? "크당" : "작당");


	}

}
