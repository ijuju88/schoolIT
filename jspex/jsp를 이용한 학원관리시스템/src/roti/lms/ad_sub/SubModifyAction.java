package roti.lms.ad_sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_sub.Action;
import roti.lms.ad_sub.ActionForward;

public class SubModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		boolean result = false;

		int num = Integer.parseInt(request.getParameter("sub_no"));

		DAO subdao = new DAO();
		Bean subdata = new Bean();

		try {
			subdata.setSub_no(num);
			subdata.setSub_name(request.getParameter("sub_name"));
			subdata.setTch_no(request.getParameter("tch_no"));

			result = subdao.subModify(subdata);
			if (result == false) {
				System.out.println("게시판 수정 실패");
				return null;
			}
			System.out.println("게시판 수정 완료");

			forward.setRedirect(true);
			forward.setPath("./sub_info.bo");
			return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}