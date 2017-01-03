package com.test;

import javax.swing.*;
import java.awt.*;

public class LabelEx extends JFrame {
	LabelEx() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JLabel textLabel = new JLabel("제임스 고슬링 입니더!");
		
		//크기바꾸기
		ImageIcon img = new ImageIcon("D:/ijuju/test/java/schooljava/GUI/test/com/test/computer.png");
		Image im=img.getImage();
		im=im.getScaledInstance(200, 100, Image.SCALE_AREA_AVERAGING);
		ImageIcon imgnew=new ImageIcon(im);
		
		JLabel imageLabel = new JLabel(imgnew);
		
		JButton jb=new JButton(imgnew);
		ImageIcon icon = new ImageIcon("D:/ijuju/test/java/schooljava/GUI/test/com/test/computer.png");
		JLabel label = new JLabel("커피한잔 하실래예, 전화주이소", icon, SwingConstants.CENTER);
		c.add(textLabel);
		c.add(jb);
		c.add(imageLabel);
		c.add(label);
		setSize(300, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new LabelEx();
	}
}