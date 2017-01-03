package com.interfacetest;

public class ColorInfo {

	public static void main(String[] args) {

		Color us=new ClassColor();
		us.setColor("red");
		us.ColorDisplay();
		
		Color us1=new Color(){
			String color;
			@Override
			public void setColor(String color) 
			{this.color=color;}

			@Override
			public void ColorDisplay() 
			{System.out.println(color);}
			
		};
		us1.setColor("red");
		us1.ColorDisplay();
		
	}

}
