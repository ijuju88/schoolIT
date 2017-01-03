/* JDK version : JDK1.70_51
 날짜 : 2014년 05월 21일 
 핵심구문 : if,try~catch
 기능: JSP에서 입력 받은 ID를 삭제 하는 기능 */
package roti.lms.ad_stu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_stu.db.StudentDAO;

public class StudentDeleteAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
	   	boolean result=false;
	   	//boolean usercheck=false;
	  
	   	//String member_id=request.getParameter("st_id");
	 	//request.getParameter("st_id");	
	   	StudentDAO studentdao = new StudentDAO();
	   	
	   	//usercheck=studentdao.isStudentWriter(member_id, request.getParameter("st_id"));
	   	//usercheck=studentdao.isStudentWriter(request.getParameter("st_id"));
	   	
//	   	if(usercheck==false){
//	   		response.setContentType("text/html;charset=utf-8");
//	   		PrintWriter out=response.getWriter();
//	   		out.println("<script>");
//	   		out.println("alert('삭제할 ID가 없습니다.');");
//	   		out.println("location.href='./StudentList.bo';");
//	   		out.println("</script>");
//	   		out.close();
//	   		return null;
//	   	}
	   	//받아온 String 값으로 studentDelete메소드를 실행 하여 쿼리문 실행 
	   	result=studentdao.studentDelete(request.getParameter("st_id"));
	   	//result=studentdao.studentDelete(member_id);
	   	if(result==false){
	   		System.out.println("게시판 삭제 실패");
   			forward.setRedirect(false);
   			forward.setPath("./editCheck.eo");
   			return forward;
	   	}
	   	
	   	System.out.println("회원 삭제 성공");
	   	forward.setRedirect(true);
   		forward.setPath("./StudentList.eo");
   		return forward;
	 }
}