<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberAuth.jsp</title>
</head>
<body>
	<h2>MVC 패턴으로 회원인증하기</h2>
	<p>
		<strong>${authMessage }</strong>
		<br />
	</p>
		
		<form action="MemberAuth2.mvc" method="post" name="loginFrm">
			아이디 : <input type="text" name="id" /><br/>
			패스워드 : <input type="password" name="pass"/> <br/>
		<input type="submit" value="로그인하기" />
		</form>
		
</body>
</html>