package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.service.facade.ItemFacade;

@Controller
public class HandmadeFormController {

	private ItemFacade itemFacade;

	@Autowired
	public void setitemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}

	@RequestMapping("/shop/handMade/listItem.do")
	public String listHandMade (
			@RequestParam("productId") int productId, ModelMap model) throws Exception {
    
		PagedListHolder<HandMade> itemList = new PagedListHolder<HandMade>(this.itemFacade.getHandMadeList());
		itemList.setPageSize(4);
		
		model.put("itemList", itemList);
		return "Product/handMade";
	}
	
	@RequestMapping("shop/handMade/listItem2.do")
	public String handleRequest2(
			@ModelAttribute("handMade") HandMade handMade,
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
		model.put("handMade", handMade);
		return "Product/handMade";
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
}
