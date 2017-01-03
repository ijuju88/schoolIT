package roti.lms.student.check;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.student.check.ActionForward;
import roti.lms.student.check.checkBean;
import roti.lms.student.check.stu_check;
import roti.lms.student.login.stu_loginDao;

/**
 * Servlet implementation class TestAjax
 */
public class stu_checkin extends HttpServlet {

	 private static final long serialVersionUID = 1L;

	       

	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  responseAjax(request,response);

	 }

	 

	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	  responseAjax(request,response);

	 }

	 

	 private void responseAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

	  
	  response.setContentType("text/html; charset=utf-8");
	  request.setCharacterEncoding("utf-8");
	  stu_check boarddao=new stu_check();
	  List boardlist=new ArrayList();
		String id = request.getParameter("st_id");
		String pass = request.getParameter("st_pass");
		boolean checkb = false;
		
		stu_loginDao adao= new stu_loginDao();
		int check;
		if(id != null){
		try {
			check = adao.userCheck2(id, pass);

				
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		boarddao.inCheck(id,pass);
		 
		}else if(checkb==false){
	  int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount=boarddao.getListCount(); //총 리스트 수를 받아옴
		boardlist = boarddao.getchecklist(page,limit); //리스트를 받아옴
		
		//총 페이지 수
		int maxpage=(int)((double)listcount/limit+0.95); //0.95를 더해서 올림 처리
		//현재 페이지에 보여줄 시작 페이지 수(1, 11, 21 등...)
		int startpage = (((int) ((double)page / 10 + 0.9)) - 1) * 10 + 1;
		//현재 페이지에 보여줄 마지막 페이지 수(10, 20, 30 등...)
		int endpage = startpage+10-1;

		if (endpage> maxpage) endpage= maxpage;

		
		request.setAttribute("page", page); //현재 페이지 수
		request.setAttribute("maxpage", maxpage); //최대 페이지 수
		request.setAttribute("startpage", startpage); //현재 페이지에 표시할 첫 페이지 수
		request.setAttribute("endpage", endpage); //현재 페이지에 표시할 끝 페이지 수
		request.setAttribute("listcount",listcount); //글 수
		request.setAttribute("boardlist", boardlist);
		List boardList=(List)request.getAttribute("boardlist");

	  PrintWriter out = response.getWriter();
	  if(listcount > 0){
	  out.print("<tr align='center' valign='middle' bordercolor='#333333'>"
	  		+ "<td style='font-family:Tahoma;font-size:8pt;' width='8%' height='26'>"
			+"<div align='center'>학생ID</div>"
			+"</td><td style='font-family:Tahoma;font-size:8pt;' width='50%'>"
			+"<div align='center'>날짜</div></td>"
			+"<td style='font-family:Tahoma;font-size:8pt;' width='14%'>"
			+"<div align='center'>입실시간</div></td>"
			+"<td style='font-family:Tahoma;font-size:8pt;' width='17%'>"
			+"<div align='center'>퇴실시간</div></td>"
			+"<td style='font-family:Tahoma;font-size:8pt;' width='11%'>"
			+"<div align='center'>상태</div></td></tr>'");

	 }
	  for(int i=0;i<boardList.size();i++){
			checkBean bl=(checkBean)boardList.get(i);
			out.print("<tr align='center' valign='middle' bordercolor='#333333'onmouseover='this.style.backgroundColor=F8F8F8'onmouseout='this.style.backgroundColor='>"
					+"<td height='23' style='font-family:Tahoma;font-size:10pt;'>"+bl.getAt_id()+"</td>"
					+"<td height='23' style='font-family:Tahoma;font-size:10pt;'>"+bl.getAt_date()+"</td>"
					+"<td height='23' style='font-family:Tahoma;font-size:10pt;'>"+bl.getCheckin()+"</td>"
					+"<td height='23' style='font-family:Tahoma;font-size:10pt;'>"+bl.getCheckout()+"</td>"
					+"<td height='23' style='font-family:Tahoma;font-size:10pt;'>"+bl.getAt_stmt()+"</td>"
					);
}
/*	  out.print*/
	 }
	 }
}