package com.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JDBCTest extends JFrame {

	public JDBCTest() {
		super("JDBC 테스트");
		setSize(300, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton jb = new JButton("연결");
		add(jb);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// 오라클 드라이버 선언
					Class.forName("oracle.jdbc.driver.OracleDriver");
	
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oxju88", "1234");
					System.out.println("성공");
				} catch (Exception ee) {
					ee.printStackTrace();
				}

			}
		});
		setVisible(true);
	}


}
