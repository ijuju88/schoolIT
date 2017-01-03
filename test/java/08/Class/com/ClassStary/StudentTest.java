package com.ClassStary;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Student stunum=new Student("hong", 53, 95, 86);
		stunum.Stutotal();
		stunum.Stuavg();*/
		Student stunum1=new Student("hong", 53, 91, 86);
		stunum1.Sumavg();
		stunum1.display();
	}

}

class Student{
	String name;
	//int kor,eng,math, total;
	//double avg;
	
	float []score=new float[5];
	
	Student(){}
	Student(String name, int kor, int eng, int math) 
	{this.name = name;
	this.score[0] = kor;this.score[1] = eng;this.score[2] = math;}
	
	void Sumavg()
	{score[3]=score[0]+score[1]+score[2]; 
	 score[4]=score[3]/3;}
	

	
/*	void Stutotal(){total=kor+eng+math;}
	void Stuavg(){avg=(double)total/3.0;}
	//int Stutotal(){return total=kor+eng+math;} */
	
	void display(){
		System.out.println("이름 : "+name);
		System.out.println("국어 : "+score[0]);
		System.out.println("영어 : "+score[1]);
		System.out.println("수학 : "+score[2]);
		System.out.println("총점 : "+score[3]);
		System.out.printf("평균 : %.2f", score[4]);
	}
}