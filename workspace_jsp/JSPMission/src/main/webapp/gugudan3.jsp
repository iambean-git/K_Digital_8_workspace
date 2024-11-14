<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단3</title>
</head>
<body>
<%
	int num = 2;
	String sVal = request.getParameter("val");
	if (sVal!=null)	num = Integer.parseInt(sVal);
	
	out.print(num+"단 입니다. <br/> ");
	for (int i=1; i<10 ; i++){
		out.print( num + " * " + i + " = " + (num* i) + "<br/>");
	}
%>
</body>
</html>