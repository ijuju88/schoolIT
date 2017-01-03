package com.test;

import java.awt.*;
import java.awt.event.*;
 
public class Jen505 {
 public static void main(String[] ar) {
  Round19_Ex02_Sub round = new Round19_Ex02_Sub();
 }
}
 
class Round19_Ex02_Sub extends Frame implements ActionListener{
 private Dimension dimen, dimen1;
 
 private int xpos, ypos, sum;
 private String kor, mat, eng;
 private float avg;
 private Label lb = new Label("성적계산", Label.CENTER);
 private Label lb1 = new Label("국어", Label.CENTER);
 private Label lb2 = new Label("영어", Label.CENTER);
 private Label lb3 = new Label("국어", Label.CENTER);
 
 private Label lb4 = new Label("총점", Label.CENTER);
 private Label lb5 = new Label("평균", Label.CENTER);
 
 private TextField n1=new TextField(3);
 private TextField n2=new TextField(3);
 private TextField n3=new TextField(3);
 private TextField n4=new TextField(6);
 private TextField n5=new TextField(6);
 
 private Button bt = new Button("계산");
 
 private Button bt1 = new Button("초기화");
 
 public Round19_Ex02_Sub() {
   super();
   this.init();
   this.start();
   //this.setSize(300,150);
   this.pack();
   dimen=Toolkit.getDefaultToolkit().getScreenSize();
   dimen1=this.getSize();
   xpos=(int)(dimen.getWidth()/2-dimen1.getWidth()/2);
   ypos=(int)(dimen.getHeight()/2-dimen1.getHeight()/2);
   this.setLocation(xpos, ypos);
   this.setVisible(true);
   
  }
 public void init() {
  // 화면 구성 넣을 부분
  BorderLayout border = new BorderLayout(5,5);
  this.setLayout(border);
  this.add("North", lb);
  
  GridLayout grid1 = new GridLayout(5, 2, 5, 5);
  Panel p1 = new Panel(grid1);
  p1.add(lb1); p1.add(n1);
  p1.add(lb2); p1.add(n2);
  p1.add(lb3); p1.add(n3);
  p1.add(lb4); p1.add(n4);
  p1.add(lb5); p1.add(n5);
  
  this.add("Center",p1);
 
  
  
  GridLayout grid2 = new GridLayout(2, 2, 5, 5);
  Panel p2 = new Panel(grid2);
  p2.add(bt);
  p2.add(bt1);
  
  n4.setEnabled(false);
  n5.setEnabled(false);
 
  this.add("South", p2);
 }
 
 public void start() {
  bt.addActionListener(this);
  bt1.addActionListener(this);
 
 
    this.addWindowListener(new WindowAdapter() {
        public void windowClosing(WindowEvent e){
          System.exit(0);
        }
     });}
    
 public void actionPerformed(ActionEvent e) {
  if (e.getSource() == bt ) {
  kor = n1.getText();
  mat = n2.getText();
  eng = n3.getText();
 
  sum = Integer.parseInt(kor) + Integer.parseInt(mat)
    + Integer.parseInt(eng);
  
  avg= sum/3.0f;
   
  n4.setText(sum+"");  
  n5.setText(avg+"");
  }
  
  if(e.getSource() ==bt1){
   n1.setText("");
   n2.setText("");
   n3.setText("");
   n4.setText("");
   n5.setText("");
 
  }  
 
 }
}
 