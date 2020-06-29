package com.example.usStore.controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.service.ItemFormValidator;

@Controller
public class ItemFormController {
	
	   @ModelAttribute("item")        
	   public ItemForm formBacking(HttpServletRequest rq, @RequestParam("productId") int productId) {  // accessor method 
	      System.out.println("item controller formBacking");
	      HttpSession session = rq.getSession(false);
	      ItemForm itemForm;
	      if((ItemForm) session.getAttribute("itemForm") != null) {   //ITEM세션이 존재하는 경우
	         itemForm = (ItemForm) session.getAttribute("itemForm");
	         if(itemForm.getProductId() == productId) {   //수정 또는 입력 1,2단계 이동중인 경우
	            return itemForm;
	         }
	         else
	            session.removeAttribute("itemForm");   //도중에 나가서 다른 판매 입력폼으로 들어간 경우
	      }
	       itemForm = new ItemForm();
	         itemForm.setProductId(autoDetectPid(rq.getRemoteAddr(), productId));   // itemForm.productId initializable
	         return itemForm;
	   }
	
	private int autoDetectPid(String remoteAddr, int productId) {	// itemForm.productId initialize
		return productId;
	}
	
	@RequestMapping(value="/shop/item/addItem.do", method = RequestMethod.GET)		// go to item.jsp
	public String step1(@ModelAttribute("item") ItemForm itemForm, 
			@RequestParam("productId") int productId, Model model) {
		System.out.println("item controller");
		
		model.addAttribute("productId", productId);		// deliver [productId] to item.jsp
		return "product/item";	//form view(item.jsp)
	}
	
	@RequestMapping(value="/shop/item/addItem2.do", method = RequestMethod.POST)	// addGb.jsp 
	public String submit(@ModelAttribute("item") ItemForm itemForm, BindingResult bindingResult, 
			@RequestParam("productId") int productId, HttpServletRequest rq, Model model) {
		System.out.println("item.addItem2.do");
		
		new ItemFormValidator().validate(itemForm, bindingResult);
		
		String itemController = "";
		HttpSession httpSession = rq.getSession(true); 
				
		System.out.println("itemForm : " + itemForm);
		
		httpSession.setAttribute("itemForm", itemForm);	//generate item session
		
		if (bindingResult.hasErrors()) {	//유효성 검증 에러 발생시
			model.addAttribute("productId", productId);
			return "product/item";
		}
		
		switch(productId) {
			case 0 : 
				itemController = "redirect:/shop/groupBuying/addItem2.do?productId=" + productId;
				break;
			case 1 :
				itemController = "redirect:/shop/auction/addItem2.do?productId=" + productId;
				break;
			case 2 : 
				itemController = "redirect:/shop/secondHand/addItem2.do?productId=" + productId;
				break;
			case 3 : 
				itemController = "redirect:/shop/handMade/addItem2.do?productId=" + productId;
				break;
		}
	
		return itemController;
	}
	
	@RequestMapping("/shop/item/index.do") //go index(remove sessions)
	public String goIndex(@RequestParam("productId") int productId)
	{
		String url = "";
		
		switch(productId) {
			case 0 : 
					url = "redirect:/shop/groupBuying/index.do";
					break;
			case 1 :
					url = "redirect:/shop/auction/index.do";
					break;
			case 2 : 
					url = "redirect:/shop/secondHand/index.do";
					break;
			case 3 : 
					url = "redirect:/shop/handMade/index.do";
					break;
		}
		
		return url;
	}
}