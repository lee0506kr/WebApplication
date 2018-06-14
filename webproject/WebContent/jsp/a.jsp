<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>가입 페이지</title>

<!-- css 코드를 불러오기 위해서는 link라는 태그를 사용 -->
<link rel="stylesheet" type="text/css" href="../../css/signup.css">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function findAddress() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('post').value = data.zonecode; //5자리 새우편번호 사용
                document.getElementById('addr').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('addr2').focus();
            }
        }).open();
    }
</script>
<script src="../../js/signup.js"></script>

</head>
<body>
	<div align="center">
		<!-- 회원 가입 양식 구현 -->
		<h1>정보 입력</h1>
		
		<form name="f" action="signup_pro.jsp" method="post"
				enctype="multipart/form-data" onsubmit="return checkForm();" > 
		<!-- onsubmit : 폼이 전송되기 전에 수행될 내용을 지정
								return 함수명() 으로 부르면 함수의 결과에 따라 전송여부를 판정 -->
		
		<table border="0" width="480">
			<tr>
				<td>
					<input type="text" name="name" placeholder="이름" required
							size="20" maxlength="20">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="id" placeholder="아이디" required
							maxlength="20">
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="pw" placeholder="비밀번호" required
							maxlength="20">
				</td>
			</tr>
			<tr>
				<td>
					<input type="password" name="pw2" placeholder="비밀번호 확인" required
							maxlength="20" onkeyup="checkPassword();">
					<!-- 비교 결과가 표시될 공간, span은 투명한 공간 -->
					<span id="pw2_res"></span>
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="tel" placeholder="전화번호(-제외)" required
							maxlength="11" onblur="checkTel();">
				</td>
			</tr>
			<tr>
				<td>
					생일 <input type="date" name="birth" placeholder="생년월일" required>
				</td> 
			</tr> 
			<tr>
				<td>
					<input type="text" name="post" placeholder="우편번호"
							size="10" maxlength="6" id="post"> 
					<input type="button" value="우편번호 검색" onclick="findAddress();">
				</td> 
			</tr>
			<tr>
				<td>
					<input type="text" name="addr1" placeholder="기본주소"
						maxlength="50" size="60" id="addr">
				</td>
			</tr>
			<tr>
				<td>
					<input type="text" name="addr2" placeholder="상세주소"
						maxlength="50" size="60" id="addr2">
				</td>
			</tr>
			<tr>
				<td>
					<input type="file" name="file">
				</td>
			</tr>
			<tr>
				<th>
					<input type="submit" value="확인">
					<input type="button" value="닫기" onclick="cancel();">
				</th>
			</tr>
		</table>
		
		</form>
		
	</div>
</body>
</html>








