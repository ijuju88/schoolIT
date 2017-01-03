/* JDK version : JDK1.70_51
 날짜 : 2014년 05월 21일 
 핵심구문 : if,try~catch
 기능: JSP에서 입력 받은 값을 DB에 넣어주는 기능 */
package roti.lms.ad_stu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import roti.lms.ad_stu.db.StudentBean;
import roti.lms.ad_stu.db.StudentDAO;






public class StudentAddAction implements Action {
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 request.setCharacterEncoding("utf-8");
        StudentDAO studentdao = new StudentDAO();
        StudentBean studentdata = new StudentBean();
		 ActionForward forward=new ActionForward();
//		 String member_id=request.getParameter("st_id");

   		
   		boolean result=false;
   		//boolean usercheck=studentdao.isStudentWriter(request.getParameter("st_id"));
//		 boolean usercheck=studentdao.isStudentWriter(member_id, request.getParameter("st_id"));
//		 if(usercheck!=false){
//		   		response.setContentType("text/html;charset=utf-8");
//		   		PrintWriter out=response.getWriter();
//		   		out.println("<script>");
//		   		out.println("alert('중복된 아이디가 있습니다.');");
//		   		out.println("location.href='./StudentWrite.bo';");
//		   		out.println("</script>");
//		   		out.close();
//		   		return null;
//		 }
//		 else if(usercheck==false){
//		   		response.setContentType("text/html;charset=utf-8");
//		   		PrintWriter out=response.getWriter();
//		   		out.println("<script>");
//		   		out.println("alert('사용 가능한 아이디 입니다.');");
//		   		out.println("location.href='./StudentWrite.bo';");
//		   		out.println("</script>");
//		   		out.close();
//		   		return null;
//		}
   		try{
   			request.setCharacterEncoding("utf-8");
//jsp페이지에서 입력 받은 값을 Bean 변수에 넣어줌
   			studentdata.setSt_id(request.getParameter("st_id"));;
   			studentdata.setSt_pass(request.getParameter("st_pass"));
   			studentdata.setSt_name(request.getParameter("st_name"));
   			studentdata.setBirth(Integer.parseInt(request.getParameter("birth")));
   			studentdata.setAddr(request.getParameter("addr"));
   			studentdata.setSt_hp(request.getParameter("st_hp"));
   			studentdata.setSt_ehp(request.getParameter("st_ehp"));
   			studentdata.setGender(request.getParameter("gender"));
   			studentdata.setRdate(request.getParameter("rdate"));

   			
 		//studentdao.studentInsert메서드의 쿼리문 실행 하여 boolean 값을 받아옴
	   		result=studentdao.studentInsert(studentdata);
	   		
	   		if(result==false){
	   			System.out.println("학생 등록 실패");
	   			forward.setRedirect(false);
	   			forward.setPath("./inCheck.eo");
	   			return forward;
	   		}
	   		System.out.println("학생 등록 완료");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./StudentList.eo");
	   		return forward;
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
  		return null;
	}  	
}