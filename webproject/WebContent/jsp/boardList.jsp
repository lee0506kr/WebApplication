<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">

h1{

	text-align: center;
	
}
body{
		background-image: url('jsp/img/10.jpg');
		background-repeat:no-repeat;
		background-position: center;
		background-size: cover;

	}

</style>

<link rel="stylesheet" type="text/css" href="css/board.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>

	<h1> 광 고 문 의</h1>
	<hr>


	<div id="wrap" align="center">
		<table class="list" border="1">

			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>


			<c:forEach items="${viewData.boardList}" var="board">
				<tr>
					<td>${board.num}</td>
					<td><a href="board?command=board_view&num=${board.num}">${board.title}</a></td>
					<td>${board.name}</td>
					<td>${board.writeDate}</td>
					<td align="center">${board.readCount}</td>
				</tr>
			</c:forEach>

			<tr>
				<td colspan="5" align="right"><input type="button" value="이전"
					onclick="location.href='board?command=main'"> <input
					type="button" value="게시글 등록"
					onclick="location.href='board?command=board_write_form'">
			</tr>

		</table>
		<br>

		<!-- 처음 이전  1 2 3 4 5 6 7 8 9 10 다음  마지막 -->
		<!-- 1 2 3 4 5 다음 마지막 -->
		<!-- 처음 이전    11  12  13     20 -->

		<c:if test="${viewData.startPage !=1 }">
			<a href="board?command=board_list&page=1">[처음]</a>
			<a href="board?command=board_list&page=${viewData.startPage-1}">[이전]</a>
		</c:if>





		<c:forEach var="pageNum"
			begin="${viewData.startPage}"
			end="${viewData.endPage < viewData.pageTotalCount ? viewData.endPage : viewData.pageTotalCount}">


			<!-- 	choose = switch -->
			<c:choose>
				<c:when test="${pageNum == viewData.currentPage}">
					<b>[${pageNum}]</b>
				</c:when>

				<c:otherwise>
					<a href="board?command=board_list&page=${pageNum}">[${pageNum}]</a>
				</c:otherwise>
			</c:choose>


		</c:forEach>


		<c:if test="${viewData.endPage < viewData.pageTotalCount}">
			<a href="board?command=board_list&page=${viewData.endPage+1}">[다음]</a>
			<a href="board?command=board_list&page=${viewData.pageTotalCount}">[마지막]</a>
		</c:if>








	</div>







</body>
</html>