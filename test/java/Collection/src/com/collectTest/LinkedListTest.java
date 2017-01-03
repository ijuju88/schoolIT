package com.collectTest;

import java.util.*;

public class LinkedListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime = 0;
		long endTime = 0;
		
		List<Integer> list1=new LinkedList<>();
		
		startTime=System.nanoTime();
		for (int i = 1; i <= 100000; i++) {
			list1.add(i);
		}
		endTime=System.nanoTime();
		System.out.println("LinkedList 삽입 걸리는 시간 : "+(endTime-startTime));
		
		
		startTime=System.nanoTime();
		for (int i = 1; i < 10000 ; i++) {
			list1.remove(i);
		}
		endTime=System.nanoTime();
		System.out.println("LinkedList 삭제 걸리는 시간 : "+(endTime-startTime));
		
		
		List<Integer> list2=new ArrayList<>();
		startTime=System.nanoTime();
		for (int i2 = 1; i2 <= 100000; i2++) {
			list2.add(i2);
		}
		endTime=System.nanoTime();
		System.out.println("ArrayList 삽입 걸리는 시간 : "+(endTime-startTime));
	
		
		startTime=System.nanoTime();
		for (int i2 = 1; i2 < 10000; i2++) {
			list2.remove(i2);
		}
		endTime=System.nanoTime();
		System.out.println("ArrayList 삭제 걸리는 시간 : "+(endTime-startTime));
	}

}
