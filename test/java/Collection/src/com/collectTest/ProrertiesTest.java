package com.collectTest;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.*;

public class ProrertiesTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Properties pr=new Properties();
		String path=ProrertiesTest.class.
				getResource("data.properties").getPath();
		
		path=URLDecoder.decode(path,"UTF-8");
		pr.load(new FileReader(path));
		
		
		String set[]={
				pr.getProperty("name"),
				pr.getProperty("age"),
				pr.getProperty("id"),
				pr.getProperty("pw")
		};
		
		for (String str : set) {
			System.out.println(str);
		}
	}

}
