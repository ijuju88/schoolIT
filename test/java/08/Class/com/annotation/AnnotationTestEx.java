package com.annotation;

import java.lang.reflect.Method;

public class AnnotationTestEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Method[] declaredMethods=Service.class.getDeclaredMethods();
		
		//Method객체를 하나씩 처리
		for (Method method : declaredMethods) {
			// AnnotationTest 객체얻기
			if(method.isAnnotationPresent( AnnotationTest.class)){
			 AnnotationTest  annotationTest=method.getAnnotation( AnnotationTest.class);
			
			//메소드 이름출력
			System.out.println("["+method.getName()+"]");
			
			//구분선출력
			for (int i = 0; i <  annotationTest.number(); i++) {
				System.out.print(annotationTest.value());
			}
			System.out.println(" ");
			
			
			try{
				//메소드 호출
				method.invoke(new Service());
			}catch(Exception e){}
			System.out.println(" ");
			}
		}
				
	}

}
