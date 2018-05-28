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

//loanService ��ûó���ϴ� Servlet �ۼ�
//��û ó���ϰ� ���� loanResult.jsp�� ������ ����
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

		// �Ķ���Ϳ� �ִ� ���ڸ� ������ ������ Ÿ������ ��ȯ
		int amount = Integer.parseInt(amountStr);
		double rate = Double.parseDouble(rateStr);
		int period = Integer.parseInt(periodStr);
		int type = Integer.parseInt(typeStr);

		double mRate = rate / 100 / 12;

		int repayTotal , repayOrigin , interest, repaySum, repayRemain;
		repayRemain = amount; // ó�� �� �ܱ��� ���� �����ݾ�
		repaySum = 0;

		// �� ���� ������� ����� �ؾ��Ѵ�.
		// �ſ� �Ȱ��� �ݾ��� �� �ݾ��� ����� �ؾ��Ѵ�.
		int repayMonth; // �ſ� ���� �ݾ��� ���� �׼��� ������ ����

		if (type == 1) {
			// ���� �յ��Ȳ
			repayMonth = amount / period;
		} else {
			// ������ �յ��ȯ
			// ������ �յ��ȯ ����: (����*������*Math.pow((1+������),period))/Math.pow(1+������,period)-1)
			// ���� * ������
			repayMonth = (int) ((amount * mRate * Math.pow(1 + mRate, period)) / (Math.pow(1 + mRate, period) - 1));
		}
		for (int i = 1; i <= period; i++) {
			// ���� ���

			interest = (int) (repayRemain * mRate);

			if (type == 1) {
				// ���� �յ��ȯ
				repayTotal = repayMonth + interest; // �̹��� �� �ݾ��� ����
				repayOrigin = repayMonth; // �̹��� �� ����
			} else {
				// ������ �յ��ȯ
				repayTotal = repayMonth;
				repayOrigin = repayMonth - interest; // �̹��� �� ����
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
