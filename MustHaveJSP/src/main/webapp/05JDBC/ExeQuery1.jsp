
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
	<h2>게시판 목록 조회 테스트 (executeQuery() 사용)</h2>
	
	<table border="1">
		<tr class='title'>
			<th> 번호 </th>
			<th> 제목 </th>
			<th> 이름 </th>
			<th> 등록 날짜</th>
			<th> 방문자 수</th>
		</tr>
	
	<%
	//db연결
	JDBCconect jdbc = new JDBCconect();
	
	//파라미터로 id 조회
	String id = request.getParameter("id");
	if(id==null)	id = "musthave";
	
	//쿼리문 생성
	String sql = "select board.num, board.title, member.name, board.postdate, board.visitcount from board, member where board.id=member.id and board.id='"+ id +"' ;";
	Statement stmt = jdbc.con.createStatement();
	
	//쿼리 수행
	ResultSet rs = stmt.executeQuery(sql);
	
	//결과 확인
	while (rs.next()) {
		int num = rs.getInt("board.num");
		String title = rs.getString("board.title");
		String name = rs.getString("member.name");
		java.sql.Date postdate = rs.getDate("board.postdate");
		int count = rs.getInt("board.visitcount");
		
		out.print("<tr>");
		out.print("<td>" + num + "</td>" );
		out.print("<td>" + title + "</td>");
		out.print("<td>" + name + "</td>");
		out.print("<td>" + postdate + "</td>");
		out.print("<td>" + count + "</td>");
		out.print("</tr>");
		
	}
	
	jdbc.close();
	stmt.close();
	%>
	
	</table>
</body>
</html>