package com.io1;

import java.io.*;

public class BufferedReaderex {
	public static void main(String[] args) {
		long start=0, end=0;
		FileInputStream fis1=null, fis2=null;

		try {
			
			//FileInputStream으로 할때 걸리는 시간
			fis1= new FileInputStream("D:/ijuju/test/java/schooljava/IOStreamtest/img/06.jpg");
			
			start=System.currentTimeMillis();
			while(fis1.read()!=-1){}
			end=System.currentTimeMillis();
			System.out.println("버퍼가 사용 x ->"+(end-start)+"ms");
			
			//BufferedInputStream으로 할때 걸리는 시간
			fis2= new FileInputStream("D:/ijuju/test/java/schooljava/IOStreamtest/img/06.jpg");
			BufferedInputStream bis=new BufferedInputStream(fis2);
			start=System.currentTimeMillis();
			while(bis.read()!=-1){}
			end=System.currentTimeMillis();
			System.out.println("버퍼가 사용 O ->"+(end-start)+"ms");
			
			bis.close();
			fis2.close();
			fis1.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
