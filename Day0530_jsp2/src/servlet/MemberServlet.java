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

		// post방식
		req.setCharacterEncoding("utf-8");

		System.out.println("URI : " + req.getRequestURI());
		// 여기서 요청 구분
		System.out.println("Context: " + req.getContextPath());

		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		MemberService memberservice = new MemberService();

		HttpSession session = req.getSession();

		if (uri.equals(contextPath + "/login")) {
			// 로그인 요청
			String userid = req.getParameter("userid");
			String userpw = req.getParameter("userpw");

			// String url=null;
			// String msg =null;

			System.out.println("로그인 요청입니다.!!!");
			// 멤버서비스 클래스의 login();

			if (memberservice.login(userid, userpw) == true) {
				session.setAttribute("userid", userid);
				session.setAttribute("userpw", userpw);
				// msg = "로그인 성공";

				resp.sendRedirect("main.jsp");
			} else {
				// msg = "로그인 실패";
				resp.sendRedirect("loginForm.jsp");
			}
			// req.setAttribute("msg", msg);
			// req.setAttribute("url", url);
			// req.getRequestDispatcher("result.jsp").forward(req, resp);

		} else if (uri.equals(contextPath + "/loginForm")) {
			// 로그인 폼요청
			System.out.println("로그인 화면 요청입니다.!!!");
			req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
		} else if (uri.equals(contextPath + "/logout")) {
			System.out.println("로그아웃 요청입니다. ");
			req.getSession().removeAttribute("userid");
			resp.sendRedirect("loginForm");

		} else if (uri.equals(contextPath + "/memberList")) {
			// MemberService클래스에 요청해서 회원 목록가져오기
			List<Member> memberList = service.getAllMembers();
			// 가져온 목록을 memberList.jsp에 전달
			req.setAttribute("memberList", memberList);
			req.getRequestDispatcher("memberList.jsp").forward(req, resp);

		} else if (uri.equals(contextPath + "/modifyForm")) {
			// 기존의 회원데이터가 전달되어야 한다.
			String userid = (String) req.getSession().getAttribute("userid");
			Member member = service.getMember(userid);

			req.setAttribute("member", member);
			req.getRequestDispatcher("modifyForm.jsp").forward(req, resp);
			

		} else if(uri.equals(contextPath+"/modify")) {
			//요청에 담겨있는 파라미터를 가져와서 해당 정보를 가지고 
			//데이터 베이스 업데이트
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
			//성공이든 실패든  메인으로 
			String msg = "";
			String url = "mainForm";
			
			if(result) {
				msg = "변경하였습니다.";
			}else {
				msg = "변경 실패하였습니다.";
			}
//			resp.sendRedirect("main");
			
			req.setAttribute("msg", msg);
			req.setAttribute("url", url);
			
			req.getRequestDispatcher("result.jsp")
			.forward(req, resp);
			

		} else if (uri.equals(contextPath + "/joinForm")) {

			System.out.println("joinForm 요청!!");

			req.getRequestDispatcher("joinForm.jsp").forward(req, resp);

		} else if (uri.equals(contextPath + "/join")) {
			// 요청 파라미터에서 입력에 필요한 값들을 받아와서 service로 넘겨주기

			Member member = new Member();

			member.setId(req.getParameter("userid"));
			member.setPw(req.getParameter("userpw"));
			member.setName(req.getParameter("name"));
			member.setEmail(req.getParameter("email"));

			boolean result = service.join(member);
			// 회원가입 성공이면 loginForm 요청
			// 회원가입 실패이면 joinForm 요청
			if (result) {
				resp.sendRedirect("loginForm");
			} else {
				resp.sendRedirect("joinForm");
			}

		} else if (uri.equals(contextPath + "/mainForm")) {

			System.out.println("mainForm 요청!!");

			req.getRequestDispatcher("main.jsp").forward(req, resp);

		} 

		// else if(uri.equals(contextPath+"/success")) {
	
		// System.out.println("로그인 화면 요청입니다!!!");
		// req.getRequestDispatcher("success.jsp")
		// .forward(req, resp);
		
		// }else if(uri.equals(contextPath+"/fail")) {
		//
		// System.out.println("로그인 화면 요청입니다!!!");
		// req.getRequestDispatcher("fail.jsp")
		// .forward(req, resp);
		//
		// }

	}

}
