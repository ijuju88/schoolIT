package add;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/EL/AddServlet")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1=20;
		int num2=10;
		int add=num1+num2;
		
		request.setAttribute("num1", num1);
		request.setAttribute("num2", num2);
		request.setAttribute("add", add);
		
		/* 위에 @WebServlet("/EL/AddServlet") 로 설정하였기 때문에
		 * getRequestDispatcher("/EL/testRequest.jsp");을 하지 않고 바고 접근가능함
		 * */
		RequestDispatcher dispatcher=request.getRequestDispatcher("testRequest.jsp");
		dispatcher.forward(request, response);
	}


}
