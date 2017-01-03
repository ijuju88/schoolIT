package com.type;

public class Ty2 {
	public static void main(String[] args){
		
		short ss=32767;
		int i1=ss+1;
		int i10=10;
		int i8=012; //8진수표시는 숫자앞에 0붙임
		int i16=0xA; //16진수는 숫자앞에 0x붙임 10=A ~ 15=F
		
		
		long l=10000000000L; //L을 안붙이면 4byte만씀 ㅠ
		float f=0.111f;//f를 안붙이면 ㅠ
		double d=0.1;
		//int i=f; 정수형과 실수분은 데이터 구조가 다르므로 안됨 ㅠ
		//실수형의 데이터구조 - 지수부+가수부
		f=i10;
		
		System.out.println(i1);
		System.out.println(i10);
		System.out.println(i8);
		System.out.println(i16);
		
		//강제변환 - 값이 짤림 ㅠ
		i10=(int)f; 
		byte b=(byte)ss;
		
		System.out.println(b);
		
		float c=5/2; 
		System.out.println(c); //2.5가 나와야하는뎅 ㅠㅠ 왜 2.0이 나오징 ㅋㅋ	
		float c2=(float)(5/2); 
		System.out.println(c2);//안에거 먼저 계산하기 때문에 2.0 나옴
		
		float c1=5/2.0f; 
		System.out.println(c1); //정수와 실수형을 하면 해결됨 ㅋ(두형중 큰 형으로 변환됨)
	
		
	}
}
