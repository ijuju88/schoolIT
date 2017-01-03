package com.util;

public class StringBufferTest {

	public static void main(String[] args) {
		//String와 StringBuffer의 비교
		String str="abc";
		System.out.println(str.hashCode());
		str+="efg";
		System.out.println(str.hashCode());//위의 hashcode와 다름
		
		System.out.println("--------------------------");
		
		StringBuffer sb=new StringBuffer();
		sb.append("java ");
		System.out.println(sb.hashCode()); 
		sb.append("Program Study");
		System.out.println(sb.toString());
		System.out.println(sb.hashCode()); //위의 hashcode와 같은걸 알수 있음
		System.out.println("--------------------------");
		//4번째 문자뒤 문자를 2로
		sb.insert(4, "2");
		System.out.println(sb.toString());
		
		System.out.println("--------------------------");
		
		//4번째 문자뒤 문자를 6으로
		sb.setCharAt(4, '6');
		System.out.println(sb.toString());
		
		System.out.println("--------------------------");
		
		//6번째 문자부터 13번째 문자 -> Book
		sb.replace(6, 13, "Book");
		System.out.println(sb.toString());
		
		System.out.println("--------------------------");
		
		//5번째 문자 삭제
		sb.delete(4, 5);
		System.out.println(sb.toString());
		
		System.out.println("--------------------------");
		
		//총문자길이 & 용량
		System.out.println("문자길이 : "+sb.length());
		System.out.println("용량 : "+sb.capacity());
		System.out.println("--------------------------");
		
		//버퍼에 있는 것을 String타입으로 리턴
		String re=sb.toString();
		System.out.println(re);
	}

}
