package com.AbstractTest;

public class AnimalEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog=new Dog();
		Cat cat=new Cat();
		
		dog.sound();
		cat.sound();
		
		System.out.println("---------");
		
		//변수의 자동 타입 변환
		Animal an=null;
		an=new Dog(); an.sound();
		an=new Cat(); an.sound();
		
		System.out.println("---------");
		
		//메소드의 다형성
		animalSound(new Dog());
		animalSound(new Cat());
		
	}
		private static void animalSound(Animal a) {a.sound();}
}