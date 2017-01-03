package roti.lms.student;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.action.Action;
import roti.lms.action.ActionForward;

public class StudentAction implements Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		request.setCharacterEncoding("utf-8");
		
		List<?> at_list = new ArrayList<>();
		StudentDAO dao = new StudentDAO();
	   	StudentBean studentdata = new StudentBean();
	   	StudentBean registerdata = new StudentBean();
	   	StudentBean attendancedata = new StudentBean();
	   	CookieBox cookie = new CookieBox(request);
	   	
	   	//쿠키에 저장된 사용자 ID와 과목번호를 불러와서 변수에 저장. 
	   	String st_id = cookie.getValue("st_id");
//	   	String st_pass = cookie.getValue("st_pass");
	   	int sub_no = Integer.parseInt(cookie.getValue("sub_no"));
	   	
	   	//DAO의 객체를 호출한다.
		int at_listcount=dao.getAttCount(st_id);
		at_list = dao.getAttendanceFor(st_id);
	   	studentdata = dao.getStudentList(st_id);
	   	registerdata = dao.getRegisterList(st_id, sub_no);
	   	attendancedata = dao.getAttendanceList(st_id);
	   	
	   	if(studentdata == null){
	   		System.out.println("상세보기 실패");
	   		return null;
	   	}
	   	System.out.println("상세보기 성공");
	   	
	   	request.setAttribute("at_list", at_list);
	   	request.setAttribute("at_listcount", at_listcount);
	   	request.setAttribute("studentdata", studentdata);
	   	request.setAttribute("registerdata", registerdata);
	   	request.setAttribute("attendancedata", attendancedata);
	   	ActionForward forward = new ActionForward();
	   	forward.setRedirect(false);
   		forward.setPath("./student.jsp");
   		return forward;

	 }
}