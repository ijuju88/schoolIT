package com.collectTest;

import java.util.TreeSet;

class Person12 implements Comparable<Person12> {
	public String name;
	 public int age;
	 
	 public Person12(String name, int age) {
	  this.name = name;
	  this.age = age;
	 }
	 
	 public String toString(){
		return name+" "+age;
	 }
	 @Override
	 public int compareTo(Person12 o) {
	  if(age<o.age) return -1;
	  else if(age == o.age) return 0;
	  else  return 1;
	 }

}

public class ComparableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Person12> treeset = new TreeSet<>();

		treeset.add(new Person12("홍길동", 22));
		treeset.add(new Person12("김상태", 21));
		treeset.add(new Person12("박영주", 26));
		treeset.add(new Person12("윤주현", 20));

		for (Person12 p : treeset) {
			System.out.println(p);
		}
	}

}
