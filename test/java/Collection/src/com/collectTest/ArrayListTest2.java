package com.collectTest;


import java.util.*;

public class ArrayListTest2 {
	private static final List<Student> Student = null;
	private static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run=true;
		List<Student> students=new ArrayList<>();
		while (run) {
			System.out.println("추가(1) 조회(2) 삽입(3) 삭제(4) 종료(5)");
			System.out.print("선택 >> ");
			int select=sc.nextInt();
			
			switch (select) {
			case 1:
				System.out.print("학번 이름 전공(각해당란에 ,로구분합시다)");
				String str=sc.next();
				String[] strs=str.split(",");
				int sno=Integer.parseInt(strs[0]);
				String name=strs[1];
				String major=strs[2];
				Student student=new Student(sno, name, major);
				students.add(student);
				break;
			case 2:
				for (Student s : students) {
					System.out.println(s.toString());
				}
				break;
			case 3:
				System.out.println("삽입할 번호넣기");
				System.out.print("번호");
				int setstr=sc.nextInt();
				if(setstr>=0 && setstr<students.size()){
					student=input();
					students.add(setstr, student);
				}else {System.out.println("없음!!");}
				break;
			case 4:
				System.out.println("삭제할 번호");
				System.out.print("번호");
				int restr=sc.nextInt();
				if(restr>=0 && restr<students.size()){
					students.remove(restr);
				}else {System.out.println("없음!!");}
				break;
			case 5:
				run=false;
				break;
			default:
				break;
			}
		}
	}
	private static Student input() {
		System.out.print("학번 이름 전공(각해당란에 ,로구분합시다)");
		String str=sc.next();
		String[] strs=str.split(",");
		int sno=Integer.parseInt(strs[0]);
		String name=strs[1];
		String major=strs[2];
		Student student=new Student(sno, name, major);
		return student;
	}


}

class Student{
	int sno;
	String name, major;
	
	public Student(int sno, String name, String major) 
	{this.sno=sno; this.name=name; this.major=major;}
	
	public String toString(){
		return sno+", "+name+", "+major;
	}
}