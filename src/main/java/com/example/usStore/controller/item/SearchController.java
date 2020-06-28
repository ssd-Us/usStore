package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller
public class SearchController {
	private ItemFacade itemFacade;
	
	@Autowired
	public void setItemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}
	 
	@RequestMapping("/shop/search/viewItem.do") 
	public String search(HttpServletRequest rq, ModelMap model) {
		System.out.println("** Search Controller **");
		
		String searchWord = rq.getParameter("word");
		System.out.println("검색어 : " + searchWord);
		
		//검색어와 일치하는 태그 리스트 가져오기
		List<Tag> tagList = new ArrayList<Tag>();
		tagList = this.itemFacade.getTagByTagName(searchWord);
		
		System.out.println("-태그 검색 결과-");
		for(int i = 0; i < tagList.size(); i++) {
			System.out.println(tagList.get(i).toString());
		}
		
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("tagList", tagList);
		
		/*
		 	태그 검색 결과로 보여줄 것
		 	1. 
		*/
		
		return "product/search";
	}
	
	@RequestMapping("/shop/search/selectItem.do") 
	public String selectItem(@RequestParam("itemId") int itemId, ModelMap model) {
		System.out.println("** 검색 페이지에서 아이템 아이디 선택 **");
		
		Item item = new Item();
		item = itemFacade.getItem(itemId);
		
		int productId = item.getProductId();
		
		String url = null;
		switch(productId) {
		case 0: 
			url = "redirect:/shop/groupBuying/viewItem.do?itemId=" + itemId + "&productId=" + productId;
			break;
		case 1: 
			url = "redirect:/shop/auction/viewItem.do?itemId=" + itemId + "&productId=" + productId;
			break;
		case 2:
			url = "redirect:/shop/secondHand/viewItem.do?itemId=" + itemId + "&productId=" + productId;
			break;
		case 3:
			url = "redirect:/shop/handMade/viewItem.do?itemId=" + itemId + "&productId=" + productId;
			break;
		}
		
		return url;
	}
}
