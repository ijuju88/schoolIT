package com.Proddunt;

public class CompackDisc extends Proddunt {
	
	String albumTitle, singer;
	
	public CompackDisc
	(int id, int price, String comment, String productor, String albumTitle, String singer) {
		super(id, price, comment, productor);this.albumTitle=albumTitle; this.singer=singer;}
	
	public CompackDisc() {}

	@Override
	public void Scr() {
		super.display();
		System.out.print("앨범제목>>");
		albumTitle=sc.next();
		System.out.print("가수>>");
		singer=sc.next();
	}

}
