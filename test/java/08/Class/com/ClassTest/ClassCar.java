package com.ClassTest;

class ClassCar{
	private String model, color;
	private int year, speed, maxSpeed;
	
	public String getModel() {return model;}
	public void setModel(String model) {this.model = model;}

	public String getColor() {return color;}
	public void setColor(String color) {this.color = color;}

	public int getYear() {return year;}
	public void setYear(int year) {this.year = year;}

	public int getSpeed() {return speed;}
	public void setSpeed(int speed) {this.speed = speed;}

	public int getMaxSpeed() {return maxSpeed;}
	public void setMaxSpeed(int maxSpeed) {this.maxSpeed = maxSpeed;}

	
	ClassCar() {}

	ClassCar(String model, String color, int year) 
	{this.model = model;  this.color = color; this.year = year;}
	
	ClassCar(String model, String color, int year, int speed, int maxSpeed) {
		this.model = model;  this.color = color; this.year = year;
		this.speed = speed; this.maxSpeed = maxSpeed;}
	
	
	int speedUp(int addspeed){
		if(speed+addspeed>maxSpeed)
		{
			System.out.println("-----차량사항-----");
			System.out.println("과속");
			speed=maxSpeed;
		}else speed+=addspeed;
		
		return this.speed;}
	
	void speedDown(int dispeed){
		if(speed-dispeed<0)
		{
			System.out.println("-----차량사항-----");
			System.out.println("속도를 못냄");
			speed=0;
		}
		else speed-=dispeed;
		}
	
	void display(){
		System.out.println("-----차량사항-----");
		System.out.println(model+" "+color+" "+year);
		System.out.println(speed);
		System.out.println(maxSpeed);
	}
	
}