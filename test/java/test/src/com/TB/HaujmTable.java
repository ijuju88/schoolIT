package com.TB;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

import javax.swing.event.*;
import javax.swing.table.*;
import java.util.*;

class HaujmTable extends JPanel{

	private static final long serialVersionUID = 1L;
	// 멤버변수 선언
	MyTableModel model = new MyTableModel();
	JTable table = new JTable(model);
	// 위에서 입력한 벡터의 값을 계산하기 위해 int형으로 다시 지정
	// 날짜선택
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
	Date today = new Date();
	String day = formatter.format(today);

	int mount , unit_price,tax_amount;
	int provision;
	int total=0;
	String ect = "";
	
	// 화면 구성과 화면 출력
	public HaujmTable() {
		setLayout(new BorderLayout());
		add("Center", new JScrollPane(table));

		table.setBackground(SystemColor.inactiveCaptionBorder);

		// 격자선
		table.setGridColor(Color.gray); // 격자선색
		table.setShowGrid(true); // 격자선그릴지 여부

		// 칸 너비 지정중
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(70);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		table.getColumnModel().getColumn(6).setPreferredWidth(80);
		table.getColumnModel().getColumn(7).setPreferredWidth(145);

		table.setBounds(0, 0, 895, 160);

		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 단일선택

		setSize(895, 200);
		setVisible(true);
	}

	// 테이블에 입력하는 레코드를 추가하기 위한 초기화
	public void initial() {
		Vector init = new Vector();
		init.add(0, day);
		for (int i = 1; i < model.getColumnCount(); i++) {
			init.addElement("");

		}
		model.data.addElement(init);
		model.fireTableDataChanged();
	}

	// 테이블에 이벤트 처리
	public void eventProc() {

		// 한 셀에서 수정이 되면 발생하는 이벤트 처리
		model.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent ev) {

				// 이벤트가 발생한 행과 열을 얻어온다
				// 4번째 열( 수학점수 셀)에서 이벤트가 발생했을시만 수행하려한다
				int row = ev.getFirstRow();
				int col = ev.getColumn();
				if (col != 4)
					return;

				Vector<Object> temp = new Vector<Object>();

				for (int i = 0; i < 5; i++) {

					temp.addElement(model.getValueAt(row, i));
				}

				mount = Integer.parseInt((String) temp.elementAt(3));
				unit_price = Integer.parseInt((String) temp.elementAt(4));

				provision = mount * unit_price;
				temp.addElement(String.valueOf(provision));
				total+=provision;
				System.out.println(total);
				
				tax_amount = (int) (provision * 0.1);
				temp.addElement(String.valueOf(tax_amount));
				
				 ect = "";
				temp.addElement(String.valueOf(ect));

				table.setSurrendersFocusOnKeystroke(true);
				model.data.removeElementAt(row);
				model.data.addElement(temp);

				initial();
			}
		});

	}

	// 메인함수
	public static void main(String[] args) {
		HaujmTable second = new HaujmTable();
		second.initial();
		second.eventProc();
	}
}

class MyTableModel extends AbstractTableModel {

	Vector<Vector<Object>> data = new Vector<Vector<Object>>(9);
	private String tablestr[] = { "날짜", "품목", "규격", "수량", "단가", "공급가액", "세액", "비고" };

	public int getColumnCount() {
		return tablestr.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public Object getValueAt(int row, int col) {
		Vector temp = (Vector) data.elementAt(row);
		return temp.elementAt(col);
	}

	public String getColumnName(int col) {
		return tablestr[col];
	}

	public boolean isCellEditable(int row, int col) {
		if (col > 4) {
			return false;
		} else {
			return true;
		}
	}

	public void setValueAt(Object value, int row, int col) {
		Vector rowTemp = (Vector) (data.elementAt(row));
		rowTemp.set(col, value);
		fireTableCellUpdated(row, col);
	}

}
