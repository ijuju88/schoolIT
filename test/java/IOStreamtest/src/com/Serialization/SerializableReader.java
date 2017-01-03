package com.Serialization;

import java.io.*;

public class SerializableReader {
	public static void main(String[] args) throws ClassNotFoundException, IOException  {
		FileInputStream fis=new FileInputStream("D:/ijuju/test/java/schooljava/IOStreamtest/file/object.dat");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		ClassA caw=(ClassA)ois.readObject();
		System.out.println("field1 -> "+caw.field1);
		System.out.println("field2.field1 -> "+caw.field2.field1);
		System.out.println("field3 -> "+caw.field3);
		System.out.println("field4 -> "+caw.field4);
	}
}
