package com.quiz;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Vector;

import javax.swing.*;

public class Qmain {

 public static void main(String[] args) {
  new Test();
 }
}

 class Test extends JFrame implements ActionListener { 
 
  private Container con;
  private JPanel p=new JPanel();
  private JPanel p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
  
  private JLabel l = new JLabel("항목을 선택하세요",JLabel.CENTER);
  private JButton bt1 = new JButton("관리자용");
  private JButton bt2 = new JButton("사용자용");
  private JButton bt3 = new JButton("종료");
  
  public Test() {
   super("문제은행");
   this.init();
   this.start();
   this.setSize(300, 150); 
   this.setVisible(true);

  }
  private void init() {
   con=this.getContentPane();
   con.setLayout(new GridLayout(2, 3, 5, 5));
   p1.add(l);
   con.add("North",p1);
   p.add(bt1);
   p.add(bt2);
   p.add(bt3);
   con.add("Center", p);
   
  }

  private void start() {//이벤트부분-버튼누를때 이벤트 발생할거임
   bt1.addActionListener(this);//관리자용
   bt2.addActionListener(this);//문제풀기
   bt3.addActionListener(this);//종료

  }
  @Override
  public void actionPerformed(ActionEvent e) {
   if (e.getSource() == bt1) {//문제내기로 들어가기위해 암호사용..
   String msg = JOptionPane.showInputDialog("비밀번호가 뭐~게?", "해보던가");//다이얼로그(비번치기) 위에글과 글안에 내용
   if(msg == null) //아무것도 안치면
    JOptionPane.showMessageDialog(null, "누구냐 넌?");
   if(msg.equals("1234"))//비번이 맞으면(1234로 설정)
    new Q11();//문제출제하는곳으로 들어감
   else //나머지
    JOptionPane.showMessageDialog(null, "땡!!");}
   
   else if (e.getSource() == bt2) {new Q22();} //문제풀기

   else if (e.getSource() == bt3) {System.exit(0);} //완전나감
  }
 }
