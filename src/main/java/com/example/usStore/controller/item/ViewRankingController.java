package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.usStore.domain.Item;
import com.example.usStore.domain.Rank;
import com.example.usStore.service.facade.ItemFacade;

@Controller
public class ViewRankingController {

    @Autowired
      private ItemFacade itemFacade; 
    
   @RequestMapping("/shop/rank/rank.do") 
    public String viewRank(ModelMap modelMap, HttpServletRequest rq) {
      System.out.println("rank");
      
      List<Item> gbList = new ArrayList<Item>();
      List<Item> auctionList = new ArrayList<Item>();
      List<Item> secondHandList = new ArrayList<Item>();
      List<Item> handMadeList = new ArrayList<Item>();   
      
      gbList = itemFacade.getItemByPId(0);
      auctionList = itemFacade.getItemByPId(1);
      secondHandList = itemFacade.getItemByPId(2);
      handMadeList = itemFacade.getItemByPId(3);
      
      gbList.sort(new Comparator<Item>() {   //내림차순 정렬
            @Override
            public int compare(Item gb1, Item gb2) {
                   if (gb1.getViewCount() > gb2.getViewCount())
                         return -1;
                   else
                         return 1;
            }
      });
      
      auctionList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item at1, Item at2) {
                   if (at1.getViewCount() > at2.getViewCount())
                         return -1;
                   else
                         return 1;
            }
      });
      
      secondHandList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item sh1, Item sh2) {
                   if (sh1.getViewCount() > sh2.getViewCount())
                      return -1;
                   else
                         return 1;
            }
      });
      
      handMadeList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item hm1, Item hm2) {
                   if (hm1.getViewCount() > hm2.getViewCount())
                      return -1;
                   else
                         return 1;
            }
      });
      
      modelMap.addAttribute("gbList", gbList);
      modelMap.addAttribute("atList", auctionList);
      modelMap.addAttribute("shList", secondHandList);
      modelMap.addAttribute("hmList", handMadeList);
      
      HttpSession session = rq.getSession(true);
      session.setAttribute("gbList", gbList);
      session.setAttribute("atList", auctionList);
      session.setAttribute("shList", secondHandList);
      session.setAttribute("hmList", handMadeList);
      
      return "product/viewRank";
   }
   
   @GetMapping(value="/shop/rank/HmToJson.do")
   @ResponseBody
   public List<Rank> hmJson(HttpServletRequest rq) {   //객체 타입 리스트
	  HttpSession session = rq.getSession(true);
	  @SuppressWarnings("unchecked")
	  List<Item> hmList = (List<Item>) session.getAttribute("hmList");
      List<Rank> hmRankList = new ArrayList<Rank>();
      
      int index = 0;
      for(Item item : hmList) {
         hmRankList.add(new Rank(item.getItemId(), item.getTitle(), item.getViewCount()));
         index++;
         if(index == 10)   break;
      }   //10위까지만 리스트 생성
      
      return hmRankList; // new MessageList2(messages);
   }
   
//   @PostMapping(value = "/post.json")
//	@ResponseBody
//	public List<Rank> hmPostJson(@RequestBody List<Rank> hmRankList) {
//		System.out.println(hmRankList.toString());
//		hmRankList.get(0).setContent("수정된 메시지1");
//		return hmRankList;
//	}
}