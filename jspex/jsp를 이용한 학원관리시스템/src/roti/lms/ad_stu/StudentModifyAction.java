/* JDK version : JDK1.70_51
 날짜 : 2014년 05월 21일 
 핵심구문 : if,try~catch
 기능: JSP에서 입력 받은 값을 DB에 수정 하는 기능 */
package roti.lms.ad_stu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_stu.db.StudentBean;
import roti.lms.ad_stu.db.StudentDAO;

 public class StudentModifyAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) 
	 	throws Exception{
		 request.setCharacterEncoding("utf-8");
		 ActionForward forward = new ActionForward();
		 boolean result = false;
		 //request.getParameter("st_id");
//		 String member_id=request.getParameter("st_id");
		 StudentDAO studentdao = new StudentDAO();
		 StudentBean studentdata = new StudentBean();


//		 boolean usercheck=studentdao.isStudentWriter(member_id, request.getParameter("st_id"));
//		 //boolean usercheck=studentdao.isStudentWriter(request.getParameter("st_id"));
//		 if(usercheck==false){
//		   		response.setContentType("text/html;charset=utf-8");
//		   		PrintWriter out=response.getWriter();
//		   		out.println("<script>");
//		   		out.println("alert('수정할 아이디가 없습니다.');");
//		   		out.println("location.href='./StudentModify.bo';");
//		   		out.println("</script>");
//		   		out.close();
//		   		return null;
//		 }
//		 
		 try{
			 studentdata.setSt_id(request.getParameter("st_id"));
			 studentdata.setSt_pass(request.getParameter("st_pass"));
			 studentdata.setSt_name(request.getParameter("st_name"));
			 studentdata.setBirth(Integer.parseInt(request.getParameter("birth")));
			 studentdata.setAddr(request.getParameter("addr"));
			 studentdata.setSt_hp(request.getParameter("st_hp"));
			 studentdata.setSt_ehp(request.getParameter("st_ehp"));
			 studentdata.setGender(request.getParameter("gender"));
			 studentdata.setRdate(request.getParameter("rdate"));
	 
			 result = studentdao.studentModify(studentdata);
			 if(result==false){
		   		System.out.println("게시판 수정 실패");
	   			forward.setRedirect(false);
	   			forward.setPath("./editCheck.eo");
	   			return forward;
		   	 }
		   	 System.out.println("게시판 수정 완료");
		   	 
		   	 forward.setRedirect(true);
		   	 forward.setPath("./StudentList.eo");

		   	 return forward;
	   	 }catch(Exception ex){
	   			ex.printStackTrace();	 
		 }
		 
		 return null;
	 }
}