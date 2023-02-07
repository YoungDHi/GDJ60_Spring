package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	public int setMemberJoin(MemberDTO memberDTO) throws Exception {
		
		int result = memberDAO.setMemberJoin(memberDTO);
		
		return result;
		
	}

}
