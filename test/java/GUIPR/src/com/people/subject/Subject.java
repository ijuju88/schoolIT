package com.people.subject;

public class Subject {

	private String semester;
	private String isRequired;
	private String subjectCode;
	private String subjectName;
	private String subjectDescription;
	private String score;

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getIsRequired() {
		return isRequired;
	}

	public void setIsRequired(String isRequired) {
		this.isRequired = isRequired;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectDescription() {
		return subjectDescription;
	}

	public void setSubjectDescription(String subjectDescription) {
		this.subjectDescription = subjectDescription;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	public String getColumnValue (int columnIndex){
		if (columnIndex == 0) {
			return this.getSemester();
		} else if (columnIndex == 1) {
			return this.isRequired;
		} else if (columnIndex == 2) {
			return this.subjectCode;
		} else if (columnIndex == 3) {
			return this.subjectName;
		} else if (columnIndex == 4) {
			return this.subjectDescription;
		} else if (columnIndex == 5) {
			return this.score;
		}
		else	return "";
	}

//	public int getHour() {
//		return hour;
//	}
//
//	public void setHour(int hour) {
//		this.hour = hour;
//	}

}
