package roti.lms.ad_reg;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.action.*;
import roti.lms.ad_reg.RegisterDAO;
import roti.lms.ad_reg.RegisterBean;

public class RegisterAddAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");

		RegisterDAO dao = new RegisterDAO();
		RegisterBean bean = new RegisterBean();

		System.out.println("AddAction");
		boolean result = false;
		
		try {
			bean.setRg_id(request.getParameter("rg_id"));
			bean.setSub_no(Integer.parseInt(request.getParameter("sub_no")));
			bean.setRg_start(request.getParameter("rg_start"));
			bean.setRg_end(request.getParameter("rg_end"));
			bean.setClassroom(Integer.parseInt(request.getParameter("classroom")));
			bean.setCharge(Integer.parseInt(request.getParameter("charge")));
			
			result = dao.RegisterInsert(bean);
			if (result == false) {
				System.out.println("음...");
				return null;
			}
			System.out.println("등록됨");

			forward.setRedirect(true);
			forward.setPath("./RegisterListAction.bo");
			return forward;

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}