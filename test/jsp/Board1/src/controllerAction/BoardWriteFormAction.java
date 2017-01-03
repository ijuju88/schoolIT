package controllerAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.BoardDao;
import dto.BoardVo;

/**
 * Servlet implementation class BoardWriteAction
 */
@WebServlet("/BoardWriteFormAction")
public class BoardWriteFormAction extends HttpServlet implements Action {
	private static final long serialVersionUID = 1L;

	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardWrite.jsp";


		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
