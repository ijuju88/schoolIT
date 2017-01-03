package com.Inhertest;

public class HankookTire extends Tire {

	public HankookTire(String location, int maxRotation) {
		super(location, maxRotation);}

	@Override
	public boolean roll(){
		if(accmulatedRototion<maxRotation){
			System.out.println(location+"Hankook 수명 : "
			+(maxRotation-accmulatedRototion)+ "회");
		return true;
		}else
		{
			System.out.println("****"+location+"Hankook 펑크****");
			return false;
		}
	
	}
}
