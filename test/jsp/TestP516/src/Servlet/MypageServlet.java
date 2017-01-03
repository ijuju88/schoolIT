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


@WebServlet("/mypage.do")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public MypageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		JoinBean emp=(JoinBean) session.getAttribute("loginUser");	
		if(emp != null){
			String url="mypage.jsp";
		
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}else{
			response.sendRedirect("login.do");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	
		System.out.println(request.getParameter("name"));
		HttpSession session = request.getSession();	
		JoinBean jb = new JoinBean();
		jb.setId(request.getParameter("id"));
		jb.setPass(request.getParameter("pwd"));
		jb.setName(request.getParameter("name"));
		
		if(request.getParameter("gender")!=null)
			jb.setGender(Integer.parseInt(request.getParameter("gender").trim()));
		
		jb.setPhone(request.getParameter("phone"));
		jb.setAddress(request.getParameter("Address"));
		jb.setLev(request.getParameter("lev"));	
		
		JoinDAO eDao = JoinDAO.getInstance();
		eDao.updateJB(jb);
		
		JoinBean emp = eDao.getJB(jb.getId());
		
		request.setAttribute("jb", emp);
		request.setAttribute("message", "수정완료");
				
		session.setAttribute("loginUser", emp);
		
		System.out.println(emp);
		
		int result = eDao.userCheck(jb.getId(), 
				jb.getPass(), jb.getLev());
		session.setAttribute("result", result);
		
		String url="joinsuccess.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);		
	}
}

