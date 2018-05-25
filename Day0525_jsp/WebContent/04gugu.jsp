<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gugudan</title>
</head>
<body>
	<%
		for (int i = 2; i <= 9; i++) {
			%>
			<h1><%=i%>단</h1>
			<% 
			for (int j = 1; j <= 9; j++) {
				out.print(i+" x "+j+" = " + i*j);
				out.print("<br>");		
			}
			out.print("<br>");
		}
%>
	<%--
	화면에 구구단 출력하기

 --%>

</body>
</html>