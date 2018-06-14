<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: 1px solid aqua;
	margin: 0px auto;
	
}

	

#submit {
	padding: 1px;
	margin-left: 200px;
	margin-right: 0px;
	
}
body{
		padding : 100px;
		background-image: url('jsp/img/10.jpg');
		background-repeat:no-repeat;
		background-position: center;
		background-size: cover;

	}

</style>

</head>
<body>
	<h1> 로그인 창 </h1>
	
	<hr>
	
	<form action="board" method="POST">
	

	
	<input type="hidden" name="command" value="member_login">
		<table>

			<tr>
				<td>아이디 :</td>
				<td><input type="text"id="id" name="userid" required maxlength="20" placeholder="id를 입력해주세요."></td>
			</tr>

			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" id="pw" name="userpw" required maxlength="20" placeholder="pw를 입력해주세요."></td>
		</tr>

			<tr >
				<td colspan="2"><input type="submit" value="로그인" id="submit"></td>
				<td colspan="2"> <button type="button" onclick="location.href='board?command=member_join_form'">회원가입</button></td>
			</tr>
		</table>


	</form>



</body>
</html>