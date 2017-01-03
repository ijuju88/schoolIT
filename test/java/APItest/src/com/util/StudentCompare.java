package com.util;

import java.util.Comparator;


public class StudentCompare implements Comparator<StudentT>{

	@Override
	public int compare(StudentT a, StudentT b) {
		if(a.sno < b.sno){return -1;}
		else return 2;
	}

}

class StudentT{
	int sno;
	String name;
	
	public StudentT(int sno) {this.sno=sno;}
	
	int compareTo(Object obj){
		StudentT s=(StudentT)obj;
		if(this.sno<s.sno){return -1;}
		else return 2;
	}
}


