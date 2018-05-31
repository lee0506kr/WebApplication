<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Board"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%
		Board board = (Board) request.getAttribute("board");
	%>


	
		제목 =
		<%=board.getTitle()%><br> 
		작성자 =
		<%=board.getName()%><br> 
		이메일 =
		<%=board.getEmail()%><br> 
		비밀번호 =
		<%=board.getPass()%><br> 
		내용 =
		<%=board.getContent()%><br>


</body>
</html>