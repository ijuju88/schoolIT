package util;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.StringTokenizer;

public class DBCPInit extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		try {
			String drivers = config.getInitParameter("jdbcdriver");
			System.out.println("1.drivers===>"+drivers);
			StringTokenizer st = new StringTokenizer(drivers, ",");
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				System.out.println("2.token===>"+token);
				Class.forName(token);
				System.out.println("3.성공");
			}
		} catch(Exception ex) {
			System.out.println("4.실패");
			throw new ServletException(ex);
			
		}
	}
}
