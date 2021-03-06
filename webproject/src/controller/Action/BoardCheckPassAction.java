package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		파라미터에서 게시글 번호 와, 비밀번호 가져와서 
//		해당게시글의 비밀번호와 입력받은 비밀번호가 같으면 
//		수정화면으로 이동, 아니면, 비밀번호 입력화면으로 이동
		String num = req.getParameter("num");
		String pass = req.getParameter("pass");
		BoardDao dao  = BoardDaoImp.getInstance();
		
		Board bard = dao.selectOne(num);
		String url = "";
		if(bard.getPass().equals(pass)) {
			url = "jsp/checkSuccess.jsp";
		}else {
			url = "jsp/boardCheckPass.jsp";
			req.setAttribute("msg", "비밀번호가 틀렸습니다.");
		}
		req.getRequestDispatcher(url)
		.forward(req, resp);
		
	}
	
}



