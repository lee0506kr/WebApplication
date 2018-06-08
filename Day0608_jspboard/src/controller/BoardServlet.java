package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Action.Action;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {

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
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		// if-else ����� �ƴ϶�..��û���� ���ο� Ŭ������ ���� ����
		// ���� ���ε�
		// ACtionFactory : ���� ��û�� ó���� Ŭ������ ��ü�� ����� �ִ� ����
		// ������ �츮�� ȣ���ϴ� �޼���� Action execute �� ȣ�� ->interface

		String command = req.getParameter("command");
		
		
		//���� ��ü�� ����� �ִ� ����� �ϴ� Ŭ���� �ۼ�
		//ActionFactory : action ��ü�� ����� �ֱ� ����
		Action action = ActionFactory.getAction(command);
		
		action.execute(req, resp);

	}
}
