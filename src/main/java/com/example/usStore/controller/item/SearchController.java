package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"tagList", "resultList"})
public class SearchController {
	private ItemFacade itemFacade;
	String searchWord;
	String sKind;
	
	@Autowired
	public void setItemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}
	 
	@RequestMapping("/shop/search/viewItem.do") 
	public String searchList(@RequestParam(value="tagName", required=false) String itemTag, HttpServletRequest rq, ModelMap model) {
		System.out.println("** Search Controller **");
		
		sKind = null;
		
		if (rq.getParameter("sKind") != null) {
			sKind = rq.getParameter("sKind");
		}
		else if (rq.getParameter("sKind") == null) {
			sKind = "tag";
		}
		
		if (sKind.equals("tag")) {
			if (itemTag != null) {
				searchWord = itemTag.replaceAll(" ", "");
			}
			else {
				searchWord = rq.getParameter("word").replaceAll(" ", "");
			}
			
			if (searchWord != null) {
				if (!StringUtils.hasLength(searchWord)) {
					model.addAttribute("message", "검색어를 입력해주세요.");
					return "error";
				}
			}
			
			//검색어와 일치하는 태그 리스트 가져오기
			List<Tag> tagList = new ArrayList<Tag>();
			tagList = this.itemFacade.getTagByTagName(searchWord);
			
		    //태그 리스트랑 같은 크기의 item 배열 생성
		    List<Item> resultList = new ArrayList<Item>();
		    
		    for(int i = 0; i < tagList.size(); i++) {
		    	Item item = itemFacade.getItem(tagList.get(i).getItemId());
		    	resultList.add(i, item); 
		    }
		    
		    PagedListHolder<Item> rl = new PagedListHolder<Item>(resultList);
		    rl.setPageSize(4);
		    
		    System.out.println("검색 결과 아이템 길이는 : " + resultList.size());
		    
		    if (resultList.size() == 0) {
		    	model.addAttribute("noResult", 1);
		    }

			model.addAttribute("resultList", rl);
		} else if (sKind.equals("title")) {
			searchWord = rq.getParameter("word");
			
			if (searchWord != null) {
				if (!StringUtils.hasLength(searchWord)) {
					model.addAttribute("message", "검색어를 입력해주세요.");
					return "error";
				}
			}
			
			List<Item> titleList = new ArrayList<Item>();
			titleList = this.itemFacade.getItemByTitle(searchWord);
			
			System.out.println("타이틀 검색 결과");
			for(int i = 0; i < titleList.size(); i++) {
				System.out.println(titleList.get(i).toString());
			}
			
			PagedListHolder<Item> rl = new PagedListHolder<Item>(titleList);
			rl.setPageSize(4);
			
			if (titleList.size() == 0) {
		    	model.addAttribute("noResult", 1);
		    }
			
			model.addAttribute("resultList", rl);
		}
		
		model.addAttribute("sKind", sKind);
		model.addAttribute("searchWord", searchWord);
		return "product/search";
	}
	
	@RequestMapping("/shop/search/viewItem2.do") 
	public String searchList2(
			@ModelAttribute("resultList") PagedListHolder<Item> resultList,
			@RequestParam("pageName") String page,
			ModelMap model) {
		if ("next".equals(page)) {
			resultList.nextPage();
		}
		else if ("previous".equals(page)) {
			resultList.previousPage();
		}
		
		model.addAttribute("sKind", sKind);
		model.addAttribute("searchWord", searchWord);
		model.addAttribute("resultList", resultList);
		
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
