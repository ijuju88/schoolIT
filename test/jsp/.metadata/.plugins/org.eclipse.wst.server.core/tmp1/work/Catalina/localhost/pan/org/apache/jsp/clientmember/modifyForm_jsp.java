/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.37
 * Generated at: 2016-12-15 01:03:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.clientmember;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clientmember.*;

public final class modifyForm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_packages.add("clientmember");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<link href=\"../Main/css/bootstrap.css\" rel=\"stylesheet\" type=\"text/css\"\r\n");
      out.write("\tmedia=\"all\">\r\n");
      out.write("\t\r\n");
      out.write("<script src=\"https://code.jquery.com/jquery-2.2.4.js\"></script>\r\n");
      out.write("<script language=\"JavaScript\" src=\"../clientmember/MemberJoin.js\"></script>\r\n");
      out.write("<script src=\"http://dmaps.daum.net/map_js_init/postcode.v2.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write(" function openDaumPostcode() {\r\n");
      out.write("\t   new daum.Postcode({\r\n");
      out.write("\t\t   oncomplete: function(data) {\r\n");
      out.write("          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.\r\n");
      out.write("          // 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.\r\n");
      out.write("          document.getElementById('zip').value = data.postcode1+\"-\"+data.postcode2;\r\n");
      out.write("          document.getElementById('addr1').value = data.address;\r\n");
      out.write("\r\n");
      out.write("          //전체 주소에서 연결 번지 및 ()로 묶여 있는 부가정보를 제거하고자 할 경우,\r\n");
      out.write("          //아래와 같은 정규식을 사용해도 된다. 정규식은 개발자의 목적에 맞게 수정해서 사용 가능하다.\r\n");
      out.write("          //var addr = data.address.replace(/(\\s|^)\\(.+\\)$|\\S+~\\S+/g, '');\r\n");
      out.write("          //document.getElementById('addr').value = addr;\r\n");
      out.write("\r\n");
      out.write("          document.getElementById('addr2').focus();\r\n");
      out.write("      }\r\n");
      out.write("  }).open();\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\tfunction checkIt(userinput) {\r\n");
      out.write("\t\tif (document.getElementById(\"passwd\").value == \"\") {\r\n");
      out.write("\t\t\talert(\"비밀번호를 입력하세요\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\r\n");
      out.write("\t\tif (document.getElementById(\"name\").value == \"\") {\r\n");
      out.write("\t\t\talert(\"사용자 이름을 입력하세요\");\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t//alert(document.getElementById(\"email\").value);\r\n");
      out.write("\t\tvar str = document.getElementById(\"email\").value;\r\n");
      out.write("\t\tvar regEmail = /([\\w-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([\\w-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$/;\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif (userinput.email.value == \"\"){\r\n");
      out.write("\t\t\talert('이메일주소를 입력 해 주세요');\r\n");
      out.write("\t\t\tdocument.getElementById(\"email\").focus();\r\n");
      out.write("            return false;\r\n");
      out.write("\t\t} else if(regEmail.test(str)==false) {\r\n");
      out.write("            alert('이메일 주소가 유효하지 않습니다');\r\n");
      out.write("            document.getElementById(\"email\").focus();\r\n");
      out.write("            return false;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");

	String id = (String) session.getAttribute("memId");
	LogonDB manager = LogonDB.getInstance();
	LogonDataBean c = manager.getMember(id);

	try {

      out.write("\r\n");
      out.write("<body><!--header-->\r\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/head.jsp", out, false);
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"content\" id=\"content\">\r\n");
      out.write("\t\t<div class=\"membermodify\">\r\n");
      out.write("\t\t\t<div class=\"container\">\r\n");
      out.write("\t<form method=\"post\" action=\"modifyPro.jsp\" name=\"userinput\"\r\n");
      out.write("\t\tonsubmit=\"return checkIt(userinput)\">\r\n");
      out.write("\t\t<table width=\"600\" border=\"1\" cellspacing=\"0\" cellpadding=\"3\"\r\n");
      out.write("\t\t\talign=\"center\" bordercolor=\"#FFC8FF\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" height=\"39\" align=\"center\"><b>회원정보수정</b></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" align=\"center\">회원의 정보를 수정합니다.</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" bgcolor=\"#FFC8FF\" class=\"f1\">아이디입력</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"f1\">사용자ID</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(c.getId());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"f1\">비밀번호</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"password\"  id=\"passwd\" name=\"passwd\" size=\"10\"\r\n");
      out.write("\t\t\t\t\tmaxlength=\"10\" value=\"");
      out.print(c.getPasswd());
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" bgcolor=\"#FFC8FF\" class=\"f1\">개인정보 입력</td>\r\n");
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"f1\">사용자 이름</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"name\" name=\"name\" size=\"12\" maxlength=\"12\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(c.getName());
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"f1\">주민등록번호</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(c.getJumin1());
      out.write('-');
      out.print(c.getJumin2());
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"f1\">E-Mail</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" id=\"email\"  name=\"email\" size=\"40\" maxlength=\"30\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(c.getEmail());
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"f1\">이메일 수신여부</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"radio\" name=\"recv_yn\" value=\"y\"\r\n");
      out.write("\t\t\t\t\t");
if (c.getRecv_yn().equals("y")) {
      out.write(" checked ");
}
      out.write(">예 <input\r\n");
      out.write("\t\t\t\t\ttype=\"radio\" name=\"recv_yn\" value=\"n\"\r\n");
      out.write("\t\t\t\t\t");
if (c.getRecv_yn().equals("n")) {
      out.write(" checked ");
}
      out.write(">아니오\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"f1\">전화번호</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");

						if (c.getPhone1() == null) {
					
      out.write(" <input type=\"text\" name=\"phone1\" size=\"4\" maxlength=\"4\">-\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"phone2\" size=\"4\" maxlength=\"4\">- <input\r\n");
      out.write("\t\t\t\t\ttype=\"text\" name=\"phone3\" size=\"4\" maxlength=\"4\"> ");

 	} else {
 
      out.write(" <input type=\"text\" name=\"phone1\" size=\"4\" maxlength=\"4\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(c.getPhone1());
      out.write("\">- <input type=\"text\"\r\n");
      out.write("\t\t\t\t\tname=\"phone2\" size=\"4\" maxlength=\"4\" value=\"");
      out.print(c.getPhone2());
      out.write("\">-\r\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"phone3\" size=\"4\" maxlength=\"4\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(c.getPhone3());
      out.write('"');
      out.write('>');
      out.write(' ');

 	}
 
      out.write("\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td class=\"f1\">휴대전화</td>\r\n");
      out.write("\t\t\t\t<td><input type=\"text\" name=\"cell1\" size=\"4\" maxlength=\"4\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(c.getCell1());
      out.write("\">- <input type=\"text\" name=\"cell2\"\r\n");
      out.write("\t\t\t\t\tsize=\"4\" maxlength=\"4\" value=\"");
      out.print(c.getCell2());
      out.write("\">- <input\r\n");
      out.write("\t\t\t\t\ttype=\"text\" name=\"cell3\" size=\"4\" maxlength=\"4\"\r\n");
      out.write("\t\t\t\t\tvalue=\"");
      out.print(c.getCell3());
      out.write("\"></td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td align=\"left\" class=\"f1\">주소</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t");

						if (c.getAddr1() == null) {
					
      out.write(" <input type=\"text\" id=\"zip\" name=\"zip\"> <input\r\n");
      out.write("\t\t\t\t\ttype=\"button\" name=\"btnzip\" value=\"우편번호찾기\" class=\"f2\"\r\n");
      out.write("\t\t\t\t\tonClick=\"openDaumPostcode()\">\r\n");
      out.write("\t\t\t\t\t<p /> <input type=\"text\" id=\"addr1\" name=\"addr1\"\r\n");
      out.write("\t\t\t\t\tstyle=\"width: 300px\"> <input type=\"text\" id=\"addr2\"\r\n");
      out.write("\t\t\t\t\tname=\"addr2\" style=\"width: 150px\"> ");

 	} else {
 
      out.write(" <input type=\"text\" id=\"zip\" name=\"zip\" value=\"");
      out.print(c.getZip());
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<input type=\"button\" name=\"btnzip\" value=\"우편번호찾기\" class=\"f2\"\r\n");
      out.write("\t\t\t\t\tonClick=\"openDaumPostcode()\">\r\n");
      out.write("\t\t\t\t\t<p />\r\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" id=\"addr1\" name=\"addr1\" style=\"width: 300px\"\r\n");
      out.write("\t\t\t\t\t\t\tvalue=\"");
      out.print(c.getAddr1());
      out.write("\"> <input type=\"text\" id=\"addr2\"\r\n");
      out.write("\t\t\t\t\t\t\tname=\"addr2\" style=\"width: 150px\" value=\"");
      out.print(c.getAddr2());
      out.write("\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t");

					}
				
      out.write("\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td colspan=\"2\" align=\"center\"><input type=\"submit\"\r\n");
      out.write("\t\t\t\t\tname=\"modify\" value=\"수 정\" class=\"f2\">&nbsp;&nbsp; <input\r\n");
      out.write("\t\t\t\t\ttype=\"button\" value=\"취 소\"\r\n");
      out.write("\t\t\t\t\tonClick=\"javascript:window.location='../Main/centerMain.jsp'\"\r\n");
      out.write("\t\t\t\t\tclass=\"f2\">&nbsp;&nbsp; <input type=\"button\" value=\"회원탈퇴\"\r\n");
      out.write("\t\t\t\t\tonClick=\"javascript:window.location='deleteForm.jsp'\" class=\"f2\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</form></div></div></div>\r\n");
      out.write("\r\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/foot.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");

	} catch (Exception e) {
	}

      out.write("\r\n");
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
