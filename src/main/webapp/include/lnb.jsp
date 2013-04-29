<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!--left-->
<script type="text/javascript">
function openview2() {
	window.open ("/html/popup/listScheduledAction.do", "newwindow", "width=720, height=600, toolbar=no, menubar=no, scrollbars=yes, resizable=no, location=no, status=no")
}
</script>
<div id="left">
	<ul>
		<li class="a01_left"><a href="/html/admin/listAdminAction.do"></a></li>
		<li class="a02_left"><a href="/html/com/listCallMarketAction.do?clear=1"></a></li>
		<li class="a03_left"><a href="/html/call/listCallMarketContactAction.do?clear=1""></a></li>
		<li class="a04_left"><a href="/html/callsta/listStatisticsAction.do"></a></li>
		<li class="a05_left"><a href="/html/calladm/que_calladm_list.jsp"></a></li>
		<li class="a06_left"><a href="/html/questa/que_questa_main.jsp"></a></li>
		<li class="a07_left"><a href="#this" onclick="openview2()"></a></li>
	</ul>
</div>
<!--//left-->