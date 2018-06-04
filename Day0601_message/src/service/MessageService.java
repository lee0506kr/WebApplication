package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.MessageDao;
import model.Message;

public class MessageService {
	private static MessageService instance;
	private MessageDao messageDao;
	//���������� ǥ�õ� �޽����� ����
	private static final int NUM_OF_MESSAGE_PER_PAGE = 10;
	//�ѹ��� ǥ�õ� �׺���̼��� ����
	private static final int NUM_OF_NAVI_PAGE = 10;
	
	
	private MessageService() {
		messageDao = MessageDao.getInstance();
	}

	public static MessageService getInstance() {
		if (instance == null) {
			instance = new MessageService();
		}
		return instance;
	}

	// ��� �޽��� ��� ��������
	public List<Message> getAllMessages() {
		return messageDao.selectAll();
	}

	public boolean writeMessage(String name, String pw, String message) {
		Message m = new Message();
		m.setName(name);
		m.setPassword(pw);
		m.setMessage(message);
		int result = messageDao.insertMessage(m);
		if (result > 0) {
			return true;
		} else {
			return false;
		}
	}
	public boolean deleteMessage(int id, String password) {
		Message message = messageDao.selectOne(id);
		
		if(message != null 
				&& message.getPassword().equals(password)) {
			messageDao.deleteMessage(id);
			return true;
		}
		return false;
	}
	public Map<String, Object> getMessageList(int pageNumber) {
		//���� �������� ǥ�õ� �޽��� ��� �������� 
		//ȭ�鿡 ǥ�õ� �׺���̼��� ������ ��� �� ����
		
		//ȭ���� ǥ���ϱ� ���� �����͵��� ����
		Map<String, Object> viewData
		 = new HashMap<String,Object>();
		
		
		
		//1. ���� �������� ǥ�õ� �޽��� ��� ��������
		/* 
		 *         firstRow   endRow
		 * 1������  :   1         10
		 * 2������ :   11         20
		 * 3������ :   21         30
		 * 4������ :   31         40 
		 * */
		int firstRow = 0;
		int endRow =0;
		int totalCount = 0;  //�� �޽����� ����, �� ���������� ���ϱ� ���� �ʿ�
		
		totalCount  = messageDao.selectCount(); //�Ѹ޽��� ����
		
		firstRow = (pageNumber-1)*NUM_OF_MESSAGE_PER_PAGE +1;
		endRow = pageNumber*NUM_OF_MESSAGE_PER_PAGE;
		//List<Message> selectList(int,int)
		
		List<Message> messageList 
		  = messageDao.selectList(firstRow, endRow);
		viewData.put("currentPage",pageNumber);
		viewData.put("messageList", messageList);
		viewData.put("pageTotalCount",calPageTotalCount(totalCount));
		viewData.put("startPage", getStartPage(pageNumber));
		viewData.put("endPage", getEndPage(pageNumber));
		//�ʿ��� ������ : �� �������� ����, �� �޽����� ����
		//���� ������,����������
		
		return viewData;
	}
	private int calPageTotalCount(int totalCount) {
		//�� �������� ���� ��ȯ : �� �޽�������, �������� �޽��� �� �� ������ ��� ����
		
		/*
		* �޽��� �� : 1~10     ������ �� : 1
		* �޽��� �� : 11~20     ������ �� : 2
		* 100  10
		* 200 20
		* 333 34
		* 33.3
		*/
		int pageTotalCount = 0;
		if(totalCount != 0) {
			pageTotalCount = (int)Math.ceil(
					((double)totalCount / NUM_OF_MESSAGE_PER_PAGE));
		}
		return pageTotalCount;
	}
	public int getStartPage(int pageNum) {
		//6  >>> 1
		//16 >>> 11
		//30 >> 21 
		//���������� >> ����������
		
		//���� ������ 6�̶�� ����, �׺���̼��� 5����
		//6���� ����
		int startPage = 
				((pageNum-1)/NUM_OF_NAVI_PAGE)*NUM_OF_NAVI_PAGE + 1;
		
		return startPage;
	}
	public int getEndPage(int pageNum) {
		/*6  >>  10
		  10 >> 10*/
		/*11 >> 15*/
		// (16 - 1) / 5 >>> (3 + 1 ) * 5 =  20;
		int endPage 
		= (((pageNum-1)/NUM_OF_NAVI_PAGE)+1)
		* NUM_OF_NAVI_PAGE;
		return endPage;
	}
	
	
	
	
	
	
	

}
