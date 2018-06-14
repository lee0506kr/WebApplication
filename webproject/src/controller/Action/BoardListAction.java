package controller.Action;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.BoardDaoImp;
import model.Board;

public class BoardListAction implements Action {

	// ���������� ǥ�õ� �޽����� ����
	private static final int NUM_OF_MESSAGE_PER_PAGE = 5;
	// �ѹ��� ǥ�õ� �׺���̼��� ����
	private static final int NUM_OF_NAVI_PAGE = 5;
	

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("BoardListAction");

		int pageNumber = 1;
		
		String strPageNumber = req.getParameter("page");
		
		
		if (strPageNumber != null) {
			
			pageNumber = Integer.parseInt(strPageNumber);

		}

		BoardDao dao = BoardDaoImp.getInstance();

		Map<String, Object> viewData = getBoardList(pageNumber);

		req.setAttribute("viewData", viewData);

		req.getRequestDispatcher("jsp/boardList.jsp").forward(req, resp);

	}
	

	public Map<String, Object> getBoardList(int pageNumber) {

		Map<String, Object> viewData = new HashMap<String, Object>();

		int firstRow = 0;
		int endRow = 0;
		int totalCount = 0;

		totalCount = BoardDaoImp.selectCount();

		firstRow = (pageNumber - 1) * NUM_OF_MESSAGE_PER_PAGE + 1;
		endRow = pageNumber * NUM_OF_MESSAGE_PER_PAGE;

		List<Board> boardList = BoardDaoImp.selectList(firstRow, endRow);

		viewData.put("currentPage", pageNumber);
		viewData.put("boardList", boardList);
		viewData.put("pageTotalCount", calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNumber));
		viewData.put("endPage", getEndPage(pageNumber));
		// �ʿ��� ������ : �� �������� ����, �� �޽����� ����
		// ���� ������,����������

		return viewData;

	}

	private int calPageTotalCount(int totalCount) {
		// �� �������� ���� ��ȯ : �� �޽�������, �������� �޽��� �� �� ������ ��� ����

		/*
		 * �޽��� �� : 1~10 ������ �� : 1 �޽��� �� : 11~20 ������ �� : 2 100 10 200 20 333 34 33.3
		 */
		int pageTotalCount = 0;
		if (totalCount != 0) {
			pageTotalCount = (int) Math.ceil(((double) totalCount / NUM_OF_MESSAGE_PER_PAGE));
		}
		return pageTotalCount;
	}

	public int getStartPage(int pageNum) {
		// 6 >>> 1
		// 16 >>> 11
		// 30 >> 21
		// ���������� >> ����������

		// ���� ������ 6�̶�� ����, �׺���̼��� 5����
		// 6���� ����
		int startPage = ((pageNum - 1) / NUM_OF_NAVI_PAGE) * NUM_OF_NAVI_PAGE + 1;

		return startPage;
	}

	public int getEndPage(int pageNum) {
		/*
		 * 6 >> 10 10 >> 10
		 */
		/* 11 >> 15 */
		// (16 - 1) / 5 >>> (3 + 1 ) * 5 = 20;
		int endPage = (((pageNum - 1) / NUM_OF_NAVI_PAGE) + 1) * NUM_OF_NAVI_PAGE;
		return endPage;
	}

}
