package com.InnerClass;

import com.InnerClass.A.B;

class A{
	B b=new B();
	C c=new C();
	
	//static B sb=new B();
	static C cb=new C();
	
	static void Method3(){
		//B b=new B();
		C c=new C();
	}
	
	
	void outMethod(){
		System.out.println("out");
	}
	
	
	class B{
		void display(){System.out.println("class B!"); A.this.outMethod();}
		}
		static class C{
			static void display(){System.out.println("class C!!");}
		}

	void Method(){
		class D{
			int field;
			void display()
			{System.out.println("class D!!!");
			System.out.println(field);}
		}
		D d= new D();
		d.field=3;
		d.display();
	}
	
	void Method2(){
		B b=new B();
		b.display();
	}
}
public class NestedCalssTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		A.B b=a.new B();
		A.C c=new A.C();
		
		
		a.c.display();//정적인 클래스로 만들어서 가능합니당
		b.display();
		c.display();
		a.Method();
		a.Method2();
		A a1=new A();
		a1.Method2();
		
	}

}
