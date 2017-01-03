package com.util;

import java.util.*;

public class Arraytest4 {

	public static void main(String[] args) {
		int[] iarray={3,2,10,30,11};
		Arrays.sort(iarray);// 검색을 위해 정렬을합니당
		
		int index=Arrays.binarySearch(iarray, 10);
		System.out.println(index+", "+iarray[index]);
		
		String names[]={"홍길동", "박동수", "김민수"};
		Arrays.sort(names);// 검색을 위해 정렬을 합니당
		
		index=Arrays.binarySearch(names, "박동수");
		System.out.println(index+", "+names[index]);

		
		//객체검색
		PersonSearch pr1= new PersonSearch("홍길동",20);
		PersonSearch pr2=new PersonSearch("김민주",28);
		PersonSearch pr3=new PersonSearch("박동수",21);

		
		PersonSearch pers[]={pr1, pr2, pr3};
		
		Arrays.sort(pers);
		index=Arrays.binarySearch(pers, pr2);
		System.out.println(index+", "+pers[index]);

	}

}


class PersonSearch implements Comparable<PersonSearch>{
	String Pname;
	Integer Page;
	
	public PersonSearch(String Pname, int Page) 
	{this.Pname=Pname; this.Page=Page;}
	
	public String toString(){
		return Pname +"\t"+Page;
	}
	
	//비교할 대상을 정하려고 만듭니다
	//객체로 되기때문에 만약에 int로 할거면 int를 Integer로 해야합니다

	@Override
	public int compareTo(PersonSearch o) {
		return Page.compareTo(o.Page);
	}
}