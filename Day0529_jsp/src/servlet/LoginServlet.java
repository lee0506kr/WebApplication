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

	// 'login' 요청 받아서 처리, post 방식으로

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
		// get,post 방식 요청 둘다 처리
		// 1. 요청의 파라미터에서 userid와 userpw를 가져온다.
		// 2. 임의의 id와 pw를 파라미터에서 받아온 값과 비교
		// 3-1 id,pw 가 같으면
		// 3-1-1 로그인 처리하고
		// 3-1-2 메인화면을 보여달라는 요청
		// 3-2 id,pw 가 다르면 로그인창으로 다시 보내기

		System.out.println("진짜 받아지네요??!!!");

		// 아이디랑 비밀번호 요청에서 꺼내와서 원래 가지고 있던 아이디랑 비밀번호 비교

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