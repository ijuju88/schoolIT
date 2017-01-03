package com.AbstractTest;

public class RectAb extends ShapeAb {
	int width, height;
	public RectAb(int width, int height){this.width=width; this.height=height;}
	 
	@Override
	public boolean equals(Object obj) {
	RectAb re=new RectAb(width, height);
	if(this.width==re.width && this.height==re.height){return true;}
	else return false;
	 
	}

}
