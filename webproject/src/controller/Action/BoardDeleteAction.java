package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		BoardDao dao = BoardDaoImp.getInstance();
		String num = req.getParameter("num");
		String url = "jsp/result.jsp";
		int result = dao.deleteBoard(num);
		if(result >0) {
			req.setAttribute("msg","�����Ϸ�");
		}else {
			req.setAttribute("msg","��������");
		}
		req.setAttribute("url", "board_list");
		req.getRequestDispatcher(url)
		.forward(req, resp);
		
	}

}
