<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%! //멤버변수

	int num1;
	int num2;
	int result;

	public int multiply(int a, int b) {

		return a * b;
	}%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>곱하기</title>

</head>
<body>

	<%
		//지역변수	
	
		num1 = 2;
		num2 = 3;
		result = multiply(3,5);
		
		out.print(num1 + " X " + num2 + " = " + result);
	
		
	%>



	<%-- 	<%= num1 %> X <%=num2 %> = <%=result %> --%>







</body>
</html>