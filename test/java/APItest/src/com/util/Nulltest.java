package com.util;

import java.util.Objects;

public class Nulltest {

	public static void main(String[] args) {
		String str1="홍길동";
		String str2=null;
		
		System.out.println(Objects.requireNonNull(str1));
		try {
			System.out.println(Objects.requireNonNull(str2));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			System.out.println(Objects.requireNonNull(str1, "null!"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println(Objects.toString(str1, "null메세지"));
		System.out.println(Objects.toString(str2, "null메세지"));

	}

}
