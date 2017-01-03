package com.util;

import java.util.Arrays;

import org.omg.CORBA.OMGVMCID;

public class Arraystest3 {

	public static void main(String[] args) {
		int a[]={1,5,2,3};
		Arrays.sort(a);
		
		for (int i : a) {System.out.println(i);}
		
		String names[]={"홍길동", "박동수", "김민수"};
		Arrays.sort(names);
		for (String st : names) {
			System.out.println(st);
		}
		
		Person p1= new Person("홍길동",20);
		Person p2=new Person("박동수",21);
		Person p3=new Person("김민주",28);
		
		Person persons[]={p1, p2, p3};
		
		Arrays.sort(persons);
		for (Person person : persons) {System.out.println(person);}

	}

}


class Person implements Comparable<Person>{
	String Pname;
	Integer Page;
	
	public Person(String Pname, int Page) 
	{this.Pname=Pname; this.Page=Page;}
	
	public String toString(){
		return Pname +"\t"+Page;
	}
	
	//비교할 대상을 정하려고 만듭니다
	//객체로 되기때문에 만약에 int로 할거면 int를 Integer로 해야합니다
	@Override
	public int compareTo(Person p){
		return Pname.compareTo(p.Pname);
	}
}