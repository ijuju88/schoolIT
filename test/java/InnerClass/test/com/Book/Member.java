package com.Book;


//회원등록
public class Member { 
	String id, pw, name, tel;
	

	
	public Member(){}
	public Member(String id,String pw, String name, String tel) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.tel = tel;
	}
	
	//나중에 대여시 값을 불려와야되서 get, set메소드를 만듬!
	String getId() {return id;}
	void setId(String id) {this.id = id;}
	
	String getPw() {return pw;}
	void setPw(String pw) {this.pw = pw;}
	
	String getName() {return name;}
	void setName(String name) {this.name = name;}
	
	String getTel() {return tel;}
	void setTel(String tel) {this.tel = tel;}
	

	//아디, 패스워드 검사
	public boolean setMember(String id, String pw){
		if(this.id.equals(id)&&this.pw.equals(pw)){return true;}
		else{return false;}
	}
	
	
	//출력
	public void display(){
		System.out.println(id+"\t"+pw+"\t"+name+"\t"+tel);
	}

}
