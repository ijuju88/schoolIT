package com.AR;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

//http://www.w3ii.com/ko/apache_poi/apache_poi_quick_guide.html
public class ARexcelAction {
	// 저장파일명에 날짜를 넣을거라서..
	Date now;
	SimpleDateFormat sdf;
	String dateformat;

	Connection connect = null;
	Statement statement = null;
	ResultSet resultSet = null;

	XSSFWorkbook workbook; // Workbook 생성
	// 2007이전버전 Workbook xlsWb = new HSSFWorkbook();
	XSSFSheet spreadsheet; // sheet 생성
	XSSFRow row;
	XSSFCell cell, cellhr, cellbody;
	XSSFFont font, fonthr;
	XSSFCellStyle styletitle, stylehr, stylebody;
	
//	XSSFSheet sheet1;
//	XSSFCell cellbody1;
//	XSSFRow row1;
	
	@SuppressWarnings("deprecation")
	public ARexcelAction() throws Exception {

		Account_registrationDAO ARDAO = new Account_registrationDAO();

		Class.forName("oracle.jdbc.driver.OracleDriver");
		connect = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oxju88", "1234");
		statement = connect.createStatement();
		resultSet = statement.executeQuery("select *  from Accountregistration");

		workbook = new XSSFWorkbook();
		spreadsheet = workbook.createSheet("거래처관리");

		// 컬럼 너비 설정
		spreadsheet.setColumnWidth(0, 7000);
		spreadsheet.setColumnWidth(1, 5000);
		spreadsheet.setColumnWidth(2, 3000);
		spreadsheet.setColumnWidth(3, 15000);
		spreadsheet.setColumnWidth(4, 3000);
		spreadsheet.setColumnWidth(5, 5000);

		/* 제목 스타일지정중 */

		// 병합
		spreadsheet.addMergedRegion(new CellRangeAddress(0, (short) 0, 0, (short) 5));
		// 정렬
		styletitle = workbook.createCellStyle();
		styletitle.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle.setVerticalAlignment(VerticalAlignment.CENTER);
		// 폰트
		font = workbook.createFont();
		font.setFontHeightInPoints((short) 20); // 폰트크기
		styletitle.setFont(font);

		/* 제목 밑 (hr)스타일지정중 */
		stylehr = workbook.createCellStyle();

		// 배경색지정
		stylehr.setFillForegroundColor(HSSFColor.BLUE.index);
		stylehr.setFillPattern(XSSFCellStyle.SOLID_FOREGROUND);

		// 폰트지정
		fonthr = workbook.createFont();
		fonthr.setColor(IndexedColors.WHITE.getIndex());
		stylehr.setFont(fonthr);

		/* 내용 스타일지정중 */
		stylebody = workbook.createCellStyle();
		stylebody.setWrapText(true); // 자동줄바꿈

		// 제목내용적는중
		row = spreadsheet.createRow((short) 0);
		row.setHeight((short) 0x200);
		cell = row.createCell(0);
		cell.setCellValue("거래처관리");
		cell.setCellStyle(styletitle);

		// 밑에내용~~
		row = spreadsheet.createRow((short) 1);
		cellhr = row.createCell(0);
		cellhr.setCellValue("사업자번호");
		cellhr.setCellStyle(stylehr);
		cellhr = row.createCell(1);
		cellhr.setCellValue("회사명");
		cellhr.setCellStyle(stylehr);
		cellhr = row.createCell(2);
		cellhr.setCellValue("회사대표명");
		cellhr.setCellStyle(stylehr);
		cellhr = row.createCell(3);
		cellhr.setCellValue("주소");
		cellhr.setCellStyle(stylehr);
		cellhr = row.createCell(4);
		cellhr.setCellValue("업태");
		cellhr.setCellStyle(stylehr);
		cellhr = row.createCell(5);
		cellhr.setCellValue("종목");
		cellhr.setCellStyle(stylehr);

		// 수식테스트
//		cellhr = row.createCell(6);
//		cellhr.setCellValue(2);
//		cellhr.setCellStyle(stylehr);
//		cellhr = row.createCell(7);
//		cellhr.setCellValue(4);
//		cellhr.setCellStyle(stylehr);
//		cellhr = row.createCell(8);
//		cellhr.setCellType(XSSFCell.CELL_TYPE_FORMULA);
//		cellhr.setCellFormula("SUM(G2:H2)");
//		cellhr.setCellStyle(stylehr);
//		
//		sheet1 = workbook.createSheet("수식확인");
//		row1 = sheet1.createRow((short) 1);
//		cellbody1 = row1.createCell(0);
//		cellbody1.setCellType(XSSFCell.CELL_TYPE_FORMULA);
//		cellbody1.setCellFormula("거래처관리!I2");
		
		

		workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

		int i = 2;
		while (resultSet.next()) {
			row = spreadsheet.createRow(i);
			cellbody = row.createCell(0);
			cellbody.setCellValue(resultSet.getString("ANO"));
			cellbody = row.createCell(1);
			cellbody.setCellValue(resultSet.getString("ANAME"));
			cellbody = row.createCell(2);
			cellbody.setCellValue(resultSet.getString("ABOSS"));
			cellbody = row.createCell(3);
			cellbody.setCellValue(resultSet.getString("ALOC"));
			cellbody = row.createCell(4);
			cellbody.setCellValue(resultSet.getString("ACATEGORY"));
			cellbody = row.createCell(5);
			cellbody.setCellValue(resultSet.getString("AEVENT"));
			i++;
		}
		now = new Date();
		sdf = new SimpleDateFormat("yyMMddHHDDSS");

		dateformat = sdf.format(now);

		String filepath = dateformat + "거래처관리" + ".xlsx";
		String path = "AR";

		File dir = new File(path);
		File file = new File(filepath);

		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		FileOutputStream out = new FileOutputStream(dir + "/" + file);
		workbook.write(out);
		out.close();
		System.out.println("exceldatabase.xlsx written successfully");
		JOptionPane.showMessageDialog(null, "엑셀파일생성이 완료되었습니다.", "완료", JOptionPane.CANCEL_OPTION);
	}

}
