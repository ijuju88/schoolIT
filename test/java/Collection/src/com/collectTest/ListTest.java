package com.collectTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ArrayList
		List<Person> arr=new ArrayList<>();
		arr.add(new Person("홍길동", 20));
		arr.add(new Person("김철수", 27));
		arr.add(new Person("박영자", 24));
		
		for (Person person : arr) {
			System.out.println(person);
		}
		System.out.println("-------------");
		
		arr.add(1, new Person("김수영",23));
		for (Person person : arr) {
			System.out.println(person);
		}
		System.out.println("-------------");
		
		arr.remove(1);
		for (Person person : arr) {
			System.out.println(person);
		}
		
		//Vector
		List<Integer> vlist=new Vector<>();
		vlist.add(2);
		vlist.add(3);
		vlist.add(5);
		vlist.add(10);
		
		for (Integer integer : vlist) {
			System.out.println(integer);
		}
		System.out.println("-------------");
		
		vlist.add(2,4);
		for (Integer integer : vlist) {
			System.out.println(integer);
		}
		System.out.println(vlist.contains(5)); //5가 있음?
		System.out.println("-------------");
		
		//LinkedList
		List<String> link=new LinkedList<>();
		link.add("홍길동");
		link.add("김철수");
		link.add("박영자");
		
		for (String string : link) {
			System.out.println(string);
		}
		System.out.println("-------------");
		
	}

}

class Person{
	String name;
	int age;
	
	public Person(String name,int age)
	{this.name=name; this.age=age;}
	
	public String toString(){return name+", "+age;}
}