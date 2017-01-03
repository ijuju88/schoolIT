package com.agm.student2;

import java.util.ArrayList;

public class Student {
	int sno;
	String name, dept;
	ArrayList<String> hobby;
	
	Score score;
	
	
	public Student(int sno, String name) {
		this.sno=sno;
		this.name=name;
	}
	
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}

	public ArrayList<String> getHobby() {
		return hobby;
	}

	public void setHobby(ArrayList<String> hobby) {
		this.hobby = hobby;
	}

	
	public String toString(){
		return sno+","+name;
	}
}
