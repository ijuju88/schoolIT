package com.Ja;
 
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
 
import javax.swing.*;
 
class InputPone extends JFrame implements ActionListener { 
// 프레임상속하고 ActionListener인터페이스를 상속
 private BorderLayout a = new BorderLayout();
 
 private JTextField tf = new JTextField(20);// 한 20자면 될까하는 생각에 만듬(이름)
 private JTextField tf1 = new JTextField(20);//(전화)
 private JLabel na=new JLabel("이름 : ");
 private JLabel po=new JLabel("번호 : ");
 private Vector vc = new Vector();// 각데이터를 저장할 백터생성
 private JButton bt1 = new JButton("등록");// 등록버튼생성
 private JButton bt2 = new JButton("삭제");// 삭제버튼생성
 private JButton bt3 = new JButton("종료");// 종료버튼생성
 
 
 private JList l = new JList(vc);// 리스트 생성 안에 배열 안써도 실행은 됨
 private File f = new File("C:\\add.txt");//파일생성
 
 public InputPone() {
  super("전화번호부");//제목
  this.init();//틀작업메서드
  this.start();//이벤트작업메서드
  this.setVisible(true);//1.4이후에 쓰임 show(),hide() 대용으로 화면이 나오는지 안나오는지 결정
 
  if (f.exists()) {// 실행시 지난 파일 뜨게 하기
   try {
    ObjectInputStream io = new ObjectInputStream(
      new BufferedInputStream(new FileInputStream(f)));
    //객체로 된 파일불러오기-예외처리
    try {
     vc = (Vector) io.readObject();//파일에 백터값 읽기
     l.setListData(vc); //JList객체에 Vector객체를 등록함 
    } catch (ClassNotFoundException e) {
     e.printStackTrace(); //실행결과를 System.out 객체가 아닌 String 객체에 저장하여 반환 
    }
    io.close();
    //맨 위의 스트림을 닫으면 그 밑에 있는 스트림도 모두 닫힌다. 
    //FileINputStream역시 닫힌다. 파일도 마찬가지다.
 
   } catch (FileNotFoundException e) {
    e.printStackTrace();//실행결과를 System.out 객체가 아닌 String 객체에 저장하여 반환 
   } catch (IOException e) {
    e.printStackTrace();//실행결과를 System.out 객체가 아닌 String 객체에 저장하여 반환 
   }
  }
 
 }
 
 private void init() {//틀부분
  this.setSize(300, 400); //크기설정
  this.setLayout(a);
  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
  /*자바에서 스윙을 구현하면  JFrame 을 상속받아서 MainFrame을 만드는 것이 보통인데, 
  이 때 주의해야 할 점은 반드시 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            을 지정해주어야 한다는 점이다. 만약 이것을 지정하지 않으면 
  프레임을 닫아도 JFrame 객체는 계속 살아서 JVM에서 계속 실행중인 상태가 된다. 
  이건 새창으로 하기위해 EXIT__ON_CLOSE를 사용하지 않고DISPOSE_ON_CLOSE를 사용한다 */
  //틀만드는중
  GridLayout grid = new GridLayout(2, 2, 5, 5);
  Panel p = new Panel(grid);
  p.add(na); p.add(tf);
  p.add(po); p.add(tf1);
  
  
  this.add("North", p);
  
  GridLayout grid1 = new GridLayout(1, 3, 5, 5);
  Panel p1 = new Panel(grid1);
  p1.add(bt1);
  p1.add(bt2);
  p1.add(bt3);
 
 
  this.add("South", p1);
 
  GridLayout grid2 = new GridLayout(1, 1, 5, 5);
  Panel p2 = new Panel(grid1);
  p2.add(l);
 
  this.add("Center", p2);
  add(new JScrollPane(l), "Center");
 
 
  
 }
 
 private void start() {//이벤트부분-버튼누를때 이벤트 발생할거임
  bt1.addActionListener(this);//등록
  bt2.addActionListener(this);//삭제
  bt3.addActionListener(this);//종료
 
 }
 
 
public void Ad(){//저장메소드
  Container cp = getContentPane();
 
   
 
 vc.add("이름 : "+tf.getText().trim()+"  번호 : "+tf1.getText().trim());//배열에 입력한거 더함
 l.setListData(vc);//리스트에 배열데이터를 추가함
 l.updateUI();//이거 입력하면 자동갱신이 됨(안하면 종료누르고 다시실행해야 보임)
 tf.setText("");  tf1.setText("");//텍스트는 지우고
 tf.requestFocus(); 
 //보통, 해당 윈도우 콤포넌트에 포커스를 요청하는 메소드랍니다.
 //즉, 버튼, 텍스트필드, 텍스트에어리어 등...에 포커스를 주고 싶을때 이메소드를 사용하죠.
}
 
 
public void De(){//삭제메소드
 if (l.getSelectedIndex() > -1) {vc.remove(l.getSelectedIndex());}
 //선택된 항목의 인덱스를 지웁니다.
 l.updateUI();//자동업데이트
 
 
}
 
 
public void Ex(){//종료메서드
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
 dispose(); 
 
 
 
}
 
 @Override
 public void actionPerformed(ActionEvent e) {
  if (e.getSource() == bt1) {this.Ad();}
 
  if (e.getSource() == bt2) {this.De();}
 
  else if (e.getSource() == bt3) {this.Ex();}
 }
}