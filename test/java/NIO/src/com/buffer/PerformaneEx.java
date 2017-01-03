package com.buffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.*;
import java.util.EnumSet;

public class PerformaneEx {
	public static void main(String[] args) throws IOException {
		Path form = Paths.get("D:/ijuju/test/java/schooljava/NIO/db.jpg");
		Path to1 = Paths.get("D:/ijuju/test/java/schooljava/NIO/db1.jpg");
		Path to2 = Paths.get("D:/ijuju/test/java/schooljava/NIO/db2.jpg");

		long size = Files.size(form); // form 사이지만큼만듭니다

		FileChannel fc_from = FileChannel.open(form);
		FileChannel fc_to1 = FileChannel.open(to1, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));
		FileChannel fc_to2 = FileChannel.open(to2, EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));

		ByteBuffer nonDirectBuffer = ByteBuffer.allocate((int) size);
		ByteBuffer DirectBuffer = ByteBuffer.allocateDirect((int) size);

		long start, end; // 시간계산

		start = System.nanoTime();

		for (int i = 0; i < 100; i++) {
			fc_from.read(nonDirectBuffer);// fc_from에서는 넌다이렉트버퍼를 읽을겁니다.
			fc_to1.write(nonDirectBuffer);// fc_to1에서는 넌다이렉트버퍼를 기록할겁니다
			nonDirectBuffer.clear();
		}

		end = System.nanoTime();
		System.out.println("넌다이렉트 시간 -> " + (end - start) + "ms" + "\n");

		fc_from.position(0); // fc_from 포지션을 0으로 줍니다
		
		start = System.nanoTime();

		for (int i = 0; i < 100; i++) {
			fc_from.read(DirectBuffer);// fc_from에서는 넌다이렉트버퍼를 읽을겁니다.
			fc_to1.write(DirectBuffer);// fc_to1에서는 넌다이렉트버퍼를 기록할겁니다
			DirectBuffer.clear();
		}

		end = System.nanoTime();
		System.out.println("넌다이렉트 시간 -> " + (end - start) + "ms");

	}
}
