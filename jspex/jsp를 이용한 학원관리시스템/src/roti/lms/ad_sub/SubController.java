package roti.lms.ad_sub;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/SubAddAction.ao")) {
			action = new SubAddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/SubModifyAction.ao")) {
			action = new SubModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/SubDeleteAction.ao")) {
			action = new SubDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/SubListAction.ao")) {
			action = new SubListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/sub_insert.ao")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./subject/sub_insert.jsp");
		} else if (command.equals("/sub_edit.ao")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./subject/sub_edit.jsp");
		} else if (command.equals("/sub_list.ao")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./subject/sub_list.jsp");
		} else if (command.equals("/sub_mod.ao")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./subject/sub_mod.jsp");

		}
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}
