function open_win(url, name) {
	window.open(url, name, "width=500,height=300");

}

function checkEmail() {

	var email = document.frm.email;
	var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

	if (!regex.test(email.value)) {
		alert("이메일을 제대로 입력해주세요")

	}
}
function checkName() {

	var name = document.frm.name.value;
	var regex = /^[가-힣]{2,20}$/
	if (!regex.test(name)) {
		document.getElementById("name").innerHTML = "이름은 한글[2-20]글자만 입력하실수 있습니다"
		return false;
	} else {
		document.getElementById("name").innerHTML = "";
		return true;
	}
}

function checkTel() {
	var regex = /^010[1-9][0-9]{7}$/;
	if (!regex.test(tel.value)) {
		alert("전화번호를 제대로 입력해 주세요");

	}
}
function chkPwd() {

	var pass = document.frm.pass;
	var reg_pwd = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;

	if (!reg_pwd.test(pass.value)) {

		return false;

	}

	return true;

}


