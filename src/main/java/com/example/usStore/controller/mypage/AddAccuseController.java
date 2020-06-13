package com.example.usStore.controller.mypage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.domain.Accuse;
import com.example.usStore.service.facade.MyPageFacade;

@Controller
public class AddAccuseController {

	private MyPageFacade myPageFacade;
	
	@Autowired
	public void setMyPageFacade(MyPageFacade myPageFacade) {
		this.myPageFacade = myPageFacade;
	}


	@RequestMapping("/addAccuse.do") 
	public String addAccuse(@RequestParam("userId") String userId,
			@RequestParam("itemId") int itemId, 
			@RequestParam("productId") int productId, HttpServletRequest request, Model model) {
		//신고하고자 하는 판매자 아이디를 파라미터로 받는다.	
		  System.out.println("addAccuse 컨트롤러 진입\n");
		  Accuse accuse = new Accuse();
		  //자바스크립트에서 넘어온 신고사유 setReason
		  // 로그인아이디가 setVictim();
		  // 판매자 아이디가 setAttacker(userId) 
		  this.myPageFacade.insertAccuse(accuse);
		  model.addAttribute("itemId", itemId);
		  model.addAttribute("productId", productId);
		  if(productId == 0)
			  return "redirect:/shop/groupBuying/viewItem.do";
		  else if(productId ==1)
			  return "redirect:/shop/auction/viewItem.do";
		  else if(productId ==2)
			  return "redirect:/shop/secondHand/viewItem.do";
		  else if(productId ==3)
			  return "redirect:/shop/handMade/viewItem.do";
		  else
			  return "/index";
	}
	
	
}
