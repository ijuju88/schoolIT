package com.collectTest;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetEcample_p776 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<StudentEx> set = new HashSet<>();
		set.add(new StudentEx(1, "홍길동"));
		set.add(new StudentEx(2, "신용권"));
		set.add(new StudentEx(1, "조민우"));

		Iterator<StudentEx> iterator = set.iterator();

		while (iterator.hasNext()) {
			StudentEx student = iterator.next();
			System.out.println(student.studentNum + ":" + student.name);
		}
	}

}

class StudentEx {
	public int studentNum;
	public String name;

	public StudentEx(int studentNum, String name) {
		super();
		this.studentNum = studentNum;
		this.name = name;
	};

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StudentEx) {
			StudentEx student = (StudentEx) obj;
			return (student.studentNum == studentNum);

		} else
			return false;
	}

	@Override
	public int hashCode() {
		return studentNum ;
	}

}