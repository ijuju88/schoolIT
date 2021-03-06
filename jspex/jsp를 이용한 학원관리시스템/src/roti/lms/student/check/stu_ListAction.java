package roti.lms.student.check;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.student.check.stu_check;

 public class stu_ListAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		stu_check boarddao=new stu_check();
		List checklist=new ArrayList();
		
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null){
			page=Integer.parseInt(request.getParameter("page"));
		}
		
		int listcount=boarddao.getListCount(); //총 리스트 수를 받아옴
		checklist = boarddao.getchecklist(page,limit); //리스트를 받아옴
		
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
		request.setAttribute("checklist", checklist);
		
		ActionForward forward= new ActionForward();
	 	forward.setRedirect(false);
 		forward.setPath("./stu_check.jsp");
 		return forward;
	 }
 }