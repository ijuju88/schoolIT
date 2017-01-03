package com.io1;

import java.io.*;

public class InputStreamReaderex {
	public static void main(String[] args) {
		// InputStreamReader 선언
        InputStreamReader isr = null;
        
        try {
        	  isr = new InputStreamReader(System.in); 
             
              int i = 0;
              char[] ch=new char[100];
              
              while((i=isr.read(ch)) != -1){
            	  System.out.println(new String(ch, 0 , i));
              }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(isr != null) try{isr.close();}catch(IOException e){}
		}
	}
}
