package com.interfacetest;

public class StringStack implements Stack {
	private int index;
	String [] stackArr;
	
	public StringStack(int size)
	{stackArr=new String[size]; index=0;}
	
	@Override
	public int length() {return stackArr.length;}

	@Override
	public Object pop() {
		if(index>0){index--;return stackArr[index];}
		else {System.out.println("없음"); return null;}
	}

	@Override
	public boolean push(Object ob) {
		if(index<length()){stackArr[index++]=(String) ob; return true;}
		else{
			System.out.println("없음");
			return false;
		}
	}

}
