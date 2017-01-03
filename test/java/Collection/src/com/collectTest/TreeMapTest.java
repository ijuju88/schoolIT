package com.collectTest;

import java.util.*;
import java.util.Map.Entry;

public class TreeMapTest {
	public static void main(String[] args) {
		TreeMap<String, Integer> scores=new TreeMap<>();
		
		scores.put("홍길동", 87);
		scores.put("이동수", 81);
		scores.put("박길순", 76);
		scores.put("신용권", 98);

		NavigableMap<String, Integer> descmap=scores.descendingMap();
		Set<Map.Entry<String, Integer>> descSet=descmap.entrySet();
		
		for (Entry<String, Integer> entry : descSet) {
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		System.out.println("----------------");
		
		NavigableMap<String, Integer> ascmap=descmap.descendingMap();
		Set<Map.Entry<String, Integer>> ascSet=ascmap.entrySet();
		
		for (Entry<String, Integer> entry : ascSet) {
			System.out.println(entry.getKey()+"-"+entry.getValue());
		}
		
		System.out.println("[박~이 씨 검색]");
		NavigableMap<String, Integer> rangeMap=scores.subMap("박", true, "이", true);
		for (Entry<String, Integer> entry : rangeMap.entrySet()) {
			System.out.println(entry.getKey());
		}
		
//		Map.Entry<String, Integer> entry=null;
//		entry=scores.firstEntry();
//		System.out.println(entry.getKey()+"-"+entry.getValue());
//	
//		entry=scores.lastEntry();
//		System.out.println(entry.getKey()+"-"+entry.getValue());
//	
//		entry=scores.lowerEntry("이동수");
//		System.out.println(entry.getKey()+"-"+entry.getValue());
//	
//		entry=scores.higherEntry("이동수");
//		System.out.println(entry.getKey()+"-"+entry.getValue());
//	
//		//가까운 값 찾기
//		entry=scores.floorEntry("이동화");
//		System.out.println(entry.getKey()+"-"+entry.getValue());
//		
//		entry=scores.ceilingEntry("이동미");
//		System.out.println(entry.getKey()+"-"+entry.getValue());
//		
//		System.out.println("----------------");
//		
//		while (!scores.isEmpty()) {
//			entry=scores.pollLastEntry();
//			//System.out.println(entry);
//			System.out.println(entry.getKey()+"-"+entry.getValue()
//			+" 남은 객체 : "+scores.size());
//		}
		
		
	}
}
