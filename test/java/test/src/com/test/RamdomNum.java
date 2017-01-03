package com.test;

public class RamdomNum {

	RamdomNum() {
		int[] num = new int[45];// 숫자생성하는 배열

		for (int i = 0; i < num.length; i++)

			num[i] = i + 1;// 숫자1번부터 나와야하니깐~~
		int count = 0;
		int temp = 0;

		for (int k = 0; k < 100; k++) { // 한 100번돌리지머~~
			count = (int) (Math.random() * 45);// 난수 발생함수
			temp = num[0];
			num[0] = num[count];
			num[count] = temp;
			// 값의 위치바꾸기(이 알고리즘이 여기에 쓰인다는거 하면서 알았음 ㅎㅎ)
			// 배열 첫번째랑 임의의 수를 서로 바꾸어서 섞음
		}
		for (int i = 0; i < 6; i++)// 6번호가 나와와하니깐
			System.out.print(num[i] + "\t");// 출력
	}

	public static void main(String[] args) {
		System.out.println("=======!!!!!!당첨되신분 축하드립니다!!!!!!=========");
		RamdomNum p = new RamdomNum();// 클래스 불러옴
	}
}