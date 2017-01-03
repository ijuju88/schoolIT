package com.people.subject;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class SubjectFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JTextField tf_Semester;
	private JLabel label;
	private JTextField tf_Major;
	private JLabel label_1;
	private JLabel label_2;
	private JTextField tf_Name;
	private JLabel label_3;
	private JTextField tf_Code;
	private JLabel label_4;
	private JScrollPane scrollPane;
	private JCheckBox checkbox;
	private JButton SaveBtn;
	private JLabel title;
	private JTextArea tf_Description;
	private JLabel label_5;
	private JTextField tf_Score;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JButton modifyBtn;
	private JButton deleteBtn;
	private JButton searchBtn;
	SubjectTableModel sub = new SubjectTableModel();
	String duplicateCheck = "";

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SubjectFrame frame = new SubjectFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SubjectFrame() {
		setTitle("\uAC74\uAD6D\uB300\uD559\uAD50");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 683);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("\uD559\uB144\uD559\uAE30");
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		lblNewLabel.setBounds(15, 64, 57, 15);
		contentPane.add(lblNewLabel);

		tf_Semester = new JTextField();
		tf_Semester.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_Semester.setBounds(71, 64, 205, 21);
		contentPane.add(tf_Semester);
		tf_Semester.setColumns(10);

		label = new JLabel("\uD544\uC218\uC5EC\uBD80");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label.setBounds(15, 120, 57, 15);
		contentPane.add(label);

		tf_Major = new JTextField();
		tf_Major.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_Major.setColumns(10);
		tf_Major.setBounds(71, 92, 205, 21);
		contentPane.add(tf_Major);

		label_1 = new JLabel("\uC804\uACF5\uC5EC\uBD80");
		label_1.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_1.setBounds(15, 92, 57, 15);
		contentPane.add(label_1);

		label_2 = new JLabel("\uACFC\uBAA9\uC774\uB984");
		label_2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_2.setBounds(15, 176, 57, 15);
		contentPane.add(label_2);

		tf_Name = new JTextField();
		tf_Name.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_Name.setColumns(10);
		tf_Name.setBounds(71, 176, 205, 21);
		contentPane.add(tf_Name);

		label_3 = new JLabel("\uACFC\uBAA9\uCF54\uB4DC");
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_3.setBounds(15, 148, 57, 15);
		contentPane.add(label_3);

		tf_Code = new JTextField();
		tf_Code.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_Code.setColumns(10);
		tf_Code.setBounds(71, 148, 205, 21);
		contentPane.add(tf_Code);

		label_4 = new JLabel("\uACFC\uBAA9\uC124\uBA85");
		label_4.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_4.setBounds(288, 64, 57, 15);
		contentPane.add(label_4);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(288, 83, 298, 114);
		contentPane.add(scrollPane);

		tf_Description = new JTextArea();
		tf_Description.setLineWrap(true);
		scrollPane.setViewportView(tf_Description);

		checkbox = new JCheckBox("\uD544\uC218");
		checkbox.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		checkbox.setBounds(72, 119, 57, 23);
		contentPane.add(checkbox);

		SaveBtn = new JButton("\uC800\uC7A5\uD558\uAE30");
		SaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					do_SaveBtn_actionPerformed(arg0);
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		SaveBtn.setBackground(SystemColor.control);
		SaveBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		SaveBtn.setBounds(133, 602, 103, 24);
		contentPane.add(SaveBtn);

		title = new JLabel("\uAC74\uAD6D\uB300\uD559\uAD50 \uAD50\uACFC\uBAA9\uC785\uB825");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		title.setBounds(15, 10, 571, 33);
		contentPane.add(title);

		label_5 = new JLabel("\uD559\uC810\uC2DC\uC218");
		label_5.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		label_5.setBounds(137, 120, 57, 15);
		contentPane.add(label_5);

		tf_Score = new JTextField();
		tf_Score.setToolTipText("");
		tf_Score.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		tf_Score.setColumns(10);
		tf_Score.setBounds(193, 120, 83, 21);
		contentPane.add(tf_Score);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(15, 260, 571, 332);
		contentPane.add(scrollPane_1);

		table = new JTable(sub);
		table.setBackground(SystemColor.text);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				try {
					do_table_mouseReleased(e);
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		scrollPane_1.setViewportView(table);

		modifyBtn = new JButton("\uC218\uC815\uD558\uAE30");
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					try {
						do_button_1_actionPerformed(e);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		modifyBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		modifyBtn.setBackground(SystemColor.control);
		modifyBtn.setBounds(248, 602, 103, 24);
		contentPane.add(modifyBtn);

		deleteBtn = new JButton("\uC0AD\uC81C\uD558\uAE30");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					do_button_2_actionPerformed(arg0);
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		deleteBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		deleteBtn.setBackground(SystemColor.control);
		deleteBtn.setBounds(363, 602, 103, 24);
		contentPane.add(deleteBtn);

		searchBtn = new JButton("\uC804\uCCB4\uC870\uD68C");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					do_button_3_actionPerformed(arg0);
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		searchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		searchBtn.setBackground(SystemColor.control);
		searchBtn.setBounds(478, 602, 108, 24);
		contentPane.add(searchBtn);

		countLabel = new JLabel("");
		countLabel.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		countLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		countLabel.setBounds(15, 235, 571, 15);
		contentPane.add(countLabel);

		positionLabel = new JLabel("");
		positionLabel.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		positionLabel.setHorizontalAlignment(SwingConstants.LEFT);
		positionLabel.setBounds(15, 235, 255, 15);
		contentPane.add(positionLabel);

		partSearchBtn = new JButton("\uC870\uAC74\uAC80\uC0C9");
		partSearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					do_btnSearch_actionPerformed(arg0);
				} catch (ClassNotFoundException | SQLException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		partSearchBtn.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		partSearchBtn.setBackground(SystemColor.inactiveCaptionBorder);
		partSearchBtn.setBounds(15, 602, 103, 24);
		contentPane.add(partSearchBtn);

		clearBtn = new JButton("\uB0B4\uC6A9\uC0AD\uC81C");
		clearBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_clearBtn_actionPerformed(arg0);
			}
		});
		clearBtn.setBackground(SystemColor.control);
		clearBtn.setFont(new Font("맑은 고딕", Font.PLAIN, 11));
		clearBtn.setBounds(499, 53, 87, 23);
		contentPane.add(clearBtn);

		label_6 = new JLabel("<\uAD50\uACFC\uBAA9 \uC870\uD68C>");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		label_6.setBounds(15, 227, 571, 33);
		contentPane.add(label_6);

		separator = new JSeparator();
		separator.setForeground(SystemColor.activeCaptionBorder);
		separator.setBounds(12, 223, 574, 2);
		contentPane.add(separator);
	}

	SubjectDB subjectDB = new SubjectDB();
	private JLabel countLabel;
	private JLabel positionLabel;
	private JButton partSearchBtn;
	private JButton clearBtn;
	private JLabel label_6;
	private JSeparator separator;

	// 저장하기
	protected void do_SaveBtn_actionPerformed(ActionEvent arg0)
			throws ClassNotFoundException, SQLException, IOException {

		if (errorCheck() == false) {

			Subject subject = new Subject();
			subject.setSemester(tf_Semester.getText());
			subject.setIsRequired(tf_Major.getText());
			subject.setSubjectCode(tf_Code.getText());
			subject.setSubjectName(tf_Name.getText());
			subject.setSubjectDescription(tf_Description.getText());
			subject.setScore(tf_Score.getText());

			subjectDB.insert(tf_Semester.getText(), tf_Major.getText(), tf_Code.getText(), tf_Name.getText(),
					tf_Description.getText(), tf_Score.getText());

			tf_Semester.setText("");
			tf_Major.setText("");
			tf_Code.setText("");
			tf_Name.setText("");
			tf_Description.setText("");
			tf_Score.setText("");

			sub.getSubjectList().add(subject);
			sub.refreshSubject();

			countLabel.setText("저장 되었습니다.");

		} else {
			JOptionPane.showMessageDialog(this, "항목을 모두 입력하거나 과목명 중복을 확인해 주세요.");
		}
	}

	// 조회하기
	protected void do_button_3_actionPerformed(ActionEvent arg0)
			throws ClassNotFoundException, SQLException, IOException {

		List<Subject> list = new ArrayList<>();
		list = subjectDB.search();
		sub.setSubjectList(list);
		sub.refreshSubject();
		int size = list.size();
		countLabel.setText(size + "건이 조회되었습니다.");
	}

	// 삭제하기
	protected void do_button_2_actionPerformed(ActionEvent arg0)
			throws ClassNotFoundException, SQLException, IOException {

		int rowCount = table.getSelectedRowCount();

		if (rowCount == 1) {
			// 1. 현재 클릭한 곳의 행
			int row = table.getSelectedRow();
			// 2. 행의 primary 키를 구함
			String primary = table.getValueAt(row, 3) + "";

			int result = JOptionPane.showConfirmDialog(this, "1건 (" + (row + 1) + "행)을 삭제하시겠습니까?", "삭제",
					JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) {
				subjectDB.delete(primary);

				sub.getSubjectList().remove(row);
				sub.refreshSubject();

				countLabel.setText(primary + "과목이 삭제되었습니다.");
			}
		}

		else if (rowCount == 0) {
			return;
		}

		else {

			int rowStart = table.getSelectedRow();
			int rowEnd = rowStart + table.getSelectedRowCount() - 1;
			int SelectedRowCount = rowEnd - rowStart + 1;

			List<String> delList = new ArrayList<>();

			for (int i = 0; i < SelectedRowCount; i++) {
				delList.add(table.getValueAt(rowStart + i, 3) + "");
			}

			int result = JOptionPane.showConfirmDialog(this, "총 " + SelectedRowCount + "행을 삭제하시겠습니까?", "삭제",
					JOptionPane.YES_NO_OPTION);

			if (result == JOptionPane.YES_OPTION) {

				subjectDB.delete(delList);

				System.out.println(rowStart);
				System.out.println(rowEnd);
				for (int i = rowStart; i < (rowEnd + 1); i++) {
					sub.getSubjectList().remove(rowStart);
				}

				sub.refreshSubject();
				countLabel.setText(SelectedRowCount + "개의 행이 삭제되었습니다.");
			}
		}
	}

	// 수정하기
	protected void do_button_1_actionPerformed(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {

		int colCount = table.getSelectedColumnCount();
		int rowCount = table.getSelectedRowCount();

		if (colCount * rowCount == 1) {
			if (tf_Name.getText().equals(duplicateCheck)) {

				int row = table.getSelectedRow();

				String s1 = tf_Semester.getText();
				String s2 = tf_Major.getText();
				String s3 = tf_Code.getText();
				String s4 = tf_Description.getText();
				String s5 = tf_Score.getText();

				String primary = table.getValueAt(row, 3) + "";

				subjectDB.modify(primary, s1, s2, s3, s4, s5);

				sub.getSubjectList().get(row).setSemester(s1);
				sub.getSubjectList().get(row).setIsRequired(s2);
				sub.getSubjectList().get(row).setSubjectCode(s3);
				sub.getSubjectList().get(row).setSubjectDescription(s4);
				sub.getSubjectList().get(row).setScore(s5);
				countLabel.setText("수정 되었습니다.");
				sub.refreshSubject();
			}
		} else {
			JOptionPane.showMessageDialog(this, "수정할 셀을 선택해 주세요. 수정은 한 행씩만 가능합니다.");
		}
	}

	// 에러체크
	public boolean errorCheck() {

		if (tf_Semester.getText().equals("")) {
			return true;
		}
		if (tf_Major.getText().equals("")) {
			return true;
		}
		if (tf_Score.getText().equals("")) {
			return true;
		}
		if (!tf_Score.getText().contains("(")) {
			return true;
		}
		if (!tf_Score.getText().contains(")")) {
			return true;
		}
		if (tf_Code.getText().equals("")) {
			return true;
		}
		if (tf_Name.getText().equals("")) {
			return true;
		}
		if (tf_Description.getText().equals("")) {
			return true;
		}
		if (tf_Name.getText().equals(duplicateCheck)) {
			return true;
		} else {
			return false;
		}

	}

	// 마우스 포지션, 읽어오기
	protected void do_table_mouseReleased(MouseEvent e) throws ClassNotFoundException, SQLException, IOException {
		// 마우스포지션
		int rowCount = table.getSelectedRowCount();
		if (rowCount == 1) {
			positionLabel.setText("1개 선택됨");
		} else {
			positionLabel.setText(rowCount + "개 선택됨");
		}

		// 데이터 읽어오기
		int row = table.getSelectedRow();
		String primary = table.getValueAt(row, 3) + "";

		Subject sub = new Subject();
		sub = subjectDB.selectView(primary);
		tf_Semester.setText(sub.getSemester());
		tf_Major.setText(sub.getIsRequired());
		tf_Score.setText(sub.getScore());
		tf_Code.setText(sub.getSubjectCode());
		tf_Name.setText(sub.getSubjectName());
		duplicateCheck = sub.getSubjectName();
		tf_Description.setText(sub.getSubjectDescription());
	}

	// 검색하기
	protected void do_btnSearch_actionPerformed(ActionEvent arg0)
			throws ClassNotFoundException, SQLException, IOException {

		String name = tf_Name.getText();
		String text = tf_Description.getText();
		String sql = "";

		// 조건1. 과목명 O, 과목설명 X
		if (!name.equals("") && text.equals("")) {
			sql = "select * from 건국대학교 WHERE `과목명` LIKE '%" + name + "%'";
		}

		// 조건2. 과목명 X, 과목설명 O
		if (name.equals("") && !text.equals("")) {
			sql = "select * from 건국대학교 WHERE `과목설명` LIKE '%" + text + "%'";
		}

		// 조건3. 과목명 O, 과목설명 O
		if (!name.equals("") && !text.equals("")) {
			sql = "SELECT * FROM 건국대학교 WHERE 과목명 LIKE '%" + name
					+ "%' union SELECT * FROM 건국대학교 WHERE 과목설명 LIKE '%" + text + "%'";
		}

		// 조건4. 과목명 X, 과목설명 X
		if (name.equals("") && text.equals("")) {
			return;
		}

		List<Subject> list = new ArrayList<>();

		list = subjectDB.partSearch(sql);
		sub.setSubjectList(list);
		sub.refreshSubject();

		int size = list.size();
		countLabel.setText(size + "건이 조회되었습니다.");
	}

	// 내용지우기버튼
	protected void do_clearBtn_actionPerformed(ActionEvent arg0) {
		tf_Semester.setText("");
		tf_Major.setText("");
		tf_Code.setText("");
		tf_Name.setText("");
		tf_Description.setText("");
		tf_Score.setText("");
	}
}
