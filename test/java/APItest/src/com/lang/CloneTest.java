package com.lang;

import java.util.Arrays;

public class CloneTest {

	public static void main(String[] args) {
		Member mem1=new Member("a1", "kkk", "1234", 20, true);
		Member cloned=mem1.getMember();
		
		cloned.password="4567";
		cloned.age=25;
		cloned.id="b1";
		cloned.score[0]=5;
		cloned.score[1]=10;
		System.out.println(mem1);
		System.out.println(cloned);
	}

}

class Member implements Cloneable{
	String id, name, password;
	int age, score[];
	boolean adult;
	
	public Member(String id, String name, String password, int age, boolean adult) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
		this.adult = adult;
		score=new int[2];
		score[0]=1;
		score[1]=2;
	}
	
	@Override
	protected Object clone()throws CloneNotSupportedException {
		Member cloned=(Member)super.clone();
		cloned.score=Arrays.copyOf(this.score, this.score.length);
		
		return cloned;
		
	}
	
	public String toString(){return id+"\t"+name+"\t"+password+"\t"+age+"\t"+adult+"\t"+score[0]+"\t"+score[1];}
	
	public Member getMember(){
		Member cloned=null;
		try {
			cloned=(Member)this.clone();
		} catch (Exception e) {
			e.getMessage();
		}return cloned;
		
	}	
	
}