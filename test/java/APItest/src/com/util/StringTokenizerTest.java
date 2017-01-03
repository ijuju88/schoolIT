package com.util;
import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		/*String text="홍길동-김준엽, 박영주 강상태&윤주연";
		String[] strArray=text.split("-|,| |&");
		
		for (String str : strArray) {
			System.out.print(str+"\t");
		}*/
		
		String text2="홍길동,김준엽,박영주,강상태,윤주연";
		StringTokenizer st=new StringTokenizer(text2,",");
		while (st.hasMoreTokens()) {
			String str1=st.nextToken();
			System.out.print(str1);		
		}
	}

}
