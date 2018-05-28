<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="model.Loan"%>
<%@ page import="servlet.LoanServelt"%>
<%@ page import="java.util.ArrayList"%>

<%!
	ArrayList<Loan> loans;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loan Result</title>
<style type="text/css">
table, td, th {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
}

table {
	margin: 0px auto;
}
</style>
</head>
<body>
	<%-- 요청에 포함된 파라미터를 받아와서, 데이터 기준으로 표만들기
	 --%>


	<table>
		<tr>
			<th>회차</th>
			<th>상환액</th>
			<th>상환원금</th>
			<th>이자</th>
			<th>상환총액</th>
			<th>대출잔액</th>
		</tr>

		<%-- tr 생성 부분을 for 문으로 작성 --%>
		<%
			//변수선언
			//상환액 : repayTotal : 월 상환원금 + 월 이자
			//상환원금: repayOrigin : 월 상환원금
			//이자 : interest  
			//상환총액 : repaySum : 상환 누적음액

			//원금 균등상환 : repayMonth + 이자
			//원리금 균등상환: repayMonth

		
			
		
			loans = (ArrayList)request.getAttribute("loans");
		
			for (int i = 0; i < loans.size(); i++) {
			
		%>
		<tr>
		
			<td><%=i+1%></td>
			<td><%=loans.get(i).getRepayTotal()%></td>
			<td><%=loans.get(i).getRepayOrigin()%></td>
			<td><%=loans.get(i).getInterest()%></td>
			<td><%=loans.get(i).getRepaySum()%></td>
			<td><%=loans.get(i).getRepayRemain()%></td>
			
		</tr>
		<%
			}
		%>

	</table>
</body>
</html>