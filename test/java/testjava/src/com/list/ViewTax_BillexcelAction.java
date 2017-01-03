package com.list;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class ViewTax_BillexcelAction {

	public ViewTax_BillexcelAction(String row1, String row2, String crname, String crboss, String crloc,
			String crcategory, String crevent, String stamp, String row3, String arname, String arboss, String arloc,
			String arcategory, String arevent, Vector<Vector> data1, int total, int cash, int check, int promissory,
			int credit, String pay) throws IOException {

		// 저장파일명에 날짜를 넣을거라서..
		Date now;
		SimpleDateFormat sdf;
		String dateformat;

		XSSFWorkbook workbook; // Workbook 생성
		// 2007이전버전 Workbook xlsWb = new HSSFWorkbook();
		XSSFSheet spreadsheet; // sheet 생성
		XSSFRow row = null;
		XSSFCell cell, cellhr, cellbody;
		XSSFFont font, fonthr;
		XSSFCellStyle styletitle, styletitle1, styletitle2, styletitle3, styletitle4, styletitle5;
		XSSFCellStyle styletitle_1, styletitle1_1, styletitle2_1, styletitle3_1, styletitle4_1, styletitle5_1;

		workbook = new XSSFWorkbook();
		spreadsheet = workbook.createSheet("세금계산서출력");

		// 컬럼 너비 설정
		for (int i = 0; i <= 34; i++) {
			spreadsheet.setColumnWidth(i, 900);
		}

		// 정렬
		styletitle = workbook.createCellStyle();
		styletitle.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle.setVerticalAlignment(VerticalAlignment.CENTER);
		styletitle.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		styletitle.setTopBorderColor(HSSFColor.BLUE.index);
		styletitle.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
		styletitle.setLeftBorderColor(HSSFColor.BLUE.index);

		// 폰트
		font = workbook.createFont();
		font.setFontHeightInPoints((short) 20); // 폰트크기
		styletitle.setFont(font);

		styletitle1 = workbook.createCellStyle();
		styletitle1.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle1.setVerticalAlignment(VerticalAlignment.CENTER);
		styletitle1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		styletitle1.setTopBorderColor(HSSFColor.BLUE.index);
		// styletitle1.setWrapText(true);

		styletitle2 = workbook.createCellStyle();
		styletitle2.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle2.setVerticalAlignment(VerticalAlignment.CENTER);
		styletitle2.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		styletitle2.setTopBorderColor(HSSFColor.BLUE.index);
		styletitle2.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
		styletitle2.setLeftBorderColor(HSSFColor.BLUE.index);
		styletitle2.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
		styletitle2.setRightBorderColor(HSSFColor.BLUE.index);
		styletitle2.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
		styletitle2.setBottomBorderColor(HSSFColor.BLUE.index);

		styletitle3 = workbook.createCellStyle();
		styletitle3.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle3.setVerticalAlignment(VerticalAlignment.CENTER);

		styletitle4 = workbook.createCellStyle();
		styletitle4.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle4.setVerticalAlignment(VerticalAlignment.CENTER);
		styletitle4.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
		styletitle4.setBottomBorderColor(HSSFColor.BLUE.index);

		// 개행용
		styletitle5 = workbook.createCellStyle();
		styletitle5.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle5.setVerticalAlignment(VerticalAlignment.CENTER);
		styletitle5.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		styletitle5.setTopBorderColor(HSSFColor.BLUE.index);
		styletitle5.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
		styletitle5.setLeftBorderColor(HSSFColor.BLUE.index);
		styletitle5.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
		styletitle5.setRightBorderColor(HSSFColor.BLUE.index);
		styletitle5.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
		styletitle5.setBottomBorderColor(HSSFColor.BLUE.index);
		styletitle5.setWrapText(true);

		// 내용적는중(위에)
		row = spreadsheet.createRow((short) 3);

		for (int i = 1; i <= 15; i++) {
			cell = row.createCell((short) i);
			cell.setCellValue("세금계산서");
			cell.setCellStyle(styletitle);
		}

		for (int i = 16; i < 23; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle1);
			cell.setCellValue("( 공급받는자  보관용  )");
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 3, (short) 4, (short) 16, (short) 22));

		for (int i = 23; i <= 27; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("책 번 호");
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 3, (short) 3, (short) 23, (short) 27));

		for (int i = 28; i <= 30; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("     권");
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 3, (short) 3, (short) 28, (short) 30));

		for (int i = 31; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("     호");
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 3, (short) 3, (short) 31, (short) 34));

		// 4번째줄
		row = spreadsheet.createRow((short) 4);
		for (int i = 1; i <= 15; i++) {
			cell = row.createCell((short) i);
			cell.setCellValue("세금계산서");
			cell.setCellStyle(styletitle);
		}
		for (int i = 23; i <= 27; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("일련번호");
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 4, (short) 4, (short) 23, (short) 27));

		String[] str = row1.split("-");

		for (int i = 24; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(str[0] + "-" + str[1]);
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 4, (short) 4, (short) 28, (short) 34));

		// 5번째줄
		row = spreadsheet.createRow(5);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle5);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("등록번호");
		}
		cell = row.createCell(6);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(0, 1));
		cell = row.createCell(7);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(1, 2));
		cell = row.createCell(8);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(2, 3));
		cell = row.createCell(9);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(3, 4));
		cell = row.createCell(10);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(4, 5));
		cell = row.createCell(11);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(5, 6));
		cell = row.createCell(12);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(6, 7));
		cell = row.createCell(13);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(7, 8));
		cell = row.createCell(14);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(8, 9));
		cell = row.createCell(15);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(9, 10));
		cell = row.createCell(16);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(10, 11));
		cell = row.createCell(17);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(11, 12));

		/*----------------------------------------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle5);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("등록번호");
		}

		cell = row.createCell(23);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(0, 1));
		cell = row.createCell(24);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(1, 2));
		cell = row.createCell(25);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(2, 3));
		cell = row.createCell(26);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(3, 4));
		cell = row.createCell(27);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(4, 5));
		cell = row.createCell(28);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(5, 6));
		cell = row.createCell(29);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(6, 7));
		cell = row.createCell(30);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(7, 8));
		cell = row.createCell(31);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(8, 9));
		cell = row.createCell(32);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(9, 10));
		cell = row.createCell(33);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(10, 11));
		cell = row.createCell(34);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(11, 12));

		// 6번째줄

		row = spreadsheet.createRow(6);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("등록번호");
		}

		cell = row.createCell(6);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(0, 1));
		cell = row.createCell(7);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(1, 2));
		cell = row.createCell(8);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(2, 3));
		cell = row.createCell(9);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(3, 4));
		cell = row.createCell(10);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(4, 5));
		cell = row.createCell(11);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(5, 6));
		cell = row.createCell(12);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(6, 7));
		cell = row.createCell(13);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(7, 8));
		cell = row.createCell(14);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(8, 9));
		cell = row.createCell(15);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(9, 10));
		cell = row.createCell(16);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(10, 11));
		cell = row.createCell(17);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row2.substring(11, 12));

		/*----------------------------------------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("등록번호");
		}

		cell = row.createCell(23);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(0, 1));
		cell = row.createCell(24);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(1, 2));
		cell = row.createCell(25);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(2, 3));
		cell = row.createCell(26);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(3, 4));
		cell = row.createCell(27);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(4, 5));
		cell = row.createCell(28);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(5, 6));
		cell = row.createCell(29);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(6, 7));
		cell = row.createCell(30);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(7, 8));
		cell = row.createCell(31);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(8, 9));
		cell = row.createCell(32);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(9, 10));
		cell = row.createCell(33);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(10, 11));
		cell = row.createCell(34);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(row3.substring(11, 12));

		// 7번째줄
		row = spreadsheet.createRow(7);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle3);
			cell.setCellValue("상호");
		}

		for (int i = 6; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crname);
		}

		cell = row.createCell(12);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("성명");

		for (int i = 13; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crboss);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle3);
			cell.setCellValue("상호");
		}

		for (int i = 23; i <= 28; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(arname);
		}

		cell = row.createCell(29);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("성명");

		for (int i = 30; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(arboss);
		}

		// 8번째줄
		row = spreadsheet.createRow(8);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4);
			cell.setCellValue("(법인명)");
		}

		for (int i = 6; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crname);
		}

		cell = row.createCell(12);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("성명");

		for (int i = 13; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crboss);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4);
			cell.setCellValue("(법인명)");
		}

		for (int i = 23; i <= 28; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(arname);
		}

		cell = row.createCell(29);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("성명");

		for (int i = 30; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(arboss);
		}

		// 9번째줄
		row = spreadsheet.createRow(9);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle3);
			cell.setCellValue("사업장");
		}

		for (int i = 6; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crloc);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle3);
			cell.setCellValue("사업장");
		}

		for (int i = 23; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(arloc);
		}

		// 10번째줄
		row = spreadsheet.createRow(10);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4);
			cell.setCellValue("주소");
		}
		for (int i = 6; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crloc);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4);
			cell.setCellValue("주소");
		}

		for (int i = 23; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(arloc);
		}

		// 11번줄
		row = spreadsheet.createRow(11);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4);
			cell.setCellValue("업태");
		}

		for (int i = 6; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crcategory);
		}

		cell = row.createCell(12);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("종목");

		for (int i = 13; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crevent);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4);
			cell.setCellValue("업태");
		}

		for (int i = 23; i <= 28; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crcategory);
		}

		cell = row.createCell(29);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("종목");

		for (int i = 30; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crevent);
		}

		// 12번째줄
		row = spreadsheet.createRow(12);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4);
			cell.setCellValue("업태");
		}

		for (int i = 6; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crcategory);
		}

		cell = row.createCell(12);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("종목");

		for (int i = 13; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crevent);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4);
			cell.setCellValue("업태");
		}

		for (int i = 23; i <= 28; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crcategory);
		}

		cell = row.createCell(29);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("종목");

		for (int i = 30; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(crevent);
		}

		// 13번째 줄
		row = spreadsheet.createRow(13);
		for (int i = 1; i <= 5; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("작  성");
		}

		for (int i = 6; i <= 18; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("공     급     가     액");
		}

		for (int i = 19; i <= 28; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("세         액");
		}

		for (int i = 29; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("비     고");
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 13, (short) 13, (short) 1, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 13, (short) 13, (short) 6, (short) 18));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 13, (short) 13, (short) 19, (short) 28));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 13, (short) 13, (short) 29, (short) 34));

		// 14번째줄
		row = spreadsheet.createRow(14);
		for (int i = 1; i <= 3; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("년");
		}

		cell = row.createCell(4);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("월");

		cell = row.createCell(5);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("일");

		for (int i = 6; i <= 7; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("공란수");
		}

		String[] moneykor = { "백", "십", "억", "천", "백", "십", "만", "천", "백", "십", "일" };

		// 공급가액
		cell = row.createCell(8);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[0].toString());
		cell = row.createCell(9);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[1].toString());
		cell = row.createCell(10);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[2].toString());
		cell = row.createCell(11);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[3].toString());
		cell = row.createCell(12);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[4].toString());
		cell = row.createCell(13);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[5].toString());
		cell = row.createCell(14);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[6].toString());
		cell = row.createCell(15);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[7].toString());
		cell = row.createCell(16);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[8].toString());
		cell = row.createCell(17);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[9].toString());
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[10].toString());

		// 세액

		cell = row.createCell(19);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[1].toString());
		cell = row.createCell(20);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[2].toString());
		cell = row.createCell(21);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[3].toString());
		cell = row.createCell(22);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[4].toString());
		cell = row.createCell(23);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[5].toString());
		cell = row.createCell(24);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[6].toString());
		cell = row.createCell(25);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[7].toString());
		cell = row.createCell(26);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[8].toString());
		cell = row.createCell(27);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[9].toString());
		cell = row.createCell(28);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(moneykor[10].toString());

		for (int i = 29; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 14, (short) 14, (short) 1, (short) 3));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 14, (short) 14, (short) 6, (short) 7));

		// System.out.println(data1.toString());

		// 15번째줄

		row = spreadsheet.createRow(15);
		for (int i = 1; i <= 3; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("20" + str[0].substring(0, 2));
		}

		cell = row.createCell(4);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(str[0].substring(2, 4));

		cell = row.createCell(5);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(str[0].substring(4, 6));

		for (int i = 6; i <= 7; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
		}

		int digit1 = total % 10;
		int digit2 = total / 10 % 10;
		int digit3 = total / 100 % 10;
		int digit4 = total / 1000 % 10;
		int digit5 = total / 10000 % 10;
		int digit6 = total / 100000 % 10;
		int digit7 = total / 1000000 % 10;
		int digit8 = total / 10000000 % 10;
		int digit9 = total / 100000000 % 10;
		int digit10 = total / 1000000000;

		// 공급가액
		cell = row.createCell(8);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("");
		cell = row.createCell(9);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit1);
		cell = row.createCell(10);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit2);
		cell = row.createCell(11);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit3);
		cell = row.createCell(12);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit4);
		cell = row.createCell(13);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit5);
		cell = row.createCell(14);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit6);
		cell = row.createCell(15);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit7);
		cell = row.createCell(16);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit8);
		cell = row.createCell(17);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit9);
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit10);

		// 세액

		cell = row.createCell(19);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("");
		cell = row.createCell(20);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit1);
		cell = row.createCell(21);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit2);
		cell = row.createCell(22);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit3);
		cell = row.createCell(23);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit4);
		cell = row.createCell(24);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit5);
		cell = row.createCell(25);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit6);
		cell = row.createCell(26);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit7);
		cell = row.createCell(27);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit8);
		cell = row.createCell(28);
		cell.setCellStyle(styletitle2);
		cell.setCellValue(digit9);

		for (int i = 29; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 15, (short) 15, (short) 1, (short) 3));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 15, (short) 15, (short) 6, (short) 7));

		// 16번째줄
		row = spreadsheet.createRow(16);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("월");

		cell = row.createCell(2);
		cell.setCellStyle(styletitle2);
		cell.setCellValue("일");

		for (int i = 3; i <= 9; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("품            목");
		}

		for (int i = 10; i <= 12; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("규 격");
		}

		for (int i = 13; i <= 15; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("수 량");
		}

		for (int i = 16; i <= 20; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("단     가");
		}

		for (int i = 21; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("공 급 가 액");
		}

		for (int i = 27; i <= 31; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("세        액");
		}

		for (int i = 32; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("비고");
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 16, (short) 16, (short) 3, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 16, (short) 16, (short) 10, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 16, (short) 16, (short) 13, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 16, (short) 16, (short) 16, (short) 20));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 16, (short) 16, (short) 21, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 16, (short) 16, (short) 27, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 16, (short) 16, (short) 32, (short) 34));

		// 17번째줄
		row = spreadsheet.createRow(17);
		try {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(data1.elementAt(0).get(0).toString().split("-")[1]);

			cell = row.createCell(2);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(data1.elementAt(0).get(0).toString().split("-")[2]);
		} catch (Exception e) {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
			cell = row.createCell(2);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
		}

		for (int i = 3; i <= 9; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(0).get(1).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 10; i <= 12; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(0).get(2).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 13; i <= 15; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(0).get(3).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 16; i <= 20; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(0).get(4).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 21; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(0).get(5).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 27; i <= 31; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(0).get(6).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 32; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(0).get(7).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 17, (short) 17, (short) 3, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 17, (short) 17, (short) 10, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 17, (short) 17, (short) 13, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 17, (short) 17, (short) 16, (short) 20));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 17, (short) 17, (short) 21, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 17, (short) 17, (short) 27, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 17, (short) 17, (short) 32, (short) 34));

		// 18번째줄
		row = spreadsheet.createRow(18);

		try {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(data1.elementAt(1).get(0).toString().split("-")[1]);

			cell = row.createCell(2);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(data1.elementAt(1).get(0).toString().split("-")[2]);
		} catch (Exception e) {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
			cell = row.createCell(2);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
		}

		for (int i = 3; i <= 9; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(1).get(1).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 10; i <= 12; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(1).get(2).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 13; i <= 15; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(1).get(3).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 16; i <= 20; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(1).get(4).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 21; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(1).get(5).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 27; i <= 31; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(1).get(6).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 32; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(1).get(7).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}

		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 18, (short) 18, (short) 3, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 18, (short) 18, (short) 10, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 18, (short) 18, (short) 13, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 18, (short) 18, (short) 16, (short) 20));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 18, (short) 18, (short) 21, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 18, (short) 18, (short) 27, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 18, (short) 18, (short) 32, (short) 34));

		// 19번째줄
		row = spreadsheet.createRow(19);

		try {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(data1.elementAt(2).get(0).toString().split("-")[1]);

			cell = row.createCell(2);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(data1.elementAt(2).get(0).toString().split("-")[2]);
		} catch (Exception e) {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
			cell = row.createCell(2);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
		}
		
		for (int i = 3; i <= 9; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(2).get(1).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 10; i <= 12; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(2).get(2).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 13; i <= 15; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(2).get(3).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 16; i <= 20; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(2).get(4).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 21; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(2).get(5).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 27; i <= 31; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(2).get(6).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 32; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(2).get(7).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 19, (short) 19, (short) 3, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 19, (short) 19, (short) 10, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 19, (short) 19, (short) 13, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 19, (short) 19, (short) 16, (short) 20));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 19, (short) 19, (short) 21, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 19, (short) 19, (short) 27, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 19, (short) 19, (short) 32, (short) 34));

		// 20번째줄
		row = spreadsheet.createRow(20);

		try {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(data1.elementAt(3).get(0).toString().split("-")[1]);

			cell = row.createCell(2);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(data1.elementAt(3).get(0).toString().split("-")[2]);
		} catch (Exception e) {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
			cell = row.createCell(2);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("");
		}
		for (int i = 3; i <= 9; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(3).get(1).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 10; i <= 12; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(3).get(2).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 13; i <= 15; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(3).get(3).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 16; i <= 20; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(3).get(4).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 21; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(3).get(5).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 27; i <= 31; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(3).get(6).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 32; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			try {
				cell.setCellValue(data1.elementAt(3).get(7).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 20, (short) 20, (short) 3, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 20, (short) 20, (short) 10, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 20, (short) 20, (short) 13, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 20, (short) 20, (short) 16, (short) 20));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 20, (short) 20, (short) 21, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 20, (short) 20, (short) 27, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 20, (short) 20, (short) 32, (short) 34));

		// 21번째줄

		row = spreadsheet.createRow(21);
		for (int i = 1; i <= 6; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("합 계 금 액");
		}

		for (int i = 7; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("현  금");
		}

		for (int i = 12; i <= 16; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("수  표");
		}

		for (int i = 17; i <= 21; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("어  음");
		}

		for (int i = 22; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("외상미수금");
		}

		for (int i = 27; i <= 30; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("이 금액을");
		}

		for (int i = 31; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(pay);
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 21, (short) 21, (short) 1, (short) 6));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 21, (short) 21, (short) 7, (short) 11));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 21, (short) 21, (short) 12, (short) 16));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 21, (short) 21, (short) 17, (short) 21));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 21, (short) 21, (short) 22, (short) 26));

		// 21번째줄

		row = spreadsheet.createRow(22);
		for (int i = 1; i <= 6; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(total);
		}

		for (int i = 7; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(cash);
		}

		for (int i = 12; i <= 16; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(check);
		}

		for (int i = 17; i <= 21; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(promissory);
		}

		for (int i = 22; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(credit);
		}

		for (int i = 27; i <= 30; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue("이 금액을");
		}

		for (int i = 31; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2);
			cell.setCellValue(pay);
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 22, (short) 22, (short) 1, (short) 6));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 22, (short) 22, (short) 7, (short) 11));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 22, (short) 22, (short) 12, (short) 16));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 22, (short) 22, (short) 17, (short) 21));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 22, (short) 22, (short) 22, (short) 26));

		// 기타 병합(row여러개일때)

		// 병합
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 3, (short) 4, (short) 1, (short) 15));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 12, (short) 1, (short) 1));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 12, (short) 18, (short) 18));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 6, (short) 6));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 7, (short) 7));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 8, (short) 8));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 9, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 10, (short) 10));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 11, (short) 11));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 12, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 13, (short) 13));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 14, (short) 14));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 15, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 16, (short) 16));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 17, (short) 17));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 23, (short) 23));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 24, (short) 24));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 25, (short) 25));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 26, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 27, (short) 27));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 28, (short) 28));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 29, (short) 29));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 30, (short) 30));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 31, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 32, (short) 32));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 33, (short) 33));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 5, (short) 6, (short) 34, (short) 34));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 7, (short) 7, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 8, (short) 8, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 7, (short) 8, (short) 6, (short) 11));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 7, (short) 8, (short) 12, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 7, (short) 8, (short) 13, (short) 17));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 7, (short) 7, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 8, (short) 8, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 7, (short) 8, (short) 23, (short) 28));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 7, (short) 8, (short) 29, (short) 29));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 7, (short) 8, (short) 30, (short) 34));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 9, (short) 9, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 10, (short) 10, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 9, (short) 10, (short) 6, (short) 17));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 9, (short) 9, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 10, (short) 10, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 9, (short) 10, (short) 23, (short) 34));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 11, (short) 12, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 11, (short) 12, (short) 6, (short) 11));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 11, (short) 12, (short) 12, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 11, (short) 12, (short) 13, (short) 17));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 11, (short) 12, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 11, (short) 12, (short) 23, (short) 28));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 11, (short) 12, (short) 29, (short) 29));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 11, (short) 12, (short) 30, (short) 34));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 14, (short) 15, (short) 29, (short) 34));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 21, (short) 22, (short) 27, (short) 30));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 21, (short) 22, (short) 31, (short) 34));

		row = spreadsheet.createRow(23);
		row = spreadsheet.createRow(24);

		/*
		 * 아래끝------------------------------------------------------------------
		 * ----------------------------------------------------------------
		 */
		// 정렬
		styletitle_1 = workbook.createCellStyle();
		styletitle_1.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle_1.setVerticalAlignment(VerticalAlignment.CENTER);
		styletitle_1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		styletitle_1.setTopBorderColor(HSSFColor.RED.index);
		styletitle_1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
		styletitle_1.setLeftBorderColor(HSSFColor.RED.index);

		// 폰트
		font = workbook.createFont();
		font.setFontHeightInPoints((short) 20); // 폰트크기
		styletitle_1.setFont(font);

		styletitle1_1 = workbook.createCellStyle();
		styletitle1_1.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle1_1.setVerticalAlignment(VerticalAlignment.CENTER);
		styletitle1_1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		styletitle1_1.setTopBorderColor(HSSFColor.RED.index);

		styletitle2_1 = workbook.createCellStyle();
		styletitle2_1.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle2_1.setVerticalAlignment(VerticalAlignment.CENTER);
		styletitle2_1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		styletitle2_1.setTopBorderColor(HSSFColor.RED.index);
		styletitle2_1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
		styletitle2_1.setLeftBorderColor(HSSFColor.RED.index);
		styletitle2_1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
		styletitle2_1.setRightBorderColor(HSSFColor.RED.index);
		styletitle2_1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
		styletitle2_1.setBottomBorderColor(HSSFColor.RED.index);

		styletitle3_1 = workbook.createCellStyle();
		styletitle3_1.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle3_1.setVerticalAlignment(VerticalAlignment.CENTER);

		styletitle4_1 = workbook.createCellStyle();
		styletitle4_1.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle4_1.setVerticalAlignment(VerticalAlignment.CENTER);
		styletitle4_1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
		styletitle4_1.setBottomBorderColor(HSSFColor.RED.index);

		// 개행용
		styletitle5_1 = workbook.createCellStyle();
		styletitle5_1.setAlignment(HorizontalAlignment.CENTER_SELECTION);
		styletitle5_1.setVerticalAlignment(VerticalAlignment.CENTER);
		styletitle5_1.setBorderTop(XSSFCellStyle.BORDER_MEDIUM);
		styletitle5_1.setTopBorderColor(HSSFColor.RED.index);
		styletitle5_1.setBorderLeft(XSSFCellStyle.BORDER_MEDIUM);
		styletitle5_1.setLeftBorderColor(HSSFColor.RED.index);
		styletitle5_1.setBorderRight(XSSFCellStyle.BORDER_MEDIUM);
		styletitle5_1.setRightBorderColor(HSSFColor.RED.index);
		styletitle5_1.setBorderBottom(XSSFCellStyle.BORDER_MEDIUM);
		styletitle5_1.setBottomBorderColor(HSSFColor.RED.index);
		styletitle5_1.setWrapText(true);

		row = spreadsheet.createRow(25);
		row = spreadsheet.createRow(26);

		// 내용적는중(아래에)

		// 27번째줄
		row = spreadsheet.createRow(27);

		for (int i = 1; i <= 15; i++) {
			cell = row.createCell((short) i);
			cell.setCellValue("세금계산서");
			cell.setCellStyle(styletitle_1);
		}

		for (int i = 16; i < 23; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle1_1);
			cell.setCellValue("( 공급자  보관용  )");
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 27, (short) 28, (short) 16, (short) 22));

		for (int i = 23; i <= 27; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("책 번 호");
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 27, (short) 27, (short) 23, (short) 27));

		for (int i = 28; i <= 30; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("     권");
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 27, (short) 27, (short) 28, (short) 30));

		for (int i = 31; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("     호");
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 27, (short) 27, (short) 31, (short) 34));

		// 28번째줄
		row = spreadsheet.createRow(28);
		for (int i = 1; i <= 15; i++) {
			cell = row.createCell((short) i);
			cell.setCellValue("세금계산서");
			cell.setCellStyle(styletitle_1);
		}
		for (int i = 23; i <= 27; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("일련번호");
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 28, (short) 28, (short) 23, (short) 27));

		for (int i = 24; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(str[0] + "-" + str[1]);
		}
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 28, (short) 28, (short) 28, (short) 34));

		// 29번째줄
		row = spreadsheet.createRow(29);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle5_1);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("등록번호");
		}
		cell = row.createCell(6);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(0, 1));
		cell = row.createCell(7);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(1, 2));
		cell = row.createCell(8);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(2, 3));
		cell = row.createCell(9);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(3, 4));
		cell = row.createCell(10);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(4, 5));
		cell = row.createCell(11);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(5, 6));
		cell = row.createCell(12);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(6, 7));
		cell = row.createCell(13);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(7, 8));
		cell = row.createCell(14);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(8, 9));
		cell = row.createCell(15);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(9, 10));
		cell = row.createCell(16);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(10, 11));
		cell = row.createCell(17);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(11, 12));

		/*----------------------------------------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle5_1);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("등록번호");
		}

		cell = row.createCell(23);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(0, 1));
		cell = row.createCell(24);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(1, 2));
		cell = row.createCell(25);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(2, 3));
		cell = row.createCell(26);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(3, 4));
		cell = row.createCell(27);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(4, 5));
		cell = row.createCell(28);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(5, 6));
		cell = row.createCell(29);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(6, 7));
		cell = row.createCell(30);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(7, 8));
		cell = row.createCell(31);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(8, 9));
		cell = row.createCell(32);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(9, 10));
		cell = row.createCell(33);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(10, 11));
		cell = row.createCell(34);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(11, 12));

		// 30번째줄

		row = spreadsheet.createRow(30);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("등록번호");
		}

		cell = row.createCell(6);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(0, 1));
		cell = row.createCell(7);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(1, 2));
		cell = row.createCell(8);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(2, 3));
		cell = row.createCell(9);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(3, 4));
		cell = row.createCell(10);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(4, 5));
		cell = row.createCell(11);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(5, 6));
		cell = row.createCell(12);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(6, 7));
		cell = row.createCell(13);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(7, 8));
		cell = row.createCell(14);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(8, 9));
		cell = row.createCell(15);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(9, 10));
		cell = row.createCell(16);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(10, 11));
		cell = row.createCell(17);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row2.substring(11, 12));

		/*----------------------------------------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("등록번호");
		}

		cell = row.createCell(23);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(0, 1));
		cell = row.createCell(24);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(1, 2));
		cell = row.createCell(25);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(2, 3));
		cell = row.createCell(26);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(3, 4));
		cell = row.createCell(27);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(4, 5));
		cell = row.createCell(28);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(5, 6));
		cell = row.createCell(29);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(6, 7));
		cell = row.createCell(30);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(7, 8));
		cell = row.createCell(31);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(8, 9));
		cell = row.createCell(32);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(9, 10));
		cell = row.createCell(33);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(10, 11));
		cell = row.createCell(34);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(row3.substring(11, 12));

		// 31번째줄
		row = spreadsheet.createRow(31);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle3_1);
			cell.setCellValue("상호");
		}

		for (int i = 6; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crname);
		}

		cell = row.createCell(12);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("성명");

		for (int i = 13; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crboss);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle3_1);
			cell.setCellValue("상호");
		}

		for (int i = 23; i <= 28; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(arname);
		}

		cell = row.createCell(29);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("성명");

		for (int i = 30; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(arboss);
		}

		// 32번째줄
		row = spreadsheet.createRow(32);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4_1);
			cell.setCellValue("(법인명)");
		}

		for (int i = 6; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crname);
		}

		cell = row.createCell(12);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("성명");

		for (int i = 13; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crboss);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4_1);
			cell.setCellValue("(법인명)");
		}

		for (int i = 23; i <= 28; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(arname);
		}

		cell = row.createCell(29);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("성명");

		for (int i = 30; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(arboss);
		}

		// 33번째줄
		row = spreadsheet.createRow(33);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle3_1);
			cell.setCellValue("사업장");
		}

		for (int i = 6; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crloc);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle3_1);
			cell.setCellValue("사업장");
		}

		for (int i = 23; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(arloc);
		}

		// 34번째줄
		row = spreadsheet.createRow(34);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4_1);
			cell.setCellValue("주소");
		}
		for (int i = 6; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crloc);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4_1);
			cell.setCellValue("주소");
		}

		for (int i = 23; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(arloc);
		}

		// 35번줄
		row = spreadsheet.createRow(35);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4_1);
			cell.setCellValue("업태");
		}

		for (int i = 6; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crcategory);
		}

		cell = row.createCell(12);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("종목");

		for (int i = 13; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crevent);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4_1);
			cell.setCellValue("업태");
		}

		for (int i = 23; i <= 28; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crcategory);
		}

		cell = row.createCell(29);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("종목");

		for (int i = 30; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crevent);
		}

		// 36번째줄
		row = spreadsheet.createRow(36);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급자");

		for (int j = 2; j <= 5; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4_1);
			cell.setCellValue("업태");
		}

		for (int i = 6; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crcategory);
		}

		cell = row.createCell(12);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("종목");

		for (int i = 13; i <= 17; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crevent);
		}

		/*---------------------------------------------*/
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("공급받는자");

		for (int j = 19; j <= 22; j++) {
			cell = row.createCell(j);
			cell.setCellStyle(styletitle4_1);
			cell.setCellValue("업태");
		}

		for (int i = 23; i <= 28; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crcategory);
		}

		cell = row.createCell(29);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("종목");

		for (int i = 30; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(crevent);
		}

		// 37번째 줄
		row = spreadsheet.createRow(37);
		for (int i = 1; i <= 5; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("작  성");
		}

		for (int i = 6; i <= 18; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("공     급     가     액");
		}

		for (int i = 19; i <= 28; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("세         액");
		}

		for (int i = 29; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("비     고");
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 37, (short) 37, (short) 1, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 37, (short) 37, (short) 6, (short) 18));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 37, (short) 37, (short) 19, (short) 28));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 37, (short) 37, (short) 29, (short) 34));

		// 38번째줄
		row = spreadsheet.createRow(38);
		for (int i = 1; i <= 3; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("년");
		}

		cell = row.createCell(4);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("월");

		cell = row.createCell(5);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("일");

		for (int i = 6; i <= 7; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("공란수");
		}

		// 공급가액
		cell = row.createCell(8);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[0].toString());
		cell = row.createCell(9);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[1].toString());
		cell = row.createCell(10);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[2].toString());
		cell = row.createCell(11);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[3].toString());
		cell = row.createCell(12);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[4].toString());
		cell = row.createCell(13);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[5].toString());
		cell = row.createCell(14);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[6].toString());
		cell = row.createCell(15);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[7].toString());
		cell = row.createCell(16);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[8].toString());
		cell = row.createCell(17);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[9].toString());
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[10].toString());

		// 세액

		cell = row.createCell(19);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[1].toString());
		cell = row.createCell(20);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[2].toString());
		cell = row.createCell(21);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[3].toString());
		cell = row.createCell(22);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[4].toString());
		cell = row.createCell(23);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[5].toString());
		cell = row.createCell(24);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[6].toString());
		cell = row.createCell(25);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[7].toString());
		cell = row.createCell(26);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[8].toString());
		cell = row.createCell(27);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[9].toString());
		cell = row.createCell(28);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(moneykor[10].toString());

		for (int i = 29; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 38, (short) 38, (short) 1, (short) 3));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 38, (short) 38, (short) 6, (short) 7));

		// System.out.println(data1.toString());

		// 39번째줄

		row = spreadsheet.createRow(39);
		for (int i = 1; i <= 3; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("20" + str[0].substring(0, 2));
		}

		cell = row.createCell(4);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(str[0].substring(2, 4));

		cell = row.createCell(5);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(str[0].substring(4, 6));

		for (int i = 6; i <= 7; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
		}

		// 공급가액
		cell = row.createCell(8);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("");
		cell = row.createCell(9);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit1);
		cell = row.createCell(10);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit2);
		cell = row.createCell(11);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit3);
		cell = row.createCell(12);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit4);
		cell = row.createCell(13);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit5);
		cell = row.createCell(14);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit6);
		cell = row.createCell(15);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit7);
		cell = row.createCell(16);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit8);
		cell = row.createCell(17);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit9);
		cell = row.createCell(18);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit10);

		// 세액

		cell = row.createCell(19);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("");
		cell = row.createCell(20);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit1);
		cell = row.createCell(21);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit2);
		cell = row.createCell(22);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit3);
		cell = row.createCell(23);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit4);
		cell = row.createCell(24);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit5);
		cell = row.createCell(25);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit6);
		cell = row.createCell(26);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit7);
		cell = row.createCell(27);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit8);
		cell = row.createCell(28);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue(digit9);

		for (int i = 29; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 39, (short) 39, (short) 1, (short) 3));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 39, (short) 39, (short) 6, (short) 7));

		// 40번째줄
		row = spreadsheet.createRow(40);
		cell = row.createCell(1);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("월");

		cell = row.createCell(2);
		cell.setCellStyle(styletitle2_1);
		cell.setCellValue("일");

		for (int i = 3; i <= 9; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("품            목");
		}

		for (int i = 10; i <= 12; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("규 격");
		}

		for (int i = 13; i <= 15; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("수 량");
		}

		for (int i = 16; i <= 20; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("단     가");
		}

		for (int i = 21; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("공 급 가 액");
		}

		for (int i = 27; i <= 31; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("세        액");
		}

		for (int i = 32; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("비고");
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 40, (short) 40, (short) 3, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 40, (short) 40, (short) 10, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 40, (short) 40, (short) 13, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 40, (short) 40, (short) 16, (short) 20));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 40, (short) 40, (short) 21, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 40, (short) 40, (short) 27, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 40, (short) 40, (short) 32, (short) 34));

		// 41번째줄
		row = spreadsheet.createRow(41);

		try {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(data1.elementAt(0).get(0).toString().split("-")[1]);

			cell = row.createCell(2);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(data1.elementAt(0).get(0).toString().split("-")[2]);
		} catch (Exception e) {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
			cell = row.createCell(2);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
		}

		for (int i = 3; i <= 9; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(0).get(1).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 10; i <= 12; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(0).get(2).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 13; i <= 15; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(0).get(3).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 16; i <= 20; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(0).get(4).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 21; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(0).get(5).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 27; i <= 31; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(0).get(6).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 32; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(0).get(7).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 41, (short) 41, (short) 3, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 41, (short) 41, (short) 10, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 41, (short) 41, (short) 13, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 41, (short) 41, (short) 16, (short) 20));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 41, (short) 41, (short) 21, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 41, (short) 41, (short) 27, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 41, (short) 41, (short) 32, (short) 34));

		// 42번째줄
		row = spreadsheet.createRow(42);

		try {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(data1.elementAt(1).get(0).toString().split("-")[1]);

			cell = row.createCell(2);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(data1.elementAt(1).get(0).toString().split("-")[2]);
		} catch (Exception e) {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
			cell = row.createCell(2);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
		}

		for (int i = 3; i <= 9; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(1).get(1).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 10; i <= 12; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(1).get(2).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 13; i <= 15; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(1).get(3).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 16; i <= 20; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(1).get(4).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 21; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(1).get(5).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 27; i <= 31; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(1).get(6).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 32; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(1).get(7).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}

		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 42, (short) 42, (short) 3, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 42, (short) 42, (short) 10, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 42, (short) 42, (short) 13, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 42, (short) 42, (short) 16, (short) 20));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 42, (short) 42, (short) 21, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 42, (short) 42, (short) 27, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 42, (short) 42, (short) 32, (short) 34));

		// 43번째줄
		row = spreadsheet.createRow(43);

		try {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(data1.elementAt(2).get(0).toString().split("-")[1]);

			cell = row.createCell(2);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(data1.elementAt(2).get(0).toString().split("-")[2]);
		} catch (Exception e) {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
			cell = row.createCell(2);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
		}

		for (int i = 3; i <= 9; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(2).get(1).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 10; i <= 12; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(2).get(2).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 13; i <= 15; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(2).get(3).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 16; i <= 20; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(2).get(4).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 21; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(2).get(5).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 27; i <= 31; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(2).get(6).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 32; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(2).get(7).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 43, (short) 43, (short) 3, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 43, (short) 43, (short) 10, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 43, (short) 43, (short) 13, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 43, (short) 43, (short) 16, (short) 20));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 43, (short) 43, (short) 21, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 43, (short) 43, (short) 27, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 43, (short) 43, (short) 32, (short) 34));

		// 44번째줄
		row = spreadsheet.createRow(44);

		try {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(data1.elementAt(3).get(0).toString().split("-")[1]);

			cell = row.createCell(2);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(data1.elementAt(3).get(0).toString().split("-")[2]);
		} catch (Exception e) {
			cell = row.createCell(1);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
			cell = row.createCell(2);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("");
		}
		for (int i = 3; i <= 9; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(3).get(1).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 10; i <= 12; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(3).get(2).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 13; i <= 15; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(3).get(3).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 16; i <= 20; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(3).get(4).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 21; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(3).get(5).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 27; i <= 31; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(3).get(6).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		for (int i = 32; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			try {
				cell.setCellValue(data1.elementAt(3).get(7).toString());
			} catch (Exception e) {
				cell.setCellValue("");
			}
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 44, (short) 44, (short) 3, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 44, (short) 44, (short) 10, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 44, (short) 44, (short) 13, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 44, (short) 44, (short) 16, (short) 20));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 44, (short) 44, (short) 21, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 44, (short) 44, (short) 27, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 44, (short) 44, (short) 32, (short) 34));

		// 45번째줄

		row = spreadsheet.createRow(45);
		for (int i = 1; i <= 6; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("합 계 금 액");
		}

		for (int i = 7; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("현  금");
		}

		for (int i = 12; i <= 16; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("수  표");
		}

		for (int i = 17; i <= 21; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("어  음");
		}

		for (int i = 22; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("외상미수금");
		}

		for (int i = 27; i <= 30; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("이 금액을");
		}

		for (int i = 31; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(pay);
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 45, (short) 45, (short) 1, (short) 6));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 45, (short) 45, (short) 7, (short) 11));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 45, (short) 45, (short) 12, (short) 16));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 45, (short) 45, (short) 17, (short) 21));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 45, (short) 45, (short) 22, (short) 26));

		// 46번째줄

		row = spreadsheet.createRow(46);
		for (int i = 1; i <= 6; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(total);
		}

		for (int i = 7; i <= 11; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(cash);
		}

		for (int i = 12; i <= 16; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(check);
		}

		for (int i = 17; i <= 21; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(promissory);
		}

		for (int i = 22; i <= 26; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(credit);
		}

		for (int i = 27; i <= 30; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue("이 금액을");
		}

		for (int i = 31; i <= 34; i++) {
			cell = row.createCell(i);
			cell.setCellStyle(styletitle2_1);
			cell.setCellValue(pay);
		}

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 46, (short) 46, (short) 1, (short) 6));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 46, (short) 46, (short) 7, (short) 11));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 46, (short) 46, (short) 12, (short) 16));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 46, (short) 46, (short) 17, (short) 21));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 46, (short) 46, (short) 22, (short) 26));

		// 기타 병합(row여러개일때)

		// 병합
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 27, (short) 28, (short) 1, (short) 15));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 36, (short) 1, (short) 1));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 36, (short) 18, (short) 18));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 6, (short) 6));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 7, (short) 7));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 8, (short) 8));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 9, (short) 9));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 10, (short) 10));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 11, (short) 11));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 12, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 13, (short) 13));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 14, (short) 14));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 15, (short) 15));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 16, (short) 16));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 17, (short) 17));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 23, (short) 23));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 24, (short) 24));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 25, (short) 25));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 26, (short) 26));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 27, (short) 27));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 28, (short) 28));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 29, (short) 29));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 30, (short) 30));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 31, (short) 31));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 32, (short) 32));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 33, (short) 33));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 29, (short) 30, (short) 34, (short) 34));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 31, (short) 31, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 32, (short) 32, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 31, (short) 32, (short) 6, (short) 11));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 31, (short) 32, (short) 12, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 31, (short) 32, (short) 13, (short) 17));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 31, (short) 31, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 32, (short) 32, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 31, (short) 32, (short) 23, (short) 28));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 31, (short) 32, (short) 29, (short) 29));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 31, (short) 32, (short) 30, (short) 34));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 33, (short) 33, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 34, (short) 34, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 33, (short) 34, (short) 6, (short) 17));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 33, (short) 33, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 34, (short) 34, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 33, (short) 34, (short) 23, (short) 34));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 35, (short) 36, (short) 2, (short) 5));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 35, (short) 36, (short) 6, (short) 11));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 35, (short) 36, (short) 12, (short) 12));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 35, (short) 36, (short) 13, (short) 17));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 35, (short) 36, (short) 19, (short) 22));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 35, (short) 36, (short) 23, (short) 28));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 35, (short) 36, (short) 29, (short) 29));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 35, (short) 36, (short) 30, (short) 34));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 38, (short) 39, (short) 29, (short) 34));

		spreadsheet.addMergedRegion(new CellRangeAddress((short) 45, (short) 46, (short) 27, (short) 30));
		spreadsheet.addMergedRegion(new CellRangeAddress((short) 45, (short) 46, (short) 31, (short) 34));

		// 도장넣기
		// 엑셀에 사진첨부하기.
		try {
			File files = new File(stamp); // 이미지경로
			long lengthh = files.length();
			if (lengthh != 0) {
				byte[] picData = new byte[(int) files.length()];
				byte[] bytes = new byte[(int) files.length()];
				InputStream input = new BufferedInputStream(new FileInputStream(files));
				FileInputStream picIn = new FileInputStream(files);
				picIn.read(picData);
				try {
					int offset = 0;
					int read = -1;
					while ((read = input.read()) != -1)
						bytes[offset++] = (byte) read;
				} finally {
					input.close();
				}
				int indx = workbook.addPicture(picData, workbook.PICTURE_TYPE_PNG); // 이미지

				XSSFDrawing patriarch = spreadsheet.createDrawingPatriarch();
				XSSFClientAnchor anchor;
				anchor = new XSSFClientAnchor(0, 0, 200, 200, (short) 16, 7, (short) 19, 10); // 이미지넣을
																								// 위치
				anchor.setAnchorType(2);
				patriarch.createPicture(anchor, indx);

				XSSFDrawing patriarch1 = spreadsheet.createDrawingPatriarch();
				XSSFClientAnchor anchor1;
				anchor1 = new XSSFClientAnchor(0, 0, 200, 200, (short) 16, 31, (short) 19, 34); // 이미지넣을
																								// 위치
				anchor1.setAnchorType(2);
				patriarch1.createPicture(anchor1, indx);
			}
		} catch (Exception e) {

		}

		now = new Date();
		sdf = new SimpleDateFormat("yyMMddHHDDSS");

		dateformat = sdf.format(now);

		String filepath = dateformat + "세금계산서" + ".xlsx";
		String path = "TaxBill";

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