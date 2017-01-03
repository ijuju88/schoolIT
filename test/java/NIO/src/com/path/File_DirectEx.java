package com.path;

import java.io.IOException;
import java.nio.file.*;

public class File_DirectEx {
	public static void main(String[] args) throws IOException {
		Path path=Paths.get("src/com/path/PathEx.java");
		
		System.out.println("디렉토리 여부 -> "+Files.isDirectory(path));
		System.out.println("파일여부 -> "+Files.isReadable(path));
		System.out.println("마지막 수정시간 -> "+Files.getLastModifiedTime(path));
		System.out.println("파일크기 -> "+Files.size(path));
		System.out.println("숨김 -> "+Files.isHidden(path));
		System.out.println("읽기 가능 -> "+Files.isReadable(path));
		System.out.println("쓰기 가능 -> "+Files.isWritable(path));
	}
}
