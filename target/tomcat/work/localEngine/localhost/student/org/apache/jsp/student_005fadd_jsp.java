package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;

public final class student_005fadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

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
      response.setContentType("text/html;charset=utf-8");
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

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <base href=\"");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("    \r\n");
      out.write("    <title>学生列表</title>\r\n");
      out.write("    \r\n");
      out.write("\t<meta http-equiv=\"pragma\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"cache-control\" content=\"no-cache\">\r\n");
      out.write("\t<meta http-equiv=\"expires\" content=\"0\">    \r\n");
      out.write("\t<meta http-equiv=\"keywords\" content=\"keyword1,keyword2,keyword3\">\r\n");
      out.write("\t<meta http-equiv=\"description\" content=\"This is my page\">\r\n");
      out.write("\r\n");
      out.write("\t<script language=\"javascript\" type=\"text/javascript\" src=\"My97DatePicker/WdatePicker.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction returnList() {\r\n");
      out.write("\t\t\twindow.open(\"listStudentAction.do\",\"_self\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("  </head>\r\n");
      out.write("  \r\n");
      out.write("  <body bgcolor=\"pink\">\r\n");
      out.write("  <center>\r\n");
      out.write("  \t<h1>学生信息添加</h1>\r\n");
      out.write("  \t<a href=\"/logout.jsp\">【退 &nbsp;出】</a>\r\n");
      out.write("  \t<hr/>\r\n");
      out.write("  <form action=\"addStudentAction.do\" method=\"post\">\r\n");
      out.write("  <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"1000px\">\r\n");
      out.write("    \t<tr align=\"center\" height=\"36px\"><td>学生姓名</td> <td>学生密码</td> <td>学生性别</td> <td>入学日期</td> </tr>\r\n");
      out.write("    \t<tr align=\"center\" height=\"36px\">\r\n");
      out.write("    \t<td><input type=\"text\" name=\"student.student_name\"/></td> \r\n");
      out.write("    \t<td><input type=\"text\" name=\"student.student_pwd\"/></td> \r\n");
      out.write("    \t<td><input type=\"text\" name=\"student.student_sex\"/></td> \r\n");
      out.write("    \t<td><input class=\"Wdate\" type=\"text\" onClick=\"WdatePicker()\" name=\"student.student_birthday\" /></td> \r\n");
      out.write("    \t</tr>\r\n");
      out.write("    </table>\r\n");
      out.write("    <br/>\r\n");
      out.write("    <input type=\"submit\" value=\"提 交\"/> &nbsp;&nbsp;&nbsp;<input type=\"button\" value=\"返 回\" onclick=\"returnList()\"/>\r\n");
      out.write("    </form>\r\n");
      out.write("   </center>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
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
