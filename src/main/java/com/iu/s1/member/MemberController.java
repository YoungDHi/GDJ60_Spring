package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	@RequestMapping(value = "memberJoin")
	public String join() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setMemberId("PARK");
		memberDTO.setMemberPassword("qwesda");
		memberDTO.setMemberName("PARKYOUNGHYUN");
		memberDTO.setMemberAddress("qweqwe");
		memberDTO.setMemberPhone("010-7894-1523");
		memberDTO.setMemberEmail("qwe@qwe.qwe");
		
		int result = memberService.memberJoin(memberDTO);
		
		if(result>0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		return "/member/memberJoin";
	}

	@RequestMapping(value = "memberLogin")
	public void login() {
		
	}
	
	@RequestMapping(value = "memberPage")
	public ModelAndView myPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/member/memberPage");
		return mv;
	}
}
