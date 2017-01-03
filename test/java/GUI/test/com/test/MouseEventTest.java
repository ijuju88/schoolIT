package com.test;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseEventTest extends JFrame implements MouseListener, MouseMotionListener {
	JButton eventButton;
	JLabel la;
	public MouseEventTest() {
		super("마우스 이벤트처리");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		eventButton=new JButton("이벤트를 받는 버튼");
		la=new JLabel("------------------ 이벤트 결과 ------------------ ");
		eventButton.addMouseListener(this);
		eventButton.addMouseMotionListener(this);
		setLayout(new FlowLayout());
		add(eventButton);
		add(la);
		setVisible(true);
	}
	@Override
	public void mouseDragged(MouseEvent arg0) 
	{la.setText("이벤트 : mouseDragged()");}
	@Override
	public void mouseMoved(MouseEvent arg0) 
	{la.setText("이벤트 : mouseMoved()");}
	@Override
	public void mouseClicked(MouseEvent e) 
	{la.setText("이벤트 : mouseClicked()");}
	@Override
	public void mouseEntered(MouseEvent e) 
	{la.setText("이벤트 : mouseEntered()");}
	@Override
	public void mouseExited(MouseEvent e) 
	{la.setText("이벤트 : mouseExited()");}
	@Override
	public void mousePressed(MouseEvent e) {
		//1번째 진행
		la.setText("좌표 : mousePressed()"+e.getX()+", " + e.getY());
	}
	@Override
	public void mouseReleased(MouseEvent e) {}

	public static void main(String[] args) {
		new MouseEventTest();
	}

}
