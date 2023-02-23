package com.iu.s1.borad.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.util.Pager;

public class NoticeDAOTest extends MyTestCase {

	@Autowired
	private NoticeDAO noticeDAO;
	
	@Test
	public void getBoardList() throws Exception {
		Pager pager = new Pager();
		pager.setKind("title");
		pager.setSearch("공지");
		//long count = noticeDAO.getTotalCount(pager);
		
		assertNotEquals(0, pager);
		
	}

}
