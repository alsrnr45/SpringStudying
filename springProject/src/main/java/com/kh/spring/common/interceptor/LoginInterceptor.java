package com.kh.spring.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * 해당 이 클래스를 Interceptor 역할을 수행하도록 하고자 한다면 HandlerInterceptorAdapter 클래스 상속받도록 해야함
 * 
 * preHandle (전처리) : DispatcherServlet에서 해당 요청을 받아주는 컨트롤러를 호출하기 전에 낚아채는 영역
 * postHandle (후처리) : 컨트롤러가 다 실행되고 DispatcherServlet으로 뷰 정보가 리턴되는 순간 낚아채는 영역
 */

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// boolean 값 리턴
		// 이 때 true가 리턴되면 기존의 요청 흐름대로 해당 Controller를 제대로 실행함
		//     false가 리턴되면 해당 Controller 실행 안 됨
		
		// Interceptor가 사용되는 경우 : 로그인한 회원인지 아닌지 체크, 로그인한 회원의 권한 체크 
		// session에 loginUser가 있냐 없냐로 로그인 여부 판단
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUser") == null) { // 로그인 전
			
			session.setAttribute("alertMsg", "로그인 후에 이용가능한 서비스입니다.");
			// url 재요청하기 ( redirect가 아니라 sendRedirect 방식으로)
			response.sendRedirect(request.getContextPath());
			
			return false;
		} else { // 로그인 후
			
			return true;
		}
		/*
		 * Interceptor 클래스를 만들어서 작성만하고 끝이 아니라, bean 등록을 해야함 
		 * 어떤 요청을 가로챌건지 설정하면서 해당 Interceptor 클래스를 빈으로 등록 해야 함
		 * @어노테이션 or xml 등록방법
		 * => servlet-context.xml 여기다가 등록할 것임(root-context.xml, spring-security.xml 등 xml 종류 중에서)
		 * 
		 */
	}
	
}
