package com.util;

import java.util.Objects;

public class CompareTest {

	public static void main(String[] args) {
		StudentT s1=new StudentT(1);
		StudentT s2=new StudentT(1);
		StudentT s3=new StudentT(2);
		
		int result=Objects.compare(s1, s2, new StudentCompare());
		System.out.println(result);
		
		result=Objects.compare(s1, s3, new StudentCompare());
		System.out.println(result);
		
		System.out.println(s1.compareTo(s2));
		System.out.println(s1.compareTo(s3));
		
		
		
	}

}
