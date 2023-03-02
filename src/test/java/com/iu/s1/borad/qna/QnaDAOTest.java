package com.iu.s1.borad.qna;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;
import com.iu.s1.board.BbsDTO;
import com.iu.s1.board.qna.QnaDAO;
import com.iu.s1.util.Pager;

public class QnaDAOTest extends MyTestCase {

	@Autowired
	private QnaDAO qnaDAO;
	
//	@Test
//	public void getListTest() throws Exception {
//		Pager pager = new Pager();
//		pager.setKind("writer");
//		pager.setSearch("Kim");
//		pager.makeRow();
//		List<BbsDTO> ar = qnaDAO.getBoardList(pager);
//		assertNotEquals(0, ar.size());
//	}

}
