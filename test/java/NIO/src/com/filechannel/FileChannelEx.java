package com.filechannel;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.file.*;

public class FileChannelEx {
	public static void main(String[] args) throws IOException {
		
		//p1의 파일을 p2경로에 복사할겁니다
		Path p1=Paths.get("d:/dir/db.jpg");
		Path p2=Paths.get("d:/dir/img/db.jpg");
		
		
		FileChannel fc1=FileChannel.open(p1, StandardOpenOption.READ);
		
		FileChannel fc2=FileChannel.open(p2, 
		StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		//용량이 100인 bytebuffer 생성
		ByteBuffer bytebuffer=ByteBuffer.allocateDirect(100);
		
		//charset를 기 UTF-8 혹시나 한글일까바
		//Charset charset=Charset.forName("UTF-8");
		
		int byteCount=-1;
		String data="";
		
		
		while ((byteCount=fc1.read(bytebuffer))!=-1) {
			byteCount=fc1.read(bytebuffer);
			if (byteCount==-1) {
				break;
			}
			bytebuffer.flip();
			//data+=charset.decode(bytebuffer).toString();
			fc2.write(bytebuffer);
			bytebuffer.clear();
		}
		//파일읽기
		//System.out.println("text.txt"+data);
		
		fc2.close();
		fc1.close();
		
	}
}
