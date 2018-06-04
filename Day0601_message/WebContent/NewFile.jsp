<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="/page/error/500.jsp"%>
<%-- 
<!-- 돌아갈 페이지를 새로이 지정하는 코드 -->
<% String curURL = (String)request.getAttribute("returnURL"); %>
 --%>
<%-- <%@ include file="/page/layout/header.jsp" %> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	th, td{
		padding:5px;
		font-size:15px;
	}
	table{
		border-collapse: collapse;
	}
	textarea{
		width:85%;
		height:100px;
		resize:none;
		font-size:25px;
		outline: none; 
		display:inline;
		vertical-align: middle;
	}
	input[type=submit]{
		width:12%;  
		height:100px;
		display:inline; 
		background-color: lightblue;
		color:black;
		font-size:30px;
		vertical-align: middle; 
	} 
</style>

<div align="center">
	<h1>상 세 보 기</h1>
	
	<table border="1" width="80%">
		<tr>
			<td>
			${bdto.head}	
			${bdto.title}	
			</td>
		</tr>	
		<tr>
			<td>${bdto.writer}</td>
		</tr>
		<tr height="200">
			<td valign="top">
			${bdto.web}<!-- bdto.getWeb() -->
			</td>
		</tr>
		
		<c:if test="${bdto.filesize > 0}">
			<!-- 첨부파일이 있을 경우에 링크 줄 구현 -->
			<tr>
				<td>
					[<a href="${pageContext.request.contextPath}/page/board/file/${bdto.filename}%>" download>
					다운로드
					</a>]  
					(${bdto.filename}, ${bdto.filesize} bytes)
				</td>
			</tr>
		</c:if>
		<tr>
			<td>
				댓글 ${bdto.reply}
				조회수 ${bdto.read} 
				작성시간 ${bdto.reg}
			</td>
		</tr>
		
		<!-- 댓글 목록과 입력창을 표시하기 위한 줄 -->
		<tr>
			<td align="center">
				<table border="1" width="99%">
					<!-- 목록 표시 -->
					
					<c:forEach var="rdto" items="${reply}">
					<tr>
						<td>
							<font size="5" color="black" face="굴림">${rdto.writer}</font>
							<font size="4" color="gray" face="고딕">${rdto.reg}</font>
							<br>
							<font size="4" color="black" face="고딕">${rdto.detail}</font>
						</td>
					</tr>
					</c:forEach>
					
					<!-- 작성 공간 : 로그인 상태일때만 표시 -->
					<tr>
						<td>
							<form action="reply_pro.jsp" method="post">
								<input type="hidden" name="writer" value="${success}">
								<input type="hidden" name="belong" value="${bdto.no}">
							
								<c:choose>
									<c:when test="${empty success}">
										<textarea name="detail" placeholder="댓글.." required disabled></textarea>
										<input type="submit" value="전송" disabled>
									</c:when>
									
									<c:otherwise>
										<textarea name="detail" placeholder="댓글.." required></textarea>
										<input type="submit" value="전송">
									</c:otherwise>
								</c:choose>
							</form>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<input type="button" value="글쓰기" onclick="location.href='write.jsp';">
				<input type="button" value="수정" onclick="location.href='pw.jsp?no=${bdto.no}&next=edit.jsp';">
				<input type="button" value="삭제" onclick="location.href='pw.jsp?no=${bdto.no}&next=delete_pro.jsp';">
				<input type="button" value="목록" onclick="location.href='list.jsp';">
			</td>
		</tr>
	</table>
	
</div>

<%-- <%@ include file="/page/layout/footer.jsp" %> --%>