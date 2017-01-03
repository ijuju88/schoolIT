package com.Arrage;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ArrageCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int oldIntArray[]={1,2,3};
		int[] newIntArray=new int[5];
		int[] IntArray=new int[5];
		
		for (int i = 0; i < oldIntArray.length; i++) {
			newIntArray[i]=oldIntArray[i];
		}
		
		for (int i = 0; i < newIntArray.length; i++) {
			System.out.print(newIntArray[i]+"\t ");
		}System.out.println("");
		
		System.arraycopy(oldIntArray, 0, IntArray, 0,oldIntArray.length); 
		//배열,복사지점,복사위치,복사위치 시작지점, 길이
		
		for (int i = 0; i < IntArray.length; i++) {
		System.out.print(IntArray[i]+"\t ");
		}System.out.println("");
		
		
		
		String oldStrArray[]={"java", "array", "copy"};
		String newStrArrat[]=new String[5];
		
		System.arraycopy(oldStrArray, 0, newStrArrat, 0, oldStrArray.length);
		
		
		for (int j = 0; j < newStrArrat.length; j++) {
			System.out.print(newStrArrat[j]+"\t ");
		}System.out.println("");
		
		
		
	}

}
