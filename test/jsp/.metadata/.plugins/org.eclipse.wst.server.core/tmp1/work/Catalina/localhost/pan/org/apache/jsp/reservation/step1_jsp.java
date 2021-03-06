/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.37
 * Generated at: 2016-12-15 00:10:22 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.reservation;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import reservation.PensionDataBean;
import reservation.RoomBean;
import reservation.ReservationBean;

public final class step1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("reservation.ReservationBean");
    _jspx_imports_classes.add("java.util.Vector");
    _jspx_imports_classes.add("java.util.Calendar");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("reservation.RoomBean");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("reservation.PensionDataBean");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

	request.setCharacterEncoding("UTF-8");

	Vector<RoomBean> room = (Vector<RoomBean>) request.getAttribute("room");
	Vector<ReservationBean> reservation = (Vector<ReservationBean>) request.getAttribute("reservation");
	Vector<String> resDate = (Vector<String>) request.getAttribute("resDate");
	PensionDataBean pension = (PensionDataBean) request.getAttribute("pension");

	//out.print(pension.getSseason().split("-"));
	String[] sSeason = pension.getSseason().split("-");
	String[] eSeason = pension.getEseason().split("-");
	for (int i = 0; i < 2; i++)
		sSeason[0] = (Integer.parseInt(sSeason[0]) < 10) ? "0" + Integer.parseInt(sSeason[0]) : "" + sSeason[0];
	for (int i = 0; i < 2; i++)
		eSeason[0] = (Integer.parseInt(eSeason[0]) < 10) ? "0" + Integer.parseInt(eSeason[0]) : "" + eSeason[0];

	int sSea = Integer.parseInt(sSeason[0] + sSeason[1]);
	int eSea = Integer.parseInt(eSeason[0] + eSeason[1]);
	/*
		if( room != null ){
			for(int i=0; i<room.size();i++){
				out.print(room.get(i).getRno()+" ");
				out.print(room.get(i).getRname()+" ");
				out.print(room.get(i).getRsize()+" ");
				out.print(room.get(i).getMen()+" ");
				out.print(room.get(i).getAddman()+" ");
				out.print(room.get(i).getWeekday()+" ");
				out.print(room.get(i).getWeekend()+" ");
				out.print(room.get(i).getSweekday()+" ");
				out.print(room.get(i).getSweekend()+"<br />");
			}
		}
		out.print("<hr />");
		if(reservation != null){
			for(int i=0; i<reservation.size();i++){
				out.print(reservation.get(i).getRsno()+" ");
				out.print(reservation.get(i).getRno()+" ");
				out.print(reservation.get(i).getUno()+" ");
				out.print(reservation.get(i).getRes_date()+" ");
				out.print(reservation.get(i).getNight()+" ");
				out.print(reservation.get(i).getUsemen()+" ");
				out.print(reservation.get(i).getPrice()+" ");
				out.print(reservation.get(i).getPayment()+" ");
				out.print(reservation.get(i).getPay_number()+" ");
				out.print(reservation.get(i).getPay_yn()+" ");
				out.print(reservation.get(i).getReg_date()+"<br />");
			}
		}
		*/
	// DB에서 넘어온 예약날짜와 기간를 처리하기 위한 선처리(날짜형 데이터로 배열처리)
	/*   if( resDate != null )
	for(int i=0; i < resDate.size(); i+=4){
		out.print(resDate.get(i)+" "+resDate.get(i+1)+" "+resDate.get(i+2)+" "+resDate.get(i+3)+"<br />");
	} 
 */
	// 현재 날짜 출력
	Calendar now = Calendar.getInstance();
	int nowYear = now.get(Calendar.YEAR); // 현재 년
	int nowMonth = now.get(Calendar.MONTH) + 1; // 현재 월
	int nowDate = now.get(Calendar.DATE); // 현재 일
	//out.print(nowYear + "년 " + nowMonth + "월 " + nowDate + "일");

	//out.print("<hr />");
	//out.print("<br />");
	//out.print(request.getAttribute("year") + "/" + request.getAttribute("month"));

	String[] day = {"일", "월", "화", "수", "목", "금", "토"};
	int year = Integer.parseInt(request.getAttribute("year").toString());
	int month = Integer.parseInt(request.getAttribute("month").toString());

	// 선택한 월에 이전달
	now.set(year, month - 1, 1);
	now.add(Calendar.MONTH, -1);
	int laterYear = now.get(Calendar.YEAR);
	int laterMonth = now.get(Calendar.MONTH) + 1;

	// 선택한 월에 다음달
	now.set(year, month - 1, 1);
	now.add(Calendar.MONTH, 1);
	int nextYear = now.get(Calendar.YEAR);
	int nextMonth = now.get(Calendar.MONTH) + 1;

	// 달력을 보여주기 위한 선처리 작업
	Calendar cal = Calendar.getInstance();
	cal.set(year, month - 1, 1);
	int firstWeekday = cal.get(Calendar.DAY_OF_WEEK); // 선택월의 1일에 해당하는 요일
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 현재 월의 마지막 날짜
	//	out.print("이번달 : "+toYear+" "+(toMonth+1)+" "+firstWeekday+" "+lastDay);	// 확인  년/월/첫날요일값 1~7
	int chkNowDate = month == nowMonth ? nowDate : 0;
	if ((year * 100) + month == (nowYear * 100) + nowMonth)
		chkNowDate = nowDate;
	else if ((year * 100) + month < (nowYear * 100) + nowMonth)
		chkNowDate = 32;
	else
		chkNowDate = 0;
	int count = 1;
	String usedRoom = null;
	String cLinkF = "";
	String cLinkB = "";

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>펜션예약</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-2.2.4.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\" lang=\"stylesheet\">\r\n");
      out.write("td.center {\r\n");
      out.write("\twidth: 10px;\r\n");
      out.write("\theight: 20px;\r\n");
      out.write("\ttext-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("td.topLeft {\r\n");
      out.write("\twidth: 100px;\r\n");
      out.write("\theight: 20px;\r\n");
      out.write("\tvertical-align: top;\r\n");
      out.write("\tpadding: 5px 5px 5px 5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#calTitle {\r\n");
      out.write("\tfont-size: 20px;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#days {\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#state1 {\r\n");
      out.write("\tfont-size: 11px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#state2 {\r\n");
      out.write("\tfont-size: 11px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#heart {\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tcolor: limegreen;\r\n");
      out.write("\tpadding-right: 2px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:link {text-decoration: none; color: #e64d00;}\r\n");
      out.write("a:visited {text-decoration: none; color: #e64d00;}\r\n");
      out.write("a:active {text-decoration: none; color: #e64d00;}\r\n");
      out.write("a:hover {text-decoration: none; color: blue;}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script language=\"javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#later\").click(function() {\r\n");
      out.write("\t\t\t$(\"#content\").load(\"../pan/Re.do?y=");
      out.print(laterYear);
      out.write('&');
      out.write('m');
      out.write('=');
      out.print(laterMonth);
      out.write("\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#last\").click(function() {\r\n");
      out.write("\t\t\t$(\"#content\").load(\"../pan/Re.do?y=");
      out.print(nextYear);
      out.write('&');
      out.write('m');
      out.write('=');
      out.print(nextMonth);
      out.write("\");\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("\t// 날짜와 방을 선택\r\n");
      out.write("\tfunction chooseRoom(cDate, rno) {\r\n");
      out.write("\t\t//document.getElementById(\"aa\").innerHTML=cDate;\r\n");
      out.write("\t\t//window.open(\"\", 'pop_title', width=400,height=300) ;\r\n");
      out.write("\t\tvar month =");
      out.print(month);
      out.write(";\r\n");
      out.write("\t\tmonth = (month < 10) ? \"0\" + month : \"\" + month;\r\n");
      out.write("\t\tvar date = (cDate < 10) ? \"0\" + cDate : \"\" + cDate;\r\n");
      out.write("\t\tdocument.step2Form.chooseDate.value =");
      out.print(year);
      out.write("+ month + date;\r\n");
      out.write("\t\tdocument.step2Form.chooseRno.value = rno;\r\n");
      out.write("\r\n");
      out.write("\t\tdocument.step2Form.submit();\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\t// 경고창과포커스처리\r\n");
      out.write("\tfunction alertAndFocus(v, str) {\r\n");
      out.write("\t\talert(str);\r\n");
      out.write("\t\tv.focus();\r\n");
      out.write("\t}\r\n");
      out.write("\t// 예약폼이 전달 되기전 체크\r\n");
      out.write("\tfunction chkReservation(form) {\r\n");
      out.write("\t\tif (form.roomNo.value == \"\") {\r\n");
      out.write("\t\t\talertAndFocus(form.roomNo, \"객실을 선택하세요!\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\treturn true;\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"content\" id=\"content\">\r\n");
      out.write("\t<div class=\"step1\">\r\n");
      out.write("\t\t<div class=\"container\">\r\n");
      out.write("\t<form name=\"step2Form\" method=\"post\" action=\"../pan/Re.do\">\r\n");
      out.write("\t\t<input type=\"hidden\" name=\"step\" value=\"two\" /> <input type=\"hidden\"\r\n");
      out.write("\t\t\tname=\"chooseDate\" /> <input type=\"hidden\" name=\"chooseRno\" />\r\n");
      out.write("\t</form>\r\n");
      out.write("\t<table class=\"table\" style=\"border-color: #999;\" cellspacing=\"1\" width=\"80%\" height=\"80%\" align=\"center\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"7\">");
      out.print("오늘은 - " + nowYear + "년 " + nowMonth + "월 " + nowDate + "일");
      out.write("\r\n");
      out.write("\t\t\t\t\t<center id=\"calTitle\" >\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" id=\"later\">◀</a>\r\n");
      out.write("\t\t\t\t\t\t");
      out.print(year + "년 " + month + "월");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<a href=\"#\" id=\"last\">▶</a>\r\n");
      out.write("\t\t\t\t\t</center></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t");

					for (int i = 0; i < day.length; i++) { // 일월화수목금토 출력 for문
				
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t<td class=\"center\"\r\n");
      out.write("\t\t\t\t\t");
if (i == 0) {
					out.print("bgcolor='tomato'");
				} else if (i == 6) {
					out.print("bgcolor='#52E252'");
				} else {
					out.print("bgcolor='tan'");
				}
      out.write(">\r\n");
      out.write("\t\t\t\t\t");
      out.print(day[i]);
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t");

				while (true) {
			
      out.write("\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t");

					for (int i = 0; i < 7; i++) { // 날짜 출력
							if (i < firstWeekday - 1 && count == 1) {
								out.print("<td>&nbsp;</td>");
								continue;
							}
							if (count > lastDay) {
								out.print("<td>&nbsp;</td>");
							} else {
				
      out.write("\r\n");
      out.write("\t\t\t\t<td class=\"topLeft\"\r\n");
      out.write("\t\t\t\t\t");
if (i == 0) {
							out.print("bgcolor='tomato'");
						} else if (i == 6) {
							out.print("bgcolor='#52E252'");
						}
      out.write(">\r\n");
      out.write("\t\t\t\t\t<div id=\"days\">");
      out.print(count++);
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t<div id=\"state1\">\r\n");
      out.write("\t\t\t\t\t\t");

							int sChkDate = Integer
												.parseInt(month + "" + (((count - 1) < 10) ? "0" + (count - 1) : (count - 1)));
										if (sChkDate >= sSea && sChkDate <= eSea)
											out.print("<b>성수기</b>");
										else
											out.print("비수기");
						
      out.write("\r\n");
      out.write("\t\t\t\t\t</div> <br />\r\n");
      out.write("\t\t\t\t\t<div id=\"state2\">\r\n");
      out.write("\t\t\t\t\t\t");

							if (count > chkNowDate)
											if (room != null)
												for (int j = 0; j < room.size(); j++) { // 방갯수 만큼 루프
													String thisDate = (room.get(j).getRno() + "-" + year + "-"
															+ (month < 10 ? "0" + month : month) + "-"
															+ ((count - 1) < 10 ? "0" + (count - 1) : (count - 1))).toString();
													if (resDate != null) {
														for (int k = 0; k < resDate.size(); k += 4) { // 예약날짜 만큼 루프
															//out.print(resDate.get(k + 1));
															if (resDate.get(k).equals(thisDate)) {
																cLinkF = "<b id='noLink' title='예약자\n" + resDate.get(k + 2) + "\n"
																		+ resDate.get(k + 3) + "'>";
																cLinkB = "</b>";
																if (resDate.get(k + 1).equals("Y")) {
																	usedRoom = "<font color='red'>(완료)</font>";
																	break;
																} else {
																	usedRoom = "<font color='#A30FE2'>(대기)</font>";
																	break;
																}
															} else {
																usedRoom = "<font color='blue'>(신청)</font>";
																cLinkF = "<b id='link' onClick='javascript:chooseRoom(" + (count - 1)
																		+ "," + room.get(j).getRno() + ")'>";
																cLinkB = "</b>";
															}
															//out.print(resDate.get(k)+"/"+thisDate);
														}
													} else {
														usedRoom = "<font color='blue'>(신청)</font>";
														cLinkF = "<b id='link' onClick='javascript:chooseRoom(" + (count - 1) + ","
																+ room.get(j).getRno() + ")'>";
														cLinkB = "</b>";
													}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<font id=\"heart\"><img src=\"../pan/Main/images/list-arrow.png\" alt=\"\" /></font>");
      out.print(cLinkF + room.get(j).getRname() + usedRoom + cLinkB);
      out.write("\r\n");
      out.write("\t\t\t\t\t\t<br />\r\n");
      out.write("\t\t\t\t\t\t");

							}
						
      out.write("\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t");

					}
						}
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t\t");

			if (count > lastDay)
					break; // while 문 종료
			}
		
      out.write("\r\n");
      out.write("\t</table></div></div></div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
