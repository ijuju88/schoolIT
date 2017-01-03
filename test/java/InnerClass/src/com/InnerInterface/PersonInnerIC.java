package com.InnerInterface;

public interface PersonInnerIC {
	void wake();
}

class Anonymous{
	int time;
	
	PersonInnerIC field=new PersonInnerIC(){
		void work()
		{time=6; System.out.println("빨리 일어나!! 안그럼 지각임 >_<");}
		public void wake() 
		{System.out.println(time+"시에 일어납니당 -_-"); ; work();}
	};
	
	void method1(){
		//field.wait(); 익명 객체안에 생성되서 구현되지가 않아요 ㅠ
		field.wake();
		}
	
	void method(){
		PersonInnerIC localVar=new PersonInnerIC(){
			void walk(){System.out.println("산책가장 ^^*");}
			
			public void wake()
			{System.out.println("7시에 일어납니당 *^*"); walk();}
		};
		localVar.wake();
	}
}
