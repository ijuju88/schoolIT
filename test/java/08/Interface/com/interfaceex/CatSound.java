package com.interfaceex;

class CatSound implements Soundable {
	String sound;
	@Override
	public String sound() {
		sound="야옹";
		return sound;
		
	}



}
