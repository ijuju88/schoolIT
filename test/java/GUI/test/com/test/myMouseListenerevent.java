package com.test;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class myMouseListenerevent implements MouseListener, MouseMotionListener {
	MouseEventTest2 me=new MouseEventTest2();
	@Override
	public void mouseDragged(MouseEvent e) {
		me.setTitle("mousePressed("+e.getX()+","+e.getY()+")");
		me.la.setLocation(e.getX(), e.getY()); 	
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		me.setTitle("mousePressed("+e.getX()+","+e.getY()+")");
		me.la.setLocation(e.getX(), e.getY()); 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		me.setTitle("mousePressed("+e.getX()+","+e.getY()+")");
		me.la.setLocation(e.getX(), e.getY()); 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		me.setTitle("mousePressed("+e.getX()+","+e.getY()+")");
		me.la.setLocation(e.getX(), e.getY()); 
	}

	@Override
	public void mouseExited(MouseEvent e) {
		me.setTitle("mousePressed("+e.getX()+","+e.getY()+")");
		me.la.setLocation(e.getX(), e.getY()); 
	}

	@Override
	public void mousePressed(MouseEvent e) {
		me.setTitle("mousePressed("+e.getX()+","+e.getY()+")");
		me.la.setLocation(e.getX(), e.getY()); 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		me.setTitle("mousePressed("+e.getX()+","+e.getY()+")");
		me.la.setLocation(e.getX(), e.getY()); 
	}
	
}
