package com.iu.s1.borad.notice;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.BoardFileDTO;
import com.iu.s1.board.notice.NoticeDAO;
import com.iu.s1.board.notice.NoticeDTO;
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
	
	public void setBoardAdd() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("Title1");
		noticeDTO.setWriter("Young");
		noticeDTO.setContents("Contents1");
		int result = noticeDAO.setBoardAdd(noticeDTO);
		assertEquals(1, result);
	}
	
	@Test
	public void setFileAdd() throws Exception{
		BoardFileDTO fileDTO = new BoardFileDTO();
		fileDTO.setFileName("파일이름");
		fileDTO.setOriName("원본 이름");
		fileDTO.setNum(226L);
		int i = noticeDAO.setFileAdd(fileDTO);
		assertNotEquals(0, i);
	}

}
