package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Message;
import service.MessageService;

public class MessageServlet extends HttpServlet {
	private MessageService service;
	public MessageServlet() {
		service = MessageService.getInstance();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doPorc(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		doPorc(req,resp);
	}
	
	protected void doPorc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		
		
		String contextPath = req.getContextPath();
		String reqUri = req.getRequestURI();
		
		System.out.println("��û���� : " + reqUri);
		/* ����¡ ó������ ���� messageList */
//		if(reqUri.equals(contextPath+"/messageList")) {
//			System.out.println("1111111");
//			//��� �޽��� ����� �����ͼ� �Ӽ��� ��Ƽ�
//			//ǥ���� ȭ������ ����
//			List<Message> messageList 
//			= service.getAllMessages();
//			req.setAttribute("messageList", messageList);
//			req.getRequestDispatcher("messageList.jsp")
//			.forward(req, resp);
//			
//			
//		}
		if(reqUri.equals(contextPath+"/messageList")) {
			//1. �������� ǥ�õ� ��� ��������
			int pageNumber = 1;
			String strPageNumber = req.getParameter("page");
			
			if(strPageNumber != null) {
				pageNumber = Integer.parseInt(strPageNumber);
			}
			//������ �׺���̼� ����� ���� ������ ����
			Map<String, Object> viewData 
			= service.getMessageList(pageNumber);
			
			req.setAttribute("viewData",viewData);
			
			req.getRequestDispatcher("messageList.jsp")
			.forward(req, resp);
			
			
			
		}else if(reqUri.equals(contextPath+"/write")){
			//�����͸� �Ķ���Ϳ��� �޾ƿͼ� ���񽺷� ���� 
			String name = req.getParameter("guestName");
			String password = req.getParameter("password");
			String message = req.getParameter("message");
			
			boolean result 
			= service.writeMessage(name, password, message);
			
			if(result==true) {
				req.setAttribute("msg", "���� ��ϵǾ����ϴ�.");
			}else {
				req.setAttribute("msg", "��� �����Ͽ����ϴ�.");
			}
			req.setAttribute("url", "messageList");
			req.getRequestDispatcher("result.jsp")
			.forward(req, resp);
		}else if(reqUri.equals(contextPath+"/confirmDeletion")) {
			req.getRequestDispatcher("confirmDeletion.jsp")
			.forward(req, resp);
		}else if(reqUri.equals(contextPath+"/pwCheck")) {
			//�ش� id�� �Խñ��� ��й�ȣ��, �Է¹��� ��й�ȣ�� ������ �� 
			String strId = req.getParameter("id");
			String password = req.getParameter("password");
			
			int id = Integer.parseInt(strId);
			
			boolean result = 
			service.deleteMessage(id, password);
			String msg = "���� �����Ͽ����ϴ�.";
			if(result) {
				msg = "���������� ���� �Ͽ����ϴ�.";
			}
			req.setAttribute("msg", msg);
			req.setAttribute("url", "messageList");
			
			req.getRequestDispatcher("result.jsp")
			.forward(req, resp);
			
		}
	}
}







