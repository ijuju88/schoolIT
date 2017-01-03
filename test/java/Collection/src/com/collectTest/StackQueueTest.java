package com.collectTest;

import java.util.*;

public class StackQueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack=new Stack<>();
		stack.push("사과");
		stack.push("배");
		stack.push("딸기");
		stack.push("바나나");
		
		//스택에서 제거 안됨
		//System.out.println(stack.peek());
		//System.out.println(stack.peek());
		
		//스택에서 제거됨
		//System.out.println(stack.pop());
		//System.out.println(stack.pop());
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop()+" ");
		}System.out.println();
		
		
		Queue<String> queue=new LinkedList<>();
		queue.offer("사과");
		queue.offer("배");
		queue.offer("딸기");
		queue.offer("바나나");
		
		while (!queue.isEmpty()) {
			System.out.print(queue.poll()+" ");
		}
			
	}

}
