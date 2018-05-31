package service;

import java.util.List;

import dao.Member;
import dao.MemberDao;

public class MemberService {

	// �α��� ��� : �α��� �����ϸ� true, �����ϸ� false �� ��ȯ
	// :���̵�� ��й�ȣ�� �Է¹޾Ƽ�,

	// 1. �����ͺ��̽����� ȸ������� ��ȸ
	// 1-1 : ���̵� ������, �α��� ���� return false
	// 1-2 : ���̵� ������ ��й�ȣ �˻�
	// 1-2-1 : ��й�ȣ�� ��ġ�ϸ� >> �α��� ���� return true
	// 1-2-2 : ��й�ȣ�� ��ġ���� ������ >> �α��� ���� return false

	private MemberDao dao;

	public boolean login(String id, String pw) {
		// 1. ���̵� �ִ��� ������ �˻�
		dao = new MemberDao();
		Member member = dao.selectOne(id);

		boolean result = false;
		// member�� �α����� id�� ������� ã�Ƽ� ��Ƶ� -> id�� �´°���
		//
		if (member != null) { // ���̵� ����
			// ���̵� ���� >> �Է¹��� ��й�ȣ��, ���� ��й�ȣ ��
			if (pw.equals(member.getPw())) {
				// �α��� ����
				result = true;
				// return true;
			} else {
				result = false;
				// return false;
			}
		} else { // ���̵� ����
			result = false;
			// return false;
		}
		return result;
	}

	// join() �޼��� �ۼ� , ȸ������ �޼���
	// ȸ�������� �Ķ���ͷ� �޾ƿͼ� ���̺� �ֱ�
	// join(Member) : boolean
	// �����ϸ� true �����ϸ� false
	// �Է¹��� ȸ�������� �̿��Ͽ� ���̺� ��ȸ
	// 1-1 �Է¹��� ȸ�������� ���̵�� ��ġ�ϴ� ȸ���� ������ ȸ�����Խ���
	// 1-2 ������ ȸ������ ��������
	// 1-2-1 insert���� �� ����� 1�̸� ȸ�����Լ���
	// 1-2-2 ����� 0�̸� ȸ������ ����
	public boolean join(Member member) {
		dao = new MemberDao();

		Member m = dao.selectOne(member.getId());
		boolean result = false;
		int insertResult = 0;
		System.out.println("d");

		if (m == null) {
			// ȸ������ ������ ���̵�
			// �̸��� �˻� >> �޼��� ����� :checkEmail()
			if (getAllMembers(member.getEmail())) {// ��밡���� �̸���
				insertResult = dao.insertMember(member);
				if (insertResult == 1) {// ȸ�����Լ���
					result = true;
				} else {// ȸ�����Խ���
					result = false;
				}
			} else {// ��� �Ұ����� �̸���
				result = false;
			}
		} else {// ���̵� �ߺ�
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
	// ������ �� ȸ�� �Ѹ��� ������ �����;� ��,
	public Member getMember(String id) {
		dao = new MemberDao();
		
		return dao.selectOne(id);
	
	}

	public boolean getAllMembers(String email) {
		// �̸��� ��밡��: true, ���Ұ��� false
		boolean result = true;
		// ��� ��� �����ͼ� ���� �̸����� ���Ե� ����ڰ� �ִ��� �˻�
		List<Member> memberList = dao.selectAll();

		for (Member m : memberList) {
			if (m.getEmail().equals(email)) {
				// �̸��� �ߺ�
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
