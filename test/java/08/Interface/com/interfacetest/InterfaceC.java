package com.interfacetest;

public interface InterfaceC extends InterfaceA, InterfaceB {
	void MethodC();
	default void defaultMethod(){
		System.out.println("Infarface의 default Method!!");
	}
}
