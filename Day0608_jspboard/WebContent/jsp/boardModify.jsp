
<%@ page import="model.Board" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Board board = (Board)request.getAttribute("board"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>

	<div class="wrap" align ="center">
		<h1>게시글 수정</h1>
		<form action="board" name="frm">
		
			<input type ="hidden" name ="command" value="board_update">
			<input type="hidden" name="num" value="${board.num}">
		
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="name" value="${board.name}" readonly="readonly">*필수</td>
			</tr>
		
			<tr>
				<th>비밀번호</th>
				<td><input type ="password" name ="pass" value="${board.pass }">*필수(게시글 수정, 삭제시 필요 )</td>
			</tr>
		
			<tr>
				<th>이메일</th>
				<td><input type ="text" name ="email"value="${board.email }" readonly="readonly">*필수</td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type ="text" name ="title"value="${board.title }"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td>
				<textarea rows="15" cols="70" name="content"value="${board.content }"></textarea>
				</td>
			</tr>
			
		
		</table>
			<br>
		<input type="submit" value="수정하기" a href = "main"> 
		<input type="reset" value="다시작성">
		
		
		</form>
	</div>



		

</body>
</html>