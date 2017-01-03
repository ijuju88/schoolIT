package com.quiz;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Vector;

import javax.swing.*;
//문제출제용
class Q11 extends JFrame implements ActionListener{
 private Container con;
 private JButton ok= new JButton("문제등록");
 private JButton cl= new JButton("문제삭제");
 private JButton ex= new JButton("종   료");
 private JOptionPane jop=new JOptionPane();
 private JList li=new JList();
 private JScrollPane sp=new JScrollPane(li);
 private JPanel jp=new JPanel(new FlowLayout());
 private Vector<String> vc=new Vector<String>();//String형으로 저장함
 private File f=new File("D:\\Qu.dat"); 

public Q11(){
 super("문제집 관리자용");
 this.init();
 this.start();
 this.load1();//불러오는 메서드
 this.setSize(500,400);
 this.setVisible(true);
}
@SuppressWarnings("unchecked")
public void load1() {//불러오기
 if(f.exists()){ 
  try {
   ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
   vc = (Vector) ois.readObject();
   li.setListData(vc); 
   ois.close();
  } catch (FileNotFoundException e) {} 
  catch (IOException e) {}
  catch (ClassNotFoundException e) {}
 }
   //System.out.println(f.getName());

}


private void init() {
 con = this.getContentPane();
 con.setLayout(new BorderLayout(5,5));
 jp.add(ok);
 jp.add(cl);
 jp.add(ex);
 con.add("North", jp);
 con.add(li);
 con.add(new JScrollPane(li));
 

}

private void start() {
 ok.addActionListener(this);
 cl.addActionListener(this);
 ex.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) {
 if(e.getSource()==ok){//등록누르면
  String str1 = JOptionPane.showInputDialog(con, "문제!!");
  //문제낼 다이얼로그 생성
  //나중에 구분자로 빼기 위해 "."로 찍어서 구분함
  //ex)문제.1.2.3.4.정답
   vc.add(str1);//친거저장
   li.setListData(vc);//리스트에 저장
   li.updateUI();//업데이트
 }
 
 else if(e.getSource()==cl){//삭제누르면
  if (li.getSelectedIndex() > -1) {vc.remove(li.getSelectedIndex());}
   li.updateUI();
  
 }
 
 
 else if(e.getSource()==ex){//나가기누르면 저장됨
  try {
     ObjectOutputStream io2 = new ObjectOutputStream(
       new BufferedOutputStream(new FileOutputStream(f)));
     io2.writeObject(vc);//파일에 객체저장하기
     io2.close();
     //맨 위의 스트림을 닫으면 그 밑에 있는 스트림도 모두 닫힌다. 
     //FileOutputStream역시 닫힌다. 파일도 마찬가지다.
    } catch (FileNotFoundException e1) {
     e1.printStackTrace();
    } catch (IOException e1) {
     e1.printStackTrace();
    }
    dispose();//완전히 안나가게 하려고 씀
  
 }
}


}