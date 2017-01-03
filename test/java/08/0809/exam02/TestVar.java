package exam02;

import java.util.Scanner;

public class TestVar {
	static int fu2;  //static = 정적변수
	static int fu3;
	static String fu4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 /* 
			5Num=20;  변수는 선언을 합시당. 변수앞에 숫자적지 말아용
			int class=10; java예약어도 쓰지 말아용. 
			*/
		
		/*int age; //변수설정
		age=20; //설정 후 값입력
		
		String name1="홍길동"; //변수설정과 동시 입력
		
		float ff=0.5f; //float에서 실수로 표현시 뒤에 f를 붙임
		double $dd=0.5; //변수앞에 $,_는 사용가능함 
		
		
		System.out.println(name1 + ", "+ age);
		
		
		//키보드로 입력하기
		
		Scanner in=new Scanner(System.in);
		int ag;
		
		System.out.print("나이를 적으시용?");
		ag=in.nextInt();
		System.out.print("이름을 적으시용?");
		String na=in.next();
		
		System.out.println(ag + ", "+ na);
		
		//리터널
		
		long l=300L; //8byte 정수형 숫자뒤에 L를 적음(소문자하면 숫자인지 몰라봄 ㅠ)
		int i=30; //4byte 정수형
		short s=20; //2byte 정수형
		byte b=10; //1byte 정수형
		
		float f1=0.5f; //4byte 숫자뒤에 f 
		double d1=0.5; //8byte 정수형 
		
		char c='z'; //문자1개만 저장
		String s1="홍길동~ *-*";
		
		boolean bb=true; // 참과 거짓(false)
*/	
	
		//범위
		
		int fu;
		{
			int fu1;
			fu=1;
			fu1=2;
			
			System.out.println("fu1="+fu1);
		}
		
		fu2=3;
		System.out.println("fu="+fu);
		//System.out.println("fu1="+fu1); 변수를 벗어난 지역임
		
		fun();
	}
	
	private static void fun()
	{
		
		System.out.println(fu2);
		System.out.println(fu3); //int형의 초기값은 0
		System.out.println(fu4); //String형의 초기값은 null
	}

}
