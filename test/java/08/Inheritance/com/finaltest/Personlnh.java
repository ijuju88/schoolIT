package com.finaltest;

/*
필드 :이름, 나이
생성자 : Person(){}
      Person(String name, int age){ .....}
메소드 : display(){} // 이름 나이 출력
*/
public class Personlnh {
String name; int age;
      
public Personlnh() {}
public Personlnh(String name, int age){this.name=name; this.age=age;}

public void display(){
System.out.println(name+"\t"+age);
}

}