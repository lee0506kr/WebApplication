package dao;

import java.util.List;

import model.Board;

public interface BoardDao {
	//insert,update,delete,selectOne,selectAll
	public int insertBoard(Board board);
	public int updateBoard(Board board);
	public int deleteBoard(String num);
	public Board selectOne(String num);
	public List<Board> selectAll();
	public int updateReadCount(String num);
	
}
//   >>>>> interface BoardDao 를 구현하는 
//         BoardDaoImp 클래스 작성하세요 . 



