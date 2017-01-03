package com.collectTest;

import java.util.*;

class Student11{
	int num1, num2, sum;
	public Student11(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;;
		this.sum=num1+num2; 
	}
	
	public String toString(){
		return num1+" "+num2+" "+sum+" ";
	}
}

class AscendingComparator implements Comparator<Student11>{
	@Override
	public int compare(Student11 o1, Student11 o2) {
		if(o1.sum<o2.sum) return 1;
		else if(o1.sum>o2.sum) return -1;
		else return 0;
	}
}
public class ComparatorTest {

	public static void main(String[] args) {
		TreeMap<Student11, String> treeset = new TreeMap<>
		(new AscendingComparator());

		treeset.put(new Student11(86, 34), "홍길동");
		treeset.put(new Student11(73, 68), "김철수");
		treeset.put(new Student11(86, 95), "박영자");
		treeset.put(new Student11(72, 86), "김철구");

		Map.Entry<Student11, String> entry=null;
		while (!treeset.isEmpty()) {
			entry=treeset.pollLastEntry();
			System.out.println(entry.getKey()+entry.getValue());
		}
		
	}
}
