import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	// ������ ������ ��û�� �޾Ƽ� ó���ϴ� ��
	// HttpServlet�� ��û�� �޾Ƽ� ó���ϴ� �޼��� : doGet,doPost

	// doGet�޼���: get����� ��û�� �޾Ƽ� ó���ϰڴ�.

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �ؾ� �� �� ��û�޾Ƽ� ó���ϱ�
		// 1.���û�� �޾Ƽ� ó���� ���ΰ��� ���ؼ� ���� : @WebServlet
		//System.out.println("hello��û�� �޾ҽ��ϴ�.!!");
		//�ְ� �ϴ����� ��û�� �޾Ƽ� ȭ���� �����ϴ� ��
		//request:��û�� ���� ������ ��� �ִ� ��ü
		//response: ���信 ���� ������ ��� �ִ� ��ü
		
		
		PrintWriter pw = resp.getWriter();
		resp.setCharacterEncoding("UTF-8");
		
		pw.print("<h1>Hello!!</h1>");
		pw.print("<br>");
		pw.print("<hr>");


		
	}

}
