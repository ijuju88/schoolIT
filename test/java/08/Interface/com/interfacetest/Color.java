package com.interfacetest;

public interface Color {
	void setColor(String color);
	void ColorDisplay();
}

class ClassColor implements Color{
	String color;
	
	public void setColor(String color){this.color=color;}
	public void ColorDisplay() {
	System.out.println(color);}
}
