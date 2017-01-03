package roti.lms.ad_reg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.action.*;

public class RegisterModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("euc-kr");
		ActionForward forward = new ActionForward();
		boolean result = false;
		System.out.println("controller Delete Action 실행");
		int sub_no = Integer.parseInt(request.getParameter("sub_no"));

		RegisterDAO boarddao = new RegisterDAO();
		RegisterBean boarddata = new RegisterBean();

		try {
			request.setCharacterEncoding("utf-8");
			boarddata.setRg_id(request.getParameter("rg_id"));
			boarddata.setSub_no(Integer.parseInt(request.getParameter("sub_no")));
			boarddata.setRg_start(request.getParameter("rg_start"));
			boarddata.setRg_end(request.getParameter("rg_end"));
			boarddata.setClassroom(Integer.parseInt(request.getParameter("classroom")));
			boarddata.setCharge(Integer.parseInt(request.getParameter("charge")));
			result = boarddao.registerModify(boarddata);
			if (result == false) {
				System.out.println("게시판 수정 실패");
				return null;
			}
			System.out.println("게시판 수정 완료");

			forward.setRedirect(true);
			forward.setPath("./RegisterListAction.bo?sub_no="
					+ boarddata.getSub_no());
			return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return forward;
	}
}