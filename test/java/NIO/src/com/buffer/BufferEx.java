package com.buffer;

import java.nio.*;

public class BufferEx {
	public static void main(String[] args) {
		//ByteBuffer directBuffer=ByteBuffer.allocateDirect(1000*1021*1024);
		//System.out.println("다이렉트 버퍼생성");

		//ByteBuffer nonDirectBuffer=ByteBuffer.allocate(1000*1021*1024);
		//System.out.println("넌다이렉트 버퍼생성");
		
		System.out.println("운영체제종류 : "+System.getProperty("os.name"));
		System.out.println("바이트 해석 순서 : "+ByteOrder.nativeOrder());
		
		ByteBuffer bb=ByteBuffer.allocateDirect(100);
		System.out.println("저장용량 : "+bb.capacity());
		
		CharBuffer cb=ByteBuffer.allocateDirect(100).asCharBuffer();
		System.out.println("저장용량 : "+cb.capacity());
		
	}
}
