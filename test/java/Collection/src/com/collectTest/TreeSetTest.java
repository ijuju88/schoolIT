package com.collectTest;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreeSetTest{
	public static void main(String[] args) {
		
		TreeSet<Integer> tst=new TreeSet<>();
		tst.add(85);
		tst.add(78);
		tst.add(68);
		tst.add(91);
		tst.add(90);
		
		//내림차순
		NavigableSet<Integer> desc=tst.descendingSet();
		for (Integer d : desc) {
			System.out.print(d+" ");
		}
		System.out.println();
		
		//오름차순
		NavigableSet<Integer> asc=desc.descendingSet();
		for (Integer a : asc) {
			System.out.print(a+" ");
		}
		System.out.println();
		
		//80보다 크고나 90보다 작은 값 출력
		NavigableSet<Integer> rangeSet=tst.subSet(80, true, 90, true);
		for (Integer r : rangeSet) {
			System.out.print(r+" ");
		}
		System.out.println();
		
		//정렬이 되네 음~ 
//		Integer tstnum=null;
//		tstnum=tst.first(); //맨앞
//		System.out.println(tstnum);
//		tstnum=tst.last(); //맨뒤
//		System.out.println(tstnum);
//		tstnum=tst.lower(90);
//		System.out.println(tstnum);
//		tstnum=tst.higher(90);
//		System.out.println(tstnum);
//		
//		while (!tst.isEmpty()) {
//			tstnum=tst.pollFirst();
//			System.out.println(tstnum+" 길이 : "+tst.size());
//		}
	}
}
