<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원목록</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	/*
	   비동기 방식으로 요청/처리 하기
	  1.아이디 확인
	  2.회원가입 후 회원 목록가져오기	
	 */
	$(function() {
		//id,email 입력창 blur 이벤트 처리하기 
		$("#userid").on("blur", function() {
			$.ajax({
				url : "member?command=checkId",
				data : {
					"id" : $(this).val()
				},
				dataType : "json",
				success : function(data) {
					if (data.result) {
						$("#idDup").html("<small>사용가능아이디</small>");
					} else {
						$("#idDup").html("<small>사용불가 아이디</small>");
					}
				}

			});
		});
		
		$("#email").on("blur", function() {
			$.ajax({
				url : "member?command=checkEmail",
				data : {
					"email" : $(this).val()
				},
				dataType : "json",
				success : function(data) {
					if (data.result) {
						$("#emailDup").html("<small>사용가능이메일</small>");
					} else {
						$("#emailDup").html("<small>사용불가 이메일</small>");
					}
				}

			});
		});
		
		//joinForm submit 이벤트 처리하기
		$("#joinForm").on("submit", function() {
			var d = $(this).serialize();
			$.ajax({
				url : "member?command=join",
				data : d,
				type : "post",
				dataType : "json",
				success : function(data) {
					if (data.result) {
						// 						alert("회원가입성공");
						createList();
					} else {
						alert("회원가입실패");
					}
				}
			});

			return false;
		});
		
		//memberList 요청이 들어오면 회원목록을json 
		//형태로 만들어서 반환
		createList();

	});
	
	
	function createList() {
		//listTable 테이블에 회원 목록을 조회해서 출력하는 함수
		//ajax 요청
		//반환된 데이터를 tr,td 요소 만들어서 갖다 붙임

		var table = $("#listTable");

		$("#listTable tr:gt(0)").remove();

		$.ajax({
			url : "member?command=memberList",
			type : "get",
			dataType : "json",
			success : function(data) {
				//memberList 데이터를 가지고 있는 json객체를 반환받아서 처리
				// 				alert(data);
				for ( var i in data) {
					//반복문 반복 하면서, 데이터를 테이블에 추가 하기 
					//테이블에 tr추가
					//tr td추가
					var tr = $("<tr>");
					var btn = $("<input type='button' value = '삭제'>");

					$("<td>").text(data[i].id).appendTo(tr);
					$("<td>").text(data[i].email).appendTo(tr);
					$("<td>").text(data[i].name).appendTo(tr);
					$("<td>").append(btn).appendTo(tr);
					tr.appendTo(table);

					//삭제요청
					//member?command=delete
					(function(m) {
						btn.on("click", function() {
							$.ajax({
								url : "member?command=delete",
								data : {
									"id" : data[m].id
								},
								type : "post",
								dataType : "json",
								success : function(data) {
									alert(data.result);
									//삭제하고 나서 목록에 새롭게 그려져야함
									
									creatList();
								}
							});
						});

					})(i);

				}
			}
		});

	}
	
	
</script>
</head>
<body>
	<form name="joinForm" method="post" id=joinForm action="">
		<table border="1">
			<tr bgcolor="aqua">
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>이메일</th>
			</tr>
			<tr>
				<td><input type="text" name="userid" id="userid"><span
					id="idDup">아이디중복여부</span></td>
				<td><input type="password" name="password" id="password"></td>
				<td><input type="text" name="name" id="name"></td>
				<td><input type="text" name="email" id="email"><span
					id="emailDup">이메일중복여부</span></td>
			</tr>
			<tr>
				<td colspan="4"><input type="submit" value="가입하기" id="joinBtn"></td>
			</tr>
		</table>
	</form>
	<h2>회원 목록</h2>
	<table id="listTable" border="1">
		<colgroup>
			<col width="150px">
			<col width="250px">
			<col width="100px">
		</colgroup>
		<tr bgcolor="gray">
			<th>아이디</th>
			<th>이메일</th>
			<th>이름</th>
			<th>삭제</th>
		</tr>
	</table>

</body>
</html>