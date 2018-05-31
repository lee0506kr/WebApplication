package test;

import org.junit.jupiter.api.Test;

import dao.Member;
import dao.MemberDao;
import service.MemberService;

public class ServiceTest {
	// 테스트를 수행하는 메서드를 가지는 클래스

	MemberService service; //멤버서비스의 객체 서비스 생성
	MemberDao dao; //멤버디에오의 객체 다오 생성

	@Test
	public void testService() {
		service = new MemberService();

		boolean result = service.login("hong", "12345");

		System.out.println(result);

	}

	@Test
	public void daoTest() {
		dao = new MemberDao();
		// insertTest
		Member member = new Member();
		member.setId("id1");
		member.setName("홍길동");
		member.setPw("123");
		member.setEmail("hong@email.com");

		int result = dao.insertMember(member);
		System.out.println("insert 결과 : " + result);

	}

}
