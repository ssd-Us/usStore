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
	
	@ModelAttribute("itemForm")		  //"itemForm"揶쏆빘猿쒙옙�벥 占쎌뵠�뵳占� 筌욑옙占쎌젟
	public ItemForm formBacking(HttpServletRequest request, @RequestParam("productId") int productId) {  // accessor method 
		ItemForm itemForm = new ItemForm(); //itemForm揶쏆빘猿� 占쎄문占쎄쉐
		
		itemForm.setProductId(autoDetectPid(request.getRemoteAddr(), productId));	//productId占쎈툡占쎈굡 �룯�뜃由곤옙�넅
		
		return itemForm; //占쎄쉭占쎈�∽옙肉� "itemForm"占쎌뵠�뵳袁⑹몵嚥∽옙 占쏙옙占쎌삢占쎈쭡
	}
	
	private int autoDetectPid(String remoteAddr, int productId) {	//�룯�뜃由곤옙�넅 揶쏉옙
		return productId;
	}
	
	@RequestMapping(value="/shop/item/addItem.do", method = RequestMethod.GET)		//筌ｏ옙 item.jsp 占쎌뒄筌ｏ옙
	public String step1(@ModelAttribute("item") ItemForm itemForm, 
			@RequestParam("productId") int productId, Model model) {
		System.out.println("item controller");
		model.addAttribute("productId", productId);		// item.jsp占쎈퓠 <productId> 占쎌읈占쎈뼎 
		return "product/item";	//form view(item.jsp)嚥∽옙 占쎌뵠占쎈짗
	}
	
	@RequestMapping(value="/shop/item/addItem2.do", method = RequestMethod.POST)	//item.jsp 占쎈쨲 占쎌뿯占쎌젾 占쎌뜎 占쎈뼄占쎌벉 jsp占쎌뒄筌ｏ옙
	public String submit(@RequestParam("productId") int productId, HttpServletRequest rq) {
		System.out.println("addItem2.do");
		HttpSession httpSession = rq.getSession(true); //占쎌뵠沃섓옙 占쎄쉭占쎈�∽옙�뵠 占쎌뿳占쎈뼄筌롳옙 域뱄옙 占쎄쉭占쎈�∽옙�뱽 占쎈즼占쎌젻雅뚯눊��, 占쎄쉭占쎈�∽옙�뵠 占쎈씨占쎌몵筌롳옙 占쎄퉱嚥≪뮇�뒲 占쎄쉭占쎈�∽옙�뱽 占쎄문占쎄쉐占쎈립占쎈뼄.
				
		String itemController = "";
		 
//		if (result.hasErrors()) {	return formViewName;	}	//野껓옙筌앾옙 占쎌궎�몴占� 獄쏆뮇源�占쎈뻻 item.jsp嚥∽옙 占쎈뼄占쎈뻻 占쎌뵠占쎈짗
		
		Item item = new Item(rq.getParameter("title"), rq.getParameter("description"), Integer.parseInt(rq.getParameter("unitCost")), 
				Integer.parseInt(rq.getParameter("qty")), rq.getParameter("tag1"), rq.getParameter("tag2"), rq.getParameter("tag3"), 
				rq.getParameter("tag4"), rq.getParameter("tag5"));
		
		httpSession.setAttribute("item", item);	//generate item session
		
		/*itemImpl.insertItem()*/
		switch(productId) {
			case 0 : 
				itemController = "redirect:/shop/groupBuying/addItem.do?productId=" + productId;
				break;
			case 1 :
				itemController = "redirect:/shop/auction/addItem.do?productId=" + productId;
				break;
			case 2 : 
				itemController = "redirect:/shop/secondHand/addItem.do?productId=" + productId;
				break;
			case 3 : 
				itemController = "redirect:/shop/handMade/addItem.do?productId=" + productId;
				break;
		}
	
		return itemController;
	}
	
}