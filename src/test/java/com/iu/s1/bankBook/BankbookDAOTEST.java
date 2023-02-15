package com.iu.s1.bankBook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class BankbookDAOTEST extends MyTestCase {

	@Autowired
	private BankBookDAO bankBookDAO;
	
	@Test
	public void getBankBookListTest() throws Exception {
		
		List<BankBookDTO> ar = bankBookDAO.getBankBookList();
		assertNotEquals(0, ar.size());
		
	}
	
	@Test
	public void getBankBookDetailTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO(); 
		bankBookDTO.setBookNumber(1L);
		bankBookDTO = bankBookDAO.getBankBookDetail(bankBookDTO);
		assertNotNull(bankBookDTO);
		
	}

	
	@Test
	public void setBankBookAddTest() throws Exception {
		
		for(int i=0;i<30;i++) {
			Random r = new Random();
			double d = r.nextDouble();
			int num = (int)(d*1000);
			d = num/10.0;
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(bankBookDAO.getBookNumber());
		bankBookDTO.setBookName("kt위즈 적금"+i);
		bankBookDTO.setBookDetail("ds");
		bankBookDTO.setBookRate(d);
		bankBookDTO.setBookSale(1);
		int result = bankBookDAO.setBankBookAdd(bankBookDTO);
		}
		//assertEquals(1, result);
	}
	
	@Test
	public void setBankBookDelete() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(1L);
		int result = bankBookDAO.setBankBookDelete(bankBookDTO);
		assertEquals(1, result);
	}
}
