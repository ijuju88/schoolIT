package com.util;

import java.util.Arrays;

public class Arraystest2 {

	public static void main(String[] args) {
		int[][] origin={{1, 2},{3, 4}};
		System.out.println("---얕은 복사---");
		
		int[][] cloned1=Arrays.copyOf(origin, origin.length);
		System.out.println("배열 번지 : "+origin.equals(cloned1));
		
		cloned1[0][0]=5;
		System.out.println("1차배열 항목 값 비교 : "+Arrays.equals(origin, cloned1));
		System.out.println("중첩배열 항목 값 비교 : "+Arrays.deepEquals(origin, cloned1));
	
		System.out.println("---깊은 복사---");
		int[][] cloned2=Arrays.copyOf(origin, origin.length);
		cloned2[0]=Arrays.copyOf(origin[0], origin[0].length);
		cloned2[1]=Arrays.copyOf(origin[1], origin[1].length);
		
		System.out.println("1차배열 항목 값 비교 : "+Arrays.equals(origin, cloned2));
		System.out.println("중첩배열 항목 값 비교 : "+Arrays.deepEquals(origin, cloned2));
	}

}
