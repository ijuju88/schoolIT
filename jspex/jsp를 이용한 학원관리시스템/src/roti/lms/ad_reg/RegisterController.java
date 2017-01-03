package roti.lms.ad_reg;
import roti.lms.action.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController extends javax.servlet.http.HttpServlet
		implements javax.servlet.Servlet {
	protected void doProcess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/actionForward.bo")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./reg_info.jsp");
		} else if (command.equals("/RegisterAddAction.bo")) {
			action = new RegisterAddAction();
			System.out.println("controller Add Controller 실행");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/RegisterModifyAction.bo")) {
			action = new RegisterModifyAction();
			System.out.println(" Modify Controller 실행");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/RegisterDeleteAction.bo")) {
			action = new RegisterDeleteAction();
			System.out.println("Delete Controller 실행");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/RegisterListAction.bo")) {
			action = new RegisterListAction();
			System.out.println("List Controller 실행");
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/DeletePage.bo")) {
			System.out.println("삭제페이지이동");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./reg_delete.jsp");
		} else if (command.equals("/UpdatePage.bo")) {
			System.out.println("수정페이지이동");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./reg_update.jsp");
		} else if (command.equals("/InsertPage.bo")) {
			System.out.println("삽입페이지이동");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./reg_insert.jsp");
		} else if (command.equals("/HomePage.bo")) {
			System.out.println("홈페이지이동");
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./ad_stu.jsp");
		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request
						.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Do Get success");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}