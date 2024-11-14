<%@ page import="common.JDBCconect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
</head>
<body>
	<h2>JDBC 테스트 1</h2>
	<%
	JDBCconect jdbc1 = new JDBCconect();
	jdbc1.close();
	%>
	
	<h2>JDBC 테스트 2</h2>
	<%
	String driver = application.getInitParameter("MySqlDriver");
	String url = application.getInitParameter("MySqlUrl");
	String id = application.getInitParameter("MySqlID");
	String pwd = application.getInitParameter("MySqlPwd");
	
	JDBCconect jdbc2 = new JDBCconect(driver, url, id, pwd);
	jdbc2.close();
	%>
	
	<h2>JDBC 테스트 3</h2>
	<%
	JDBCconect jdbc3 = new JDBCconect(application);
	jdbc3.close();
	%>
	
</body>
</html>