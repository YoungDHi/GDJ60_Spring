package com.iu.s1.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class MemberCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		// controller 진입전
		// return이 true라면 다음 Controller로 진행
		// return이 false라면 다음 Controller로 진행 X
		System.out.println("Controller 진입 전 체크");
		if(request.getSession().getAttribute("member")!=null) {
			return true;
		}
		response.sendRedirect("../member/memberLogin");
		return false;
	}

}
