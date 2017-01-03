package roti.lms.ad_sub;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_sub.Action;
import roti.lms.ad_sub.ActionForward;
import roti.lms.ad_sub.DAO;
import roti.lms.ad_sub.Bean;

public class SubModifyView implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 	ActionForward forward = new ActionForward();
		 	request.setCharacterEncoding("euc-kr");
	   		
		DAO boarddao=new DAO();
		   	Bean boarddata=new Bean();
		   	
			int num=Integer.parseInt(request.getParameter("num"));
		   	boarddata=boarddao.getDetail(num);
		   	
		   	if(boarddata==null){
		   		System.out.println("(수정)상세보기 실패");
		   		return null;
		   	}
		   	System.out.println("(수정)상세보기 성공");
		   	
		   	request.setAttribute("boarddata", boarddata);
		   	forward.setRedirect(false);
	   		forward.setPath("./board/qna_board_modify.jsp");
	   		return forward;
	 }
}