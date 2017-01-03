package com.agm.aop;

public class Student {
	private String name;
	private int age, gradeNum, classnum;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGradeNum() {
		return gradeNum;
	}
	public void setGradeNum(int gradeNum) {
		this.gradeNum = gradeNum;
	}
	public int getClassnum() {
		return classnum;
	}
	public void setClassnum(int classnum) {
		this.classnum = classnum;
	}
	
	public void getStudentInfo(){
		System.out.println("이름 : "+getName());
		System.out.println("나이 : "+getAge());
		System.out.println("번호 : "+getGradeNum());
		System.out.println("교실 : "+getClassnum());
	}
}
