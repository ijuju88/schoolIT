package com.util;

import java.util.Arrays;
import java.util.StringTokenizer;

public class Arraytestt {

	public static void main(String[] args) {
		String pn="02-561-8965,051-895-7956,031-672-6465";

		StringTokenizer pnser=new StringTokenizer(pn,"-,");
		while (pnser.hasMoreTokens()) {
			String token = pnser.nextToken();
			//System.out.println(token);
			for (int i = 0; i < token.length(); i+=3) {
				System.out.println(i);
			}
		}
	}

}
