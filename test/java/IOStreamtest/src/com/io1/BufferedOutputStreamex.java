package com.io1;

import java.io.*;

public class BufferedOutputStreamex {
	public static void main(String[] args) {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		BufferedInputStream bis=null;
		BufferedOutputStream bos=null;
		
		int data=-1;
		long start=0, end=0;
		try {
			fis= new FileInputStream("D:/ijuju/test/java/schooljava/IOStreamtest/img/html5.jpg");
			bis=new BufferedInputStream(fis);
			fos=new FileOutputStream("D:/ijuju/test/java/schooljava/IOStreamtest/img/html5_1.jpg");
			
			start=System.currentTimeMillis();
			while((data=bis.read())!=-1){ fos.write(data);}
			
			end=System.currentTimeMillis();
			System.out.println("버퍼가 사용 x ->"+(end-start)+"ms");	
			
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			if(fos != null) try{fos.close();}catch(IOException e){}
			if(bis != null) try{bis.close();}catch(IOException e){}
			if(fis != null) try{fis.close();}catch(IOException e){}
		}
		
		
		
		try {
			fis= new FileInputStream("D:/ijuju/test/java/schooljava/IOStreamtest/img/html5.jpg");
			bis=new BufferedInputStream(fis);

			fos=new FileOutputStream("D:/ijuju/test/java/schooljava/IOStreamtest/img/html5_2.jpg");
			bos=new BufferedOutputStream(fos);
			
			start=System.currentTimeMillis();
			while((data=bis.read())!=-1){ bos.write(data);}
			
			end=System.currentTimeMillis();
			System.out.println("버퍼가 사용 O ->"+(end-start)+"ms");
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			if(bos != null) try{fos.close();}catch(IOException e){}
			if(fos != null) try{fos.close();}catch(IOException e){}
			if(bis != null) try{bis.close();}catch(IOException e){}
			if(fis != null) try{fis.close();}catch(IOException e){}
		}
	}
}
