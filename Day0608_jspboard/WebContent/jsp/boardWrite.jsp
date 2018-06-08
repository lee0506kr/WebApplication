<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/board.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"src="js/board.js">
</script>
</head>
<body>
	<!-- 새 글쓰기 양식 작성 -->

	<div class="wrap">
		<h1>게시글 등록</h1>
		<form action="board" name="frm" >

			<input type="hidden" name="command" value="board_write">

			<table>
				<tr>
					<th>작성자</th>
					<td><input type="Text" name="name"   onblur="checkForm();">*필수</td>
				</tr>

				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="pass"  onblur="checkPassword();">*필수(게시글 수정, 삭제시
						필요 )</td>
				</tr>

				<tr>
					<th>이메일</th>
					<td><input type="Text" name="email" id="email" onblur="checkEmail();">*필수
					<span id="pw2_res"></span></td>
					
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="Text" name="title"></td>
				</tr>

				<tr>
					<th>내용</th>
					<td><textarea rows="15" cols="70" name="content"></textarea></td>
				</tr>


			</table>
			<br> <input type="submit" value="등록"> <input
				type="reset" value="다시 작성"> <input type="button" value="목록"
				onclick="location.href ='board?command=board_list'">



		</form>
	</div>


</body>
</html>