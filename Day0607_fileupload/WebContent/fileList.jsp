<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript">

function createList(){
	var table = $("#listTable");
	
	
	
	
}










</script>
</head>
<body>

	<table id = "listTable" border ="1">
		<c:forEach items="${fileList}" var="file">
			<a href="file?command=download&filename=${file}">${file}</a>
			<input type="checkbox">
			<input type="button" value ="delete">
			<br>

			
		</c:forEach>

	</table>
</body>
</html>



