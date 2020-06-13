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
	
	@ModelAttribute("itemForm")		  //"itemForm"媛앹껜�쓽 �씠由� 吏��젙
	public ItemForm formBacking(HttpServletRequest request, @RequestParam("productId") int productId) {  // accessor method 
		ItemForm itemForm = new ItemForm(); //itemForm媛앹껜 �깮�꽦
		
		itemForm.setProductId(autoDetectPid(request.getRemoteAddr(), productId));	//productId�븘�뱶 珥덇린�솕
		
		return itemForm; //�꽭�뀡�뿉 "itemForm"�씠由꾩쑝濡� ���옣�맖
	}
	
	private int autoDetectPid(String remoteAddr, int productId) {	//珥덇린�솕 媛�
		return productId;
	}
	
	@RequestMapping(value="/shop/item/addItem.do", method = RequestMethod.GET)		//泥� item.jsp �슂泥�
	public String step1(@ModelAttribute("item") ItemForm itemForm, 
			@RequestParam("productId") int productId, Model model) {
		System.out.println("item controller");
		model.addAttribute("productId", productId);		// item.jsp�뿉 <productId> �쟾�떖 
		return "product/item";	//form view(item.jsp)濡� �씠�룞
	}
	
	@RequestMapping(value="/shop/item/addItem2/{productId}", method = RequestMethod.POST)	//item.jsp �뤌 �엯�젰 �썑 �떎�쓬 jsp�슂泥�
	public String submit(Item item, ItemForm itemForm,  
			BindingResult result, @PathVariable("productId") int productId, 
			HttpServletRequest rq, Model model) {
		HttpSession httpSession = rq.getSession(true); //�씠誘� �꽭�뀡�씠 �엳�떎硫� 洹� �꽭�뀡�쓣 �룎�젮二쇨퀬, �꽭�뀡�씠 �뾾�쑝硫� �깉濡쒖슫 �꽭�뀡�쓣 �깮�꽦�븳�떎.
				
		String view = "";
		
		if (result.hasErrors()) {	return formViewName;	}	//寃�利� �삤瑜� 諛쒖깮�떆 item.jsp濡� �떎�떆 �씠�룞
		
		itemForm.setTitle(rq.getParameter("title"));
		itemForm.setDescription(rq.getParameter("description"));	
		itemForm.setUnitCost(Integer.parseInt(rq.getParameter("unitCost")));
		itemForm.setQty(Integer.parseInt(rq.getParameter("qty")));
		itemForm.setTag1(rq.getParameter("tag1"));
		itemForm.setTag2(rq.getParameter("tag2"));
		itemForm.setTag3(rq.getParameter("tag3"));
		itemForm.setTag4(rq.getParameter("tag4"));
		itemForm.setTag5(rq.getParameter("tag5"));
		
		
		
		httpSession.setAttribute("itemForm", itemForm);	//itemForm �꽭�뀡 �깮�꽦, �궗�슜�옄 �엯�젰媛믪쓣 itemForm �꽭�뀡�뿉 ���옣
		
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