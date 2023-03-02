package com.iu.s1.member;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping(value = "memberAgree", method = RequestMethod.GET)
	public void setMemberAgree() throws Exception {
		
	}
	
	@RequestMapping(value = "list")
	public ModelAndView getMemberList(ModelAndView mv) throws Exception {
		mv.setViewName("member/memberList");
		List<MemberDTO> ar = new ArrayList<MemberDTO>();
		ar = memberService.getMemberList();
		mv.addObject("list", ar); 
		
		return mv;
	}
		
	@RequestMapping(value = "memberAdd", method = RequestMethod.GET)
	public void setMemberAdd() {
		
	}
	
	@RequestMapping(value = "memberAdd", method = RequestMethod.POST)
	public String setMemberAdd(MemberDTO memberDTO) throws Exception{
		int result = memberService.setMemberAdd(memberDTO);
		return "redirect:../";
	}

	@RequestMapping(value = "memberLogin", method = RequestMethod.GET)
	public void getMemberLogin() {
		
	}
	
	@RequestMapping(value = "memberLogin", method = RequestMethod.POST)
	public String getMemberLogin(MemberDTO memberDTO, HttpServletRequest request) throws Exception{
		memberDTO = memberService.getMemberLogin(memberDTO);
		
		if(memberDTO !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", memberDTO);
		}
		return "redirect:../";
	}
	
	@RequestMapping(value = "memberLogout", method = RequestMethod.GET)
	public ModelAndView getMemberLogout(HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		session.invalidate();
		mv.setViewName("redirect:../");
		return mv;
	}
	
	@RequestMapping(value = "memberPage", method = RequestMethod.GET)
	public ModelAndView getMemberPage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO = memberService.getMemberPage(memberDTO);
		mv.addObject("dto", memberDTO);
		mv.setViewName("/member/memberPage");
		
		return mv;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.GET)
	public ModelAndView setMemberUpdate(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		
		memberDTO = memberService.getMemberPage(memberDTO);
		mv.addObject("dto", memberDTO);
		mv.setViewName("member/memberUpdate");
		return mv;
	}
	
	@RequestMapping(value = "memberUpdate", method = RequestMethod.POST)
	public String setMemberUpdate(MemberDTO memberDTO, HttpSession session) throws Exception {
		MemberDTO memberDTO2 = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(memberDTO2.getId());
		int result = memberService.setMemberUpdate(memberDTO);
		if(result > 0) {
			session.setAttribute("member", memberDTO);
		}
		String st = "redirect:./memberPage";
		
		
		
		return st;
	}
	
	//--------------------
	
	
	
}
