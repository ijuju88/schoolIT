package com.interfacetest;

public interface PersonInterface {
	void setName(String name);
	void setAge(int age);
	void dispaly();
	
	default void defMethod()
	{System.out.println("Person default Metnod!!");}
	
	static void stataicMethod(){
		System.out.println("Person static Metnod!!");}
	
	boolean comperTo(PersonInterface per);
}
