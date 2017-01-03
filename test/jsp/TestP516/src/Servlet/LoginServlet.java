package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import DAO.JoinDAO;
import DVO.JoinBean;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String lev = request.getParameter("lev");
		String url=null;
		
		JoinDAO empDAO = JoinDAO.getInstance();
		int result = empDAO.userCheck(id, pwd, lev);

		if(result == 2 || result == 3){
			JoinBean emp = new JoinBean();
			emp = empDAO.getJB(id);
			
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", emp);			
			session.setAttribute("result", result);			
			url = "main.jsp";				
		}else{
			url = "login.jsp";
			if(result == 1){
				request.setAttribute("message", "회원가입성공");
			}else if(result == 0){			
				request.setAttribute("message", "비번 안맞음");
			}else{			
				request.setAttribute("message", "존재하지 않습니다");
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
