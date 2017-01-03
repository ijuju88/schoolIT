package com.path;

import java.nio.file.*;
public class PathEx {
	public static void main(String[] args) {
		Path p1=Paths.get("src/com/path/PathEx.java");
		Path p2=Paths.get("src","com","path","PathEx.java");
		Path p3=Paths.get("d:/dir/text.txt");
		
		System.out.println("파일명 -> "+p1.getFileName());
		System.out.println("부모디렉토리 -> "+p1.getParent().getFileName());
		System.out.println("파일명 -> "+p1.getNameCount()+"\n");
		
		System.out.println("파일명 -> "+p2.getFileName());
		System.out.println("부모디렉토리 -> "+p2.getParent().getFileName());
		System.out.println("파일명 -> "+p2.getNameCount()+"\n");
		
		System.out.println("파일명 -> "+p3.getFileName());
		System.out.println("부모디렉토리 -> "+p3.getParent().getFileName());
		System.out.println("파일명 -> "+p3.getNameCount());
	}
}
