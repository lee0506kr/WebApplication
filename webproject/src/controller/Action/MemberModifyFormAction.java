package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dao.MemberDaoImp;
import model.Member;

public class MemberModifyFormAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "jsp/modifyForm.jsp";
		
		HttpSession session = req.getSession();
		
		MemberDao dao = MemberDaoImp.getInstance();
		
		String id = (String) session.getAttribute("userid");
		
		Member member = dao.selectOne(id);
		
		req.setAttribute("member", member);
		req.getRequestDispatcher(url).forward(req, resp);
		
	}
	

}
