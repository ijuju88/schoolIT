package com.grnerictest;

class Person{
	String name;
	int age;
	public Person(String name, int age){
		this.name=name;
		this.age=age;
	}
	public String toString(){return name+", "+age;}
}

class Box<E>{
	private E e;
	public void set(E e){this.e=e;};
	public E get(){return e;}
}

public class GenericTest {
	
	public static void main(String[] args){
		Box<String> box=new Box<String>();
		box.set("hello!");
		System.out.println(box.get());
		
		Box<Integer> ibox=new Box<Integer>();
		ibox.set(10);
		System.out.println(ibox.get());
		
		Person p1=new Person("홍길동", 22);
		Box<Person> pbox=new Box<Person>();
		pbox.set(p1);
		System.out.println(pbox.get());
	}
}
