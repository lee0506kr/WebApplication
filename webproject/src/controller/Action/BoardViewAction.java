package controller.Action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//�󼼺��� ��û
		//�����ͺ��̽����� �Խñ� �ϳ��� ������ �����ͼ�
		//�󼼺��� �������� ����
		String url = "jsp/boardView.jsp";
		BoardDao dao = BoardDaoImp.getInstance(); 
		String num = req.getParameter("num");
		System.err.println("���� ��ȣ : "+req.getParameter("num"));
		dao.updateReadCount(num);
		
		
		Board board = dao.selectOne(req.getParameter("num"));
		req.setAttribute("board", board);
		req.getRequestDispatcher(url)
		.forward(req, resp);
		
	}
}





