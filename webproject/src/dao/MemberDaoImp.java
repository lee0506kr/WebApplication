package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Member;

public class MemberDaoImp implements MemberDao {

	private static MemberDaoImp instance;
	private MemberDaoImp dao;

	public static MemberDaoImp getInstance() {
		if (instance == null) {
			instance = new MemberDaoImp();
		}
		return instance;
	}

	public int insertMember(Member member) {
		String sql = "insert into member " + " values(?,?,?,?,sysdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateMember(Member member) {
		String sql ="update member set "
				+ "pw = ?, "
				+ "name = ?, "
				+ "email = ? "
				+ "where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getId());
			result = pstmt.executeUpdate();
			System.out.println(sql);
			System.out.println(member.getPw());
			System.out.println(member.getName());
			System.out.println(member.getEmail());
			System.out.println(member.getId());
			System.out.println("result:"+result);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
				if (pstmt != null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public int deleteMember(String id) {
		String sql = "delete from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			result = pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Member selectOne(String id) {
		String sql = "select * from member where id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member result = null;

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new Member();

				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				result.setName(rs.getString("name"));
				result.setEmail(rs.getString("email"));
				result.setRegDate(rs.getDate("regdate"));
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	
	
	public Member selectOneByEmail(String email) {
		String sql = "select * from member where email = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member result = null;

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				result = new Member();
				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				result.setName(rs.getString("name"));
				result.setEmail(rs.getString("email"));

			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Member> selectAll() {
		String sql = "select * from member";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Member> result = new ArrayList<Member>();

		try {
			conn = ConnectionProvider.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("email"));
				member.setRegDate(rs.getDate("regdate"));
				result.add(member);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public boolean modify(Member member) {
		dao = new MemberDaoImp();
		int updateResult = dao.updateMember(member);
		boolean result = false;
		if (updateResult > 0) {
			result = true;
		}
		return result;

	}

	public boolean join(Member member) {
		dao = new MemberDaoImp();

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

	public boolean getAllMembers(String email) {
		dao = new MemberDaoImp();
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
	public Member getMember(String id) {
		dao = new MemberDaoImp();
		
		return dao.selectOne(id);
	
	}
	

	public List<Member> getAllMembers() {
		dao = new MemberDaoImp();

		return dao.selectAll();
	}

}