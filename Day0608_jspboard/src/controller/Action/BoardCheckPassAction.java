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
//		�Ķ���Ϳ��� �Խñ� ��ȣ ��, ��й�ȣ �����ͼ� 
//		�ش�Խñ��� ��й�ȣ�� �Է¹��� ��й�ȣ�� ������ 
//		����ȭ������ �̵�, �ƴϸ�, ��й�ȣ �Է�ȭ������ �̵�
		String num = req.getParameter("num");
		String pass = req.getParameter("pass");
		BoardDao dao  = BoardDaoImp.getInstance();
		
		Board bard = dao.selectOne(num);
		String url = "";
		if(bard.getPass().equals(pass)) {
			url = "jsp/checkSuccess.jsp";
		}else {
			url = "jsp/boardCheckPass.jsp";
			req.setAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
		}
		req.getRequestDispatcher(url)
		.forward(req, resp);
		
	}
	
}



