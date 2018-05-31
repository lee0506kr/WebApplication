package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Member;
import service.MemberService;

public class MemberServlet extends HttpServlet {

	private MemberService service;

	public MemberServlet() {

		service = new MemberService();

	}

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

		// post���
		req.setCharacterEncoding("utf-8");

		System.out.println("URI : " + req.getRequestURI());
		// ���⼭ ��û ����
		System.out.println("Context: " + req.getContextPath());

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		MemberService memberservice = new MemberService();

		HttpSession session = req.getSession();

		if (uri.equals(contextPath + "/login")) {
			// �α��� ��û
			String userid = req.getParameter("userid");
			String userpw = req.getParameter("userpw");

			// String url=null;
			// String msg =null;

			System.out.println("�α��� ��û�Դϴ�.!!!");
			// ������� Ŭ������ login();

			if (memberservice.login(userid, userpw) == true) {
				session.setAttribute("userid", userid);
				session.setAttribute("userpw", userpw);
				// msg = "�α��� ����";

				resp.sendRedirect("main.jsp");
			} else {
				// msg = "�α��� ����";
				resp.sendRedirect("loginForm.jsp");
			}
			// req.setAttribute("msg", msg);
			// req.setAttribute("url", url);
			// req.getRequestDispatcher("result.jsp").forward(req, resp);

		} else if (uri.equals(contextPath + "/loginForm")) {
			// �α��� ����û
			System.out.println("�α��� ȭ�� ��û�Դϴ�.!!!");
			req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
		} else if (uri.equals(contextPath + "/logout")) {
			System.out.println("�α׾ƿ� ��û�Դϴ�. ");
			req.getSession().removeAttribute("userid");
			resp.sendRedirect("loginForm");

		} else if (uri.equals(contextPath + "/memberList")) {
			// MemberServiceŬ������ ��û�ؼ� ȸ�� ��ϰ�������
			List<Member> memberList = service.getAllMembers();
			// ������ ����� memberList.jsp�� ����
			req.setAttribute("memberList", memberList);
			req.getRequestDispatcher("memberList.jsp").forward(req, resp);

		} else if (uri.equals(contextPath + "/modifyForm")) {
			// ������ ȸ�������Ͱ� ���޵Ǿ�� �Ѵ�.
			String userid = (String) req.getSession().getAttribute("userid");
			Member member = service.getMember(userid);

			req.setAttribute("member", member);
			req.getRequestDispatcher("modifyForm.jsp").forward(req, resp);
			

		} else if(uri.equals(contextPath+"/modify")) {
			//��û�� ����ִ� �Ķ���͸� �����ͼ� �ش� ������ ������ 
			//������ ���̽� ������Ʈ
			String userid = req.getParameter("userid");
			String userpw = req.getParameter("userpw");
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			
			Member member = new Member();
			member.setId(userid);
			member.setPw(userpw);
			member.setName(name);
			member.setEmail(email);
			
			boolean result = service.modify(member);
			//�����̵� ���е�  �������� 
			String msg = "";
			String url = "mainForm";
			
			if(result) {
				msg = "�����Ͽ����ϴ�.";
			}else {
				msg = "���� �����Ͽ����ϴ�.";
			}
//			resp.sendRedirect("main");
			
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			
			req.getRequestDispatcher("result.jsp")
			.forward(req, resp);
			

		} else if (uri.equals(contextPath + "/joinForm")) {

			System.out.println("joinForm ��û!!");

			req.getRequestDispatcher("joinForm.jsp").forward(req, resp);

		} else if (uri.equals(contextPath + "/join")) {
			// ��û �Ķ���Ϳ��� �Է¿� �ʿ��� ������ �޾ƿͼ� service�� �Ѱ��ֱ�

			Member member = new Member();

			member.setId(req.getParameter("userid"));
			member.setPw(req.getParameter("userpw"));
			member.setName(req.getParameter("name"));
			member.setEmail(req.getParameter("email"));

			boolean result = service.join(member);
			// ȸ������ �����̸� loginForm ��û
			// ȸ������ �����̸� joinForm ��û
			if (result) {
				resp.sendRedirect("loginForm");
			} else {
				resp.sendRedirect("joinForm");
			}

		} else if (uri.equals(contextPath + "/mainForm")) {

			System.out.println("mainForm ��û!!");

			req.getRequestDispatcher("main.jsp").forward(req, resp);

		} 

		// else if(uri.equals(contextPath+"/success")) {
	
		// System.out.println("�α��� ȭ�� ��û�Դϴ�!!!");
		// req.getRequestDispatcher("success.jsp")
		// .forward(req, resp);
		
		// }else if(uri.equals(contextPath+"/fail")) {
		//
		// System.out.println("�α��� ȭ�� ��û�Դϴ�!!!");
		// req.getRequestDispatcher("fail.jsp")
		// .forward(req, resp);
		//
		// }

	}

}
