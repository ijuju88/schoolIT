package com.people.subject;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class SubjectTableModel extends AbstractTableModel {

	private String[] COLUMN_HEADER = { "학년학기", "필수여부", "과목코드", "과목이름", "과목설명", "학점시수" };
	
	private List<Subject> subjectlist = new ArrayList<>();

	
	public List<Subject> getSubjectList() {
		return subjectlist;
	}

	public void setSubjectList(List<Subject> subjectlist) {
		this.subjectlist = subjectlist;
	}
	
	

	// 열의 갯수
	@Override
	public int getColumnCount() {
		return COLUMN_HEADER.length;
	}

	// 행의 갯수
	@Override
	public int getRowCount() {
		return subjectlist.size();
	}

	// 값을 표시할때, 행열형태로
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Subject subject = subjectlist.get(rowIndex);
		return subject.getColumnValue(columnIndex);
	}

	// 텍스트로 열 이름을 리턴해주기 위함
	@Override
	public String getColumnName(int column) {
		return COLUMN_HEADER[column];
	}
	
	public void refreshSubject() {
		fireTableDataChanged();
	}

}
