<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form>
      <table width="800"  align="center" border="1">
      <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>年龄</td>
        <td>金额</td>
        <td>编辑</td>
        <td>删除</td>
      </tr>
       <c:forEach var="team"  items="${list }" varStatus="i">
      <tr>
        <td>${team.uid}</td>
        <td>${team.uname}</td>
        <td>${team.age}</td>
        <td>${team.money}</td>
        <td><a href="teamServlet.do?method=findOne&uid=${team.uid}">编辑</a></td>
        <td><a href="teamServlet.do?method=delete&uid=${team.uid}">删除</a></td>
      </tr>
      </c:forEach>
      <tr><th colspan="7"><a href="add.jsp">添加</a></th></tr>
      </table>
   </form>

</body>
</html>