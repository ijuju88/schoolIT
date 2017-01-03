package roti.lms.ad_tch;

import roti.lms.ad_tch.Action;
import roti.lms.ad_tch.ActionForward;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_tchdb.Tch_BoardDAO;

public class Tch_DeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();

		boolean result = false;
		// boolean usercheck = false;
		String num = request.getParameter("tch_no");

		Tch_BoardDAO boarddao = new Tch_BoardDAO();

		result = boarddao.Tch_Delete(num);
		if (result == false) {
			System.out.println("강사 삭제 실패");
			return null;
		}

		System.out.println("강사 삭제 성공");
		forward.setRedirect(true);
		forward.setPath("./tch_ListAction.do");
		return forward;
	}
}
