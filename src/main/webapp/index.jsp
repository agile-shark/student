<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/styles.css" rel="stylesheet" type="text/css" />
<!--[if IE 6]><link href="css/ie6.css" rel="stylesheet" type="text/css" media="all" /><![endif]-->
<!--[if IE 7]><link href="css/ie7.css" rel="stylesheet" type="text/css" media="all" /><![endif]-->
<!--[if IE 8]><link href="css/ie8.css" rel="stylesheet" type="text/css" media="all" /><![endif]-->
<!--[if IE 9]><link href="css/ie9.css" rel="stylesheet" type="text/css" media="all" /><![endif]-->
<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>

<title>学生登录</title>

<script type="text/javascript">
function login() {
	var uid=$('#id01').val();
	var pwd=$('#id02').val();
	if(uid==null||uid==''){
		alert('请输入用户名.');
	}else if(pwd==null||pwd==''){
		alert('请输入密码.');
	}else{
		$('#loginForm').submit();
	}
}
</script>

</head>
<body>
<%@ include file="/include/header.jsp" %>
<div id="container" class="bgnone">
	<div id="mid" class="group">
		<div class="loginbox">
			<form id="loginForm" action="loginStudentAction.do" method="post">
				<fieldset>
					<legend>Login</legend>
					<dl>
						<dt><label for="id01"> SID</label> </dt>
						<dd>
							<input type="text" name="uid" id="id01" class="text" />
						</dd>
					</dl>
					<dl>
						<dt> <label for="id02"> SPW</label> </dt>
						<dd>
							<input type="password" name="pwd" id="id02" class="text" />
						</dd>
					</dl>
				</fieldset>
			</form>
			<p><a href="#this" onclick="login()"><img src="img/btn/btn_login.gif" alt="" /></a></p>
		</div>
	</div>
</div>
<%@ include file="/include/footer.jsp" %>
</body>
</html>