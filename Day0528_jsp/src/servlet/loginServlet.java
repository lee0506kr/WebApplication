package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class loginServlet extends HttpServlet {
	//'login' ��û �޾Ƽ� ó��, post �������
	
	String myId = "hong123";
	String myPw = "12345";
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("��¥ �޾����׿�??!!!");
		
		//���̵�� ��й�ȣ ��û���� �����ͼ� ���� ������ �ִ� ���̵�� ��й�ȣ ��
		
		String id = request.getParameter("userid"); 
		String pw = request.getParameter("userpw");
			
			if(id !=null && id.equals(myId)){
				//���̵� ����
				if(pw !=null && pw.equals(myPw)){
					
					RequestDispatcher dispatcher
					= request.getRequestDispatcher("03loginsuccess.jsp");
					dispatcher.forward(request, response);
				}else{
					
//	 				out.print("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					request.setAttribute("msg", "��й�ȣ�� Ʋ�Ƚ��ϴ�.");
					RequestDispatcher dispatcher
					= request.getRequestDispatcher("03loginfail.jsp");
					dispatcher.forward(request, response);
				}			
			}else{
//	 			out.print("���̵� Ʋ�Ƚ��ϴ�.");
				request.setAttribute("msg", "���̵� Ʋ�Ƚ��ϴ�.");
				RequestDispatcher dispatcher
				= request.getRequestDispatcher("03loginfail.jsp");
				dispatcher.forward(request, response);
			}
		
		
		
		
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}






