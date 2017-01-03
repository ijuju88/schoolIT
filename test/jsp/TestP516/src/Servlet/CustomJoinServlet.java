package Servlet;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.JoinDAO;
import DVO.JoinBean;


@WebServlet("/custom.do")
public class CustomJoinServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		JoinBean emp=(JoinBean) session.getAttribute("loginUser");
		Integer result=(Integer) session.getAttribute("result");
		if(emp != null && result==2){
			String url = "customjoin.jsp";
			
			RequestDispatcher rd = request.getRequestDispatcher(url);
			rd.forward(request, response);
		}else{
			response.sendRedirect("login.do");
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setCharacterEncoding("UTF-8");
		JoinBean jb = new JoinBean();
		jb.setId(request.getParameter("id"));
		jb.setPass(request.getParameter("pwd"));
		jb.setName(request.getParameter("name"));	
		jb.setGender(Integer.parseInt(request.getParameter("gender")));
		jb.setPhone(request.getParameter("phone"));
		jb.setAddress(request.getParameter("Address"));
		jb.setLev(request.getParameter("lev"));	
		
		JoinDAO jbDAO = JoinDAO.getInstance();
		jbDAO.insertJB(jb);
		
		request.setAttribute("jb", jb);
		request.setAttribute("message", "가입");
		String url = "joinsuccess.jsp";		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
