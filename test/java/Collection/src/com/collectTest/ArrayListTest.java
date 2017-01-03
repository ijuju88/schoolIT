package com.collectTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<>();
		list.add("홍길동"); //추가하기
		list.add("홍수정");
		System.out.println(list.size()); //길이
		System.out.println(list.get(0)+","+list.get(1));
		System.out.println();
		
		list.add(1,"김자바"); 
		list.set(1, "김지바"); //들어있는값 변경
		for (String s : list) {
			System.out.print(s.toString()+" "); //밀려버렸습니다
		}System.out.println();
		
		list.remove(1); //1번 인덱스 삭제
		for (String s : list) {
			System.out.print(s.toString()+" "); //밀려버렸습니다
		}System.out.println();
		
		list.clear(); //다지우기
		System.out.println(list.isEmpty()); //데이터가 없는지 확인-없으면 true
	}

}
