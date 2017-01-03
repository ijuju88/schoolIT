package com.io1;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class fileex {
	public static void main(String[] args) throws URISyntaxException, IOException {
		File dir=new File("D:/ijuju/test/java/schooljava/IOStreamtest/file/Dir");
		
		File file1=new File("D:/ijuju/test/java/schooljava/IOStreamtest/file/text1.txt");
		File file2=new File("D:/ijuju/test/java/schooljava/IOStreamtest/file/text2.txt");
		
		//파일 경로를 url 객체로 생성해서 매개값으로 제공가능
		File file3=new File(new URI("file:///D:/ijuju/test/java/schooljava/IOStreamtest/file/text.txt"));
		
		//해당경로에 폴더가 없으면 폴더를 생성
		if(dir.exists() ==false){dir.mkdirs();}
		
		//해당경로에 파일 없으면 파일을 생성
		if(file1.exists() ==false){file1.createNewFile();}
		if(file2.exists() ==false){file2.createNewFile();}
		if(file3.exists() ==false){file3.createNewFile();}
		
		
		File temp=new File("D:/ijuju/test/java/schooljava/IOStreamtest/file");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd	a HH:mm");
		File[] contents=temp.listFiles();
		
		//해당경로의 목록을 보여줌
		System.out.println("날짜                            시간                           형태          크기          이름");
		System.out.println("-------------------------------------------------------------------");
		
		for (File f : contents) {
			System.out.print(sdf.format(new Date(f.lastModified())));
			
			//파일의 디렉토리이면
			if(f.isDirectory()){
				System.out.print("\t<DIR>\t\t"+f.getName());
			}else{
				System.out.print("\t\t"+f.length()+"\t"+f.getName());
			}
			System.out.println();
		}
	}
}
