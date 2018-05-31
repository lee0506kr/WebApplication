<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">





<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파라미터 값 사용하기</title>
<style type="text/css">


table{
	border: 1px solid black;
	margin: 0 auto;
}
	

</style>


</head>
<body>

<!-- 

	form 양식 하나 만들어서 회원가입 정보 입력
	form에서 입력한 정보가 요청 파라미터로 넘어오면
	받아서 사용하기

 -->
 
 
 
 <form action="03memberinfo.jsp" method = "get">
 

 <table>
 <tr>
 <td>아이디: </td>
 <td> <input type= "text" name ="id" placeholder="id를 입력해주세요."></td>
 </tr>
 
 
 
 <tr>
 <td>비밀번호: </td>
 <td> <input type= "password" name ="password" placeholder="pw를 입력해주세요."></td>
 </tr>
 
 
 <tr>
 <td>이름: </td>
 <td> <input type= "text" name ="name" placeholder="name를 입력해주세요."></td>
 </tr>
 
 
 <tr>
 <td>이메일: </td>
 <td> <input type= "text" name ="email" placeholder="email를 입력해주세요."></td>
 </tr>

<tr>
<td><input type = "submit" value="회원가입"></td>
</tr> 
 
 
</table>
  
 
 
 </form>

</body>
</html>