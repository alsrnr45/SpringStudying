/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.64
 * Generated at: 2021-06-04 01:45:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1621908604124L));
    _jspx_dependants.put("jar:file:/C:/spring-workspace/ajaxProject/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<!-- jQuery 라이브러리 -->\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<h1> Spring에서의 ajax 사용법</h1>\r\n");
      out.write("\t\r\n");
      out.write("\t<h3> 1. 요청시 두개의 값 전달 후 응답 결과 받아보기</h3>\r\n");
      out.write("\t이름 : <input type=\"text\" id=\"name\"> <br>\r\n");
      out.write("\t나이 : <input type=\"number\" id=\"age\"> <br>\r\n");
      out.write("\t<button id=\"btn1\">전송</button>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"result1\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\t$(function(){\r\n");
      out.write("\t\t\t/*\r\n");
      out.write("\t\t\t#btn1이 동적으로 만들어진 요소일때는 $(id).click(function(){}) 또는 $(id).on(\"click\", function(){}) 이런 이벤트 안먹힘\r\n");
      out.write("\t\t\t즉, 직접 해당 id출력하여 이벤트 하면 이벤트 안됨\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t$(\"#btn1\").click(function(){\t\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t\tor\r\n");
      out.write("\t\t\t$(\"#btn1\").on(\"click\", function(){})\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t*/\r\n");
      out.write("\t\t\t$(document).on(\"click\", \"#btn1\", function(){ // 해당 요소가 동적으로 만들어진 요소라면 다음과 같은 방식으로 이벤트 연결해야됨\r\n");
      out.write("\t\t\t\t//console.log(\"클릭됨\");\r\n");
      out.write("\t\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\turl:\"ajax1.do\",\r\n");
      out.write("\t\t\t\t\tdata:{\r\n");
      out.write("\t\t\t\t\t\tname:$(\"#name\").val(),\r\n");
      out.write("\t\t\t\t\t\tage:$(\"#age\").val()\r\n");
      out.write("\t\t\t\t\t},\r\n");
      out.write("\t\t\t\t\ttype:\"post\",\r\n");
      out.write("\t\t\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\t\t\t$(\"#result1\").html(data);\r\n");
      out.write("\t\t\t\t\t}, error:function(){\r\n");
      out.write("\t\t\t\t\t\tconsole.log(\"ajax 통신 실패!\");\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t})\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t<h3> 2. 조회된 한 회원 객체를 응답받아서 출력해보기 </h3>\r\n");
      out.write("\t조회활 회원 번호 : <input type=\"number\" id=\"userNo\">\r\n");
      out.write("\t<button onclick=\"ajaxTest2();\">조회</button>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"result2\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction ajaxTest2(){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"ajax2.do\",\r\n");
      out.write("\t\t\t\tdata:{userNo:$(\"#userNo\").val()},\r\n");
      out.write("\t\t\t\tsuccess:function(obj){\r\n");
      out.write("\t\t\t\t\t// console.log(obj);\r\n");
      out.write("\t\t\t\t\tvar value = \"<ul>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<li>이름 : \" + obj.userName + \"</li>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<li>나이 : \" + obj.age + \"</li>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"<li>아이디 : \" + obj.userId + \"</li>\"\r\n");
      out.write("\t\t\t\t\t\t\t\t+ \"</ul>\";\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(\"#result2\").html(value);\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t}, error:function(){\r\n");
      out.write("\t\t\t\t\tconsole.log(\"ajax 통신 실패\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("\t\r\n");
      out.write("\t<h3> 3. 조회된 회원들의 리스트 응답받기 </h3>\r\n");
      out.write("\t<button onclick=\"ajaxTest3();\">회원 전체 조회</button>\r\n");
      out.write("\t\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t<table border=\"1\" id=\"tableList\">\r\n");
      out.write("\t\t<thead>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>아이디</th>\r\n");
      out.write("\t\t\t\t<th>이름</th>\r\n");
      out.write("\t\t\t\t<th>나이</th>\r\n");
      out.write("\t\t\t\t<th>이메일</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</thead>\r\n");
      out.write("\t\t<tbody>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</tbody>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\t\tfunction ajaxTest3(){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl:\"ajax3.do\",\r\n");
      out.write("\t\t\t\tsuccess:function(list){\r\n");
      out.write("\t\t\t\t\t// 배열로 받아왔으니 배열에서 하나하나 빼옵시당\r\n");
      out.write("\t\t\t\t\tvar value= \"\";\r\n");
      out.write("\t\t\t\t\tfor(var i in list){\r\n");
      out.write("\t\t\t\t\t\tvalue += \"<tr>\"\r\n");
      out.write("\t\t\t\t\t\t         + \"<td>\" + list[i].userId + \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t         + \"<td>\" + list[i].userName + \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t         + \"<td>\" + list[i].age + \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t         + \"<td>\" + list[i].email + \"</td>\"\r\n");
      out.write("\t\t\t\t\t\t         + \"</tr>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t$(\"#tableList tbody\").html(value);\r\n");
      out.write("\t\t\t\t}, error:function(){\r\n");
      out.write("\t\t\t\t\tconsole.log(\"ajax톻신 실패\");\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
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
