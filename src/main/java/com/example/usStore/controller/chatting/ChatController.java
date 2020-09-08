package com.example.usStore.controller.chatting;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.usStore.controller.mypage.UserSession;

@Controller
public class ChatController {

	@GetMapping(value = "/chatting.do")
	public ModelAndView chat(ModelAndView mv, HttpServletRequest request) {

		System.out.println("여기는 채팅 컨트롤러 입니다. 진입 성공 ");
		mv.setViewName("webchat");
		//사용자 정보 출력(세션) - 시큐리티를 통한 세션관리를 권장 //
//		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		System.out.println("user name :" + user.getUsername());
//				
//		System.out.println("normal chat page");
//		
//		mv.addObject("userid", user.getUsername());	
		  
		HttpSession session = request.getSession(false);
		if (session.getAttribute("userSession") != null) { 
			//수정할 사안 ) 애초에 인터셉터로 채팅전에 로그인체크 걸어주기 
	         UserSession userSession = (UserSession)session.getAttribute("userSession") ;
	         if (userSession != null) {// attacker = 판매자 아이디, victim = 세션 유저 아이디
	     		mv.addObject("userId", userSession.getAccount().getUserId());
	         }
		}
		
		return mv;
	}
	
	      
}
