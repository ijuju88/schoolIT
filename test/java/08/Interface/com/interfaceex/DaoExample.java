package com.interfaceex;

public class DaoExample {
	private static void dbWork(DataAccessObject DA) {
		DA.select();
		DA.insert();
		DA.update();
		DA.delete();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dbWork(new OracleDao());
		dbWork(new MySqlDao());
	}



}
