<%@ page language="java" contentType="text/html; charset=utf-8" 
pageEncoding="utf-8"%>
<html>
<head>
<title>用户登录的界面</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript">
	function countdown(){
			var count = document.getElementById("count");
			count.innerHTML-=1;
		}
</script>

</head>
  <body bgcolor="pink" onload="window.setInterval('countdown()','1000')">
  <center>
  <h1>用户注销</h1>
  <hr/>
   <%
      session.invalidate();
 	  response.setHeader("refresh","3;url=index.jsp");
    %>
    <h3>您已注销 <font color="red"><b><label id="count">3</label> </b></font> 秒后回到登录界面</h3>
    <h3>如果没有跳转请点击 <a href="index.jsp">这里</a></h3>
    </center>
</body>
</html>
