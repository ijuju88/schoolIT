/* JDK version : JDK1.70_51
 날짜 : 2014년 05월 21일 
 핵심기술 : doGet,doPost방식 사용(HttpServletRequest,HttpServletResponse)
 핵심구문 : if,else if,try~catch
 기능: 입력 받은 경로로 모든 페이지간 이동 되도록 Servlet생성  */

package roti.lms.ad_stu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class StudentFrontController 
 	extends javax.servlet.http.HttpServlet 
 	implements javax.servlet.Servlet {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) 
	 	throws ServletException, IOException {
		 String RequestURI=request.getRequestURI();
		 String contextPath=request.getContextPath();
		 String command=RequestURI.substring(contextPath.length());
		 ActionForward forward=null;
		 Action action=null;
//if , else if문의 조건을 통해 ActionForward를 사용 하여 만든 forward객체로 각 페이지로 이동	
		if(command.equals("/StudentWrite.eo")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./student/stu_insert.jsp");
		}else if(command.equals("/StudentModify.eo")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./student/stu_edit.jsp");
		}else if(command.equals("/StudentAddAction.eo")){
			action  = new StudentAddAction();
			try {
				forward=action.execute(request, response );
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/StudentModifyAction.eo")){
			action = new StudentModifyAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/StudentDeleteAction.eo")){
			action = new StudentDeleteAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/StudentList.eo")){
			action = new StudentListAction();
			try{
				forward=action.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if (command.equals("/inCheck.eo")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./student/idCheck2.jsp");
		}else if (command.equals("/editCheck.eo")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./student/editCheck2.jsp");
		}
		if(forward != null){
		if(forward.isRedirect()){
			response.sendRedirect(forward.getPath());
		}else{
			RequestDispatcher dispatcher=
				request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
		}
	 }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}	  	 
}