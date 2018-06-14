<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function openWin(){  
    window.open("https://www.facebook.com", "페이스북", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
}  

function openWin1(){  
    window.open("https://www.instagram.com", "인스타", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
}  



	
</script>



<style type="text/css">
div {
	border: 1px solid gray;
}

h2 {
	text-align: center;
}

#container {
	width: 960px;
	margin: 0 auto;
	padding: 20px;
}

#header {
	padding: 20px;
	margin-bottom: 20px;
	border: 1px solid gray;
}

#contents {
	width: 620px;
	padding: 20px;
	float: left;
	margin-bottom: 20px;
	border: 1px solid gray;
}

#sidebar {
	width: 220px;
	padding: 20px;
	float: right;
	border: 1px solid gray;
}

#sidebar1 {
	width: 220px;
	padding: 20px;
	float: right;
	border: 1px solid gray;
}

#footer {
	clear: both;
	border: 1px solid gray;
}

.ul {
	list-style: none;
	text-align: right;
}

.li {
	display: inline-block;
	/* 	margin: 1px;
	padding: 2px; */
}


body{
		
		background-image: url('jsp/img/.jpg');
		background-repeat:no-repeat;
		background-position: center;
		background-size: cover;

	}
	
#header{

	background-color: gray;

}
</style>
</head>




<body>

	<%
		String loginId = (String) session.getAttribute("userid");
		boolean login = false;

		if (loginId != null) {
			//로그아웃
			login = true;
		}
	%>


	<%-- <%
 		out.print(request.getSession().getAttribute("userid"));
 	%> --%>

	<div id="container">

		<header id="header"> <!-- 시멘틱 태그: 사용 목적에 맞는 이름을 가지는 태그 -->

		<h1>광 고 문 의</h1>


		<%
			if (login) {
		%>
		
		<ul class="ul">
			<li class="li" style="text-decoration: none"><a
				href="board?command=main" style="text-decoration: none; font-weight:bold; color:aqua;">홈</a></li>
			<span>|</span>
			<li class="li"><a href="board?command=board_list"
				style="text-decoration: none;font-weight:bold; color:aqua;">게시판</a></li>
			<span>|</span>
			<li class="li"><a href="board?command=member_modify_form"
				style="text-decoration: none;font-weight:bold; color:aqua;">마이페이지</a></li>
			<span>|</span>
			<li class="li"><a href="board?command=logout"
				style="text-decoration: none;font-weight:bold; color:aqua;">로그아웃</a></li>
		</ul>


		<%
			} else {
		%>



		<ul class="ul">
			<li class="li"><a href="board?command=main"
				style="text-decoration: none;font-weight:bold; color:aqua;">홈</a></li>
			<span>|</span>
			<li class="li"><a href="board?command=board_list"
				style="text-decoration: none;font-weight:bold; color:aqua;">게시판</a></li>
			<span>|</span>
			<li class="li"><a href="board?command=member_login_form"
				style="text-decoration: none;font-weight:bold; color:aqua;">로그인</a></li>
			<span>|</span>
			<li class="li"><a href="board?command=member_join_form"
				style="text-decoration: none;font-weight:bold; color:aqua;">회원가입</a></li>
		</ul>

		<%
			}
		%> 
		
		
		</header>


		<section> <article id="contents"> <img
			src="jsp/img/to.jpg" height="500" width="500"> </article> </section>
		<aside id="sidebar"> <!-- sidebar는 내용이들어가는 게 아니라 링크, 간단한 제목 -->





		<h2>이곳에서도 광고 해드림</h2>
		<ul>
			<li><a href="#"onclick="javascript:openWin();"style="text-decoration: none;font-weight:bold; color:blue;">페이스북</a></li>
			<li><a href="#"onclick="javascript:openWin1();"style="text-decoration: none;font-weight:bold; color:purple;">인스타그램</a></li>

		</ul>
		</aside>



		<footer id="footer">
		<h2>광고 문의</h2>
		<p> 저의 홈페이지에서 광고 하실분 계시면 연락 주세요!!
			싸게 해드림
		</p>
		</footer>
	</div>
</body>
</html>