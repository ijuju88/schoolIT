package roti.lms.ad_tch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_tchdb.Tch_Bean;
import roti.lms.ad_tchdb.Tch_BoardDAO;
import roti.lms.ad_tch.Action;
import roti.lms.ad_tch.ActionForward;

public class Tch_AddAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Tch_BoardDAO Tchdao = new Tch_BoardDAO();
		Tch_Bean Tchdata = new Tch_Bean();
		ActionForward forward = new ActionForward();

		request.setCharacterEncoding("utf-8");

		boolean result = false;

		try {
			Tchdata.setTch_no(request.getParameter("tch_no"));
			Tchdata.setTch_pass(request.getParameter("tch_pass"));
			Tchdata.setTch_name(request.getParameter("tch_name"));
			Tchdata.setAcab(request.getParameter("acab"));
			Tchdata.setResp_sub(request.getParameter("resp_sub"));
			Tchdata.setTch_hp(request.getParameter("tch_hp"));
			result = Tchdao.boardInsert(Tchdata);

			if (result == false) {
				System.out.println("강사 등록 실패");
				return null;
			}
			System.out.println("강사 등록 완료");

			forward.setRedirect(true);
			forward.setPath("./tch_ListAction.do");
			return forward;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}