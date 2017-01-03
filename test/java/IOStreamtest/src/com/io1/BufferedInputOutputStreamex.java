package com.io1;

import java.io.*;

public class BufferedInputOutputStreamex {
	public static void main(String[] args) {
		long start=0, end=0;
		FileReader fr=null;
		FileWriter fw=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		
		System.out.println("----------------------------읽어오기 + 걸리는 시간----------------------------");
		try {
			
		
			fr= new FileReader
					("D:/ijuju/test/java/schooljava/IOStreamtest/file/ViewTax_BillexcelAction.txt");
			
			start=System.currentTimeMillis();
			while(fr.read()!=-1){}
			end=System.currentTimeMillis();
			System.out.println("버퍼가 사용 x ->"+(end-start)+"ms");
			fr.close();
			
			
			fr= new FileReader
					("D:/ijuju/test/java/schooljava/IOStreamtest/file/ViewTax_BillexcelAction.txt");
			br=new BufferedReader(fr);
			start=System.currentTimeMillis();
			while(br.read()!=-1){}
			end=System.currentTimeMillis();
			System.out.println("버퍼가 사용 O ->"+(end-start)+"ms");
			
			br.close();
			fr.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		System.out.println("----------------------------불러오기 + 걸리는 시간----------------------------");
		
		int data=-1;
		try {
			fr= new FileReader
					("D:/ijuju/test/java/schooljava/IOStreamtest/file/ViewTax_BillexcelAction.txt");
			br=new BufferedReader(fr);
			fw=new FileWriter
					("D:/ijuju/test/java/schooljava/IOStreamtest/file/ViewTax_BillexcelAction_1.txt");
			
			start=System.currentTimeMillis();
			while((data=br.read())!=-1){ fw.write(data);}
			
			end=System.currentTimeMillis();
			System.out.println("버퍼가 사용 x ->"+(end-start)+"ms");	
			
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			if(fw != null) try{fw.close();}catch(IOException e){}
			if(br != null) try{br.close();}catch(IOException e){}
			if(fr != null) try{fr.close();}catch(IOException e){}
		}
		
		
		
		
		try {
			fr= new FileReader
					("D:/ijuju/test/java/schooljava/IOStreamtest/file/ViewTax_BillexcelAction.txt");
			br=new BufferedReader(fr);
			fw=new FileWriter
					("D:/ijuju/test/java/schooljava/IOStreamtest/file/ViewTax_BillexcelAction_1.txt");
			bw=new BufferedWriter(fw);
			
			start=System.currentTimeMillis();
			while((data=br.read())!=-1){ bw.write(data);}
			
			end=System.currentTimeMillis();
			System.out.println("버퍼가 사용 O ->"+(end-start)+"ms");
			
			
		} catch (Exception e) {
			e.getStackTrace();
		}finally {
			if(bw != null) try{fw.close();}catch(IOException e){}
			if(fw != null) try{fw.close();}catch(IOException e){}
			if(br != null) try{br.close();}catch(IOException e){}
			if(fr != null) try{fr.close();}catch(IOException e){}
		}
	}
}
