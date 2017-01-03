package com.interfacetest;

public class Scoretest {

	public static void main(String[] args) {
		
		//선언하기
		KorScore ks=new KorScore();
		//Score sc=new KorScore();
		ks.setScore(90);
		ks.display();
		ks.deMethod();
		Score.staticMethod(); //static메소드 찾기!
		
		//안에서만 사용가능
		Score sc1=new Score() {
			int korScore;
			@Override
			public void setScore(int score) 
			{korScore=score;}
			
			@Override
			public void display() 
			{System.out.println(korScore);}
		};
		
		sc1.setScore(60);
		sc1.display();
	}

}
