<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
 table{
 
 border: 1px solid black;
 margin: 0px auto;
 padding-top: 25px;
 }


</style>


</head>
<body>

<form action="join" method="POST">
		<table>
			
			<tr>
			<td>회원가입창</td>
			</tr>
		
			<tr>
				<td>아이디 :</td>
				<td><input type="text" name="userid" placeholder="id를 입력해주세요."></td>
			</tr>
			
			<tr>
				<td>이름 :</td>
				<td><input type="text" name="name" placeholder=" 닉네임을 입력해주세요."></td>
			</tr>
		
			<tr>
				<td>비밀번호 :</td>
				<td><input type="password" name="userpw" placeholder="pw를 입력해주세요."></td>
			</tr>
			
			<tr>
				<td>E-mail :</td>
				<td><input type="text" name="email" placeholder="email을 입력해주세여."></td>
			</tr>

			<tr>
				<td colspan = "2"><input type="submit" value="회원가입" id="submit"></td>
				<td><input type="reset" value="다시작성"></td>
				
			</tr>
			



		</table>





	</form>





</body>
</html>
