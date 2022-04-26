<%@page import="kr.co.hf.domain.BoardVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.hf.domain.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	BoardDAO dao = BoardDAO.getInstance();

	List<BoardVO> boardList = dao.getBoardList();

	request.setAttribute("boardList", boardList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="board" items="${boardList}">
	${board.postID}
	${board.postAuthor}
	${board.postTitle}
	${board.postContent}
	${board.postTime}
	${board.postLastModified}
	${board.viewCount}
	${board.postType}	
</c:forEach>


</body>
</html>