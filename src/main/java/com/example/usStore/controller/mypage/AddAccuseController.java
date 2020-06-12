package com.example.usStore.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.domain.Accuse;
import com.example.usStore.service.facade.MyPageFacade;

@Controller
public class AddAccuseController {

	private MyPageFacade myPageFacade;
	
	@RequestMapping("/addAccuse") 
	public String addAccuse(@RequestParam("userId") int userId, ModelMap model) {
		 // SecondHand sh = this.itemFacade.getSecondHandItem(itemId);
		  //도메인에서 가져와야함 디비에서 불러온걸 도메인에 저장해놈 
		  Accuse accuse = new Accuse(); //자바스크립트에서 넘어온 스트링값을 저장하기 
		  
		  this.myPageFacade.insertAccuse(accuse);
		
		  System.out.println("addAccuse 컨트롤러 진입\n");
	      return "product/viewSecondHand";
	}
	
	
}
