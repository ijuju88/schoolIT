package roti.lms.ad_reg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import roti.lms.action.*;
import roti.lms.ad_reg.RegisterDAO;
import roti.lms.ad_reg.RegisterBean;

public class RegisterModifyView implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("euc-kr");

		RegisterDAO boarddao = new RegisterDAO();
		RegisterBean boarddata = new RegisterBean();

		String num = request.getParameter("rg_id");

		if (boarddata == null) {
			System.out.println("안됨");
			return null;
		}
		System.out.println("됨");

		request.setAttribute("boarddata", boarddata);
		forward.setRedirect(false);
		forward.setPath("./RegisterListAction.bo");
		return forward;
	}
}