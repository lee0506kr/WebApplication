package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(req, resp);
	}

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("메인요청입니다!!!!!!!!");
		
		
		Cookie[] cookies = req.getCookies();
		String url ="04loginForm.jsp";
		System.out.println("qq");

		if (cookies != null && cookies.length > 0) {
			System.out.println("d");
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("userid")) {

					
					//resp.sendRedirect("04main.jsp");
					url = "04main.jsp";
					
				}
			}

		}

		//resp.sendRedirect("04loginForm.jsp");

		resp.sendRedirect(url);
	}
}
