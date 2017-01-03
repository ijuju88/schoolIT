package com.quiz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.*;

//문제출제 안내용
public class Q22 extends JFrame implements ActionListener{
 private JLabel lb = new JLabel("제한시간은 문제*10초입니다.");//문제안내 문제당 10초로 설정함
 private JButton st = new JButton("시작");
 
 
public Q22(){
 super("시작");
 this.init();
 this.start();
 this.setSize(300,100);
 this.setVisible(true);
 }
 
 public void init(){
  Container con = new Container();
  con = this.getContentPane();
  con.setLayout(new BorderLayout());
  
  Container con1 = new Container();
  con1.setLayout(new FlowLayout());
  
  Container con2 = new Container();
  con2.setLayout(new FlowLayout());
  
  con1.add(lb);
  con2.add(st);
  con.add("North", con1);
  con.add("Center", con2);
}
 private void start() {
  st.addActionListener(this);  
 }

 @Override
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==st){new Q22st();} //문제풀기로감 
 }

}

