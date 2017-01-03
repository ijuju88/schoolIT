package com.collectTest;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapRevise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, Integer> treemap=new TreeMap<>();
		treemap.put("사과", 1500);
		treemap.put("배", 2300);
		treemap.put("포도", 1800);
		treemap.put("딸기", 3600);
		treemap.put("복숭아", 2800);
			
		System.out.println("-----[처음, 끝]-----");
		System.out.println(treemap.firstEntry()+" "+treemap.lastEntry());
		
		Map.Entry<String, Integer>entry=null;
		entry=treemap.firstEntry();
		System.out.print(entry.getKey()+"-"+entry.getValue()+" ");
	
		entry=treemap.lastEntry();
		System.out.println(entry.getKey()+"-"+entry.getValue());

		
	}

}
