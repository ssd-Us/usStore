package com.example.usStore.controller.item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.usStore.domain.Item;
import com.example.usStore.domain.Rank;
import com.example.usStore.service.facade.ItemFacade;

@Controller
public class ViewRankingController {

    @Autowired
      private ItemFacade itemFacade; 
    
   @RequestMapping("/shop/rank.do") 
    public String viewRank(ModelMap modelMap, HttpServletRequest rq) {
      System.out.println("rank");
      
      return "viewRank";
   }
   
   @RequestMapping(value = "/shop/getData.do/{productId}", method = RequestMethod.GET, produces = "application/json")
   @ResponseBody
   public List<Rank> getJson(@PathVariable("productId") int productId, HttpServletResponse response) throws IOException {   //객체 타입 리스트
	   System.out.println("getJson들어옴");
	   List<Rank> RankList = new ArrayList<Rank>();
	   int index = 0;

	   if(productId == 0) {
		   List<Item> groupBuyingList = new ArrayList<Item>();
		   groupBuyingList = itemFacade.getItemByPId(productId);
		   Collections.sort(groupBuyingList);	//조회수 기준으로 내림차순 정렬
		  		   
		   if (groupBuyingList == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
			}
		   
		   for(Item item : groupBuyingList) {
			   if(index == 10) break;
			   RankList.add(index, new Rank(item.getItemId(), item.getTitle(), item.getViewCount()));
			   index++;
		   }
		   System.out.println("리스트:" + RankList);
	   }
	   else if(productId == 1) {
		   System.out.println("중고거래");
		   List<Item> auctionList = new ArrayList<Item>();
		   auctionList = itemFacade.getItemByPId(productId);
		   Collections.sort(auctionList);	//조회수 기준으로 내림차순 정렬
		   
		   if (auctionList == null) {
			   System.out.println("없음");
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
			}
		   
		   for(Item item : auctionList) {
			   if(index == 10) break;
			   RankList.add(index, new Rank(item.getItemId(), item.getTitle(), item.getViewCount()));
			   index++;
		   }
	   }
	   else if(productId == 2) {
		   List<Item> secondHandList = new ArrayList<Item>();
		   secondHandList = itemFacade.getItemByPId(productId);
		   Collections.sort(secondHandList);	//조회수 기준으로 내림차순 정렬
		   
		   if (secondHandList == null) {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
				return null;
			}
		   
		   for(Item item : secondHandList) {
			   if(index == 10) break;
			   RankList.add(index, new Rank(item.getItemId(), item.getTitle(), item.getViewCount()));
			   index++;
		   }
	   }
	   else {
		   List<Item> handMadeList = new ArrayList<Item>();
		   handMadeList = itemFacade.getItemByPId(productId);
		   Collections.sort(handMadeList);	//조회수 기준으로 내림차순 정렬
		   
		   if (handMadeList == null) {
			   response.sendError(HttpServletResponse.SC_NOT_FOUND);
			   return null;
		   }
		   
		   for(Item item : handMadeList) {
			   if(index == 10) break;
			   RankList.add(index, new Rank(item.getItemId(), item.getTitle(), item.getViewCount()));
			   index++;
		   }
	   }
	   return RankList;
   }
   
}