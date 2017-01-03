package com.Ja;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
 
import javax.swing.*;
 
 
@SuppressWarnings("serial")
class InputCa extends JFrame {
private JPanel p = new JPanel(); //아랫부분
private JPanel p1 = new JPanel();//윗부분
private JButton back = new JButton("☜");//전달
private JButton Next = new JButton("☞");//다음달
private JLabel YearMon = new JLabel();//위에 제목(년/월)
private JButton[] Arr = new JButton[42];//일수~~
private Calendar ca = Calendar.getInstance();//캘린더 클래스 불러오기
private Font myFont = new Font("Ravie",Font.BOLD,15); 
 
InputCa() {
super("달력");//제목
this.init(); //틀부분
this.start(); //이벤트부분
setVisible(true); //창보이게
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
/*자바에서 스윙을 구현하면  JFrame 을 상속받아서 MainFrame을 만드는 것이 보통인데, 
이 때 주의해야 할 점은 반드시 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    을 지정해주어야 한다는 점이다. 만약 이것을 지정하지 않으면 
프레임을 닫아도 JFrame 객체는 계속 살아서 JVM에서 계속 실행중인 상태가 된다. 
이건 새창으로 하기위해 EXIT__ON_CLOSE를 사용하지 않고DISPOSE_ON_CLOSE를 사용한다 */
}
 
 
private void init() {//틀
 p1.setBackground(Color.cyan);//위에틀 배경
 p1.setLayout(new FlowLayout(FlowLayout.CENTER));//중간정렬
 p1.add(back); //전달버튼
 p1.add(YearMon); //년/월
 p1.add(Next); //다음달버튼
 p1.setFont(myFont);
 p.setLayout(new GridLayout(6,7)); //GridLayout로 따로 요일부분에 따로 설정할 필요없이 나뉘어진다
 for(int i=0; i < Arr.length;i++) {//배열로 숫자넣기
 Arr[i] = new JButton("");
 p.add(Arr[i]);
 }
 this.add(p1,"North"); 
 this.add(p,"Center");
 this.setBounds(200,200,500,300); //컴포넌트 위치+ 크기지정
 this.setDays(ca);//날짜선정용 
}
 
 
private void start() {//이벤트
 back.addActionListener(new BtE());
 Next.addActionListener(new BtE());
 addWindowListener(new WindowAdapter() {
 public void windowClosing(WindowEvent we) {//창닫치면
 dispose();//뒤에창안닫치게 하려고 설정
 }
 });
}
 
class BtE implements ActionListener {
public void actionPerformed(ActionEvent e) {
if(e.getSource()==back) {
ca.add(Calendar.MONTH, -1);//전달
} else if(e.getSource()==Next) {
ca.add(Calendar.MONTH, 1);//다음달
}
setDays(ca);//setDays메소드 불러오기
}}
 
 
private void setDays(Calendar d) {//일수 맞추기 위해서
int year = d.get(Calendar.YEAR);//년불러오기
int month = d.get(Calendar.MONTH);//월불러오기
YearMon.setText(year+"년 "+(month+1)+"월");//중간에 글자출력
Calendar sDay = Calendar.getInstance(); // 현재시스템날짜불러오기
sDay.set(year, month, 1); //시작월을 1로 설정
sDay.add(Calendar.DATE, -sDay.get(Calendar.DAY_OF_WEEK) + 1);
/*해당 월의 첫번째 주의 일요일로 날짜를 셋팅하는 겁니다.
예를 들어서 4월 1일이 화요일이면, 요일 sDay.get(Calendar.DAY_OF_WEEK)의 값이 3(화요일)이 됩니다.
즉 -3+1이니까
sDay.add(Calendar.DATE, -2);가 되겠죠. 즉 4월 1일에서 2일을 빼는 겁니다. 그러면 3월 30일이 되겠죠.*/
 
 
for(int i=0; i < Arr.length; i++, sDay.add(Calendar.DATE, 1)) {
int day = sDay.get(Calendar.DATE); // sDay에서 날자를 뽑아서 day에 저장
Arr[i].setText(day+"");
 
if(sDay.get(Calendar.MONTH)!=month) {//버튼색
Arr[i].setBackground(Color.lightGray);
} else {
Arr[i].setBackground(Color.white);
}}}}