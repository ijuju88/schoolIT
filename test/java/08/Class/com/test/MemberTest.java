package com.test;

public class MemberTest {
	public static void main(String[] args){
	Member user1=new Member("홍길동", "hong");
	Member user2=new Member("강자바", "java","1236as",20);
	
	//System.out.println(user1.getName()+"\t"+user1.getId());
	//System.out.println(user2.getName()+"\t"+user2.getId()+"\t"+user2.getPassword()+"\t"+user2.getAge());
	
	boolean result=user2.login("java", "1236as");
	
	if(result){
		System.out.println("로그인되셨습니다");
		user2.logout(user2.getName());
	}else System.out.println("로그인정보가 올바르지 않습니다");
	}
}
