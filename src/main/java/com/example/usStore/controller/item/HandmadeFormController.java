package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.domain.HandMade;
import com.example.usStore.service.facade.ItemFacade;

@Controller
public class HandmadeFormController {

	private ItemFacade itemFacade;

	@Autowired
	public void setitemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}

	///
	@RequestMapping("shop/handMade/listItem.do")
	public String handleRequest(
			@RequestParam("productId") int productId,
			ModelMap model) throws Exception {
//		PagedListHolder<Item> itemList = new PagedListHolder<Item>(this.itemFacade.getItemListByProduct(productId));
//		itemList.setPageSize(4);
		List<HandMade> list = itemFacade.getHandMadeList();
//		model.put("itemList", itemList);
		model.put("list", list);
		return "Product/handMade";
	}
	
	@RequestMapping("shop/handMade/listItem2.do")
	public String handleRequest2(
			@ModelAttribute("product") HandMade handMade,
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
		return "Product";
	}
}
