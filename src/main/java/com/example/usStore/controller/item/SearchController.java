package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"tagList", "itemList"})
public class SearchController {
	private ItemFacade itemFacade;
	String searchWord;
	
	@Autowired
	public void setItemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}
	 
	@RequestMapping("/shop/search/viewItem.do") 
	public String searchList(HttpServletRequest rq, ModelMap model) {
		System.out.println("** Search Controller **");
		
		searchWord = rq.getParameter("word");
		System.out.println("검색어 : " + searchWord);
		
		//검색어와 일치하는 태그 리스트 가져오기
		List<Tag> tagList = new ArrayList<Tag>();
		tagList = this.itemFacade.getTagByTagName(searchWord);
		
//		PagedListHolder<Tag> tl = new PagedListHolder<Tag>(tagList);
//	    tl.setPageSize(4);
		
	    //태그 리스트랑 같은 크기의 item 배열 생성
	    List<Item> itemList = new ArrayList<Item>();
	    
	    for(int i = 0; i < tagList.size(); i++) {
	    	Item item = itemFacade.getItem(tagList.get(i).getItemId());
	    	itemList.add(i, item); 
	    }
	    
	    PagedListHolder<Item> il = new PagedListHolder<Item>(itemList);
	    il.setPageSize(4);
	    
	
		model.addAttribute("searchWord", searchWord);
//		model.addAttribute("tagList", tl);
		model.addAttribute("itemList", il);
		
		return "product/search";
	}
	
	@RequestMapping("/shop/search/viewItem2.do") 
	public String searchList2(
			/* @ModelAttribute("tagList") PagedListHolder<Tag> tagList, */ 
			@ModelAttribute("itemList") PagedListHolder<Item> itemList,
			@RequestParam("pageName") String page,
			ModelMap model) {
		if ("next".equals(page)) {
//			tagList.nextPage();
			itemList.nextPage();
		}
		else if ("previous".equals(page)) {
//			tagList.previousPage();
			itemList.previousPage();
		}
		
		model.addAttribute("searchWord", searchWord);
//		model.addAttribute("tagList", tagList);
		model.addAttribute("itemList", itemList);
		
		return "product/search";
	}
	
	
	@RequestMapping("/shop/search/selectItem.do") 
	public String selectItem(@RequestParam("itemId") int itemId, ModelMap model) {
		System.out.println("** 검색 페이지에서 아이템 아이디 선택 **");
		System.out.println(itemId);
		
		Item item = this.itemFacade.getItem(itemId);
		System.out.println(item.toString());
		
		int productId = item.getProductId();
		
		System.out.println("productId : " + productId);
		
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
