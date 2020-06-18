package com.example.usStore.controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.example.usStore.domain.Item;
import com.example.usStore.service.facade.ItemFacade;

@Controller
public class ItemFormController {
	private String formViewName = "product/item";
	
	@Autowired
	private ItemFacade itemFacade;
	
	@ModelAttribute("item")		  
	public ItemForm formBacking(HttpServletRequest rq, @RequestParam("productId") int productId) {  // accessor method 
		System.out.println("item controller formBacking");
		HttpSession session = rq.getSession(false);
		ItemForm itemForm;
		if((ItemForm) session.getAttribute("itemForm") != null) {
			System.out.println("session alive");
			ItemForm itemFormSession = (ItemForm) session.getAttribute("itemForm");
			System.out.println(itemFormSession);
			itemForm = new ItemForm();
			itemForm.setUnitCost(itemFormSession.getUnitCost());
			itemForm.setTitle(itemFormSession.getTitle());
			itemForm.setDescription(itemFormSession.getDescription());
			itemForm.setViewCount(itemFormSession.getViewCount());
			itemForm.setQty(itemFormSession.getQty());
			itemForm.setTag1(itemFormSession.getTag1());
			itemForm.setTag2(itemFormSession.getTag2());
			itemForm.setTag3(itemFormSession.getTag3());
			itemForm.setTag4(itemFormSession.getTag4());
			itemForm.setTag5(itemFormSession.getTag5());
			
			System.out.println("itemForm setting: " + itemForm);
			return itemForm;
		}
		else {
			System.out.println("session null");
			itemForm = new ItemForm();
			itemForm.setProductId(autoDetectPid(rq.getRemoteAddr(), productId));	// itemForm.productId initializable
			return itemForm;
		}
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
	
	@RequestMapping(value="/shop/item/addItem2.do", method = RequestMethod.POST)	// detailItem.jsp 
	public String submit(@ModelAttribute("item") ItemForm itemForm, BindingResult bindingResult, 
			@RequestParam("productId") int productId, HttpServletRequest rq, Model model) {
		System.out.println("item.addItem2.do");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "title", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "description", "required");
		if(itemForm.getDescription().length() > 0 && itemForm.getDescription().length() < 11) {
			bindingResult.rejectValue("description", "tooShortDesc");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "unitCost", "required");
		try {
			int unitCost = itemForm.getUnitCost();
		} catch(NumberFormatException e) {	
			bindingResult.rejectValue("unitCost", "mustInt");
		} 
		
		if(itemForm.getUnitCost() <= 0) {
			bindingResult.rejectValue("unitCost", "tooSmall");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(bindingResult, "qty", "required");
		if(itemForm.getQty() <= 0) {
			bindingResult.rejectValue("qty", "tooSmall");
		}
		
		String itemController = "";
		HttpSession httpSession = rq.getSession(true); //�뜝�럩逾졿쾬�꼻�삕 �뜝�럡�돪�뜝�럥占썩댙�삕占쎈턄 �뜝�럩肉녑뜝�럥堉꾤춯濡녹삕 �윜諭꾩삕 �뜝�럡�돪�뜝�럥占썩댙�삕占쎈굵 �뜝�럥利쇔뜝�럩�졎�썒�슣�닁占쏙옙, �뜝�럡�돪�뜝�럥占썩댙�삕占쎈턄 �뜝�럥�뵪�뜝�럩紐든춯濡녹삕 �뜝�럡�돮�슖�돦裕뉛옙�뮧 �뜝�럡�돪�뜝�럥占썩댙�삕占쎈굵 �뜝�럡臾멨뜝�럡�뎽�뜝�럥由썲뜝�럥堉�.
				
		System.out.println("itemForm : " + itemForm);
		
		httpSession.setAttribute("itemForm", itemForm);	//generate item session
		
		if (bindingResult.hasErrors()) {	//寃�利� �삤瑜� 諛쒖깮�떆 �몢踰덉㎏ �뤌�쑝濡� �룎�븘媛�
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