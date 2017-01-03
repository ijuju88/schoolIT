package roti.lms.ad_tch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tch_FrontController extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/tch_AddAction.do")) {
			action = new Tch_AddAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/tch_ModifyAction.do")) {
			action = new Tch_ModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/tch_DeleteAction.do")) {
			action = new Tch_DeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/tch_ListAction.do")) {
			action = new Tch_ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/tch_insert.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./tch_insert.jsp");
		} else if (command.equals("/tch_edit.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./tch_edit.jsp");
		} else if (command.equals("/tch_info.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./tch_info.jsp");
		} else if (command.equals("/tch_mod.do")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./tch_mod.jsp");

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