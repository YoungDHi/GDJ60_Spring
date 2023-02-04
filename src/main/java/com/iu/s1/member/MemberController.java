package com.iu.s1.member;

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
		List<MemberDTO> ar = memberService.getMemberList();
		mv.setViewName("/member/memberList");
		mv.addObject("list", ar);
		return mv;
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.GET)
	public void setMember() {
		
	}
	
	@RequestMapping(value = "memberJoin", method = RequestMethod.POST)
	public String setMember(MemberDTO memberDTO) throws Exception{
		memberService.setMember(memberDTO);
		return "redirect:./list";
	}
	
	@RequestMapping(value = "memberPage")
	public ModelAndView getMemberDetail(MemberDTO memberDTO, ModelAndView mv) throws Exception {
		memberDTO = memberService.getMemberDetail(memberDTO);
		mv.setViewName("/member/memberPage");
		mv.addObject("dto", memberDTO);
		return mv;
		
	}
	
	@RequestMapping(value = "memberLogin")
	public void memberLogin() {
		
	}
}
