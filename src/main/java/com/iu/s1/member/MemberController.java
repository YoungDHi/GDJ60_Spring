package com.iu.s1.member;

import java.util.ArrayList;
import java.util.List;

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
	public ModelAndView getMemberList(ModelAndView mv) throws Exception {
		mv.setViewName("member/memberList");
		List<MemberDTO> ar = new ArrayList<MemberDTO>();
		ar = memberService.getMemberList();
		mv.addObject("list", ar); 
		
		return mv;
	}
		
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void setMemberJoin() {
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String setMemberJoin(MemberDTO memberDTO) throws Exception{
		memberService.setMemberJoin(memberDTO);
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
