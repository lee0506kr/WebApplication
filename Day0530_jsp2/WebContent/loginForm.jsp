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


</style>

</head>
<body>

	<form action="login" method="POST">
		<table>

			<tr>
				<td>아이디 :</td>
				<td><input type="text"id="id" name="userid" placeholder="id를 입력해주세요."></td>
			</tr>

			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" id="pw" name="userpw"placeholder="pw를 입력해주세요."></td>			</tr>

			<tr >
				<td colspan="2"><input type="submit" value="로그인" id="submit"></td>
				<td colspan="2"> <button type="button" onclick="location.href='joinForm.jsp' ">회원가입</button></td>
			</tr>
		</table>


	</form>



</body>
</html>