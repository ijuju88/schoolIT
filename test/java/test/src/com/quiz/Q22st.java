package com.quiz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.*;

/*문제풀기
많이 부족합니다 정리가 안되서 ㅠㅠ 잘부탁드립니다.
여러공부도 하고(부연설명존재 할 수도있음) 시도도 해서 코드가 깁니다
기능?
1.문제 섞기
2.문제수 램덤
3.제한시간 설정(10초*문제수)
4.문제풀고 점수랑 정답, 점수다이얼로그
5.취소누르면 나감
6.시간제한다되면 총점수나오고 나감*/


class Q22st extends JFrame implements ActionListener, Runnable {
 /*serialVersionUID
   □ 특징
     - 서로 다른 클래스들 간의 구별을 위해 사용.
     - 직렬화 가능(Serializable) 클래스에 명시적으로 선언 추천. 

       (java 컴파일러의 구현이 달라도 serialVersionUID의 일관성을 확보하기 위해.)
     - static, final 이어야 하며 long 타입.

   □ 명시적 선언을 추천하는 이유
     - serialVersionUID를 명시적으로 선언하지 않으면 실행시점에서 serialization을 담당하는 모듈이 디폴트 값을 산정.
     - 산정된 값은 컴파일러 구현체에 따라서 달라질 수 있어 deserialization(serialization 했던 객체를 복구하는 과정)과정에서 예상치

       못한 InvalidClassExceptions을 유발.
     - 서로 다른 자바 컴파일러 구현체 사이에서도 동일한 serialVersionUID 값을 얻기위해서는 명시적으로 선언해야 함.

   □ 기본 uid값 계산에 사용되는 정보
     - 클래스 이름. (fully qualified)
     - 클래스의 접근 제한자. (upblic final, abstract, 또는 interface 인지 여부)
     - 각 멤버 필드의 시그너처. (이름과 접근 제한자, 타입)
     - 각 멤버 메소드의 시크너처. (이름과 접근 제한자, 각 인자별 정보, 리턴 타입)
     - 각 생성자의 시그너처. (접근 제한자, 각 인자별 정보)
     - static initializer block 존재 유무.

 [출처] serialVersionUID|작성자 외계인셩
   */
 private static final long serialVersionUID = 991257015363786221L;
 private Container con;
 private JPanel jp = new JPanel();
 private JPanel jp1 = new JPanel();

 //문제 나눠서 넣을거에 대한 배치
 String[] str = new String[6];
 private JLabel l = new JLabel("", JLabel.CENTER);
 private JRadioButton n1 = new JRadioButton();
 private JRadioButton n2 = new JRadioButton();
 private JRadioButton n3 = new JRadioButton();
 private JRadioButton n4 = new JRadioButton();
 private ButtonGroup bg = new ButtonGroup();
 
 
 private JLabel timerLabel = null;//타이머나올 라벨
 
 
 //그외 배치들
 private Vector<Object> vc = new Vector<Object>(); //기본배열
 private Vector<String> vc11 = new Vector<String>();//점수배열
 private int timer = 0;//타이머
 private int c = 0, count = 0;  //문제 카운터랑 점수
 private String co, co1;
 private JButton bt = new JButton("NEXT");
 private JButton ex = new JButton("Fin");
 private File f = new File("D:\\Qu.dat");
 
 public Q22st(){
  super("문제풀기");
  this.load();
  this.init();
  this.start();
  this.setSize(500, 300);
  this.setVisible(true);
 }
 
 @SuppressWarnings("unchecked")
public void load(){//파일불러오기
  if(f.exists()){ 
   try {
    ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(f)));
    vc = (Vector<Object>) ois.readObject(); 
    ois.close();
   } catch (FileNotFoundException e) {} 
   catch (IOException e) {}
   catch (ClassNotFoundException e) {}
  }
 }
 
 public void init(){
 
  con = this.getContentPane();
  con.setLayout(new BorderLayout());
  con.add("North",l);
  jp.setLayout(new GridLayout(4,1));
  con.add("Center", jp);
 
  
  Collections.shuffle(vc);//배열을 섞는법(와 ㅠㅠ)
 //복사안되서 참고하세요 http://blog.naver.com/jss7747/140124450876
 //System.out.println("문제보기=>"+vc);//시험용 문제 섞여있는지 보려고
  
  //문제수 random
  int idx = (int) (Math.random() * vc.size())+2;
  
  if(vc.size()>=idx){
   vc.setSize(idx);   
  }else vc.size();
  
  
  //문제부분(구분자로 나누어서 문제배치하는곳에 등록)
  StringTokenizer que = new StringTokenizer((String) vc.get(c), ".");
  
  for(int i=0; que.hasMoreTokens();i++){
  str[i] = que.nextToken();
  }
  l.setText(str[0]);
  con.add("North", l);
  
  n1.setText(str[1]);
  n2.setText(str[2]);
  n3.setText(str[3]);
  n4.setText(str[4]);
  
  bg.add(n1);
  bg.add(n2);
  bg.add(n3);
  bg.add(n4);
  
  jp.add(n1);
  jp.add(n2);
  jp.add(n3);
  jp.add(n4);
  
  co=str[5];//정답은 보이면 안되니 다른곳에 저장함
  
  //밑에
  jp1.setLayout(new FlowLayout());
  timerLabel = new JLabel(timer+""); 
  jp1.add(timerLabel); 
  jp1.add(bt);
  jp1.add(ex); 
  
  con.add("South", jp1);
 
  //쓰레드 시작
  new Thread(this).start();
  //버튼 활성화(종료 비활성화)
  bt.setEnabled(true);  
  ex.setEnabled(false); 
 }
 public void start(){
  bt.addActionListener(this);
  ex.addActionListener(this);
 }

 
 public void actionPerformed(ActionEvent e) {


 //Enumeration를 통한 for문 (이거 예전이라고 함) Iterator를 많이씀
 //(Iterator에 관한건 이번주공부한자료안에 있음(for문 출력3가지))
   for (Enumeration<AbstractButton> buttons = bg.getElements(); buttons.hasMoreElements();) {
          AbstractButton button = buttons.nextElement();

          if (button.isSelected()) {
              co1=button.getText();        
          }
      }
  //System.out.println(">"+co1); 시험용

    if(co.equals(co1)){count+=10; //System.out.println("점수=>"+count); 시험용
    }
    c++;//문제수 증가
    jp.removeAll();//문제나오는 부분 다지움
     jp.updateUI();//업데이트
     
     
   if(e.getSource() == bt){//다음버튼 누르면 
  String str1=vc.size()+"개 문제중"+c+"번 정답 : "+co+"점수"+count;//나올문구
     vc11.add(str1);//배열저장
     int aa=JOptionPane.showConfirmDialog(null
                 ,vc11.toString(), "정답",JOptionPane.YES_NO_OPTION );//다이얼로그
                
     if(aa==JOptionPane.YES_OPTION){//확인누르면 지우고 다음으로 감
      vc11.clear();
     }
     if(aa == JOptionPane.NO_OPTION || c==vc.size()){//취소나 문제가 끝나면
                  System.exit(0);//완전나감
      }
      if(c==vc.size()-1)//문제수 -1수에 ex버튼 활성화 다음은 비활성화(마지막문제에서)
    {bt.setEnabled(false);  
  ex.setEnabled(true);}
  //다음문제를 나오게 하기 위해 다시... 
    StringTokenizer que = new StringTokenizer((String) vc.get(c), ".");
    for(int i=0; que.hasMoreTokens();i++){
    str[i] = que.nextToken(); 
    l.setText(str[0]);
    con.add("North", l);
    
    n1.setText(str[1]);
    n2.setText(str[2]);
    n3.setText(str[3]);
    n4.setText(str[4]);
    
    bg.add(n1);
    bg.add(n2);
    bg.add(n3);
    bg.add(n4);
    
    jp.add(n1);
    jp.add(n2);
    jp.add(n3);
    jp.add(n4);
    con.add("Center",jp);
    co=str[5];
    }
   }
   
   
   if(e.getSource() == ex){  //나가기 누르면   
    String str1=vc.size()+"개 문제중"+c+"번 정답 : "+co+"점수"+count;//마지막 문제 정답이랑 점수나오고
      vc11.add(str1);
      int aa=JOptionPane.showConfirmDialog(null
                  ,vc11.toString(), "정답",JOptionPane.YES_NO_OPTION );
                 
      if(aa==JOptionPane.YES_OPTION){
       vc11.clear();
      }
      if(aa == JOptionPane.NO_OPTION){
                   System.exit(0);
       }
    
    
    //그다음 전체문제랑 최종점수나옴
    String str2=vc.size()+"개 문제중"+"점수"+count;
      vc11.add(str2);
      int aa1=JOptionPane.showConfirmDialog(null
                  ,vc11.toString(), "종료",JOptionPane.YES_NO_OPTION );
                 
      if(aa1==JOptionPane.YES_OPTION || aa1 == JOptionPane.NO_OPTION || c==vc.size()){
                   System.exit(0);

  }
   }
  }


@Override
public void run() {
 while( true ) { 
        try { 
          timer++; 
          System.out.println( timer + ""); 
           timerLabel.setText( timer + ""); 
         
           if( timer== vc.size()*5) { 
              
           String str2=vc.size()+"개 문제중 시간이 다지났습니다."+"총점수"+count;
           vc11.add(str2);
           int aa2=JOptionPane.showConfirmDialog(null
                       ,vc11.toString(), "종료",JOptionPane.YES_NO_OPTION );
                      
           if(aa2==JOptionPane.YES_OPTION ||aa2 == JOptionPane.NO_OPTION){
            System.exit(0);
           }
    
           } 
           Thread.sleep(1000); 
           } catch(Exception e) { 
           e.printStackTrace(); 
        } 
     } 
 
}}