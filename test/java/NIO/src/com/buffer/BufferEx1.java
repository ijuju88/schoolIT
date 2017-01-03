package com.buffer;

import java.nio.*;

public class BufferEx1 {
	public static void main(String[] args) {
		System.out.println("7바이트 비트 생성");
		ByteBuffer buffer=ByteBuffer.allocateDirect(7);
		printState(buffer);
		
		buffer.put((byte)12);
		buffer.put((byte)13);
		buffer.put((byte)14);
		System.out.println("3바이트 저장후");
		
		printState(buffer);
		
		buffer.flip();
		System.out.println("flip() 후");
		printState(buffer);
		
		buffer.get(new byte[3]);
		System.out.println("3바이트 데이터읽은 후 ");
		printState(buffer);
		
		buffer.mark();
		System.out.println("현재 위치 마크");
		
		/*buffer.get(new byte[2]);
		System.out.println("2바이트 읽은 후");
		printState(buffer);*/
		
		buffer.reset();
		System.out.println("버퍼리셋 후");
		printState(buffer);
		
		buffer.rewind();
		System.out.println("rewind 후");
		printState(buffer);
		
		buffer.clear();
		System.out.println("버퍼클리어 후");
		printState(buffer);
	}
	
	public static void printState(Buffer buffer){
		System.out.print(" position : "+buffer.position());
		System.out.print(" limit : "+buffer.limit());
		System.out.println(" capacity "+buffer.capacity());
		
		//System.out.println(" mark : "+buffer.mark());
	}
}
