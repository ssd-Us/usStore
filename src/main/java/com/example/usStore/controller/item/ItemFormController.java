package com.example.usStore.controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.domain.Item;
import com.example.usStore.service.facade.ItemFacade;

@Controller
public class ItemFormController {
	private String formViewName = "product/item";
	
	@Autowired
	private ItemFacade itemFacade;
	
	@ModelAttribute("itemForm")		  
	public ItemForm formBacking(HttpServletRequest request, @RequestParam("productId") int productId) {  // accessor method 
		ItemForm itemForm = new ItemForm();
		
		itemForm.setProductId(autoDetectPid(request.getRemoteAddr(), productId));	// itemForm.productId initializable
		
		return itemForm;
	}
	
	private int autoDetectPid(String remoteAddr, int productId) {	// itemForm.productId initializable
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
	public String submit(@ModelAttribute("item") ItemForm itemForm, 
			@RequestParam("productId") int productId, HttpServletRequest rq) {
		System.out.println("item.addItem2.do");
		HttpSession httpSession = rq.getSession(true); //占쎌뵠沃섓옙 占쎄쉭占쎈�∽옙�뵠 占쎌뿳占쎈뼄筌롳옙 域뱄옙 占쎄쉭占쎈�∽옙�뱽 占쎈즼占쎌젻雅뚯눊��, 占쎄쉭占쎈�∽옙�뵠 占쎈씨占쎌몵筌롳옙 占쎄퉱嚥≪뮇�뒲 占쎄쉭占쎈�∽옙�뱽 占쎄문占쎄쉐占쎈립占쎈뼄.
				
		System.out.println("itemForm : " + itemForm);
		String itemController = "";
		 
//		if (result.hasErrors()) {	return formViewName;	}	//野껓옙筌앾옙 占쎌궎�몴占� 獄쏆뮇源�占쎈뻻 item.jsp嚥∽옙 占쎈뼄占쎈뻻 占쎌뵠占쎈짗
		
//		ItemForm itemform = new ItemForm(itemForm.getTitle(), itemForm.getUserId(), itemForm.getProductId(), itemForm.getDescription(), itemForm.getUnitCost(), 
//										itemForm.getQty(), rq.getParameter("tag1"), rq.getParameter("tag2"), rq.getParameter("tag3"), 
//				rq.getParameter("tag4"), rq.getParameter("tag5"));
		
		httpSession.setAttribute("itemForm", itemForm);	//generate item session
		
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
	
}