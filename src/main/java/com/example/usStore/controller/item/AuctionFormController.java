package com.example.usStore.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

public class AuctionFormController {
   private ItemFacade itemFacade;
   
   @Autowired
   public void setUsStore(ItemFacade itemFacade) {
      this.itemFacade = itemFacade;
   }
   
   //경매 리스트
   @RequestMapping("/shop/auctionList") 
   public String handleRequest(ModelMap model) {
      List<Auction> auctionList = this.itemFacade.getAuctionList();
      
      model.addAttribute("auctionList", auctionList);
      
      return "Product/auction";
   }
   
   //경매 상세 페이지
   @RequestMapping("/shop/auctionView") 
   public String handleRequest(@RequestParam("itemId") int itemId, ModelMap model) {
      Auction auction = this.itemFacade.getAuctionById(itemId);
      List<Tag> tag = this.itemFacade.getTagByItemId(itemId);
      
      model.addAttribute("tag", tag);
      model.addAttribute("auction", auction);
      
      /*
       마감 날짜 계산해서 model 에 담아 보내기
       */
      
      return "Product/viewAuction";
   }
}