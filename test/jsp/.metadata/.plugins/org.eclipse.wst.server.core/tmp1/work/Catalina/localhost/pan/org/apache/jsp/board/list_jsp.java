/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.37
 * Generated at: 2016-12-15 00:08:51 UTC
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
import java.util.ArrayList;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/D:/ijuju/test/jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/pan/WEB-INF/lib/jstl-1.2.jar!/META-INF/fmt.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("jar:file:/D:/ijuju/test/jsp/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/pan/WEB-INF/lib/jstl-1.2.jar!/META-INF/c.tld", Long.valueOf(1153352682000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-1.2.jar", Long.valueOf(1478178682000L));
  }

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
    _jspx_imports_classes.add("java.util.ArrayList");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
 request.setCharacterEncoding("UTF-8"); 
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");

	int pageno = request.getParameter("pageno")==null?1:Integer.parseInt(request.getParameter("pageno"));
	String search = request.getParameter("search")==null?"":request.getParameter("search");
	String category = request.getParameter("category")==null?"all":request.getParameter("category");
	BoardDao dao = new BoardDao();
	System.out.println("category : " + request.getParameter("category"));
	ArrayList<BoardBean> list = dao.selectBoard(search, category, pageno);
	
	dao = new BoardDao();
	int listsize = dao.cntTotalBoard(category, search);
	
	int totalPage = 0; 
	
	if((listsize % 10) == 0){
		totalPage=(listsize/10);
		 }else{
			 totalPage=(listsize/10 + 1);
		 }
	

      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-2.2.4.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"/pan/board/css/notice.css\">\r\n");
      out.write("<script>\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#wirte\").click(function() {\r\n");
      out.write("\t\t\tlocation.href=\"/pan/board/BoardServlet?command=board_write_form\";\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$(\"#se\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\tvar url = \"/pan/board/BoardServlet?command=board_list&category=\";\r\n");
      out.write("\t\t\tvar category=$(\"#category option:selected\").val();\r\n");
      out.write("\t\t\tvar url2=\"&search=\";\r\n");
      out.write("\t\t\tvar Str=$(\"#search\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tlocation.href=url+category+url2+Str;\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t $(\"#category\").change(function() {\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tvar url = \"/pan/board/BoardServlet?command=board_list&category=\";\r\n");
      out.write("\t\t\tvar category=$(\"#category option:selected\").val();\r\n");
      out.write("\t\t\tvar url2=\"&search=\";\r\n");
      out.write("\t\t\tvar Str=$(\"#search\").val();\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tlocation.href=url+category+url2+Str;\r\n");
      out.write("\t\t}); \r\n");
      out.write("\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("    </head>\r\n");
      out.write("  <body>  \r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/head.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"content\" id=\"content\">\r\n");
      out.write("\t\t<div class=\"boradlist\">\r\n");
      out.write("\t\t<div class=\"bs-docs-example\">\r\n");
      out.write("\t\t<div id=\"wrap\" align=\"center\">\r\n");
      out.write("\t\t\r\n");
      out.write("    <div class=\"gallery-info\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<h2>Review</h2>\r\n");
      out.write("    </div>\r\n");
      out.write("\t\r\n");
      out.write("    <br>\r\n");
      out.write("\t<p>&nbsp;</p>\r\n");
      out.write("<!-- <form name=\"frm\" action=\"/pan/BoardServlet?command=board_list\" method=\"get\" >  -->\r\n");
      out.write(" <table border=\"1\"  class=\"list\" id=\"board\" style=\"width: 80%;\">  \r\n");
      out.write("\t \r\n");
      out.write("\t\t<thead><tr style=\"font-size: 20px\">\r\n");
      out.write("\t\t\t<td align=\"right\" colspan=\"6\">\r\n");
      out.write("\t\t\t검색 : <input type=\"text\" name=\"search\" id=\"search\" value=");
      out.print(search);
      out.write("><a href=\"#\" id=\"se\"><input type=\"button\" value=\"검색\"></a>\r\n");
      out.write("\t\t\t\t<select name=\"category\" id=\"category\">\r\n");
      out.write("\t\t\t\t\t<option value=\"all\" ");
if("all".equals(category)){
      out.write(" selected");
}
      out.write(">전체</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"00001\" ");
if("00001".equals(category)){
      out.write(" selected");
}
      out.write(">방후기</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"00002\" ");
if("00002".equals(category)){
      out.write(" selected");
}
      out.write(">서비스</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"00003\" ");
if("00003".equals(category)){
      out.write(" selected");
}
      out.write(">주변</option>\r\n");
      out.write("\t\t\t\t\t<option value=\"00004\" ");
if("00004".equals(category)){
      out.write(" selected");
}
      out.write(">기타</option>\r\n");
      out.write("\t\t\t\t</select>\t\t\t\r\n");
      out.write("\t\t\t\t \t<a href=\"#\" id=\"wirte\"><img src=\"\\pan\\board\\img\\btn_write.gif\" height=\"20px\"></a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr></thead>\r\n");
      out.write("\t\t<thead><tr class=\"list\">\r\n");
      out.write("\t\t\t<th width=\"6%\" style=\"text-align: center;\">번호</th>\r\n");
      out.write("\t\t\t<th width=\"10%\" style=\"text-align: center;\">구분</th>\r\n");
      out.write("\t\t\t<th width=\"34%\" style=\"text-align: center;\">내용</th>\r\n");
      out.write("\t\t\t<th width=\"14%\" style=\"text-align: center;\">작성자</th>\r\n");
      out.write("\t\t\t<th width=\"12%\" style=\"text-align: center;\">작성일</th>\r\n");
      out.write("\t\t\t<th width=\"12%\" style=\"text-align: center;\">조회수</th>\r\n");
      out.write("\t\t</tr></thead>\t\t\r\n");
      out.write("\t\t");

		if(list.size() > 0){
			for(int i=0; i<list.size(); i++){
				BoardBean vo = list.get(i);	
			
      out.write("\r\n");
      out.write("\t\t\t<tbody><tr style=\"font-size: 15px\">\r\n");
      out.write("\t\t\t\t<td>");
      out.print(vo.getNo() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
 
						if("00001".equals(vo.getCategory())){
							out.println("방후기");
						}else if("00002".equals(vo.getCategory())){
							out.println("서비스");
						}else if("00003".equals(vo.getCategory())){
							out.println("주변");
						}else if("00004".equals(vo.getCategory())){
							out.println("기타");
						}
					
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t<td><a href=\"javascript:location.href=('/pan/board/BoardServlet?command=board_view&no=");
      out.print(vo.getNo());
      out.write("&pageno=");
      out.print(pageno);
      out.write("');\">");
      out.print(vo.getTitle() );
      out.write("</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t");
 if(vo.getHit()>=20){
      out.write("\r\n");
      out.write("             <img src=\"\\pan\\board\\img\\btn.gif\">\r\n");
}
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(vo.getUsername() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(vo.getTime() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t");
      out.write("\r\n");
      out.write("\t\t\t\t<td>");
      out.print(vo.getHit() );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr></tbody><tbody>\r\n");

			}
		}else{
			out.println("<td colspan=6>해당게시판에 글이 없습니다.</td>");
		}
		
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"7\" style=\"font-size: 15px\" align=\"center\">\r\n");
      out.write("\t\t\t\t<a href=\"/pan/board/BoardServlet?command=board_list&pageno=1\">[처음]</a>\r\n");
      out.write("\t\t\t\t");

					if(totalPage <= 10){
						for(int i=1; i<=totalPage; i++){
				
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t<a href=\"/pan/board/BoardServlet?command=board_list&pageno=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(i);
      out.write("]</a>\r\n");
      out.write("\t\t\t\t");

						}
					}else{
						if(pageno >= 6){
							for(int i=pageno-5; i<pageno+5; i++){
								if(i == totalPage+1) break;
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/pan/board/BoardServlet?command=board_list&pageno=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(i);
      out.write("]</a>\r\n");
      out.write("\t\t\t\t\t\t\t");

							}
						}else{
							for(int i=1; i<=10; i++){
							
      out.write("\r\n");
      out.write("\t\t\t\t\t\t\t\t<a href=\"/pan/board/BoardServlet?command=board_list&pageno=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.write('[');
      out.print(i);
      out.write("]</a>\r\n");
      out.write("        ");

							}			
						}
					}
				
      out.write("\r\n");
      out.write("\t\t\t\t<a href=\"/pan/board/BoardServlet?command=board_list&pageno=");
      out.print(totalPage);
      out.write("\">[마지막]</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr></tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</div></div></div></div>\r\n");
      out.write("\t  ");
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
