package com.agm.aop;

public class Worker {
	private String name, job;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void WorkerInfo(){
		System.out.println("이름 : "+getName());
		System.out.println("나이 : "+getAge());
		System.out.println("직업 : "+getJob());
	}
}
