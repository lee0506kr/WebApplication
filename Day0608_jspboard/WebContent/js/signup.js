function checkPassword() {
	// document라는 내장객체를 이용하여 name="pw"와 name="pw2"를 불러와 비교
	// 탐색시 name 따라서 탐색이 가능하도록 구성되어 있다(form에 이름 부여)

	var a = document.f.pw.value;// pw의 값;
	var b = document.f.pw2.value;// pw2의 값;
	// window.alert("a = "+a+", b = "+b);
	if (a == b) {
		// 입력창 오른쪽에 있는 글자를 삭제
		document.getElementById("pw2_res").innerHTML = "";
		return true;
	} else {
		// 입력창 오른쪽에 있는 공간에 오류 글자를 작성
		document.getElementById("pw2_res").innerHTML = "비밀번호가 일치하지 않습니다";
		return false;
	}
}

function checkTel() {
	// 전화번호가 정확한 형식인지 검사...
	// 정규표현식 : 문장의 형식을 검사하는 식
	var tel = document.f.tel;// 입력창의 값(tel.value)
	var regex = /^010[1-9][0-9]{7}$/
	if (!regex.test(tel.value)) {// 실패
		window.alert("전화번호를 제대로 입력해 주세요");
		// tel.select(); //tel을 선택하라
	}
}

function checkForm() {
	// 전송 직전에 검사가 이루어지는 함수
	// return true 전송하라
	// return false 전송하지 마라

	var check = checkPassword();
	if (!check) {// 비밀번호 불일치
		document.f.pw2.select();
		return false;// 전송 중지
	}

	// 나머지 항목들에 대한 검사..... 작성

	// return true;
}

// 창 닫기 함수
function cancel() {
	var c = window.confirm("지금 작성한 내용이 삭제됩니다\n정말 나가시겠습니까?");
	if (c == true) {
		window.close();
	}
}