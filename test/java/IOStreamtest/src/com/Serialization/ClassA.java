package com.Serialization;

import java.io.Serializable;

public class ClassA implements Serializable{

	//serialVersionUID를 private static final 로 선언합니다
	private static final long serialVersionUID = -4037774944889988055L;
	
	//직렬화에 포함할겁니다
	int field1;
	ClassB field2=new ClassB();
	
	//field3, 4 는 직렬화에서 제외할겁니다
	static int field3;
	transient int field4; 
}
