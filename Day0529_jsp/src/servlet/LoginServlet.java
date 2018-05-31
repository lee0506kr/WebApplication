package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	String myId = "hong123";
	String myPw = "12345";

	// 'login' ��û �޾Ƽ� ó��, post �������

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProc(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doProc(req,resp);
	}

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// get,post ��� ��û �Ѵ� ó��
		// 1. ��û�� �Ķ���Ϳ��� userid�� userpw�� �����´�.
		// 2. ������ id�� pw�� �Ķ���Ϳ��� �޾ƿ� ���� ��
		// 3-1 id,pw �� ������
		// 3-1-1 �α��� ó���ϰ�
		// 3-1-2 ����ȭ���� �����޶�� ��û
		// 3-2 id,pw �� �ٸ��� �α���â���� �ٽ� ������

		System.out.println("��¥ �޾����׿�??!!!");

		// ���̵�� ��й�ȣ ��û���� �����ͼ� ���� ������ �ִ� ���̵�� ��й�ȣ ��

		String id = req.getParameter("userid");
		String pw = req.getParameter("userpw");

		HttpSession session = req.getSession();

		if (id != null && id.equals(myId) && pw != null && pw.equals(myPw)) {
			/*
			 * RequestDispatcher dispatcher = request.getRequestDispatcher("main.jsp");
			 * dispatcher.forward(request, response);
			 */
			session.setAttribute("userid", id);

			resp.sendRedirect("04main.jsp");

		} else {
			/*
			 * RequestDispatcher dispatcher = request.getRequestDispatcher("loginForm.jsp");
			 * dispatcher.forward(request, response);
			 */

			resp.sendRedirect("04loginForm.jsp");
		}

	}

}