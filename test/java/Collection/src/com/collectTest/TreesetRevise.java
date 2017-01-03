package com.collectTest;

import java.util.NavigableSet;
import java.util.TreeSet;

public class TreesetRevise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.add("사과");
		treeSet.add("배");
		treeSet.add("바나나");
		treeSet.add("오렌지");
		treeSet.add("딸기");

		System.out.println("처음-" + treeSet.first() + " 끝-" + treeSet.last());
		
		System.out.println("---------[내림차순]---------");
		NavigableSet<String> desc = treeSet.descendingSet();
		for (String d : desc) {
			System.out.print(d + " ");
		}
		System.out.println();
		
		System.out.println("---------[오름차순]---------");
		NavigableSet<String> asc = desc.descendingSet();
		for (String c : asc) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		
		System.out.println("-------[바~사 사이글자]-------");
		NavigableSet<String> ns = treeSet.subSet("바", true, "사", true);
		for (String s : ns) {
			System.out.print(s + " ");
		}
		System.out.println();

		System.out.println("-------------------------");

		while (!treeSet.isEmpty()) {
			System.out.println(treeSet.pollFirst() + "남은 객체-" + treeSet.size());
		}
	}

}
