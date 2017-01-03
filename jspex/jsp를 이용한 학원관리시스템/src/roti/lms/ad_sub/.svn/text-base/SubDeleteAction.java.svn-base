package roti.lms.ad_sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_sub.Action;
import roti.lms.ad_sub.ActionForward;

public class SubDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();

		boolean result = false;
		// boolean usercheck=false;
		int num = Integer.parseInt(request.getParameter("sub_no"));

		DAO dao = new DAO();

		result = dao.SubDelete(num);
		if (result == false) {
			System.out.println("subject 실패");
			return null;
		}

		System.out.println("subject 성공");
		forward.setRedirect(true);
		forward.setPath("./SubListAction.ao");
		return forward;
	}
}