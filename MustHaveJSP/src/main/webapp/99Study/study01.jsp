<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!

public int getAge(int year, int birthYear){
	return year - birthYear + 1;
}

public String getGangi(int num){
	
	//방법1
	String[] allGangi = new String[]{"원숭이띠", "닭띠", "개띠", "돼지띠", "쥐띠", "소띠", "범띠", "토끼띠", "용띠", "뱀띠", "말띠", "양띠"};
	String myGangi;
	
	myGangi = allGangi[num%12];
	
	return myGangi;
	
	//방법2. switch 사용하는 방법
/*	
	switch(num%12){
	case 1 : 
		return "닭띠";
	case 2 : 
		return "개띠";
	case 3 : 
		return "돼지띠";
	case 4 : 
		return "쥐띠";
	case 5 : 
		return "소띠";
	case 6 : 
		return "범띠";
	case 7 : 
		return "토끼띠";
	case 8 : 
		return "용띠";
	case 9 : 
		return "뱀띠";
	case 10 : 
		return "말띠";
	case 11 : 
		return "양띠";
	default:
		return "원숭이띠";
	
	}
*/
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>나이 계산 연습</title>
</head>
<body>

<%
try{
	int birthYear = Integer.parseInt(request.getParameter("year"));
	int LocalYear = LocalDate.now().getYear();

	int age = getAge(LocalYear, birthYear);
	String gangi = getGangi(birthYear); 	
	
	out.println(birthYear+"에 태어난 당신은 </br>");
	out.println(LocalYear+"년 올해 한국 나이로 "+ age + "살 이고, </br>");
	out.println(gangi + "입니다. ");
}

catch(Exception e){
	out.println("예외 발생 : 매개변수 year가 null 입니다.");
}

%>

</body>
</html>