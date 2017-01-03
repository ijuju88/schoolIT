package com.Ja;

import java.awt.*;
import java.awt.event.*;
 
import javax.swing.*;
 
public class InputTest {
 
 public static void main(String[] args) {
  new Test();
 }
}
 
 class Test extends JFrame implements ActionListener { 
 // 프레임상속하고 ActionListener인터페이스를 상속
  private BorderLayout a = new BorderLayout();
 
  private JLabel l = new JLabel("항목을 선택하세요",JLabel.CENTER);// 등록버튼생성
  private JButton bt1 = new JButton("전화번호부");// 등록버튼생성
  private JButton bt2 = new JButton("달력");// 삭제버튼생성
  private JButton bt3 = new JButton("종료");// 종료버튼생성
  
  public Test() {
   super("10월2일과제");//제목
   this.init();//틀작업메서드
   this.start();//이벤트작업메서드
   this.setVisible(true);//1.4이후에 쓰임 show(),hide() 대용으로 화면이 나오는지 안나오는지 결정
 
  }
  private void init() {//틀부분
   this.setSize(300, 400); //크기설정
   this.setLayout(a);
   this.add("North",l);
   
   GridLayout grid1 = new GridLayout(3, 1, 5, 5);
   Panel p1 = new Panel(grid1);
   p1.add(bt1);
   p1.add(bt2);
   p1.add(bt3);
   this.add("Center", p1);
   
  }
 
  private void start() {//이벤트부분-버튼누를때 이벤트 발생할거임
   bt1.addActionListener(this);//등록
   bt2.addActionListener(this);//삭제
   bt3.addActionListener(this);//종료
 
  }
  @Override
  public void actionPerformed(ActionEvent e) {
   if (e.getSource() == bt1) {new InputPone();} //전화번호부
 
   else if (e.getSource() == bt2) {new InputCa();} //달력
 
   else if (e.getSource() == bt3) {System.exit(0);} //완전나감
  }
 }
 