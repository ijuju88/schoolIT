package com.test;

import java.io.*;

public class ECal2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Cal2 a = new Cal2();
		a.disp();
	}
}

class Cal2 {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };// 일수다적음
	int year, month, yeartot, week, i;

	public Cal2() throws NumberFormatException, IOException {
		System.out.print("년도 : ");
		year = Integer.parseInt(in.readLine());

		do {
			System.out.print("월 : ");
			month = Integer.parseInt(in.readLine());
		} while (month < 1 || month > 12);

		// 윤달
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0)
			days[1] = 29;
		else
			days[1] = 28;

		// 1년 1월 1일~year-1년 12월 31일의 날수
		// 구하는 방법을 몰라서 결국인터넷행
		yeartot = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;
		// 1월 ~month-1월
		for (i = 0; i < month - 1; i++) {
			yeartot += days[i];
		}
		// 1일의 요일을 알기위해 더한거에 1더함
		yeartot++;

		week = yeartot % 7;// 0일요일 1월요일~
	}

	public void disp() {
		System.out.println("▦▦▦▦▦▦▦▦▦" + year + "년" + month + "월▦▦▦▦▦▦▦▦▦");
		System.out.println("   일    월     화    수    목    금    토");

		for (i = 1; i <= week; i++)
			System.out.print("    ");// 빈칸 맞추기 ?? ㅎㅎ
		for (i = 1; i <= days[month - 1]; i++) {
			System.out.printf("%4d", i);// 우측정렬하려고 씀
			week++; // 요일++
			if (week % 7 == 0)
				System.out.println();
		} // 토요일(7번)이면 다음줄
	}
}
