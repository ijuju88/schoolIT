package com.filechannel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileChannelEx2 {
	public static void main(String[] args) throws IOException {
		Path p1=Paths.get("d:/dir/snowman.jpg");
		Path p2=Paths.get("d:/dir/img/snowman.jpg");
		
		//StandardCopyOption.REPLACE_EXISTING - 파일이 있다면 대채합니다
		Files.copy(p1, p2, StandardCopyOption.REPLACE_EXISTING);
	}
}
