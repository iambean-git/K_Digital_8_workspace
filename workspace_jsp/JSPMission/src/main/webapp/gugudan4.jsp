<%@ page import="utils.CookieManager" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 여러단 출력하기</title>
</head>
<body>

	<%
	
	String danVal = request.getParameter("val");
	//주소값에 val 인자가 없으면
	if(danVal==null) {
		danVal = CookieManager.readCookie(request, "danVal");
		if(danVal.equals(""))	danVal = "3";
	}
	//주소값에 val 인자가 없으면 (쿠키생성)
	else{
		CookieManager.makeCookie(response, "danVal", danVal, 86400);
	}
	
	//문자열을 정수로 변환
	int col = Integer.parseInt(danVal);

	%>
	<div style="display:grid; grid-template-columns:repeat(<%=danVal %>,100px); ">
	<%
	
	for (int j = 2; j < 10; j += col) {  
		for (int k = 0; k < col; k++){ 
			if ((j+k) <= 9) { %>
				<div style ="text-align:center; font-size:20px; font-weight: bold ; margin-top:30px ;"><%=(j + k) %>단</div>
			<% } 
			else { %>
				<div></div>
			<% }
		}
		for (int i = 1; i < 10; i++) {
			for (int k = 0; k < col; k++) {
				if((j+k) <= 9){%>
					<div style =text-align:center; >
						<%=(j + k) %> * <%= i %> = <%= (j + k) * i %> 
					</div>
				<%}
				else {%>
					<div></div>
				<%}
					
			}
		}
	}
	%>
</div>
</body>
</html>