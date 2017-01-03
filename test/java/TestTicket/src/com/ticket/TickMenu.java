package com.ticket;

import java.util.Scanner;

//세부정보용
public class TickMenu extends TicketSeat {
	private static String SName; // 좌석예약할 사람
	private static int SNo; // 좌석번호
	private static TicketSeat ts = new TicketSeat(); // 좌석정보클래스를 불려오기위해 생성하였습니다.
	private static Scanner sc = new Scanner(System.in);

	public static String getSName() {
		return SName;
	}

	public static void setSName(String sName) {
		SName = sName;
	}

	public static int getSNo() {
		return SNo;
	}

	public static void setSNo(int sNo) {
		SNo = sNo;
	}

	// 예약하기
	void ReTicket() {

		System.out.println("─────────────────────────");
		System.out.println("좌석구분 S(1), A(2), B(3)");
		System.out.println("─────────────────────────");
		System.out.print("좌석타입 선택>> ");
		int se = sc.nextInt();

		// 예약시 좌석번호는 1번부터이므로 배열의 값을 찾을때는 -1번째로 찾아야함
		switch (se) {
		case 1:
			ts.setTicketSSeat();
			System.out.print("이름>> ");
			SName = sc.next();
			System.out.print("번호>> ");
			SNo = sc.nextInt();

			if (ts.SSeat[SNo - 1].equals("---")) {
				ts.SSeat[SNo - 1] = SName;
				System.out.println("예약이 완료되었습니다. 즐겁게 즐겨주세용 ^^*");
			} else {
				System.out.println("다른분이 이미 예약했어요 ㅠㅠ");
			}
			break;

		case 2:
			ts.setTicketASeat();
			System.out.print("이름>> ");
			SName = sc.next();
			System.out.print("번호>> ");
			SNo = sc.nextInt();

			if (ts.ASeat[SNo - 1].equals("---")) {
				ts.ASeat[SNo - 1] = SName;
				System.out.println("예약이 완료되었습니다. 즐겁게 즐겨주세용 ^^*");
			} else {
				System.out.println("다른분이 이미 예약했어요 ㅠㅠ");
			}
			break;

		case 3:
			ts.setTicketBSeat();
			System.out.print("이름>> ");
			SName = sc.next();
			System.out.print("번호>> ");
			SNo = sc.nextInt();

			if (ts.BSeat[SNo - 1].equals("---")) {
				ts.BSeat[SNo - 1] = SName;
				System.out.println("예약이 완료되었습니다. 즐겁게 즐겨주세용 ^^*");
			} else {
				System.out.println("다른분이 이미 예약했어요 ㅠㅠ");
			}
			break;
		default:

			System.out.println("번호를 잘못 선택하였습니다.");
		}
	}

	// 취소하기
	void delTicket() {
		System.out.println("────────────────────────");
		System.out.println("좌석구분 S(1), A(2), B(3)");
		System.out.println("────────────────────────");
		System.out.print("좌석타입 선택>> ");
		int se = sc.nextInt();

		switch (se) {
		case 1:
			ts.setTicketSSeat();
			System.out.print("이름>> ");
			SName = sc.next();
			for (int i = 0; i < SSeat.length; i++) {
				if (ts.SSeat[i].equals(SName)) {
					ts.SSeat[i] = "---";
					System.out.println("취소가 완료되었습니다.. 다음에 다시 찾아주세요 ㅠㅠ");
				}
			}
			break;

		case 2:
			ts.setTicketASeat();
			System.out.print("이름>> ");
			SName = sc.next();
			for (int i = 0; i < ASeat.length; i++) {
				if (ts.ASeat[i].equals(SName)) {
					ts.ASeat[i] = "---";
					System.out.println("취소가 완료되었습니다.. 다음에 다시 찾아주세요 ㅠㅠ");
				}
			}
			break;

		case 3:
			ts.setTicketBSeat();
			System.out.print("이름>> ");
			SName = sc.next();
			for (int i = 0; i < BSeat.length; i++) {
				if (ts.BSeat[i].equals(SName)) {
					ts.BSeat[i] = "---";
					System.out.println("취소가 완료되었습니다.. 다음에 다시 찾아주세요 ㅠㅠ");
				}
			}
			break;

		default:
			System.out.println("번호를 잘못 선택하였습니다.");
		}

	}

	// 좌석출력
	void ListTicket() {
		ts.setTicketSSeat();
		ts.setTicketASeat();
		ts.setTicketBSeat();
	}
}
