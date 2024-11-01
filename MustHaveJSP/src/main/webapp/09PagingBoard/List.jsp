<%@page import="utils.BoardPage"%>
<%@page import="model1.board.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="model1.board.BoardDAO"%>
<%@page import="utils.BoardPage" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//DAO 생성해 DB에 연결
BoardDAO dao = new BoardDAO(application);

//사용자가 입력한 검색 조건을 MAP에 저장
Map<String, Object> param = new HashMap<String, Object>();
String searchField = request.getParameter("searchField");
searchField = (searchField==null)? "title" : searchField;
String searchWord = request.getParameter("searchWord");

if(searchWord != null) {
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
}

int totalCount = dao.selectCount(param);	//게시물 수 확인

/* 페이징 처리 START */
//전체 페이지 수 계산
int pageSize = Integer.parseInt(application.getInitParameter("POSTS_PER_PAGE"));
int blockPage = Integer.parseInt(application.getInitParameter("PAGES_PER_BLCOK"));
int totalPage = (int)Math.ceil((double)totalCount / pageSize);

//현재 페이지 확인
int pageNum = 1;
String pageTemp = request.getParameter("pageNum");
if (pageTemp != null && !pageTemp.equals(""))
	pageNum = Integer.parseInt(pageTemp);

//목록에 출력할 게시물 범위 계산
int start = (pageNum - 1) * pageSize ;
param.put("start", start);
param.put("pageSize", pageSize);

List<BoardDTO> boardLists = dao.selectListPage(param);	//게시물 목록 확인
dao.close();	//DB연결 닫기
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원제 게시판</title>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />
	
	<h2>목록 보기(List) - 현재 페이지 : <%=pageNum %> (전체 : <%= totalPage %>)</h2>
	
	<!-- 검색 폼 -->
	<form method = "get">
	<table border="1" width="90%">
	<tr>
		<td align = "center">
			<select name="searchField">			
				<option value = "title"  <%=searchField.equals("title")? "selected" : ""  %>>제목 </option>
				<option value = "content" <%=searchField.equals("content")? "selected" : ""  %> >내용 </option>
			</select>
			<input type="text" name="searchWord" value="<%=searchWord==null? "" : searchWord %>" />
			<input type="submit" value="검색하기" />
		</td>
	</tr>
	</table>
	</form>
	
	<!-- 게시물 목록 테이블(표) -->
	<table border = "1" width="90%">
		<!-- 각 컬럼의 이름 -->
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>
		
		
		<!-- 목록의 내용 -->
<%
if(boardLists.isEmpty()){
	//게시물이 하나도 없을때
	
%>
	<tr>
		<td colspan="5" align="center">
			등록된 게시물이 없습니다 ^^*
		</td>
	</tr>
<%
}
else {
	//게시물이 1개 이상 있을 때
	int virtualNum = 0;	//화면상에서의 게시물 번호
	int countNum = 0;
	for(BoardDTO dto : boardLists){
		//virtualNum = totalCount--;
		virtualNum = totalCount - (((pageNum - 1) * pageSize) + countNum ++);
		
%>
	<tr align="center">
		<td><%= virtualNum %></td>
		<td align="left">
			<a href="View.jsp?num=<%= dto.getNum() %>"><%=dto.getTitle() %>
			</a>
			</td>
			<td align="center"><%= dto.getId() %></td>
			<td align="center"><%= dto.getVisitcount() %></td>
			<td align="center"><%= dto.getPostdate() %></td>
		</tr>
				
<%
	}
}
%>
	</table>
	<!-- 목록 하단의 [글쓰기] 버튼 -->
	<table border="1" width="90%">
		<tr align="center">
			<td>
				<%=BoardPage.pagingStr(totalCount, pageSize, blockPage, pageNum, request.getRequestURI()) %>
			</td>
			<!-- 글쓰기버튼 -->
			<td><button type="button" onclick="location.href='Write.jsp';">글쓰기
			</button></td>
		</tr>
	</table>
</body>
</html>