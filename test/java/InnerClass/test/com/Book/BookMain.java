package com.Book;

import java.util.Scanner;

public class BookMain {
	private static Scanner sc = new Scanner(System.in);
	private static Member me[] = new Member[4];
	private static Book book[] = new Book[5];
	private static Rent re[] = new Rent[10];
	private static Prodect pr[]=new Prodect[5];
	static int mindex;
	static int bindex;
	static int rindex;
	static int pindex;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean run = true;
		while (run) {
			System.out.println("────────────────────────────────────────────────────");
			System.out.println("1 회원관리 | 2 도서관리 | 3영화관리 | 4 책대여 | 5 영화대여 | 6.종료");
			System.out.println("────────────────────────────────────────────────────");
			System.out.print("선택>> ");
			int No = sc.nextInt();

			switch (No) {
			case 1:
				MemberManage();
				break;
			case 2:
				BookManage();
				break;

			case 3:
				ProdectManage();
				break;
				
			case 4:
				ReturnBookManage();
				break;

			case 5:
				ReturnProdectManage();
				break;
				
			case 6:
				run = false;
				break;
			default:
				System.out.println("번호를 잘못 입력하였습니다.");
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

	// 함수 시작!!

	// 회원가입소목록
	private static void MemberManage() {
		boolean run = true;
		while (run) {
			System.out.println("────────────────────────────────");
			System.out.print("1 회원등록 | 2 회원목록 전체 조회 | 3 종료 >>");
			int PrNo1 = sc.nextInt();
			switch (PrNo1) {
			case 1:
				JoinMember();
				break;
			case 2:
				ListMember();
				break;
			case 3:
				run = false;
				break;
			default:
				System.out.println("번호를 잘못 입력하였습니다.");
				break;
			}
		}

	}

	// 책소목록
	private static void BookManage() {
		boolean run = true;
		while (run) {
			System.out.println("────────────────────────────────");
			System.out.print("1 도서등록 | 2 도서목록 전체 조회 | 3 종료 >>");
			int PrNo2 = sc.nextInt();
			switch (PrNo2) {
			case 1:
				JoinBook();
				break;
			case 2:
				ListBook();
				break;
			case 3:
				run = false;
				break;
			default:
				System.out.println("번호를 잘못 입력하였습니다.");
				break;
			}
		}
	}
	
	
	//영화소목록
	private static void ProdectManage() {
		boolean run = true;
		while (run) {
			System.out.println("────────────────────────────────");
			System.out.print("1 영화등록 | 2 영화목록 전체 조회 | 3 종료 >>");
			int PrNo2 = sc.nextInt();
			switch (PrNo2) {
			case 1:
				JoinPridect();
				break;
			case 2:
				ListPridect();
				break;
			case 3:
				run = false;
				break;
			default:
				System.out.println("번호를 잘못 입력하였습니다.");
				break;
			}
		}
		
	}


	// 반납, 대여 소목록
	private static void ReturnBookManage() {
		Member mes;
		Book bos;
		boolean run = true;
		while (run) {
			System.out.println("────────────────────────────────");
			System.out.print("1 대여 | 2 반납 | 3 대여목록 조회 | 4.종료 >>");
			int PrNo3 = sc.nextInt();
			switch (PrNo3) {
			case 1:
				LendBook();
				break;
			case 2:
				ReturnBook();
				break;
			case 3:
				ListLandBook();
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("번호를 잘못 입력하였습니다.");
				break;
			}
		}
	}
	
	
	
	//영화대여
	private static void ReturnProdectManage() {
		Member mes;
		Prodect prs;
		boolean run = true;
		while (run) {
			System.out.println("────────────────────────────────");
			System.out.print("1 대여 | 2 반납 | 3 대여목록 조회 | 4.종료 >>");
			int PrNo3 = sc.nextInt();
			switch (PrNo3) {
			case 1:
				 LendProdect();
				break;
			case 2:
				ReturnProdect();
				break;
			case 3:
				ListLandProdect();
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("번호를 잘못 입력하였습니다.");
				break;
			}
		}
	}

	// 회원가입
	public static void JoinMember() {
		System.out.print("아이디    입력>>");
		String id = sc.next();
		System.out.print("패스워드 입력>>");
		String pw = sc.next();
		System.out.print("이름      입력>>");
		String name = sc.next();
		System.out.print("연락처   입력>>");
		String tel = sc.next();
		me[mindex++] = new Member(id, pw, name, tel);
	}

	// 회원 전체조회
	public static void ListMember() {
		for (int i = 0; i < mindex; i++) {
			me[i].display();
		}
	}

	// 책등록
	public static void JoinBook() {
		System.out.print("코드  입력>>");
		String code = sc.next();
		System.out.print("제목  입력>>");
		String title = sc.next();
		System.out.print("저자  입력>>");
		String author = sc.next();
		System.out.print("출판사입력>>");
		String publisher = sc.next();
		System.out.print("대여비입력>>");
		int rent_sum = sc.nextInt();
		book[bindex++] = new Book(code, title, author, publisher, rent_sum);

	}

	// 책목록 전체 출력용
	public static void ListBook() {
		for (int i = 0; i < bindex; i++) {
			book[i].display();
		}
	}
	
	//영화등록
	private static void JoinPridect() {
		System.out.print("영화코드입력>>");
		String dcode=sc.next();
		System.out.print("영화제목입력>>");
		String dtitle=sc.next();
		System.out.print("영화감독입력>>");
		String supervision=sc.next();
		System.out.println("영화배우입력>>");
		String actor=sc.next();
		System.out.print("대여료   입력>>");
		int drent_sum=sc.nextInt();
		pr[pindex++] = new Prodect(dcode, dtitle, supervision, actor, drent_sum);

	}

	//영화목록 전체 출력용
	private static void ListPridect() {
		for (int i = 0; i < pindex; i++) {
			pr[i].display();
		}
		
	}
	

	// 책대여
	private static void LendBook() {
		Member mes =null;
		Book bos=null;
		System.out.print("아이디  입력>>");
		String id = sc.next();
		System.out.print("비밀번호입력>>");
		String pw = sc.next();
		System.out.print("도서코드입력>>");
		String code = sc.next();

		for (int i = 0; i < mindex; i++) {
			if(me[i].setMember(id, pw)){mes=me[i];break;}
		}
		
		for (int i = 0; i < bindex; i++) {
			if(book[i].setBook(code)){bos=book[i]; break;}
		}
		
		
		if((mes!=null && bos!=null)){
			if(!bos.isRent_state()){
				bos.setRent_state(true);
				re[rindex++]=new Rent(mes, bos);
			}else{System.out.println("대여중입니당--;");}
		}else{System.out.println("회원정보 또는 정보가 맞지 않습니다--;");}

			
	}

	// 책반납
	private static void ReturnBook() {
		int index=0;
		System.out.print("아이디입력>>");
		String id=sc.next();
		System.out.print("코드 입력>>");
		String code=sc.next();
		for (int i = 0; i < rindex; i++) {
			if(re[i].returnBook(id, code)==true){ index=i;}
			}
		for (int i = 0; i < rindex-1; i++) {
			re[i]=re[i+1];
		}
		rindex--;
	}

	// 책대여목록
	private static void ListLandBook() {
		for (int i = 0; i < rindex; i++) {
			re[i].dispaly1();
		}
	}
	
	
	//영화대여
	private static void LendProdect(){
		Member mes =null;
		Prodect prs=null;
		System.out.print("아이디  입력>>");
		String id = sc.next();
		System.out.print("비밀번호입력>>");
		String pw = sc.next();
		System.out.print("도서코드입력>>");
		String code = sc.next();

		for (int i = 0; i < mindex; i++) {
			if(me[i].setMember(id, pw)){mes=me[i];break;}
		}
		
		
		for (int i = 0; i < pindex; i++) {
			if(pr[i].setProdect(code)){prs=pr[i]; break;}
		}
		
		if((mes!=null && prs!=null)){
		if(!prs.isRent_state()){
			prs.setRent_state(true);
			re[rindex++]=new Rent(mes, prs);
		}else{System.out.println("대여중입니당--;");}
		}else{System.out.println("회원정보 또는 정보가 맞지 않습니다--;");}

	}
	
	//영화반납
	private static void ReturnProdect(){
		int index=0;
		System.out.print("아이디입력>>");
		String id=sc.next();
		System.out.print("코드 입력>>");
		String code=sc.next();
		for (int i = 0; i < rindex; i++) {
			if(re[i].returnProdect(id, code)==true){ index=i;}
			}
		for (int i = 0; i < rindex-1; i++) {
			re[i]=re[i+1];
		}
		rindex--;
		
	}
	// 영화대여목록
		private static void ListLandProdect() {
			for (int i = 0; i < rindex; i++) {
				re[i].dispaly2();
			}
		}
}
