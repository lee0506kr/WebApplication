<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
table {
	border: 1px solid black;
	margin: 0px auto;
	padding: 70px;
}

#memo {
	margin-right: 50px;
}

#reset {
	display: inline-block;
}
</style>
</head>
<body>



	<form action="abc">
		<table>
			<tr>
				<td><label>제목 : <input type="text" name="title"></label><br></td>
			</tr>
			<tr>
				<td><label>작성자 : <input type="text" name="name"></label><br></td>
			</tr>
			<tr>
				<td><label>이메일 : <input type="text" name="email"></label><br></td>
			</tr>
			<tr>
				<td><label>비밀번호 : <input type="text" name="pass"></label><br></td>
			</tr>

			<tr>
				<td>내용 :</td>

			</tr>
			<tr>
				<td><textarea rows="10" cols="30" name="content" id="memo">
				</textarea></td>
			</tr>

			<tr>
				<td><input type="submit" value="전송" id="send"> 
				<input type="reset" value="초기화" id="reset"></td>
			</tr>




		</table>
	</form>





</body>
</html>