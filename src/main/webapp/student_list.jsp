<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="pg" uri="/WEB-INF/pager-taglib.tld" %>
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
	<script src="jquery-1.4.2.min.js" type="text/javascript"></script>
<script>
$(function(){
	$("#allCheck").change(function(){
		var flag = $(this).attr("checked");
		$('body input[type="checkbox"]').each(function () {
            $(this).attr('checked',flag)})
	});
})
</script>
  </head>
  
  <body bgcolor="pink">
  <center>
  	<h1>学生信息列表</h1>
  	<a href="/logout.jsp">【退 &nbsp;出】</a>
  	<hr/>
  
  
	  <%
		cn.edu.ccdx.student.util.Pager pager=(cn.edu.ccdx.student.util.Pager)request.getAttribute("pager");
	  %>
	<pg:pager items="<%=pager.getItems() %>" maxPageItems="<%=pager.getMaxPageItems() %>"
							  maxIndexPages="<%=pager.getMaxIndexPages() %>" isOffset="true"
	                                      index="center" url="listStudentAction.do" 
							  export="offset, currentPageNumber=pageNumber" scope="request">
	<%
		int number = pager.getItems().intValue()-(currentPageNumber-1)*pager.getMaxPageItems().intValue();
	%>
 <form action="deleteAllStudentAction.do" method="post">
  <table border="1" cellpadding="0" cellspacing="0" width="1000px">
   	<tr align="center" height="36px"><td><input type="checkbox" id="allCheck" /></td><td>学生顺序</td> <td>学生姓名</td> <td>学生密码</td> <td>学生性别</td> <td>入学日期</td> <td>操  作</td></tr>
   	<s:iterator value="#request.list">
   	<tr align="center" height="36px"><td><input type="checkbox" name="ids"  value="<s:property value="student_id"/>" /></td><td><%=number-- %></td> <td><s:property value="student_name"/></td> <td><s:property value="student_pwd"/></td> <td><s:property value="student_sex"/></td> <td><s:property value="student_birthday"/></td> 
   	<td>
   	<a href="deleteStudentAction.do?id=<s:property value="student_id"/>"  onclick="return window.confirm('是否真的要删除该用户!')">删除
   	</a> &nbsp;<a href="toUpdateStudentAction.do?id=<s:property value="student_id"/>">更新</a></td></tr>
   	</s:iterator>
   </table>
  </form>
  <pg:first>
	<a href="<s:property value="#attr.pageUrl"/>" id="firstP"><img src="/img/btn/btn01_paging.gif" alt="" /></a>
	</pg:first>
	<pg:skip pages="<%= -1 %>" ifnull="true">
	<s:if test="#attr.pageUrl==null">
	<a href="#this" id="beforeP"><img src="/img/btn/btn02_paging.gif" alt="" /></a>
	</s:if>
	<s:else>
	<a href="<s:property value="#attr.pageUrl"/>" id="beforeP"><img src="/img/btn/btn02_paging.gif" alt="" /></a>
	</s:else>
	</pg:skip>	
	<pg:pages>	
	 <s:if test="#attr.pageNumber==#attr.currentPageNumber">
	<strong><s:property value="#attr.pageNumber"/></strong>
	</s:if>
	<s:else>
	<a href="<s:property value="#attr.pageUrl"/>" id="<s:property value="#attr.pageNumber"/>"><s:property value="#attr.pageNumber"/></a>
	</s:else>
	</pg:pages>
	<pg:skip pages="<%= 1 %>" ifnull="true">
	  <s:if test="#attr.pageUrl==null">
		<a href="#this" id="nextP"><img src="/img/btn/btn03_paging.gif" alt="" /></a>
	  </s:if>
	<s:else>	
		<a href="<s:property value="#attr.pageUrl"/>" id="nextP"><img src="/img/btn/btn03_paging.gif" alt="" /></a>
	</s:else>
	</pg:skip>															
	<pg:last>	
		<a href="<s:property value="#attr.pageUrl"/>" id="lastP"><img src="/img/btn/btn04_paging.gif" alt="" /></a>
	</pg:last>
  </pg:pager>
    <a href="student_add.jsp">添加</a> &nbsp;&nbsp;&nbsp;<a href="javascript:document.forms[0].submit();"  onclick="return window.confirm('是否真的要删除此商品!')">删除</a>
    </center>
  </body>
</html>
