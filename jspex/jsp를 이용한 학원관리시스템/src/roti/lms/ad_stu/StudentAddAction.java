/* JDK version : JDK1.70_51
 ��¥ : 2014�� 05�� 21�� 
 �ٽɱ��� : if,try~catch
 ���: JSP���� �Է� ���� ���� DB�� �־��ִ� ��� */
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
//		   		out.println("alert('�ߺ��� ���̵� �ֽ��ϴ�.');");
//		   		out.println("location.href='./StudentWrite.bo';");
//		   		out.println("</script>");
//		   		out.close();
//		   		return null;
//		 }
//		 else if(usercheck==false){
//		   		response.setContentType("text/html;charset=utf-8");
//		   		PrintWriter out=response.getWriter();
//		   		out.println("<script>");
//		   		out.println("alert('��� ������ ���̵� �Դϴ�.');");
//		   		out.println("location.href='./StudentWrite.bo';");
//		   		out.println("</script>");
//		   		out.close();
//		   		return null;
//		}
   		try{
   			request.setCharacterEncoding("utf-8");
//jsp���������� �Է� ���� ���� Bean ������ �־���
   			studentdata.setSt_id(request.getParameter("st_id"));;
   			studentdata.setSt_pass(request.getParameter("st_pass"));
   			studentdata.setSt_name(request.getParameter("st_name"));
   			studentdata.setBirth(Integer.parseInt(request.getParameter("birth")));
   			studentdata.setAddr(request.getParameter("addr"));
   			studentdata.setSt_hp(request.getParameter("st_hp"));
   			studentdata.setSt_ehp(request.getParameter("st_ehp"));
   			studentdata.setGender(request.getParameter("gender"));
   			studentdata.setRdate(request.getParameter("rdate"));

   			
 		//studentdao.studentInsert�޼����� ������ ���� �Ͽ� boolean ���� �޾ƿ�
	   		result=studentdao.studentInsert(studentdata);
	   		
	   		if(result==false){
	   			System.out.println("�л� ��� ����");
	   			forward.setRedirect(false);
	   			forward.setPath("./inCheck.eo");
	   			return forward;
	   		}
	   		System.out.println("�л� ��� �Ϸ�");
	   		
	   		forward.setRedirect(true);
	   		forward.setPath("./StudentList.eo");
	   		return forward;
	   		
  		}catch(Exception ex){
   			ex.printStackTrace();
   		}
  		return null;
	}  	
}