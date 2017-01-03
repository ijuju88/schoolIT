package com.datatype;

public class DataType1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*char v1='A';
		int[] arrv={1,2,3}; //배열
		
		
		if(v1=='A')
		{
			int v2=100;
			double v3=3.14;
			System.out.println(v2);
			System.out.println(v3);
		}
		
		boolean v4=true;
		
		System.out.println(v1);
		System.out.println(v4);
		System.out.println(arrv);//배열의 참조값
*/		
		
		//참조변수의 ==, != 연산
		
		/*int v1=2, v2=2;
		
		System.out.println(v1==v2);  //true
		System.out.println(v1!=v2);  //false
		
		Person p1=new Person();
		Person p2=new Person();
		
		System.out.println(p1==p2);  //false 선언하면 각각의 영역에 만들어지므로 참조값이 다름
		System.out.println(p1!=p2);  //true
		
		p2=p1;
		System.out.println(p1==p2);
		
		//String
		System.out.println(p1.name==p2.name);
		//true 이미 문자열이 있는 경우 jvm에서 만들어짐
		
		String str1=new String("abc");
		String str2=new String("abc");
		
		System.out.println(str1==str2);  
		//사용자에 의해 만들어지므로 각각의 개체를 생성함
		
		
		System.out.println(p1.age+", "+ p1.name); //20, hong
		
		p1=null; //주소를 초기화 설정 더이상 객체를 참조하지 않음
		//System.out.println(p1.age+", "+ p1.name);
		//java.lang.NullPointerException 
		
		if(p1==null)
			System.out.println("p1=null");
		else
			System.out.println("p1=not null");
			
		
		Person p0;//변수는 선언되었지만 객체가 만들어지지 않음
		*/
		
		String name1="park", name2="park";

		System.out.println(name1==name2);
		System.out.println(name1.equals(name2));
		
		String name3= new String("park");
		String name4= new String("park");
		

		System.out.println(name3==name4);
		System.out.println(name3.equals(name4));

		
		String str1="abc";
		char[] data1={'a','b','c'};
		
		System.out.println(data1);
		String str2=new String(data1);
		System.out.println(str2);
		System.out.println(str1.substring(0, 3)); //글자를 자르세용 
		System.out.println(str1.length()); //글자의 길이
		System.out.println(str1.concat("aaaaa")); //글자뒤에 합하세용
		System.out.println(str1.contains("b"));  //글자안에 같은글자가 있는가?
		System.out.println(str1.indexOf('c')); //글자안에 같은 글자가 있는 인덱스 번호는?
		
		String file1="d:aaa\\bbb\\ccc\\abcde.exe"; // \\=/
		
		System.out.println
		(file1.substring(file1.indexOf(".")+1, file1.length()));
		System.out.println
		(file1.substring(file1.lastIndexOf("\\")+1, file1.length()));
		
	}

}


class Person{
	int age=20;
	String name="hong";
}
