package com.AR;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.filechooser.*;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.poi.util.StringUtil;


public class Account_registration extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6866312616747590298L;

	private Account_registrationDAO Adao = new Account_registrationDAO();

	private JTextField ARtext[] = new JTextField[8];

	private JPanel ARpanel;
	private JTable ARtable = new JTable();
	
	//테이블 선택시 나오는 값을 위해 만듬
	private String ARRow1 = "";
	private String ARRow2 = "";
	private String ARRow3 = "";
	private String ARRow4 = "";
	private String ARRow5 = "";
	private String ARRow6 = "";
	
	private JButton ARJBNew; //신규
	private JButton ARJBSave; //저장
	private JButton ARJBMod; //수정
	private JButton ARJBSaveMod; //수정저장
	private JButton ARJBCel; //취소
	private JButton ARJBDel; //삭제
	private JButton ARExcel; //엑세파일 만들기

	public Account_registration() {
		super("거래처관리");
		getContentPane().setLayout(null);

		ARpanel = new JPanel();
		ARpanel.setBounds(0, 0, 882, 190);
		ARpanel.setLayout(null);

		JLabel CRNo = new JLabel("사업자번호");
		CRNo.setFont(new Font("Dialog", Font.PLAIN, 18));
		CRNo.setBounds(24, 8, 120, 18);
		ARpanel.add(CRNo);

		ARtext[0] = new JTextField();
		ARtext[0].setBounds(130, 5, 70, 24);
		ARpanel.add(ARtext[0]);
		ARtext[0].setColumns(3);

		JLabel jl1 = new JLabel("-");
		jl1.setBounds(203, 5, 70, 24);
		ARpanel.add(jl1);

		ARtext[1] = new JTextField();
		ARtext[1].setBounds(210, 5, 70, 24);
		ARpanel.add(ARtext[1]);
		ARtext[1].setColumns(2);

		JLabel jl2 = new JLabel("-");
		jl2.setBounds(283, 5, 70, 24);
		ARpanel.add(jl2);

		ARtext[2] = new JTextField();
		ARtext[2].setBounds(290, 5, 70, 24);
		ARpanel.add(ARtext[2]);
		ARtext[2].setColumns(5);

		JLabel CRName = new JLabel("회사명");
		CRName.setFont(new Font("Dialog", Font.PLAIN, 18));
		CRName.setBounds(24, 38, 120, 18);
		ARpanel.add(CRName);

		ARtext[3] = new JTextField();
		ARtext[3].setBounds(130, 35, 320, 24);
		ARtext[3].setColumns(12);
		ARpanel.add(ARtext[3]);

		JLabel CRBoss = new JLabel("대표자명");
		CRBoss.setBounds(23, 68, 120, 18);
		ARpanel.add(CRBoss);
		CRBoss.setFont(new Font("Dialog", Font.PLAIN, 18));

		ARtext[4] = new JTextField();
		ARtext[4].setColumns(12);
		ARtext[4].setBounds(130, 65, 320, 24);
		ARpanel.add(ARtext[4]);

		JLabel CRCrcategory = new JLabel("주소");
		CRCrcategory.setFont(new Font("Dialog", Font.PLAIN, 18));
		CRCrcategory.setBounds(24, 98, 120, 18);
		ARpanel.add(CRCrcategory);

		ARtext[5] = new JTextField();
		ARtext[5].setColumns(12);
		ARtext[5].setBounds(130, 95, 320, 24);
		ARpanel.add(ARtext[5]);

		JLabel CREvent = new JLabel("업태");
		CREvent.setFont(new Font("Dialog", Font.PLAIN, 18));
		CREvent.setBounds(24, 128, 120, 18);
		ARpanel.add(CREvent);

		ARtext[6] = new JTextField();
		ARtext[6].setColumns(12);
		ARtext[6].setBounds(130, 125, 320, 24);
		ARpanel.add(ARtext[6]);

		JLabel label = new JLabel("종목");
		label.setFont(new Font("Dialog", Font.PLAIN, 18));
		label.setBounds(24, 158, 120, 18);
		ARpanel.add(label);

		ARtext[7] = new JTextField();
		ARtext[7].setColumns(12);
		ARtext[7].setBounds(130, 155, 320, 24);
		ARpanel.add(ARtext[7]);

		ARJBNew = new JButton("신규");
		ARJBNew.setBounds(650, 35, 220, 27);
		ARpanel.add(ARJBNew);

		ARJBSave = new JButton("저장");
		ARJBSave.setBounds(650, 5, 220, 27);
		ARpanel.add(ARJBSave);

		ARJBSaveMod = new JButton("내용저장");
		ARJBSaveMod.setBounds(650, 5, 220, 27);
		ARpanel.add(ARJBSaveMod);

		ARJBMod = new JButton("수정");
		ARJBMod.setBounds(650, 65, 220, 27);
		ARpanel.add(ARJBMod);

		ARJBCel = new JButton("취소");
		ARJBCel.setBounds(650, 125, 220, 27);
		ARpanel.add(ARJBCel);

		ARJBDel = new JButton("삭제");
		ARJBDel.setBounds(650, 95, 220, 27);
		ARpanel.add(ARJBDel);

		ARExcel = new JButton("엑셀파일만들기");
		ARExcel.setEnabled(false);
		ARExcel.setBounds(650, 155, 220, 27);
		ARpanel.add(ARExcel);

		ARJBNew.addActionListener(new newAction());// 신규
		ARJBSave.addActionListener(new inputAction()); // 저장
		ARJBDel.addActionListener(new deleteAction()); // 삭제
		ARJBMod.addActionListener(new ModnewAction()); // 수정
		ARJBSaveMod.addActionListener(new renewAction()); // 수정저장
		ARExcel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					new ARexcelAction();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); // 엑셀파일저장

		ARJBCel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < ARtext.length; i++) {
					ARtext[i].setText("");
					ARJBNew.setEnabled(true);// 신규
					ARJBSave.setEnabled(false); // 저장
					ARJBDel.setEnabled(true);// 삭제
					ARJBMod.setEnabled(true); // 수정
					ARJBCel.setEnabled(false); // 취소
					ARJBSaveMod.setVisible(false); // 수정시만 나타나게 할거임
					ARtext[i].setEnabled(false);
					ARExcel.setEnabled(true);// 엑셀
				}

			}
		});

		ARJBNew.setEnabled(true);// 신규
		ARJBSave.setEnabled(false); // 저장
		ARJBDel.setEnabled(true);// 삭제
		ARJBMod.setEnabled(true); // 수정
		ARJBCel.setEnabled(false); // 취소
		ARJBSaveMod.setVisible(false); // 수정시만 나타나게 할거임
		ARtext[0].setEnabled(false);
		ARtext[1].setEnabled(false);
		ARtext[2].setEnabled(false);
		ARtext[3].setEnabled(false);
		ARtext[4].setEnabled(false);
		ARtext[5].setEnabled(false);
		ARtext[6].setEnabled(false);
		ARtext[7].setEnabled(false);
		ARExcel.setEnabled(true);// 엑셀

		ARtable = Adao.getJTable();

		// 행을 선택해 해당행데이터 알아봄
		ARtable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				ARRow1 = (String) ARtable.getValueAt(ARtable.getSelectedRow(), 0);
				ARRow2 = (String) ARtable.getValueAt(ARtable.getSelectedRow(), 1);
				ARRow3 = (String) ARtable.getValueAt(ARtable.getSelectedRow(), 2);
				ARRow4 = (String) ARtable.getValueAt(ARtable.getSelectedRow(), 3);
				ARRow5 = (String) ARtable.getValueAt(ARtable.getSelectedRow(), 4);
				ARRow6 = (String) ARtable.getValueAt(ARtable.getSelectedRow(), 5);
			}
		});

		getContentPane().setLayout(null);
		getContentPane().add(ARpanel);

		JScrollPane scrollPane = new JScrollPane(ARtable);
		scrollPane.setSize(882, 273);
		scrollPane.setLocation(0, 192);
		getContentPane().add(scrollPane);

		setBounds(0, 0, 900, 500);
		setVisible(true);
	}

	// 신규버튼
	class newAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ARJBNew.setEnabled(false);// 신규
			ARJBSave.setEnabled(true); // 저장
			ARJBDel.setEnabled(false);// 삭제
			ARJBMod.setEnabled(false); // 수정
			ARJBCel.setEnabled(true); // 취소
			ARJBSaveMod.setVisible(false);
			for (int j = 0; j < ARtext.length; j++) {
				ARtext[j].setEnabled(true);
				ARExcel.setEnabled(false);// 엑셀
			}
		}

	}

	// 저장버튼
	class inputAction implements ActionListener {
		String num;
		public void actionPerformed(ActionEvent e) {
			num = ARtext[0].getText() + ARtext[1].getText() + ARtext[2].getText();
			ARJBNew.setEnabled(true);// 신규
			ARJBSave.setEnabled(false); // 저장
			ARJBDel.setEnabled(true);// 삭제
			ARJBMod.setEnabled(true); // 수정
			ARJBCel.setEnabled(false); // 취소
			ARJBSaveMod.setVisible(false);
			ARExcel.setEnabled(true);// 엑셀

			String tf1 = ARtext[0].getText() + "-" + ARtext[1].getText() + "-" + ARtext[2].getText();
			String tf2 = ARtext[3].getText();
			String tf3 = ARtext[4].getText();
			String tf4 = ARtext[5].getText();
			String tf5 = ARtext[6].getText();
			String tf6 = ARtext[7].getText();

			if (ARtext[0].getText().equals("") || ARtext[1].getText().equals("") || ARtext[2].getText().equals("")
					|| ARtext[3].getText().equals("") || ARtext[4].getText().equals("")
					|| ARtext[5].getText().equals("") || ARtext[6].getText().equals("")
					|| ARtext[7].getText().equals("")) {
				int su = JOptionPane.showConfirmDialog(null, "입력하지 않은 곳이 있으니 다시 입력해주세요", "실패",
						JOptionPane.YES_NO_OPTION);

				if (su == JOptionPane.YES_OPTION) {
					ARJBNew.setEnabled(false);// 신규
					ARJBSave.setEnabled(true); // 저장
					ARJBDel.setEnabled(false);// 삭제
					ARJBMod.setEnabled(false); // 수정
					ARJBCel.setEnabled(true); // 취소
					ARExcel.setEnabled(false);// 엑셀
					return;
				} else if (su == JOptionPane.NO_OPTION) {
					for (int i = 0; i < ARtext.length; i++) {
						ARtext[i].setText("");
						ARJBNew.setEnabled(true);// 신규
						ARJBSave.setEnabled(false); // 저장
						ARJBDel.setEnabled(true);// 삭제
						ARJBMod.setEnabled(true); // 수정
						ARJBCel.setEnabled(false); // 취소
						ARJBSaveMod.setVisible(false); // 수정시만 나타나게 할거임
						ARtext[i].setEnabled(false);
						ARExcel.setEnabled(true);// 엑셀
					}
				}

			} else {
	
				for (int i = 0; i < num.length(); i++) {

					if (!isStringDouble(num)) {
						JOptionPane.showMessageDialog(null, "사업자번호형식 이 안맞습니다-숫자가 아님");
						for (int j = 0; j < ARtext.length; j++) {
							ARtext[j].setText("");
							ARJBNew.setEnabled(false);// 신규
							ARJBSave.setEnabled(true); // 저장
							ARJBDel.setEnabled(false);// 삭제
							ARJBMod.setEnabled(false); // 수정
							ARJBCel.setEnabled(true); // 취소
							ARExcel.setEnabled(false);// 엑셀
						}
						return;
					} else if (num.length() != 10) {
						JOptionPane.showMessageDialog(null, "사업자번호형식 이 안맞습니다-10자리아님");
						for (int j = 0; j < ARtext.length; j++) {
							ARtext[j].setText("");
							ARJBNew.setEnabled(false);// 신규
							ARJBSave.setEnabled(true); // 저장
							ARJBDel.setEnabled(false);// 삭제
							ARJBMod.setEnabled(false); // 수정
							ARJBCel.setEnabled(true); // 취소
							ARExcel.setEnabled(false);// 엑셀
						}
						return;
					} else if(((ARtext[0].getText().length()!=3) || (ARtext[1].getText().length()!=2) || ARtext[2].getText().length()!=5)){
						JOptionPane.showMessageDialog(null, "사업자번호형식은 3자리-2자리-5자리입니다- 예)111-11-11111");
						ARJBNew.setEnabled(false);// 신규
						ARJBSave.setEnabled(true); // 저장
						ARJBDel.setEnabled(false);// 삭제
						ARJBMod.setEnabled(false); // 수정
						ARJBCel.setEnabled(true); // 취소
						ARExcel.setEnabled(false);// 엑셀
						return;
					}
					else {
						Adao.inputdb(tf1, tf2, tf3, tf4, tf5, tf6);
						Adao.redefJTable();
						ARtable.updateUI();
						for (int j = 0; j < ARtext.length; j++) {
							ARtext[j].setText("");
							ARtext[j].setEnabled(false);
							ARExcel.setEnabled(true);// 엑셀
						}
					}return;
				}
			}
		}
		
		//숫자체크용 메서드
		private boolean isStringDouble(String num2) {
			 boolean result = false; 
	         
	         
		        try{
		            Double.parseDouble(num) ;
		            result = true ;
		        }catch(Exception e){}
		         
		         
		        return result ;
		}
	}

	// 삭제버튼
	class deleteAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (ARRow1.equals("")) {
				JOptionPane.showMessageDialog(null, "행을선택해 삭제합니다 삭제하실 테이블을 선택해주세요-_<", "실패",
						JOptionPane.WARNING_MESSAGE);
			}

			Adao.deleteRow(ARRow1);

			Adao.redefJTable();
			ARtable.updateUI();
		}
	}

	// 수정버튼
	class ModnewAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (ARRow1.equals("")) {
				JOptionPane.showMessageDialog(null, "행을선택해 수정합니다 수정하실 테이블을 더블클릭해주세요-_<", "실패",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			ARJBNew.setEnabled(false);// 신규
			ARJBDel.setEnabled(false);// 삭제
			ARJBMod.setEnabled(false); // 수정
			ARJBCel.setEnabled(true); // 취소
			ARJBSaveMod.setEnabled(true);
			ARJBSaveMod.setVisible(true);
			ARJBSave.setVisible(false);
			ARExcel.setEnabled(false);// 엑셀

			System.out.println(ARRow1);

			String[] strarr = ARRow1.split("-");

			ARtext[0].setText(strarr[0]);
			ARtext[1].setText(strarr[1]);
			ARtext[2].setText(strarr[2]);
			ARtext[3].setText(ARRow2);
			ARtext[4].setText(ARRow3);
			ARtext[5].setText(ARRow4);
			ARtext[6].setText(ARRow5);
			ARtext[7].setText(ARRow6);

			for (int j = 3; j < ARtext.length; j++) {
				ARtext[j].setEnabled(true);
			}
		}

	}

	// 수정저장버튼
	class renewAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			ARJBNew.setEnabled(true);// 신규
			ARJBSave.setEnabled(false); // 저장
			ARJBDel.setEnabled(true);// 삭제
			ARJBMod.setEnabled(true); // 수정
			ARJBCel.setEnabled(false); // 취소
			ARJBSave.setVisible(true);
			ARJBSaveMod.setVisible(false);
			ARExcel.setEnabled(true);// 엑셀

			String tf1 = ARtext[0].getText() + "-" + ARtext[1].getText() + "-" + ARtext[2].getText();
			String tf2 = ARtext[3].getText();
			String tf3 = ARtext[4].getText();
			String tf4 = ARtext[5].getText();
			String tf5 = ARtext[6].getText();
			String tf6 = ARtext[7].getText();

			System.out.println(tf1);
			if (ARtext[0].getText().equals("") || ARtext[1].getText().equals("") || ARtext[2].getText().equals("")
					|| ARtext[3].getText().equals("") || ARtext[4].getText().equals("")
					|| ARtext[5].getText().equals("") || ARtext[6].getText().equals("")
					|| ARtext[7].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "입력하지 않은 곳이 있으니 다시 입력해주세요", "실패", JOptionPane.WARNING_MESSAGE);

				ARJBNew.setEnabled(false);// 신규
				ARJBDel.setEnabled(false);// 삭제
				ARJBMod.setEnabled(false); // 수정
				ARJBCel.setEnabled(true); // 취소
				ARJBSaveMod.setEnabled(true);
				ARJBSaveMod.setVisible(true);
				ARJBSave.setVisible(false);
				ARExcel.setEnabled(false);// 엑셀
				return;
			} else {

				Adao.update(tf1, tf2, tf3, tf4, tf5, tf6);
				Adao.redefJTable();
				ARtable.updateUI();
				for (int j = 0; j < ARtext.length; j++) {
					ARtext[j].setText("");
					ARtext[j].setEnabled(false);
					ARExcel.setEnabled(true);// 엑셀
				}

			}

		}
	}

}
