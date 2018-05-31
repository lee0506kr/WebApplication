<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%--
   	<jsp:forward> 사용해보기
   	
   	넘어온 파라미터의 값에 따라서 적절한 페이지로 포워딩
   
    --%>
    <% request.setCharacterEncoding("utf-8"); %>
<%
	//파라미터 받아오기
	String color = request.getParameter("color");
	String url = null;
	if (color.equals("red")) {
		//빨강 페이지
		url = "01red.jsp";
		
	} else if (color.equals("blue")) {
		//파란 페이지
		url = "01blue.jsp";

	} else if (color.equals("yellow")) {
		//노란 페이지
		url = "01yellow.jsp";
	}

	/* RequestDispatcher dispatcher
	 = request.getRequestDispatcher("url");
	
	dispatcher.forward(request, response);
	 */
%>



<jsp:forward page ="<%=url%>">

<jsp:param value="홍길동" name="name"/>

</jsp:forward>


