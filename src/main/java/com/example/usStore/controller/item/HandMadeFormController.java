package com.example.usStore.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.usStore.domain.HandMade;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"handMadeForm", "itemList"})
public class HandMadeFormController {

	private ItemFacade itemFacade;

	@Autowired
	public void setitemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}

	// HandMade 리스트 초기 화면 출력시 실행되는 Controller
	@RequestMapping("/shop/handMade/listItem.do")
	public String listHandMade (
			@RequestParam("productId") int productId, ModelMap model) throws Exception {
  
		PagedListHolder<HandMade> itemList = new PagedListHolder<HandMade>(this.itemFacade.getHandMadeList());
		itemList.setPageSize(4);
		
		model.put("itemList", itemList);
		return "product/handMade";
	}
	
	// 페이지 넘어갈때 실행되는 Controller
	@RequestMapping("shop/handMade/listItem2.do")
	public String listHandMade2 (
			@ModelAttribute("itemList") PagedListHolder<HandMade> itemList,
			@RequestParam("pageName") String page,
			ModelMap model) throws Exception {
		if ("next".equals(page)) {
			itemList.nextPage();
		}
		else if ("previous".equals(page)) {
			itemList.previousPage();
		}
		model.put("itemList", itemList);
		return "product/handMade";
	}
	
	@RequestMapping("/shop/handMade/addItem.do")
	public String goItem(@RequestParam("productId") int productId) {
	      return "redirect:/shop/item/addItem.do?productId=" + productId;
	}
	
	@ModelAttribute("handMadeForm")
	public SecondHandForm createSecondHandForm() {
		return new SecondHandForm();
	}
	
	@RequestMapping("/shop/handMade/addItem/${itemId}")
	public ModelAndView handleRequest(
			@PathVariable String itemId,
			@ModelAttribute("handMadeForm") HandMade handMade 
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
	
	@RequestMapping("/shop/handMade/viewItem.do")
	public String handMadeView(@RequestParam("itemId") int itemId, 
			@RequestParam("productId") int productId, ModelMap model) {
		HandMade handMade = this.itemFacade.getHandMadeById(itemId);
		
		model.addAttribute("handMade", handMade);
		model.addAttribute("productId", productId);
		return "product/viewHandMade";
	}
	
	@RequestMapping("/shop/handMade/deleteItem.do")
	public String delete(@RequestParam("productId") int productId, @RequestParam("itemId") int itemId, ModelMap model) {
		this.itemFacade.deleteItem(itemId);
		return "redirect:/shop/handMade/listItem.do?productId=" + productId;
	}
}
