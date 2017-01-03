package com.Serialization;

import java.util.ArrayList;

class ttt {
	public void eat(){}
}

class Student extends ttt{
	public void study(){}
}

public class aaa{
	public static void main(String[] args) {
		ArrayList<ttt> list=new ArrayList<>();
		list.add(new Student());
		///Object o=list.get(0);
		list.set(0, new ttt());
	}
}
