package com.iu.s1.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public List<MemberDTO> getMemberList() throws Exception {
		return memberDAO.getMemberList();
		
	}
	
	public int setMember(MemberDTO memberDTO) throws Exception {
		return memberDAO.setMember(memberDTO);
		
	}
	
	public MemberDTO getMemberDetail(MemberDTO memberDTO) throws Exception {
		return memberDAO.getMemberDetail(memberDTO);
	}
	
}
