package com.io1;

import java.io.*;

public class DataInputStreamex {
	public static void main(String[] args) {
		
		FileInputStream fis=null;
		FileOutputStream fos=null;
		DataInputStream dis=null;
		DataOutputStream dos=null;
		
		try{
			fos=new FileOutputStream
			("D:/ijuju/test/java/schooljava/IOStreamtest/file/data.dat");
			
			dos=new DataOutputStream(fos);
			
			dos.writeUTF("홍길동");
			dos.writeDouble(95.5);
			dos.writeInt(1);
			
			dos.writeUTF("김철수");
			dos.writeDouble(84.7);
			dos.writeInt(2);
			
			dos.writeUTF("박가영");
			dos.writeDouble(82.2);
			dos.writeInt(3);
			
			dos.flush(); dos.close(); fos.close();
			
			fis=new FileInputStream
			("D:/ijuju/test/java/schooljava/IOStreamtest/file/data.dat");
			
			dis=new DataInputStream(fis);
			
			for (int i = 0; i < 3; i++) {
				String name=dis.readUTF();
				double score=dis.readDouble();
				int order=dis.readInt();
				
				System.out.println(name+"\t"+score+"\t"+order);
			}
			
			dis.close(); fis.close();
			
			}catch(Exception e){e.getStackTrace();}
		
	}
}
