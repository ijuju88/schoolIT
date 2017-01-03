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

		// 사용자에게 폼에서 입력받은 값을 받아 Bean에 저장 뒤 DB를 호출하여 update 구문을 실행한 뒤 학생 페이지로
		// 이동한다.
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
				System.out.println("게시판 수정 실패");
				return null;
			}
			System.out.println("게시판 수정 완료");

			forward.setRedirect(true);
			forward.setPath("./student.fo");
			return forward;
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}