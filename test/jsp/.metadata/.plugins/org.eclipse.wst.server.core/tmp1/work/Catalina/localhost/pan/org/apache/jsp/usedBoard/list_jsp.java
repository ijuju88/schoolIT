/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.37
 * Generated at: 2016-12-15 00:09:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.usedBoard;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import board.BoardDB;
import board.BoardDataBean;
import java.util.List;
import java.text.SimpleDateFormat;

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
    _jspx_imports_classes.add("board.BoardDB");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.text.SimpleDateFormat");
    _jspx_imports_classes.add("board.BoardDataBean");
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
      out.write("\r\n");
      out.write("\r\n");

    int pageSize = 10;  // 한 페이지에 나타낼 글 수
    SimpleDateFormat sdf =
    new SimpleDateFormat("yyyy-MM-dd HH:mm");

      out.write("\r\n");
      out.write("\r\n");

    String pageNum = request.getParameter("pageNum");
    if (pageNum == null) {//페이지 번호가 인수로 넘어오지 않으면 1을 기억
        pageNum = "1";
    }

    int currentPage = Integer.parseInt(pageNum);
    int startRow = (currentPage - 1) * pageSize + 1;  //그 페이지의 시작행 지정
    // 2페이지의 경우
    // (2-1)*10 + 1 = 11
    int endRow = currentPage * pageSize; // 그 페이지의 끝행 지정
    // 2페이지의 경우
    //  2+10 = 20
    int count = 0;    // 전체 글 수
    int number=0;   // 그 페이지에서 시작행 번호

    List articleList = null;
    BoardDB dbPro = BoardDB.getInstance();
    count = dbPro.getArticleCount();
    if (count > 0) {
    //    articleList = dbPro.getArticles(startRow, pageSize);
        articleList = dbPro.getArticles(startRow, endRow);
    }

    number=count-(currentPage-1)*pageSize;//그 페이지에서 시작 행 번호
    // 전체 52개의 글인 경우 2페이지 시작 행 번호
    //    52 - (2-1)*10 = 42

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<title>게시판</title>\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-2.2.4.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function() {\r\n");
      out.write("\t$(\"#search\").click(function() {\r\n");
      out.write("\t\tvar url = \"../usedBoard/searchList.jsp?flag=search&gubun=\";\r\n");
      out.write("\t\tvar Gubun=$(\"#gubun option:selected\").val();\r\n");
      out.write("\t\tvar url2=\"&sstring=\";\r\n");
      out.write("\t\tvar Str=$(\"#sstring\").val();\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tlocation.href=(url+Gubun+url2+Str);\r\n");
      out.write("\t});\r\n");
      out.write("\r\n");
      out.write("});\r\n");
      out.write("</script>     \r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("<body>\r\n");
      out.write("  ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/head.jsp", out, false);
      out.write("\r\n");
      out.write("<div class=\"content\" id=\"content\">\r\n");
      out.write("\t\t<div class=\"userboradlist\">\r\n");
      out.write("\t\t<div class=\"bs-docs-example\">\r\n");
      out.write("\t\t<div class=\"gallery-info\" align=\"center\">\r\n");
      out.write("\t\t\t\t\t<h2>Question</h2>\r\n");
      out.write("    </div>\r\n");
      out.write("    <hr>\r\n");

    if (count == 0) {  // 등록된 글이 없는 경우

      out.write("\r\n");
      out.write("\t<center>\r\n");
      out.write("    <table border=\"1\"  class=\"list\" id=\"board\" style=\"width: 80%;\">\r\n");
      out.write("\r\n");
      out.write("        <thead><tr>\r\n");
      out.write("            <td align=\"center\">\r\n");
      out.write("                게시판에 저장된 글이 없습니다.\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr></thead>\r\n");
      out.write("    </table>\r\n");
      out.write("    </center>\r\n");
  } else {     // 등록된 글이 있는 경우
      out.write(" \r\n");
      out.write("<center>\r\n");
      out.write("    <table border=\"1\"  class=\"list\" id=\"board\" style=\"width: 80%;\">  \r\n");
      out.write("\t\t<thead>\r\n");
      out.write("        <tr height=\"30\" bgcolor=\"black\">\r\n");
      out.write("            <td align=\"center\"  width=\"25\" ><font color=\"white\" face=\"HY나무M\" size=\"3\">번 호</font></td>\r\n");
      out.write("            <td align=\"center\"  width=\"250\" ><font color=\"white\" face=\"HY나무M\" size=\"3\">제   목</font></td>\r\n");
      out.write("            <td align=\"center\"  width=\"100\" ><font color=\"white\" face=\"HY나무M\" size=\"3\">작성자</font></td>\r\n");
      out.write("            <td align=\"center\"  width=\"150\" ><font color=\"white\" face=\"HY나무M\" size=\"3\">작성일</font></td>\r\n");
      out.write("            <td align=\"center\"  width=\"50\" ><font color=\"white\" face=\"HY나무M\" size=\"3\">조 회</font></td>\r\n");
      out.write("           \r\n");
      out.write("        </tr></thead>\r\n");
 
    for (int i = 0 ; i < articleList.size() ; i++) {
        BoardDataBean article = (BoardDataBean)articleList.get(i);

      out.write("\r\n");
      out.write("        <tbody><tr height=\"30\">\r\n");
      out.write("            <td align=\"center\"  width=\"50\">");
      out.print(number--);
      out.write("</td>\r\n");
      out.write("            <td  width=\"250\" >\r\n");

    int wid=0;  // 들여쓰기 설정(레벨에 따라)
    if(article.getRe_level()>0){
        wid=5*(article.getRe_level());

      out.write("\r\n");
      out.write("      ");
      out.write("\r\n");
      out.write("        <img src=\"../usedBoard/img/ioc-reply.gif\">\r\n");
}else{
      out.write("\r\n");
      out.write("       ");
      out.write('\r');
      out.write('\n');
}
      out.write("  \r\n");
      out.write("    <a href=\"javascript:location.href=('../usedBoard/content.jsp?num=");
      out.print(article.getNum());
      out.write("&pageNum=");
      out.print(currentPage);
      out.write("&sstring=");
      out.print(article.getSubject());
      out.write("');\">");
      out.print(article.getSubject());
      out.write("</a>\r\n");
 if(article.getReadcount()>=20){
      out.write("\r\n");
      out.write("        <img src=\"../usedBoard/img/11.bmp\" border=\"0\"  height=\"16\">");
}
      out.write(" </td>\r\n");
      out.write("            <td align=\"center\"  width=\"100\">\r\n");
      out.write("            <!-- Gmail로 설정 http://fantaziulo.blog.me/150188563111 -->\r\n");
      out.write("            <a href=\"mailto:");
      out.print(article.getEmail());
      out.write("?Subject=Hello%20again\" target=\"_blank\">");
      out.print(article.getWriter());
      out.write("</a></td>\r\n");
      out.write("            <td align=\"center\"  width=\"150\">");
      out.print( sdf.format(article.getReg_date()));
      out.write("</td>\r\n");
      out.write("            <td align=\"center\"  width=\"50\">");
      out.print(article.getReadcount());
      out.write("</td>\r\n");
      out.write("        </tr></tbody>\r\n");
}
      out.write("\r\n");
      out.write("\t</table></center>\r\n");
}
      out.write("\r\n");
      out.write("<input type=\"hidden\" name=\"flag\" value=\"search\">\r\n");
      out.write("<center>\r\n");
      out.write("<table class=\"table\" bordercolor=\"#ffffff\" cellspacing=\"0\" style=\"width: 80%;\"><tr>\r\n");
      out.write("<td align=\"center\" ><select name=\"gubun\" id=\"gubun\">\r\n");
      out.write("    <option value=\"subject\"> 제    목</option>\r\n");
      out.write("    <option value=\"content\">내    용</option>\r\n");
      out.write("    <option value=\"writer\">작성자</option>\r\n");
      out.write("</select>\r\n");
      out.write("<input type=\"text\" name=\"sstring\" id=\"sstring\" size=15>  \r\n");
      out.write("<a href=\"#\" id=\"search\">\r\n");
      out.write("<input type=\"image\" src=\"../usedBoard/img/btn_search.gif\">\r\n");
      out.write("</a></td>\r\n");
      out.write("<td>\r\n");
      out.write("<ul class=\"pagination pagination-sm\">\r\n");



    if (count > 0) {  // 등록된 글이 있는 경우
    int pageCount = count / pageSize + ( count % pageSize == 0 ? 0 : 1);
    // 총페이지 수 계산
    //  5 + 1 = 6(등록된 글이 52개인 경우)
    // 5 + 0 = 5 (등록된 글이 50개인 경우)     
    int startPage = (int)(currentPage/10)*10+1;
    int pageBlock=10;
    // 시작 페이지 번호
    // (int)15/10 * 10 + 1= 11(15페이지의 경우)
    int endPage = startPage + pageBlock-1;
    //
    if (endPage > pageCount) endPage = pageCount;

        if (startPage > 10) {    
      out.write("\r\n");
      out.write("        <li class=\"disabled\">\r\n");
      out.write("            <a href=\"javascript:location.href='list.jsp?pageNum=");
      out.print( startPage - 10 );
      out.write("';\">\r\n");
      out.write("            <i class=\"fa fa-angle-left\">\r\n");
      out.write("            [이전]</i></a></li>\r\n");
      }
        for (int i = startPage ; i <= endPage ; i++) {  
      out.write("\r\n");
      out.write("        <li class=\"active\"><a href=\"javascript:location.href='../usedBoard/list.jsp?pageNum=");
      out.print( i );
      out.write("';\">\r\n");
      out.write("           [");
      out.print( i );
      out.write("]</a>\r\n");
      out.write("            </li>\r\n");

        }
        if (endPage < pageCount) {  
      out.write("\r\n");
      out.write("        <li><a href=\"javascript:location.href='../usedBoard/list.jsp?pageNum=");
      out.print( startPage + 10 );
      out.write("';\" >\r\n");
      out.write("            <i class=\"fa fa-angle-right\">\r\n");
      out.write("            [다음]</i></a></li>\r\n");
      out.write("\r\n");

        }
    }

      out.write("\r\n");
      out.write("</ul>\r\n");
      out.write("</td>\r\n");
      out.write("<td><a href=\"javascript:location.href='../usedBoard/wirteForm.jsp';\">\r\n");
      out.write("<img src=\"..\\usedBoard\\img\\btn_write.gif\" border=\"0\"></a></td>\r\n");
      out.write("</tr></table></center></div></div></div>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/foot.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
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
