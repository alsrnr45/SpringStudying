/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.64
 * Generated at: 2021-06-03 05:52:47 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.member;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class memberEnrollForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar", Long.valueOf(1621908604124L));
    _jspx_dependants.put("jar:file:/C:/spring-workspace/springProject/src/main/webapp/WEB-INF/lib/taglibs-standard-impl-1.2.5.jar!/META-INF/c.tld", Long.valueOf(1425946270000L));
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
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP?????? ?????? GET, POST ?????? HEAD ??????????????? ???????????????. Jasper??? OPTIONS ????????? ?????? ???????????????.");
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
      out.write("<head>    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>Document</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css\">\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("    .content{\r\n");
      out.write("        background-color:rgb(247, 245, 245);\r\n");
      out.write("        width:80%;\r\n");
      out.write("        margin:auto;\r\n");
      out.write("    }\r\n");
      out.write("    .innerOuter{\r\n");
      out.write("        border:1px solid lightgray;\r\n");
      out.write("        width:80%;\r\n");
      out.write("        margin:auto;\r\n");
      out.write("        padding:5% 15%;\r\n");
      out.write("        background:white;\r\n");
      out.write("    }\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <!-- ????????? ????????? ?????? ????????? -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/header.jsp", out, false);
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"content\">\r\n");
      out.write("        <br><br>\r\n");
      out.write("        <div class=\"innerOuter\">\r\n");
      out.write("            <h2>????????????</h2>\r\n");
      out.write("            <br>\r\n");
      out.write("\r\n");
      out.write("            <form action=\"insert.me\" method=\"post\" id=\"enrollForm\">\r\n");
      out.write("                <div class=\"form-group\">\r\n");
      out.write("                    <label for=\"userId\">* ID :</label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"userId\" name=\"userId\" placeholder=\"Please Enter ID\" required><br>\r\n");
      out.write("                    <div id=\"checkResult\" style=\"display:none; font-size:0.8em;\"></div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"userPwd\">* Password :</label>\r\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"userPwd\" name=\"userPwd\" placeholder=\"Please Enter Password\" required><br>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"checkPwd\">* Password Check :</label>\r\n");
      out.write("                    <input type=\"password\" class=\"form-control\" id=\"checkPwd\" placeholder=\"Please Enter Password\" required><br>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"userName\">* Name :</label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"userName\" name=\"userName\" placeholder=\"Please Enter Name\" required><br>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"email\"> &nbsp; Email :</label>\r\n");
      out.write("                    <input type=\"email\" class=\"form-control\" id=\"email\" name=\"email\" placeholder=\"Please Enter Email\"><br>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"age\"> &nbsp; Age :</label>\r\n");
      out.write("                    <input type=\"number\" class=\"form-control\" id=\"age\" name=\"age\" placeholder=\"Please Enter Age\"><br>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"phone\"> &nbsp; Phone :</label>\r\n");
      out.write("                    <input type=\"tel\" class=\"form-control\" id=\"phone\" name=\"phone\" placeholder=\"Please Enter Phone (-??????)\"><br>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"address\"> &nbsp; Address :</label>\r\n");
      out.write("                    <input type=\"text\" class=\"form-control\" id=\"address\" name=\"address\" placeholder=\"Please Enter Address\"><br>\r\n");
      out.write("                    \r\n");
      out.write("                    <label for=\"\"> &nbsp; Gender : </label> &nbsp;&nbsp;\r\n");
      out.write("                    <input type=\"radio\" name=\"gender\" id=\"Male\" value=\"M\">\r\n");
      out.write("                    <label for=\"Male\">??????</label> &nbsp;&nbsp;\r\n");
      out.write("                    <input type=\"radio\" name=\"gender\" id=\"Female\" value=\"F\">\r\n");
      out.write("                    <label for=\"Female\">??????</label><br>\r\n");
      out.write("                    \r\n");
      out.write("                </div>\r\n");
      out.write("                <br>\r\n");
      out.write("                <div class=\"btns\" align=\"center\">\r\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\" id=\"enrollBtn\" disabled>????????????</button>\r\n");
      out.write("                    <button type=\"reset\" class=\"btn btn-danger\"> ?????????</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br><br>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <script>\r\n");
      out.write("    \t$(function(){\r\n");
      out.write("    \t\tvar $idInput = $(\"#enrollForm input[name=userId]\");\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t\t$idInput.keyup(function(){\r\n");
      out.write("    \t\t\t// ?????? ?????? 5?????? ???????????? ?????????????????? ajax ???????????? ???????????? ?????????\r\n");
      out.write("    \t\t\tif($idInput.val().length >=5){\r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("    \t\t\t\t$.ajax({\r\n");
      out.write("    \t\t\t\t\turl:\"idCheck.me\",\r\n");
      out.write("    \t\t\t\t\tdata:{checkId:$idInput.val()},\r\n");
      out.write("    \t\t\t\t\tsuccess:function(result){\r\n");
      out.write("    \t\t\t\t\t\tif(result == \"N\"){ // ????????????\r\n");
      out.write("    \t\t\t\t\t\t\t// ????????? ????????? ??????, ?????? ????????????\r\n");
      out.write("    \t\t\t\t\t\t\t$(\"#checkResult\").show();\r\n");
      out.write("    \t\t\t\t\t\t\t$(\"#checkResult\").css(\"color\",\"red\").text(\"????????? ???????????? ???????????????. ?????? ??????????????????.\");\r\n");
      out.write("    \t\t\t\t\t\t\t$(\"#enrollBtn\").attr(\"disabled\", true);\r\n");
      out.write("    \t\t\t\t\t\t} else{ // ????????????\r\n");
      out.write("    \t\t\t\t\t\t\t$(\"#checkResult\").show();\r\n");
      out.write("    \t\t\t\t\t\t\t$(\"#checkResult\").css(\"color\",\"green\").text(\"??????????????? ??????????????????\");\r\n");
      out.write("    \t\t\t\t\t\t\t$(\"#enrollBtn\").removeAttr(\"disabled\");\r\n");
      out.write("    \t\t\t\t\t\t}\r\n");
      out.write("    \t\t\t\t\t}, error:function(){\r\n");
      out.write("    \t\t\t\t\t\tconosole.log(\"????????? ???????????? ajax ?????? ??????\");\r\n");
      out.write("    \t\t\t\t\t}\r\n");
      out.write("    \t\t\t\t\t\r\n");
      out.write("    \t\t\t\t})\r\n");
      out.write("    \t\t\t\t\r\n");
      out.write("    \t\t\t} else{ // ???????????? 5?????? ??????????????? => ???????????? ?????? ???????????? ????????? ???\r\n");
      out.write("    \t\t\t\t$(\"#enrollBtn\").attr(\"disabled\", true);\r\n");
      out.write("    \t\t\t\t$(\"#checkResult\").hide();\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t\t\r\n");
      out.write("    \t\t})\r\n");
      out.write("    \t\t\r\n");
      out.write("    \t})\r\n");
      out.write("    </script>\r\n");
      out.write("\r\n");
      out.write("    <!-- ????????? ????????? ??????????????? -->\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "../common/footer.jsp", out, false);
      out.write("\r\n");
      out.write("    \r\n");
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
