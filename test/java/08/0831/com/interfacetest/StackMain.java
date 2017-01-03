package com.interfacetest;

public class StackMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack stack=new StringStack(5);

		System.out.println(stack.push("1"));
		System.out.println(stack.push("2"));
		System.out.println(stack.push("3"));
		System.out.println(stack.push("4"));
		System.out.println(stack.push("5"));
		System.out.println(stack.push("6"));
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

	}

}
