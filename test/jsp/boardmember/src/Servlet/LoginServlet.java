package Servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import javax.xml.ws.Dispatch;

import dao.DBConnect;
import dto.BoardMemberBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url="member/login.jsp";
		HttpSession session = request.getSession();
		
		if (session.getAttribute("loginUser") != null) {
			url = "main.jsp"; 
		}
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "member/login.jsp";
		String userid = request.getParameter("userid");
		System.out.println(userid);
		String pwd = request.getParameter("pwd");
		DBConnect mDao = DBConnect.getInstance();
		int result = mDao.userCheck(userid, pwd);
		if (result == 1) {
			BoardMemberBean bmb = mDao.getBoardMember(userid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", bmb);
			request.setAttribute("message", "회원 가입에 성공했습니다.");
			url = "main.jsp";
		} else if (result == 0) {
			request.setAttribute("message", "비밀번호가 맞지 않습니다.");
		} else if (result == -1) {
			request.setAttribute("message", "존재하지 않는 회원입니다.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
