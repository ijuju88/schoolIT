package com.path;

import java.io.IOException;
import java.nio.file.*;

public class FileSystemEx {
	public static void main(String[] args) throws IOException {
		FileSystem fs=FileSystems.getDefault();
		
		for (FileStore store : fs.getFileStores()) {
			System.out.println("드라이브명 -> "+store.name());
			System.out.println("파일시스템-> "+store.type());
			System.out.println("전체공간 -> "+store.getTotalSpace());
		}
	}
}
