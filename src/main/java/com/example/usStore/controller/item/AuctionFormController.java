package com.example.usStore.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.impl.ItemImpl;

@Controller
public class AuctionFormController {
   @Autowired
   private ItemImpl itemImpl;
   
   @Autowired
   public void setUsStore(ItemImpl itemImpl) {
      this.itemImpl = itemImpl;
   }
   
   //경매 리스트
   @RequestMapping("/shop/auction/listItem.do") 
   public String auctionList(@RequestParam("productId") int productId, ModelMap model) {
      List<Auction> auctionList = this.itemImpl.getAuctionList();
      
      System.out.println("테스트" + auctionList.get(0).getTitle().toString());
      
      //model.addAttribute("auctionList", auctionList);

      return "Product/auction";
   }
   
   //경매 상세 페이지
   @RequestMapping("/shop/auction/viewItem.do") 
   public String auctionView(@RequestParam("itemId") int itemId, ModelMap model) {
      Auction auction = this.itemImpl.getAuctionById(itemId);
      List<Tag> tag = this.itemImpl.getTagByItemId(itemId);
      
      model.addAttribute("tag", tag);
      model.addAttribute("auction", auction);
      
      /*
       마감 날짜 계산해서 model 에 담아 보내기
       */
      
      return "Product/viewAuction";
   }

      
   //경매 추가(로그인 여부 확인)
   @RequestMapping("/shop/auction/addItem.do/{auctionList.productId}") 
   public String auctionAdd(@PathVariable int productId, ModelMap model) {
	   return "Product/addAuction";
   }
   
   
   
   //경매 수정(로그인 여부 확인)
   @RequestMapping("/shop/auction/listItem.do") 
   public String auctionUpdate(@RequestParam("productId") int productId, ModelMap model) {
	   
	   return "Product/item";
   }
   
   
   //경매 삭제(로그인 여부 확인)
   @RequestMapping("/shop/auction/listItem.do") 
   public String auctionDelete(@RequestParam("productId") int productId, ModelMap model) {
	   
	   return "Product/auction";
   }
}