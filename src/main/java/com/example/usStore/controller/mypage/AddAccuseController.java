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
		  //�����ο��� �����;��� ��񿡼� �ҷ��°� �����ο� �����س� 
		  Accuse accuse = new Accuse(); //�ڹٽ�ũ��Ʈ���� �Ѿ�� ��Ʈ������ �����ϱ� 
		  
		  this.myPageFacade.insertAccuse(accuse);
		
		  System.out.println("addAccuse ��Ʈ�ѷ� ����\n");
	      return "product/viewSecondHand";
	}
	
	
}
