package roti.lms.ad_tch;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_tchdb.*;

public class Tch_ModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		boolean result = false;

		String num = request.getParameter("tch_no");

		Tch_BoardDAO boarddao = new Tch_BoardDAO();
		Tch_Bean boarddata = new Tch_Bean();

		try {
			boarddata.setTch_no(num);
			boarddata.setTch_pass(request.getParameter("tch_pass"));
			boarddata.setTch_name(request.getParameter("tch_name"));
			boarddata.setAcab(request.getParameter("acab"));
			boarddata.setResp_sub(request.getParameter("resp_sub"));
			boarddata.setTch_hp(request.getParameter("tch_hp"));

			result = boarddao.boardModify(boarddata);
			if (result == false) {
				System.out.println("강사 수정 실패");
				return null;
			}
			System.out.println("강사 수정 완료");

			forward.setRedirect(true);
			forward.setPath("./tch_ListAction.do");
			return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}