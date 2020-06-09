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
   
   //��� ����Ʈ
   @RequestMapping("/shop/auctionList") 
   public String handleRequest(ModelMap model) {
      List<Auction> auctionList = this.itemFacade.getAuctionList();
      
      model.addAttribute("auctionList", auctionList);
      
      return "Product/auction";
   }
   
   //��� �� ������
   @RequestMapping("/shop/auctionView") 
   public String handleRequest(@RequestParam("itemId") int itemId, ModelMap model) {
      Auction auction = this.itemFacade.getAuctionById(itemId);
      List<Tag> tag = this.itemFacade.getTagByItemId(itemId);
      
      model.addAttribute("tag", tag);
      model.addAttribute("auction", auction);
      
      /*
       ���� ��¥ ����ؼ� model �� ��� ������
       */
      
      return "Product/viewAuction";
   }
}