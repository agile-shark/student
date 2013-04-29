<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" type="text/javascript" src="My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript">
		function returnList() {
			window.open("listStudentAction.do","_self");
		}
	</script>
  </head>
  
  <body bgcolor="pink">
  <center>
  	<h1>学生信息添加</h1>
  	<a href="/logout.jsp">【退 &nbsp;出】</a>
  	<hr/>
	  <s:form action="updateStudentAction.do" method="post">
	  	<table border="1" cellpadding="0" cellspacing="0" width="1000px">
	    	<tr align="center" height="36px">
	    	<td>学生姓名</td> <td>学生密码</td> <td>学生性别</td> <td>入学日期</td> </tr>
	    	<tr align="center" height="36px"><td><s:textfield name="student.student_name"/></td> 
	    	<td><s:textfield name="student.student_pwd"/></td> <td><s:textfield name="student.student_sex"/></td> 
	    	<td><s:textfield  class="Wdate" type="text" onClick="WdatePicker()" name="student.student_birthday"/></td> 
	    	</tr>
	    </table>
	    <br/>
	    <input type="submit" value="确认更新"/> &nbsp;&nbsp;&nbsp;<input type="button" value="返 回" onclick="returnList()"/>
	  </s:form>
    </center>
  </body>
</html>
