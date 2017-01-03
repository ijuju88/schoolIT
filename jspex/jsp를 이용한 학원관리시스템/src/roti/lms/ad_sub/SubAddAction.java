package roti.lms.ad_sub;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_sub.Action;
import roti.lms.ad_sub.ActionForward;
import roti.lms.ad_sub.DAO;
import roti.lms.ad_sub.Bean;

public class SubAddAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DAO subdao = new DAO();
		Bean subdata = new Bean();
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");

		boolean result = false;

		try {

			subdata.setSub_no(Integer.parseInt(request.getParameter("sub_no")));
			subdata.setSub_name(request.getParameter("sub_name"));
			subdata.setTch_no(request.getParameter("tch_no"));

			result = subdao.SubInsert(subdata);

			if (result == false) {
				System.out.println("subject 실패");
				return null;
			}
			System.out.println("subject 성공");

			forward.setRedirect(true);
			forward.setPath("./sub_insert.bo");
			return forward;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}