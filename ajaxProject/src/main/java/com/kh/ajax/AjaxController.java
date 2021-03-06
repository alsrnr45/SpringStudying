package com.kh.ajax;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
public class AjaxController {
	
	/*
	 * * 응답데이터를 돌려줄 때의 방식
	 * 
	 * 1. HttpServletResponse 객체를 이용해서 응답하는 방법
	 *   (기존 jsp/servlet때 stream을 통해서 응답했던 방식)
	
	@RequestMapping("ajax1.do")
	public void ajaxMethod1(String name, int age, HttpServletResponse response) throws IOException {
		// 요청처리 다 했다는 가정하에 현재 그 페이지에 다시 돌려줄 응답데이터있을 경우
		String responseData = "응답 문자열 : " + name + "는 " + age + "살 입니다";
		
		response.setContentType("text/html; charset=utf-8");
		response.getWriter().print(responseData);
	}
	 */
	/*
	 * 2. 응답할 데이터를 문자열로 곧바로 리턴 (@ResponseBody)
	 *    원래 문자열 리턴하면 포워딩방식이었음! (해당 뷰를 탐색함)
	 *    따라서 내가 리턴하는 문자열이 응답뷰가 아닌 응답데이터야 라는 걸 선언해야함
	 *    그걸 선언하는 어노테이션이 ResponseBody
	 *    
	 *    단, 응답데이터에 한글이 있을 경우 @RequestMapping에서 produces속성으로 contentType 기술해야됨
	 */

	@ResponseBody
	@RequestMapping(value="ajax1.do", produces="text/html; charset=utf-8")
	public String ajaxMethod1(String name, int age) {
		String responseData = "응답 문자열 : " + name + "는 " + age + "살 입니다";
		
		return responseData;
	}
	
	/*
	 * 여러개의 응답데이톨 응답하고자 할 때의 방법
	 */
	@ResponseBody
	@RequestMapping("ajax2.do")
	public String ajaxMethod2(int userNo){
		// Member m = mService.selectMember(userNo);
		Member m = new Member("user01", "pass01", "홍길동", 20, "hong@kh.com", "01055847777");
		/*
		// response.getWriter().print(m); 객체형태가 아닌 String 타입으로 반환 
		JSONObject jObj = new JSONObject(); // JSON Lib 필요함 {}
		jObj.put("userId", m.getUserId()); // {userId:"user01"}
		jObj.put("userPwd", m.getUserPwd());
		jObj.put("userName", m.getUserName());
		jObj.put("age", m.getAge());
		jObj.put("email", m.getEmail());
		jObj.put("phone", m.getPhone());
		
		// response 객체 안쓸거임(HttpServletResponse)
		//response.setContentType("application/json; charset=utf-8");
		//response.getWriter().print(jObj);
		
		return jObj.toJSONString();
		*/
		
		// gson 활용하면 저거 위에 한거 다 피료없음
		// new Gson().toJson(응답할 데이터, 응답할 String)
		return new Gson().toJson(m);
	}
	
	// 전체 회원 조회 요청
	@ResponseBody
	@RequestMapping(value="ajax3.do", produces="application/json; charset=utf-8")
	public String ajaxMethod3() {
		
		// ArrayList<Member> list = mService.selectMemberList();
		ArrayList<Member> list = new ArrayList<Member>();
		
		list.add(new Member("user01","pass01","홍길동",20,"aaa@naver.com","01055744442"));
		list.add(new Member("user02","pass02","홍길",21,"bb@naver.com","01055744443"));
		list.add(new Member("user03","pass03","홍동",22,"cc@naver.com","01055744444"));
		
		// [ {}, {}, {} ]
		
		return new Gson().toJson(list);
	}
}
