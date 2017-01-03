package com.collectTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Board{
	private String title, content;

	public Board(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	
	
	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

}

class BoardDao{
	public List<Board> getBoardList(){
		List<Board> list=new LinkedList<>();
		list.add(0,new Board("제목1", "내용1"));
		list.add(1,new Board("제목2", "내용2"));
		list.add(2,new Board("제목3", "내용3"));
		return list;
		
		
	}
}

public class ListExample_p775 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BoardDao dao=new BoardDao();
		List<Board> list= dao.getBoardList();
		
		for (Board board : list) {
			System.out.println(board.getTitle()+"-"+board.getContent());
		}
	}

}
