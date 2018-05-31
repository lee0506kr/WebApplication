<%@page import="java.lang.reflect.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	<%--
	forEach 태그 연습 
	배열, collection, Map 에 있는 값들을 순차적으로 접근해서 처리

	items : 순차적으로 접근하고자 하는 데이터들의 모음
	var : 각 회차에서 요소가 저장될 변수의 이름
	begin : 시작인덱스 설정
	end : 종료 인덱스 설정 
	step : 인덱스 증가분 설정
	
 --%>



	<c:forEach items="${memberList}" var="member">
		<table>
			<tr>
				<td>아이디 :${member.id}</td>
				<td>이름 :${member.name}</td>
				<td>이메일 :${member.email}</td>
				<td>가입일 :${member.regDate}</td>
			</tr>
		</table>
	</c:forEach>
	<a href="main.jsp">메인화면으로 </a>
	
	
<%-- 	${memberList}




	<%
		List<Member> memberList = (List<Member>) request.getAttribute("memberList");
	%>

	<table border="1">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>가입일</th>
		</tr>
		<%
			for (int i = 0; i < memberList.size(); i++) {
		%>
		<tr>
			<td><%=memberList.get(i).getId()%></td>
			<td><%=memberList.get(i).getName()%></td>
			<td><%=memberList.get(i).getEmail()%></td>
			<td><%=memberList.get(i).getRegDate()%></td>
		</tr>
		<%
			}
		%>
	</table> --%>

</body>
</html>