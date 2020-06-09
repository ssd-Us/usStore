package com.example.usStore.controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.usStore.domain.Item;
import com.example.usStore.service.impl.ItemImpl;

public class ItemFormController {
	private String formViewName = "Product/item";
	
	@Autowired
	private ItemImpl itemImpl;
	
	@GetMapping("/shop/item/addItem/{productId}")		//첫 item.jsp 요청
	public String step1(@PathVariable("productId") int productId, Model model) {
		model.addAttribute("productId", productId);		// item.jsp에 <productId> 전달 
		return formViewName;	//form view(item.jsp)로 이동
	}
	
	@RequestMapping(value="/shop/item/addItem2/{productId}", method = RequestMethod.POST)	//item.jsp 폼 입력 후 다음 jsp요청
	public String submit(Item item, ItemForm itemForm,  
			BindingResult result, @PathVariable("productId") int productId, 
			HttpServletRequest rq, Model model) {
		HttpSession httpSession = rq.getSession(true); //이미 세션이 있다면 그 세션을 돌려주고, 세션이 없으면 새로운 세션을 생성한다.
				
		String view = "";
		
		if (result.hasErrors()) {	return formViewName;	}	//검증 오류 발생시 item.jsp로 다시 이동
		
		itemForm.setTitle(rq.getParameter("title"));
		itemForm.setDescription(rq.getParameter("description"));	
		itemForm.setUnitCost(Integer.parseInt(rq.getParameter("unitCost")));
		itemForm.setQty(Integer.parseInt(rq.getParameter("qty")));
	//	itemForm.setTag(rq.getParameter("tag"));
		
		httpSession.setAttribute("itemForm", itemForm);	//itemForm 세션 생성, 사용자 입력값을 itemForm 세션에 저장
		
		/*itemImpl.insertItem()*/
		switch(productId) {
			case 0 : 
				view = "Product/addGroupBuying";
				break;
			case 1 :
				view = "Product/addAuction";
				break;
			case 2 : 
				view = "Product/addSecondHand";
				break;
			case 3 : 
				view = "Product/addHandMade";
				break;
		}
	
		return view;
	}
	
}