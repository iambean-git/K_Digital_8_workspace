<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> ForEach - 구구단 </title>
</head>
<body>
	<c:forEach begin="2" end="9" step="1" var="i">
		<h3>${i }단</h3>
		<table border="1">
		<c:forEach begin="1" end="9" step="1" var="j">
			<tr>
				<td> ${i}  X ${ j} = ${i*j }</td>
			</tr>
		</c:forEach>
		</table>
	</c:forEach>
</body>
</html>