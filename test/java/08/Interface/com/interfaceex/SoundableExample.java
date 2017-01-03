package com.interfaceex;

public class SoundableExample {
	public static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
		
	}
	public static void main(String[] args) {
		printSound(new CatSound());
		printSound(new DogSound());
	}

	
}
