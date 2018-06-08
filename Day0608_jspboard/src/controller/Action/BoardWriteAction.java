package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;
import oracle.net.aso.b;

public class BoardWriteAction implements Action{
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//파라미터로 전달받은 데이터를 데이터 베이스에 넣고
		//결과 출력하고, list로 화면전환
		BoardDao dao = BoardDaoImp.getInstance();
		
		Board board = new Board();
		board.setTitle(req.getParameter("title"));
		board.setName(req.getParameter("name"));
		board.setEmail(req.getParameter("email"));
		board.setPass(req.getParameter("pass"));
		board.setContent(req.getParameter("content"));
		
		int result = dao.insertBoard(board);
		
		if(result > 0) {
			req.setAttribute("msg", "등록완료");
		}else {
			req.setAttribute("msg", "등록 중 오류가 발생하였습니다.");
		}
		req.setAttribute("url", "board_list");
		req.getRequestDispatcher("jsp/result.jsp")
		.forward(req, resp);
		
		
		
		
		
	}
	
}
