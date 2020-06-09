package com.example.usStore.controller.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
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
   @RequestMapping("/shop/viewProduct.do") 
   public String auctionList(@RequestParam("productId") int productId, ModelMap model) {
//      List<Auction> auctionList = this.itemFacade.getAuctionList();
//      
//      System.out.println(auctionList.get(0).getTitle().toString());
//      
//      model.addAttribute("auctionList", auctionList);
      
	   System.out.println("컨트롤러로 넘어옴");
      return "Product/auction";
   }
   
   //경매 상세 페이지
   @RequestMapping("/shop/auctionView") 
   public String auctionView(@RequestParam("itemId") int itemId, ModelMap model) {
      Auction auction = this.itemFacade.getAuctionById(itemId);
      List<Tag> tag = this.itemFacade.getTagByItemId(itemId);
      
      model.addAttribute("tag", tag);
      model.addAttribute("auction", auction);
      
      /*
       마감 날짜 계산해서 model 에 담아 보내기
       */
      
      return "Product/viewAuction";
   }
   
   //경매 수정
   //경매 삭제
   //경매 추가
   @RequestMapping("/shop/item/addItem/${auctionList.productId}") 
   public String auctionAdd(@PathVariable int productId, ModelMap model) {
	   return "Product/addAuction";
   }
}