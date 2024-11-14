
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="common.JDBCconect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
<style>
table, td, th {
	border-collapse:collapse;
}
td, tr, th{
	padding: 4px 15px;
	
	}
.title{
	text-align : center;
	background-color : lightgray;
}
</style>
</head>
<body>
	<h2>회원 목록 조회 테스트 (executeQuery() 사용)</h2>
	
	<table border="1">
		<tr class='title'>
			<th> ID </th>
			<th> PW </th>
			<th> 이름 </th>
			<th> 등록 날짜</th>
		</tr>
	
	<%
	//db연결
	JDBCconect jdbc = new JDBCconect();
	
	//쿼리문 생성
	String sql = "SELECT id, pass, name, regidate From member";
	Statement stmt = jdbc.con.createStatement();
	
	//쿼리 수행
	ResultSet rs = stmt.executeQuery(sql);
	
	//결과 확인
	while (rs.next()) {
		String id = rs.getString(1);
		String pw = rs.getString(2);
		String name = rs.getString("name");
		java.sql.Date regidate = rs.getDate("regidate");
		
		out.print("<tr>");
		out.print("<td>" + id + "</td>" );
		out.print("<td>" + pw + "</td>");
		out.print("<td>" + name + "</td>");
		out.print("<td>" + regidate + "</td>");
		out.print("</tr>");
		
		//out.println(String.format("%s %s %s %s", id, pw, name, regidate)+ "<br/>");
	}
	
	jdbc.close();
	%>
	
	</table>
</body>
</html>