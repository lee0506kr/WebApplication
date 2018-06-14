package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	BoardDao dao = BoardDaoImp.getInstance();
		
		Board board = new Board();
		
		
		
		board.setNum(Integer.parseInt(req.getParameter("num")));
		board.setTitle(req.getParameter("title"));
		board.setName(req.getParameter("name"));
		board.setEmail(req.getParameter("email"));
		board.setPass(req.getParameter("pass"));
		board.setContent(req.getParameter("content"));
		
		int result = dao.updateBoard(board);
		
		if(result > 0) {
			req.setAttribute("msg", "�����Ϸ�");
		}else {
			req.setAttribute("msg", "������ ���� �Ͽ����ϴ�.");
		}
		req.setAttribute("url", "board_list");
		req.getRequestDispatcher("jsp/result.jsp")
		.forward(req, resp);

	}

}
