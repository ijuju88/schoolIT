package com.collectTest;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HashMapTest extends JFrame implements ActionListener{

	public static void main(String[] args) {
		/*// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<>();
		map.put("홍길동", "123-123");
		map.put("홍정수", "456-456");
		map.put("홍미영", "789-789");
		
		System.out.println(map.get("홍길동")); //해당 키의 값을 가져옵니다
		
		map.put("홍길동", "111-111");
		System.out.println(map.get("홍길동")); //검색을 다시하니 추가한 값만 나옵니다
		
		//이것도 순차적으로 출력합시다
		Set<String>keys=map.keySet(); //kes값을 set로 만듭니다
		Iterator iterator = keys.iterator();
		
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
			System.out.println(map.get(iterator.next()));
		}*/
		
		HashMapTest h = new HashMapTest();
		h.JFrameForm();
	}
	public void JFrameForm() {
		setBounds(600, 300, 500, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("물류 관리");

		JPanel all = new JPanel(new BorderLayout());
		JPanel north = new JPanel(new GridLayout(1, 4, 10, 10));
		JPanel center = new JPanel(new FlowLayout(FlowLayout.CENTER));

		north.setBorder(new EmptyBorder(10, 10, 10, 10));
		all.setBorder(new EmptyBorder(10, 10, 10, 10));

		add(all);
		all.add(north, BorderLayout.NORTH);
		all.add(center, BorderLayout.CENTER);

		String[] BtnName = { "물품 등록", "물품 조회", "물품 삭제", "종 료" };
		for (int i = 0; i < BtnName.length; i++) {
			JButton btn = new JButton(BtnName[i]);
			btn.addActionListener(this);
			north.add(btn);
		}

		String[] LabelName = {"등록자", "물품명", "휴대전화", "주소", "날짜" };
		for (int i = 0; i < LabelName.length; i++) {
			JLabel jl = new JLabel(LabelName[i]);
			jl.setPreferredSize(new Dimension(70, 30));
			jl.setHorizontalAlignment(jl.LEFT);
			center.add(jl);

			/*jt[i] = new JTextField();
			jt[i].setPreferredSize(new Dimension(130, 30));
			jt[i].setHorizontalAlignment(jt[i].CENTER);
			center.add(jt[i]);*/
		}

		/*LocalDate now = LocalDate.now();

		jt[4].setText(now.toString());
		setVisible(true);*/
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
