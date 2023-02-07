package com.iu.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.s1.MyTestCase;

public class MemberDAOTest extends MyTestCase {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Test
	public void setMemberJoin() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("sadasd");
		memberDTO.setPw("qwewq");
		memberDTO.setMemberName("so");
		memberDTO.setMemberPhone("123.123");
		memberDTO.setEmail("seas@asd.asd");
		int result = memberDAO.setMemberJoin(memberDTO);
		assertEquals(1, result);
		
	}
	

}
