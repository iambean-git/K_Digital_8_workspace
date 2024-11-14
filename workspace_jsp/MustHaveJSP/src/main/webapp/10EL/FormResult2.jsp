<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
String gen = request.getParameter("gender");
String grade = request.getParameter("grade");
String inters[] = request.getParameterValues("inter");
StringBuilder sb = new StringBuilder();
for(String s : inters) {
	sb.append(s + " ");
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어(EL) - 폼값처리</title>
</head>
<body>
	<h3>EL로 폼값 받기 </h3>
	<ul>
		<li>이름 : ${param.name } </li>
		<li>성별 : ${param.gender } </li>
		<li>학력 : ${param.grade } </li>
		<li>관심사항 : ${paramValues.inter[0] }
		${paramValues.inter[1] }
		${paramValues.inter[2] }
		${paramValues.inter[3] } </li>
	</ul>
	<br/><br/>
	
	<h3>표현식으로 폼값 받기 </h3>
	<ul>
		<li>이름 : <%=name %> </li>
		<li>성별 : <%=gen %> </li>
		<li>학력 : <%=grade %> </li>
		<li>관심사항 : <%=sb.toString() %> </li>
	</ul>
</body>
</html>