package com.AbstractTest;

public class Shapeabstest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PointAb p1 = new PointAb(3, 2);
		PointAb p2 = new PointAb(2, 3);

		System.out.println(p1.equals(p2));

		RectAb r1 = new RectAb(10, 5);
		RectAb r2 = new RectAb(5, 10);

		System.out.println(r1.equals(r2));

	}

}
