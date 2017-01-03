package com.lang;

import java.util.*;

public class SystemTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long startTime=System.nanoTime();
		
		int sum=0;
		for (int i = 1; i < 10000000; i++) {
			sum+=i;
		}
		
		long endTime=System.currentTimeMillis();
		System.out.println(endTime-startTime);
		
		System.out.println("--------------------------------------");
		
		String javaHome=System.getenv("JAVA_HOME");
		System.out.println(javaHome);
		
		System.out.println("--------------------------------------");
		
		String osName=System.getProperty("os.name");
		String userName=System.getProperty("user.name");
		String userHome=System.getProperty("user.home");
		System.out.println(osName);
		System.out.println(userName);
		System.out.println(userHome);
		
		System.out.println("--------------------------------------");
		
		Properties pros=System.getProperties();
		Set keys=pros.keySet();
		
		for (Object objKey : keys) {
			String key=(String)objKey;
			String value=System.getProperty(key);
			
			System.out.println(key+" : "+value);		
		}
		
	}

}
