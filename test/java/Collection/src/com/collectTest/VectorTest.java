package com.collectTest;

import java.util.*;

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new Vector<Integer>(); //래퍼클래스 타입이기 때문에 int가 아닙니다

		list.add(10);
		list.add(20);
		list.add(30);
		
		for (Integer i : list) 
		{System.out.print(i.toString()+" ");}
		System.out.println();
		
		list.add(1, 40); //인덱스 1위치에 40추가
		for (Integer i1 : list)
		{System.out.print(i1.toString()+" ");}
		System.out.println();
		
		list.set(1, 50);
		for (Integer i1 : list)
		{System.out.print(i1.toString()+" ");}
		System.out.println();
		
		list.remove(1);
		for (Integer i1 : list)
		{System.out.print(i1.toString()+" ");}
		System.out.println();
	}

}
