package com.lang;

public class Substring {
	public static void main(String[] args){
		String[] tel={"02-123-4567", "051-456-7890"
			,"031-489-8963", "055-862-9361 "};
	//지역번호만 짤라서 출력합시당!!
		
		for (int i = 0; i < tel.length; i++) {
			System.out.print(tel[i].substring(0, tel[i].indexOf("-"))+"\t");
		}System.out.println("");
		
		for (int j = 0; j < tel.length; j++) {
			System.out.print(tel[j].substring(tel[j].indexOf("-")+1, 
					tel[j].indexOf("-", tel[j].indexOf("-")+1))+"\t");
			System.out.println(tel[j].lastIndexOf("-"));
		}System.out.println("");
		
		for (int i = 0; i < tel.length; i++) {
			System.out.println(tel[i].replace(tel[i].substring
					(tel[i].lastIndexOf("-")+1), "####"));
		}
	
		for (int i = 0; i < tel.length; i++) {
			String str=tel[i].substring(tel[i].lastIndexOf("-")+1);
		if(str.trim().equals("9361"))
		{System.out.println("9361찾음");}
		}
	}
}
