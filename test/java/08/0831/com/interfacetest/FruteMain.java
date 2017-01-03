package com.interfacetest;

public class FruteMain {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frute fArr[]={new Grape(), new Apple(), new Pear()};
		for (Frute f : fArr) {
			f.print(f);
		}
	}

}
