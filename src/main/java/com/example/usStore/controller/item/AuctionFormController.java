package com.example.usStore.controller.item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller
public class AuctionFormController {
   @Autowired
   private ItemFacade itemFacade;
   
   @Autowired
   public void setUsStore(ItemFacade itemFacade) {
      this.itemFacade = itemFacade;
   }
   
   //경매 리스트
   @RequestMapping("/shop/auction/listItem.do") 
   public String auctionList(@RequestParam("productId") int productId, ModelMap model) {
      List<Auction> auctionList = this.itemFacade.getAuctionList();
      
      model.addAttribute("auctionList", auctionList);

      return "Product/auction";
   }
   
   //경매 상세 페이지
   @RequestMapping("/shop/auction/viewItem.do") 
   public String auctionView(@RequestParam("itemId") int itemId, ModelMap model) {
	  Auction auction = this.itemFacade.getAuctionById(itemId);

      model.addAttribute("auction", auction);
      
//      마감 날짜 계산해서 model 에 담아 보내기        
//      SimpleDateFormat format = new SimpleDateFormat("yy/mm/dd");
//      Date time = new Date();
//      System.out.println("auction deadline : " + auction.getDeadLine().toString() + ", sysdate : " + format.format(time));
      
      
//      unitCost 를 현재 최대 금액으로 받으려고 함.
      
      return "Product/viewAuction";
   }

   
   //경매 참여(로그인 여부 확인)
   @RequestMapping("/shop/auction/participateItem.do") 
   public String auctionParticipate(@RequestParam("price") String price, ModelMap model) {
	   System.out.println("참여 금액 : " + price.toString());
	   
	   return "Product/viewAuction";
   }
      
   //경매 추가(로그인 여부 확인)
   @RequestMapping("/shop/groupBuying/addItem.do")
   public String goItem(@RequestParam("productId") int productId) {
      return "redirect:/shop/item/addItem.do?productId=" + productId;
   }
   
   
   
   //경매 수정(로그인 여부 확인)
   @RequestMapping("/shop/auction/updateItem.do") 
   public String auctionUpdate(@RequestParam("productId") int productId, ModelMap model) {
	   
	   return "Product/item";
   }
   
   
   //경매 삭제(로그인 여부 확인)
   @RequestMapping("/shop/auction/deleteItem.do") 
   public String auctionDelete(@RequestParam("productId") int productId, ModelMap model) {
	   
	   return "Product/auction";
   }
}