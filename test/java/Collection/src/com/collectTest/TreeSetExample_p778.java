package com.collectTest;

import java.util.*;

public class TreeSetExample_p778 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<StudentEx10> treeset=new TreeSet<>();
		treeset.add(new StudentEx10("blue", 96));
		treeset.add(new StudentEx10("hong", 86));
		treeset.add(new StudentEx10("white", 92));
		
		StudentEx10 st=treeset.last();
		System.out.println("최고점수:"+st.score);
		System.out.println("최고점수가진이:"+st.id);
		
	}

}

class StudentEx10 implements Comparable<StudentEx10>{
	public String id;
	public int score;
	
	public StudentEx10(String id, int score) {
		super();
		this.id = id;
		this.score = score;
	}
	@Override
	public int compareTo(StudentEx10 o) {
		if(this.score<o.score)return -1;
		else if(this.score>o.score)return 1;
		else return 0;
	}
}