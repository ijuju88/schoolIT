package com.Inhertest;

public class Tire {
	public int maxRotation, accmulatedRototion;
	public String location;
	
	public Tire(String location, int maxRotation)
	{
		this.location=location; 
		this.maxRotation=maxRotation;
	}
	


	public boolean roll(){
		++accmulatedRototion;
		if(accmulatedRototion<maxRotation){
			System.out.println(location +"Tier 수명"
			+(maxRotation-accmulatedRototion)+"회");
			return true;
		}else {
			System.out.println("****"+location+"Tire 펑크 ****");
		}
		return false;
	}
}