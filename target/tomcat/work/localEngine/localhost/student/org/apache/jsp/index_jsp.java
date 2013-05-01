package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.sql.*;
import java.sql.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/include/header.jsp");
    _jspx_dependants.add("/include/footer.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			"", true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n");
      out.write("<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\r\n");
      out.write("<link href=\"/css/styles.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<!--[if IE 6]><link href=\"css/ie6.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" /><![endif]-->\r\n");
      out.write("<!--[if IE 7]><link href=\"css/ie7.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" /><![endif]-->\r\n");
      out.write("<!--[if IE 8]><link href=\"css/ie8.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" /><![endif]-->\r\n");
      out.write("<!--[if IE 9]><link href=\"css/ie9.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\" /><![endif]-->\r\n");
      out.write("<script src=\"js/jquery-1.4.2.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<title>学生登录</title>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function login() {\r\n");
      out.write("\tvar uid=$('#id01').val();\r\n");
      out.write("\tvar pwd=$('#id02').val();\r\n");
      out.write("\tif(uid==null||uid==''){\r\n");
      out.write("\t\talert('请输入用户名.');\r\n");
      out.write("\t}else if(pwd==null||pwd==''){\r\n");
      out.write("\t\talert('请输入密码.');\r\n");
      out.write("\t}else{\r\n");
      out.write("\t\t$('#loginForm').submit();\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<!--header-->\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t<h1><a href=\"/html/main.jsp\">Korea Software Park in Changchun jingyue</a><span><img src=\"/img/layout/tit_header.gif\" alt=\"企业管理\" /></span></h1>\r\n");
      out.write("\t<p class=\"logout\"><span>Hello,管理员！</span><a href=\"/html/login.jsp\"><img src=\"/img/layout/Logout_header.gif\" alt=\"Logout\" /></a></p>\r\n");
      out.write("</div>\r\n");
      out.write("<!--//header-->");
      out.write("\r\n");
      out.write("<div id=\"container\" class=\"bgnone\">\r\n");
      out.write("\t<div id=\"mid\" class=\"group\">\r\n");
      out.write("\t\t<div class=\"loginbox\">\r\n");
      out.write("\t\t\t<form id=\"loginForm\" action=\"loginStudentAction.do\" method=\"post\">\r\n");
      out.write("\t\t\t\t<fieldset>\r\n");
      out.write("\t\t\t\t\t<legend>Login</legend>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt><label for=\"id01\"> SID</label> </dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"text\" name=\"uid\" id=\"id01\" class=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t\t<dl>\r\n");
      out.write("\t\t\t\t\t\t<dt> <label for=\"id02\"> SPW</label> </dt>\r\n");
      out.write("\t\t\t\t\t\t<dd>\r\n");
      out.write("\t\t\t\t\t\t\t<input type=\"password\" name=\"pwd\" id=\"id02\" class=\"text\" />\r\n");
      out.write("\t\t\t\t\t\t</dd>\r\n");
      out.write("\t\t\t\t\t</dl>\r\n");
      out.write("\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t</form>\r\n");
      out.write("\t\t\t<p><a href=\"#this\" onclick=\"login()\"><img src=\"img/btn/btn_login.gif\" alt=\"\" /></a></p>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--footer-->\r\n");
      out.write("<div id=\"footer\"><a href=\"#this\"><img src=\"/img/layout/footer.gif\" alt=\"Copyright © 2011. CCKSP. All Rights Reserved\" /></a></div>\r\n");
      out.write("<!--//footer-->");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
