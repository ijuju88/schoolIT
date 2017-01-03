package roti.lms.ad_reg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import roti.lms.action.*;
import roti.lms.ad_reg.RegisterDAO;
import roti.lms.ad_reg.RegisterBean;

public class RegisterDeleteAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");

		RegisterDAO dao = new RegisterDAO();
		RegisterBean bean = new RegisterBean();

		System.out.println("DeleteAction 실행");
		HttpSession session = request.getSession();

		boolean result = false;
		try {
			request.setCharacterEncoding("utf-8");
			String rg_id = request.getParameter("rg_id");
			int sub_no = Integer.parseInt(request.getParameter("sub_no"));
			result = dao.registerDelete(rg_id, sub_no);
			if (result == false) {
				System.out.println("게시판 삭제 실패");
				return null;
			}
			System.out.println("게시판 삭제 성공");
			forward.setRedirect(true);
			forward.setPath("./RegisterListAction.bo");
			return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}