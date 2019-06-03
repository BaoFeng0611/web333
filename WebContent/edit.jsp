<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="teamServlet.do?method=edit" method="post">
			<input type="hidden" name="uid" value="${t.uid }" />
		<table align="center" width="800" height="600" border="1">
			<tr>
				<td>uname:<input type="text" name="uname" value="${t.uname }" /></td>
			</tr>
			<tr>
				<td>age:<input type="text" name="age" value="${t.age }" /></td>
			</tr>
			<tr>
				<td>money:<input type="text" name="money" value="${t.money }" /></td>
			</tr>
			<tr>
				<th><button>提交</button></th>
			</tr>

		</table>
	</form>
</body>
</html>