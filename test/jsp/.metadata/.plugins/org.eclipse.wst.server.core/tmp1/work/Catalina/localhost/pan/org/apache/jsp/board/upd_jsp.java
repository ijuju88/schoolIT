/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.37
 * Generated at: 2016-12-15 00:13:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board.vo.BoardBean;
import board.dao.BoardDao;

public final class upd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("board.dao.BoardDao");
    _jspx_imports_classes.add("board.vo.BoardBean");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");

	request.setCharacterEncoding("UTF-8");

      out.write('\r');
      out.write('\n');

	BoardDao dao = new BoardDao();
	BoardBean vo = new BoardBean();
	int no = Integer.parseInt(request.getParameter("no"));
	int pageno = Integer.parseInt(request.getParameter("pageno"));
	vo = dao.selectBoard(no);

      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<script language=\"JavaScript\" src=\"/pan/board/script.js\"></script>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-2.2.4.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".listtitle {\r\n");
      out.write("\tbackground: #c83cc8;\r\n");
      out.write("\tcolor: white;\r\n");
      out.write("\tfont-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/head.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"updateForm\">\r\n");
      out.write("<div class=\"content\">\r\n");
      out.write("<div id=\"wrap\">\r\n");
      out.write("\t <div class=\"gallery-info\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<h2>Review Update</h2>\r\n");
      out.write("    </div>\r\n");
      out.write("<form name=\"frm\" action=\"/pan/board/BoardServlet?command=board_update\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t<center>\r\n");
      out.write("\t<input type=\"hidden\" id=\"no\" name=\"no\" value=");
      out.print(no);
      out.write("> <input type=\"hidden\" id=\"pageno\" name=\"pageno\" value=");
      out.print(pageno);
      out.write(" />\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t<div class=\"input-group\">\t\r\n");
      out.write("\t\t<span class=\"input-group-addon\" id=\"sizing-addon1\">등록자</span>\r\n");
      out.write("\t\t<input type=\"text\" class=\"form-control\" placeholder=\"username\" aria-describedby=\"sizing-addon1\" name=\"username\" id=\"username\" value=");
      out.print(vo.getUsername());
      out.write(">\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"input-group\">\t\r\n");
      out.write("\t\t<span class=\"input-group-addon\" id=\"sizing-addon2\">비밀번호</span>\r\n");
      out.write("\t\t<input type=\"password\" class=\"form-control\" placeholder=\"password\" aria-describedby=\"sizing-addon2\" name=\"password\" id=\"password\">\r\n");
      out.write("\t</div>\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t<div class=\"input-group\">\t\r\n");
      out.write("\t\t<span class=\"input-group-addon\" id=\"sizing-addon3\">제목\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<select name=\"category\" style=\"width: 150px\">\r\n");
      out.write("\t\t\t<option value=\"00001\">방후기</option>\r\n");
      out.write("\t\t\t<option value=\"00002\">서비스</option>\r\n");
      out.write("\t\t\t<option value=\"00003\">주변</option>\r\n");
      out.write("\t\t\t<option value=\"00004\">기타</option>\r\n");
      out.write("\t\t</select></span>\r\n");
      out.write("\t\t <input type=\"text\" class=\"form-control\" placeholder=\"title\" aria-describedby=\"sizing-addon3\"  name=\"title\" id=\"title\" value=");
      out.print(vo.getTitle());
      out.write(">\r\n");
      out.write("\t\t</div>\t\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t<div class=\"input-group\">\r\n");
      out.write("\t\t\t<span class=\"input-group-addon\" id=\"sizing-addon4\">내용</span>\r\n");
      out.write("\t\t\t<textarea class=\"form-control\" placeholder=\"content\" aria-describedby=\"sizing-addon4\" rows=\"15\" cols=\"75%\" id=\"content\" name=\"content\" wrap=\"virtural\">");
      out.print(vo.getContent());
      out.write("</textarea>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t<div class=\"input-group\">\t\r\n");
      out.write("\t\t\t<span class=\"input-group-addon\" id=\"sizing-addon5\">이미지/설명</span>\r\n");
      out.write("\t\t\t<input type=\"file\" name=\"file_name\"  class=\"form-control\" placeholder=\"file_name\" aria-describedby=\"sizing-addon5\"  value=");
      out.print(vo.getFile_name());
      out.write(" /> \r\n");
      out.write("\t\t\t<input type=\"hidden\" name=\"file_chk\" />\r\n");
      out.write("\t\t</div>\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<input type=\"submit\" onclick=\"return writeSave()\"/>\r\n");
      out.write("\t\t\t<a href=\"/pan/board/BoardServlet?command=board_list\"><input type=\"button\" value=\"취소\"></a>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</center>\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div></div></div>\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/foot.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
