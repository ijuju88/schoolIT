package roti.lms.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.action.Action;
import roti.lms.action.ActionForward;

public class StudentModifyAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward forward = new ActionForward();
		boolean result = false;

		StudentDAO dao = new StudentDAO();
		StudentBean studentdata = new StudentBean();
		CookieBox cookie = new CookieBox(request);

		String st_id = cookie.getValue("st_id");

		// ����ڿ��� ������ �Է¹��� ���� �޾� Bean�� ���� �� DB�� ȣ���Ͽ� update ������ ������ �� �л� ��������
		// �̵��Ѵ�.
		try {
			studentdata.setSt_id(st_id);
			studentdata.setSt_name(request.getParameter("st_name"));
			studentdata.setBirth(Integer.parseInt(request.getParameter("birth")));
			studentdata.setAddr(request.getParameter("addr"));
			studentdata.setSt_hp(request.getParameter("st_hp"));
			studentdata.setSt_ehp(request.getParameter("st_ehp"));
			studentdata.setGender(request.getParameter("gender"));
			studentdata.setRdate(request.getParameter("rdate"));

			result = dao.boardModify(studentdata);
			if (result == false) {
				System.out.println("�Խ��� ���� ����");
				return null;
			}
			System.out.println("�Խ��� ���� �Ϸ�");

			forward.setRedirect(true);
			forward.setPath("./student.fo");
			return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}