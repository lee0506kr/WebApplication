package controller.Action;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDaoImp;
import model.Member;

public class MemberModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		
		MemberDaoImp dao = MemberDaoImp.getInstance();
	
		
		Member member= new Member();
		
	
		
		member.setId(req.getParameter("userid"));  
		member.setPw(req.getParameter("userpw"));;
		member.setEmail(req.getParameter("email"));
		member.setName(req.getParameter("name"));

		int reuslt = dao.updateMember(member);
		
		if (reuslt > 0) {
			req.setAttribute("msg", "수정성공");
			req.setAttribute("url", "main");

		} else {

			req.setAttribute("msg", "수정 실패");
			req.setAttribute("url", "member_modify_form");

		}

		req.getRequestDispatcher("jsp/result.jsp").forward(req, resp);

	}

}
