package service;

import java.util.List;

import dao.MemberDao;
import model.Member;

public class MemberService {
	//Dao ��ü�� ����� �����鼭 ���
	MemberDao memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	
	//������ �鰡��˴ϴ�. ex �α���:���� or ����
	public boolean login(String id, String pw) {
		//1. ������ ���̽����� �Է¹��� ���̵�� ������ ȸ�� ������ ��ȸ
		Member member = memberDao.selectOne(id);
		if(member != null) {
			//�ش� ���̵��� ȸ�������� ���� 
			if(member.getPw().equals(pw)) {
				//�α��� ����
				return true;
			}else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	public boolean join(Member member) {
		//���޹��� �Ķ���͸� ������ ���̽��� insert �����ϸ� true, �����ϸ� false
		int insertResult = memberDao.insertMember(member);
		boolean result = false;
		if(insertResult == 1) {
			result =true;
		}
		
		return result;
	}
	public boolean modify(Member member) {
		int updateResult = memberDao.updateMember(member);
		boolean result = false;
		if(updateResult >0) {
			result = true;
		}
		return result;
	}
	//������ �� ȸ�� �Ѹ��� ������ �����;� ��,
	public Member getMember(String id) {
		return memberDao.selectOne(id);
	}
	public Member getMemberByEmail(String email) {
		return memberDao.selectOneByEmail(email);
	}
	
	public List<Member> getAllMembers(){
		return memberDao.selectAll();
	}
	
	public boolean removeMember(String id) {
		int result = memberDao.deleteMember(id);
		
		if(result > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	
}
