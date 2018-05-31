package test;

import org.junit.jupiter.api.Test;

import dao.Member;
import dao.MemberDao;
import service.MemberService;

public class ServiceTest {
	// �׽�Ʈ�� �����ϴ� �޼��带 ������ Ŭ����

	MemberService service; //��������� ��ü ���� ����
	MemberDao dao; //����𿡿��� ��ü �ٿ� ����

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
		member.setName("ȫ�浿");
		member.setPw("123");
		member.setEmail("hong@email.com");

		int result = dao.insertMember(member);
		System.out.println("insert ��� : " + result);

	}

}
