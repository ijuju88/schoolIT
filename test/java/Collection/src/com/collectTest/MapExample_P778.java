package com.collectTest;

import java.util.HashMap;
import java.util.Map;

public class MapExample_P778 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Integer> map=new HashMap<>();
		map.put("blue", 96);
		map.put("hong", 86);
		map.put("white", 92);
		
		String name=null;
		int maxScore=0;
		int totScore=0;
		
		for(Map.Entry<String, Integer> entry :map.entrySet()){
			if(entry.getValue()>maxScore){
				name=entry.getKey();
				maxScore=entry.getValue();
			}
			totScore+=entry.getValue();
		}
		
		System.out.println("평균점수:"+totScore/3);
		System.out.println("최고점수:"+maxScore);
		System.out.println("최고점수가진이:"+name);
	}

}
