package com.test;

public class Member {
	private String name, id, password;
	private int age;
	
	Member() {}
	Member(String name, String id){this.name=name; this.id=id;}
	Member(String name, String id, String password, int age)
	{this.name=name; this.id=id;this.password=password; this.age=age;}
	
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	
	public String getId() {return id;}
	public void setId(String id) {this.id = id;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	
	public int getAge() {return age;}
	public void setAge(int age) {this.age = age;}

	public boolean login(String id, String password)
	{
		if(id.equals(this.id)&& password.equals(this.password))return true;
		else return false;
	}
	
	public void logout(String id){System.out.println(id+"님께서 로그아웃하셨습니다.");}

}


