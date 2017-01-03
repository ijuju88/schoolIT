package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DBConnect;
import dto.BoardMemberBean;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class MemberUpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid=request.getParameter("userid");
		DBConnect mDao = DBConnect.getInstance();
		
		BoardMemberBean bmb=mDao.getBoardMember(userid);
		request.setAttribute("bmb", bmb);
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("member/Update.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String admin = request.getParameter("admin");
		BoardMemberBean bmb = new BoardMemberBean();
		bmb.setUserid(userid);
		bmb.setPwd(pwd);
		bmb.setEmail(email);
		bmb.setPhone(phone);
		bmb.setAdmin(Integer.parseInt(admin));
		DBConnect mDao = DBConnect.getInstance();
		int result = mDao.updateMember(bmb);
		response.sendRedirect("login.do");
	}

}
