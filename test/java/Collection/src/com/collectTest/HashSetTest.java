package com.collectTest;

import java.util.*;

public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set=new HashSet<>();
		set.add("자바");
		set.add("안드로이드");
		set.add("oracle");
		set.add("HTML");
		set.add("자바");
		
		//값을 읽어오는데 순서가 뒤죽박죽~~
		//같은 값은 저장이 안되는걸 알 수 있음
		//for문으로 출력할 수 없음
		//System.out.println(set.toString()); 
		
		//순서대로 나오게 하기
		Iterator keys=set.iterator();
		while (keys.hasNext()) {
			System.out.println(keys.next());
		}
		
	}
}
