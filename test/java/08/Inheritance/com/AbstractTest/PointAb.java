package com.AbstractTest;

public class PointAb extends ShapeAb {
	int x, y;
	public PointAb(int x, int y){this.x=x; this.y=y;}


	@Override
	public boolean equals(Object obj) {
	ShapeAb sh=(PointAb) obj;
	if(this.x==((PointAb)sh).x && this.y==((PointAb)sh).y){return true;}
	else return false;
	}

}

