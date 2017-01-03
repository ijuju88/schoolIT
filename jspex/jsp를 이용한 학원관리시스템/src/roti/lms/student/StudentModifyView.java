package roti.lms.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.action.Action;
import roti.lms.action.ActionForward;

public class StudentModifyView implements Action {

	// 회원 정보를 수정할때 기존의 정보를 보여주기 위해 student 테이블을 호출한 뒤 
	// student_update.jsp 페이지로 이동한다. 
	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");

		StudentDAO dao = new StudentDAO();
		StudentBean studentdata = new StudentBean();
		CookieBox cookie = new CookieBox(request);

		String st_id = cookie.getValue("st_id");

		studentdata = dao.getStudentList(st_id);

		if (studentdata == null) {
			System.out.println("상세보기 실패");
			return null;
		}
		System.out.println("상세보기 성공");

		request.setAttribute("studentdata", studentdata);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./student_update.jsp");
		return forward;
	}

}
