package dao;


import java.util.List;

public interface IMemberDao {
	//회원가입 처리를 위해서 int로 바꿈
	
	public int insertMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(int num);
	public Member selectOne(int num);
	public Member selectOne(String id);
	public List<Member> selectAll();

}
