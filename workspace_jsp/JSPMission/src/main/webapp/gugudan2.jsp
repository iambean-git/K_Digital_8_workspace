<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단2</title>
<style>
table, td, th {
	border-collapse:collapse;
}
td, tr{
	padding: 4px 15px;
	
	}
.title{
	text-align : center;
	background-color : lightgray;
}
</style>
</head>
<body>
<table border="1">
	<%
	out.print("<tr class='title'>");
	for(int j=2; j<10; j++){
		out.print("<td style=\"text-align:center\">"+j+"단</td>");
	}
	out.print("</tr>");
	out.print("<tr>");
		
	for(int i=1; i<10; i++){
		for(int j=2; j<10; j++){
			out.print("<td>"+j+" * "+ i + " = " + j*i + "</td>");
		}
		out.print("</tr>");
	}
	%>
	
</table>

</body>
</html>