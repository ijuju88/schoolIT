package com.collectTest;

import java.util.*;

public class SetMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> hashset=new HashSet<>();
		hashset.add("포도");
		hashset.add("사과");
		hashset.add("바나나");
		
		//순서가 없으므로 반복자로 불러옴
		Iterator<String> it=hashset.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("--------------");
		
		Map<String, Integer> maps=new HashMap<>();
		//map는 put로 넣음
		maps.put("홍길동", 92);
		maps.put("김철수", 75);
		maps.put("박영자", 57);
		maps.put("김영주", 79);
		
		System.out.println(maps.get("박영자"));
		System.out.println("--------------");
		
		//순차 저장이 안되서 반복자를 쓰는데 set로 만들어서 합니다
		Set<String> keys=maps.keySet();
		Iterator<String> it1=keys.iterator();
		
		while (it1.hasNext()) {
			String key=it1.next();
			System.out.println(key+":"+maps.get(key));
		}
		
		//HashTable(HashMap+동기화)
		Map<String, Integer> mapt=new Hashtable<>();
		//map는 put로 넣음
		mapt.put("홍길동", 92);
		mapt.put("김철수", 75);
		mapt.put("박영자", 57);
		mapt.put("김영주", 79);
		
		System.out.println(mapt.get("박영자"));
		System.out.println("--------------");
		
		//순차 저장이 안되서 반복자를 쓰는데 set로 만들어서 합니다
		Set<String> keyt=mapt.keySet();
		Iterator<String> it2=keys.iterator();
		
		while (it2.hasNext()) {
			String key=it2.next();
			System.out.println(key+":"+mapt.get(key));
		}

	}

}
