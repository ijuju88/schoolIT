package com.Test6;
public class Testalign {

	 public static void main(String[] args){
	  int align[]={15, 7, 2, 9, 10, 12, 17, 11, 20, 5};
	  int temp=0; 
	  
	  for (int i = 0; i < align.length-1; i++) {
	   int in=i; int mi=align[i];
	   for (int j=i+1; j < align.length; j++) { 
	   if(mi>align[j])
	   {
	    in=j; mi=align[j];
	   }
	   }
	    temp=align[i];
	    align[i]=align[in];
	    align[in]=temp;
	    System.out.print((i+1)+" : ");
	 
	   for (int k = 0; k < align.length; k++) {
	   
	    System.out.print(align[k]+" ");
	   }   System.out.println(" ");
  
	   
	  }
	     
	 }
	}
