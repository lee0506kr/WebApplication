package controller.Action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

public class MemberLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("userid");
		String pw = req.getParameter("userpw");
		

		

		MemberDao dao = MemberDaoImp.getInstance();

		HttpSession session = req.getSession();

	

		Member meber = dao.selectOne(id);

		if (meber != null && pw.equals(meber.getPw())) {

			session.setAttribute("userid", id);

			req.setAttribute("url", "main");
			req.setAttribute("msg", "로그인");

		} else {
			req.setAttribute("url", "member_login_form");
			req.setAttribute("msg", "다시해 임마");

		}
		
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}
