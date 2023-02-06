package com.iu.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	@RequestMapping(value = "list")
	public String getMemberList(ModelAndView mv) throws Exception {
		String result = "member/memberList";
	
		return result;
	}
		
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void setMember() {
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String setMember(MemberDTO memberDTO) throws Exception{
		memberService.memberJoin(memberDTO);
		return "redirect:./list";
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
