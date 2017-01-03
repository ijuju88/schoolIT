package com.Except;

public class TryCatch {
	public static void main(String[] args) {
		
		try{
			//예외 발생가능코드
			Class clzz=Class.forName("java.lang.String");
			
			//Class.forName("");
			//이런 이름을 가진 클래스를 알아봅니당
			
			System.out.println(clzz);
		}catch(ClassNotFoundException e){
			//예외발생시 처리
			System.out.println("없음!!");
		}finally{
			//항상실행
			System.out.println("finally문입니당");
		}
		
		
		
		try {
			
			String data1=args[0];
			String data2=args[1];
		
			
			int v1=Integer.parseInt(data1);
			int v2=Integer.parseInt(data2);
			int result=v1+v2;
			System.out.println(data1+"+"+data2+"="+result);
			
			int[] a=new int[3];

			a[3]=10;
		} catch (NumberFormatException e) {
			System.out.println("숫자로 변환안됨");
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 인텍스 초과");
		}
		
		finally {
			System.out.println("다시하삼");
		}
	}
}
