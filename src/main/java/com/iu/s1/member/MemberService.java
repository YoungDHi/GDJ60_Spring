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
	
	
	public int setMemberAdd(MemberDTO memberDTO) throws Exception {
		int result = memberDAO.setMemberAdd(memberDTO);
		result = memberDAO.setMemberRoleAdd(memberDTO);
		
		return result;
		
	}

	public MemberDTO getMemberLogin(MemberDTO memberDTO) throws Exception{
		//memberDTO : Client에서 입력한 ID, PW
		MemberDTO result = memberDAO.getMemberLogin(memberDTO);
		//result : ID와 일치하는 모든 정보
		
		//pw check
		if(result != null && memberDTO.getPw().equals(result.getPw())) {
			memberDTO.setPw(null);
			return memberDTO;
		} else {
			return null;
		}
	}
	
	public MemberDTO getMemberPage(MemberDTO memberDTO) throws Exception {
		return memberDAO.getMemberLogin(memberDTO);
	}
	
	public int setMemberUpdate(MemberDTO memberDTO) throws Exception {
		return memberDAO.setMemberUpdate(memberDTO);
	}
	
}
