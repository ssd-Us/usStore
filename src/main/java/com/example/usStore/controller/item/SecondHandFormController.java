package com.example.usStore.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.usStore.domain.Item;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes("secondHandForm")
public class SecondHandFormController {
	
	private ItemFacade itemFacade;
	
	@Autowired
	public void setItemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}

	@RequestMapping("/shop/secondHand/listItem.do")
	public String secondHandList(
			@RequestParam("productId") int productId, 
			ModelMap model) throws Exception{
		PagedListHolder<SecondHand> itemList = new PagedListHolder<SecondHand>(this.itemFacade.getSecondHandList());
		itemList.setPageSize(3);
		System.out.println("여기는 게시물 목록 컨트롤러\n ");
		model.addAttribute("itemList", itemList);
		model.addAttribute("productId", productId);
		return "product/secondHand"; 
	}	
	
	@RequestMapping("/shop/secondHand/listItem2.do")
	public String secondHandList2(
			@RequestParam("pageName") String page,
			@RequestParam("productId") int productId,
			@ModelAttribute("itemList") PagedListHolder<Item> itemList,
			 ModelMap model) throws Exception {
		if ("next".equals(page)) {
			itemList.nextPage();
		}
		else if ("previous".equals(page)) {
			itemList.previousPage();
		}
		model.addAttribute("itemList", itemList);
		model.addAttribute("productId", productId);
		return "product/secondHand";
	}
	
	@RequestMapping("/shop/secondHand/viewItem.do") 
	public String viewSecondHand(@RequestParam("itemId") int itemId,
			@RequestParam("productId") int productId, ModelMap model) {
		  SecondHand sh = this.itemFacade.getSecondHandItem(itemId);
	      model.addAttribute("sh", sh);
	      model.addAttribute("productId", productId);
	      return "product/viewSecondHand";
	}
	 
	@RequestMapping("/shop/secondHand/addItem.do")
	public String goItem(@RequestParam("productId") int productId) {
	      return "redirect:/shop/item/addItem.do?productId=" + productId;
	}
	
	@ModelAttribute("secondHandForm")
	public SecondHandForm createSecondHandForm() {
		return new SecondHandForm();
	}
	
	@RequestMapping("/shop/secondHand/addItem/${itemId}")
	public ModelAndView handleRequest(
			@PathVariable String itemId,
			@ModelAttribute("secondHandForm") SecondHand secondHand 
			) throws Exception {
		/*
		 * if (cart.containsItemId(workingItemId)) {
		 * cart.incrementQuantityByItemId(workingItemId); } else { boolean isInStock =
		 * this.petStore.isItemInStock(workingItemId); Item item =
		 * this.petStore.getItem(workingItemId); cart.addItem(item, isInStock); } return
		 * new ModelAndView("Cart", "cart", cart);
		 */
		return null;
	}
	
	
	@RequestMapping(value="/shop/secondHand/addItem.do", method = RequestMethod.GET)
	public String step2(
	         @ModelAttribute("SecondHand") SecondHandForm secondHandForm, 
	         @RequestParam("productId") int productId, Model model) {
	      
	      System.out.println("secondHandForm controller");   //print toString
	      model.addAttribute("productId", productId);
	      return  "product/addSecondHand";  
	}
	
}
