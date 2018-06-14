<%@page import="dao.MemberDao"%>
<%@page import="dao.MemberDaoImp"%>
<%@page import="model.Member"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id = (String) session.getAttribute("userid");
	MemberDao dao = MemberDaoImp.getInstance();

	Member member = dao.selectOne(id);
%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

body{
padding-top: 100px;  
}

form {
	border: 1px solid aqua;
	width : 200px;
	padding : 100px;
	margin: 0px auto;
	
}
</style>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="board" method="post">
		<input type="hidden" name="command" value="member_modify">


		<p>
			<label>아이디: <input type="text" name="userid"
				readonly="readonly" value='<%=member.getId()%> '></label>
		</p>
		<p>
			<label>비&nbsp;&nbsp;&nbsp;번: <input type="password"
				name="userpw"></label>
		</p>
		<p>
			<label>이&nbsp;&nbsp;&nbsp;름: <input type="text" name="name"
				value='<%=member.getName()%>'></label>
		</p>
		<p>
			<label>이메일: <input type="text" name="email"
				value='<%=member.getEmail()%>'></label>
		</p>



		<input type="button" value="이전"
			onclick="location.href='board?command=main'"> 
			<input type="submit" value="수정하기"> 
		
			<a	href="location.href='board?command=main'"></a> 
			
			
			
			<input type="reset" value="다시작성">


	</form>
</body>
</html>