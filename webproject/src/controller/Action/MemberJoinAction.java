package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

public class MemberJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberDao dao = MemberDaoImp.getInstance();

		Member member = new Member();
		
		System.out.println("1");


		member.setId(req.getParameter("userid"));
		member.setPw(req.getParameter("userpw"));
		member.setName(req.getParameter("name"));
		member.setEmail(req.getParameter("email"));

		int result = dao.insertMember(member);
		
		System.out.println("2");
		
		if (result == 0) {
			
			req.setAttribute("msg", "회원가입실패");
			req.setAttribute("url", "member_join_form");
			System.out.println("3");
			
		} else {
			
			req.setAttribute("msg", "회원가입성공");
			req.setAttribute("url", "member_login_form");
			System.out.println("4");
			
		}

	
		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}
