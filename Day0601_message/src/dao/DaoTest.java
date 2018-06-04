package dao;

import org.junit.Test;

import model.Message;

public class DaoTest {
	
	@Test
	public void doTest() {
		MessageDao dao = MessageDao.getInstance(); 
		for(int i=0;i<40;i++) {
			Message m = new Message();
			m.setPassword("123");
			m.setName("name"+(i+1));
			m.setMessage("Hello!! world!! message"+ i);
			dao.insertMessage(m);
		}
	}
	
}
