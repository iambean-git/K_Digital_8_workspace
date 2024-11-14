<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 목록 조회 (ID 입력)</title>
</head>
<body>
	<h2>게시판 목록 조회</h2>
	<form action="ExeQuery1.jsp" method=get>
		아이디 : <input type="text" name="id" />
		<input type="submit" value="조회하기"/>
	</form>
</body>
</html>