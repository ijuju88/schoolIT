package roti.lms.ad_tch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_tchdb.Tch_Bean;
import roti.lms.ad_tchdb.Tch_BoardDAO;


 public class Tch_DetailAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		request.setCharacterEncoding("euc-kr");
   		
		Tch_BoardDAO boarddao=new Tch_BoardDAO();
	   	Tch_Bean boarddata=new Tch_Bean();
	   	
		int num=Integer.parseInt(request.getParameter("num"));
	   	boarddata=boarddao.getDetail(num);
	   	
	   	if(boarddata==null){
	   		System.out.println("상세보기 실패");
	   		return null;
	   	}
	   	System.out.println("상세보기 성공");
	   	
	   	request.setAttribute("boarddata", boarddata);
	   	ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./tch_info.jsp");
   		return forward;

	 }
}