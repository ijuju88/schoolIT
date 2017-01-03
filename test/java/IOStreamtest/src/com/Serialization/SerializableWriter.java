package com.Serialization;

import java.io.*;

public class SerializableWriter {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos=new FileOutputStream("D:/ijuju/test/java/schooljava/IOStreamtest/file/object.dat");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		
		ClassA ca=new ClassA();
		ca.field1 =1;
		ca.field2.field1=2;
		ca.field3=3;
		ca.field4=4;
		oos.writeObject(ca);
		
		oos.flush(); oos.close(); fos.close();
		
	}
}
