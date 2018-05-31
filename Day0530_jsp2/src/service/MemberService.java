package service;

import java.util.List;

import dao.Member;
import dao.MemberDao;

public class MemberService {

	// 로그인 기능 : 로그인 성공하면 true, 실패하면 false 을 반환
	// :아이디와 비밀번호를 입력받아서,

	// 1. 데이터베이스에서 회원목록을 조회
	// 1-1 : 아이디가 없으면, 로그인 실패 return false
	// 1-2 : 아이디가 있으면 비밀번호 검사
	// 1-2-1 : 비밀번호가 일치하면 >> 로그인 성공 return true
	// 1-2-2 : 비밀번호가 일치하지 않으면 >> 로그인 실패 return false

	private MemberDao dao;

	public boolean login(String id, String pw) {
		// 1. 아이디가 있는지 없는지 검사
		dao = new MemberDao();
		Member member = dao.selectOne(id);

		boolean result = false;
		// member에 로그인한 id와 같은사람 찾아서 담아둠 -> id는 맞는거임
		//
		if (member != null) { // 아이디 있음
			// 아이디 있음 >> 입력받은 비밀번호와, 기존 비밀번호 비교
			if (pw.equals(member.getPw())) {
				// 로그인 성공
				result = true;
				// return true;
			} else {
				result = false;
				// return false;
			}
		} else { // 아이디 없음
			result = false;
			// return false;
		}
		return result;
	}

	// join() 메서드 작성 , 회원가입 메서드
	// 회원정보를 파라미터로 받아와서 테이블에 넣기
	// join(Member) : boolean
	// 성공하면 true 실패하면 false
	// 입력받은 회원정보를 이용하여 테이블 조회
	// 1-1 입력받은 회원정보의 아이디와 일치하는 회원이 있으면 회원가입실패
	// 1-2 없으면 회원가입 절차시작
	// 1-2-1 insert했을 때 결과가 1이면 회원가입성공
	// 1-2-2 결과가 0이면 회원가입 실패
	public boolean join(Member member) {
		dao = new MemberDao();

		Member m = dao.selectOne(member.getId());
		boolean result = false;
		int insertResult = 0;
		System.out.println("d");

		if (m == null) {
			// 회원가입 가능한 아이디
			// 이메일 검사 >> 메서드 만들기 :checkEmail()
			if (getAllMembers(member.getEmail())) {// 사용가능한 이메일
				insertResult = dao.insertMember(member);
				if (insertResult == 1) {// 회원가입성공
					result = true;
				} else {// 회원가입실패
					result = false;
				}
			} else {// 사용 불가능한 이메일
				result = false;
			}
		} else {// 아이디 중복
			result = false;
		}
		return result;
	}

	public boolean modify(Member member) {
		dao = new MemberDao();
		
		int updateResult = dao.updateMember(member);
		boolean result = false;
		if(updateResult >0) {
			result = true;
		}
		return result;
		
	
	}
	// 수정할 때 회원 한명의 정보를 가져와야 함,
	public Member getMember(String id) {
		dao = new MemberDao();
		
		return dao.selectOne(id);
	
	}

	public boolean getAllMembers(String email) {
		// 이메일 사용가능: true, 사용불가능 false
		boolean result = true;
		// 모든 목록 가져와서 현재 이메일이 포함된 사용자가 있는지 검사
		List<Member> memberList = dao.selectAll();

		for (Member m : memberList) {
			if (m.getEmail().equals(email)) {
				// 이메일 중복
				result = false;
				break;
			}
		}
		return result;
	}

	public List<Member> getAllMembers() {
		dao = new MemberDao();
		
		return dao.selectAll();
	}
}
