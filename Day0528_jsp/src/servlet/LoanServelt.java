package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loan;

//loanService 요청처리하는 Servlet 작성
//요청 처리하고 나서 loanResult.jsp로 데이터 전달
@WebServlet("/abc")
public class LoanServelt extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,resp);
	}

	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<Loan> loans = new ArrayList<Loan>();
		
		String amountStr = request.getParameter("amount");
		String rateStr = request.getParameter("rate");
		String periodStr = request.getParameter("period");
		String typeStr = request.getParameter("type");

		// 파라미터에 있는 숫자를 적절한 데이터 타입으로 변환
		int amount = Integer.parseInt(amountStr);
		double rate = Double.parseDouble(rateStr);
		int period = Integer.parseInt(periodStr);
		int type = Integer.parseInt(typeStr);

		double mRate = rate / 100 / 12;

		int repayTotal , repayOrigin , interest, repaySum, repayRemain;
		repayRemain = amount; // 처음 총 잔금은 내가 빌린금액
		repaySum = 0;

		// 두 가지 방식으로 계산을 해야한다.
		// 매월 똑같은 금액을 낼 금액을 계산을 해야한다.
		int repayMonth; // 매월 같은 금액을 내는 액수를 저장할 변수

		if (type == 1) {
			// 원금 균등상황
			repayMonth = amount / period;
		} else {
			// 원리금 균등상환
			// 원리금 균등상환 계산식: (원금*월이율*Math.pow((1+월이율),period))/Math.pow(1+월이율,period)-1)
			// 원금 * 원이율
			repayMonth = (int) ((amount * mRate * Math.pow(1 + mRate, period)) / (Math.pow(1 + mRate, period) - 1));
		}
		for (int i = 1; i <= period; i++) {
			// 이자 계산

			interest = (int) (repayRemain * mRate);

			if (type == 1) {
				// 원금 균등상환
				repayTotal = repayMonth + interest; // 이번달 낼 금액의 총합
				repayOrigin = repayMonth; // 이번달 낸 원금
			} else {
				// 원리금 균등상환
				repayTotal = repayMonth;
				repayOrigin = repayMonth - interest; // 이번달 낸 원금
			}
			repayRemain = repayRemain - repayOrigin;
			
			loans.add(new Loan(repayTotal, repayOrigin, interest, repaySum, repayRemain));
		}

		request.setAttribute("loans", loans);
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("04LoanResult.jsp");
		dispatcher.forward(request, resp);

	}

}
