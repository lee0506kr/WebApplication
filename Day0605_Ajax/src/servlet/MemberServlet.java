package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Member;
import service.MemberService;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	MemberService service;

	public MemberServlet() {
		service = new MemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doProc(req, resp);
	}

	protected void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		// 요청구분 : command 파라미터로 구분
		String command = req.getParameter("command");

		if (command.equals("hello")) {
			Map<String, String[]> parameters = req.getParameterMap();

			for (String key : parameters.keySet()) {
				System.out.println(key + " : " + parameters.get(key)[0]);
			}
		} else if (command.equals("checkId")) {
			String userid = req.getParameter("id"); //data 값 이름 맞추기 
			Member member = service.getMember(userid);
			String result = "";
			if (member != null) {
				// 아이디 사용불가
				result = "{\"result\" : false}";

			} else {
				// 아이디 사용 사능
				result = "{\"result\" : true}";
			}
			resp.getWriter().print(result);
		} else if (command.equals("checkEmail")) {
			String email = req.getParameter("email");

			Member member = service.getMemberByEmail(email);
			String result = "";
			if (member != null) {
				// 아이디 사용불가
				result = "{\"result\" : false}";

			} else {
				// 아이디 사용 가능
				result = "{\"result\" : true}";
			}
			resp.getWriter().print(result);
		} else if (command.equals("join")) {
			Member member = new Member();
			member.setId(req.getParameter("userid"));
			member.setEmail(req.getParameter("email"));
			member.setName(req.getParameter("name"));
			member.setPw(req.getParameter("password"));
			boolean result = service.join(member);
			String data = "";
			if (result) {
				data = "{\"result\" : true}";
			} else {
				data = "{\"result\" : false}";
			}
			resp.getWriter().print(data);

		} else if (command.equals("memberList")) {
			// 회원 목록 조회해서
			// json형태로 만들어내서 반환
			List<Member> memberList = service.getAllMembers();
			// Gson : 자바 리스트를 json형태로 쉽게 바꿔주는 라이브러리
			String result = new Gson().toJson(memberList);
			System.out.println(result);
			resp.getWriter().println(result);
		} else if (command.equals("delete")) {
			System.out.println("delete 요청 받았습니다.");
			// 지우기 위해서는 지우려는 member의 id

			String memberId = req.getParameter("id");

			boolean result = service.removeMember(memberId);

			resp.getWriter().print("(\"result\" : " + result + ")");

		}
	}// doProc end
}
