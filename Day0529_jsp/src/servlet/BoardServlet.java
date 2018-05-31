package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Dispatch;

import model.Board;


@WebServlet("/abc")
public class BoardServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProc(req, resp);
	}

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		Board board = new Board();
		
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String email = req.getParameter("email");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		
		board.setName(name);
		board.setPass(pass);
		board.setEmail(email);
		board.setTitle(title);
		board.setContent(content);
		
		
		req.setAttribute("board", board);
		RequestDispatcher dispatcher;
		dispatcher = req.getRequestDispatcher("07boardInfo.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
	
	
	
	

}
