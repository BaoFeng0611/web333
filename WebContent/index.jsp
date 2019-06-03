<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>欢迎界面</title>
<style>
#div1 {
	border: 30px solid green;
}
</style>
<script src="http://libs.baidu.com/jquery/1.10.2/jquery.min.js"></script>
<script>
	function showManage() {
		$("#div1").show(1200);
	}
	$(document).ready(function() {
		$("#div1").hide(200);
	});
</script>
</head>
<body>

	<div width="600" align="center" magin-top="100px" id="div1">

		<table width="600" height="300" border="1">
			<caption>
				<font size="6" color="red">欢迎进入蜗牛学院五组组员管理系统</font>
			</caption>
			<tr>
				<th><a href="teamServlet.do?method=list">查看组员信息</a></th>
			</tr>
		</table>
	</div>
	<div width="200" align="center" id="div2">
		<button onclick="showManage()">进入管理系统</button><br>
	</div>
</body>
</html>