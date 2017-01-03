package com.interfaceex;

public class DogSound implements Soundable {
	String sound;
	@Override
	public String sound() {
		return sound="멍멍";
	}

}
