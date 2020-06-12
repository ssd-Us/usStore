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
   
   //寃쎈ℓ 由ъ뒪�듃
   @RequestMapping("/shop/auction/listItem.do") 
   public String auctionList(@RequestParam("productId") int productId, ModelMap model) {
      List<Auction> auctionList = this.itemFacade.getAuctionList();
      
      model.addAttribute("auctionList", auctionList);

      return "product/auction";
   }
   
   //寃쎈ℓ �긽�꽭 �럹�씠吏�
   @RequestMapping("/shop/auction/viewItem.do") 
   public String auctionView(@RequestParam("itemId") int itemId, ModelMap model) {
	  System.out.println("---경매 상세 페이지---"); 
	  Auction auction = this.itemFacade.getAuctionById(itemId);

      model.addAttribute("auction", auction);
      
//      留덇컧 �궇吏� 怨꾩궛�빐�꽌 model �뿉 �떞�븘 蹂대궡湲�        
//      SimpleDateFormat format = new SimpleDateFormat("yy/mm/dd");
//      Date time = new Date();
//      System.out.println("auction deadline : " + auction.getDeadLine().toString() + ", sysdate : " + format.format(time));
      
      
//      unitCost 瑜� �쁽�옱 理쒕� 湲덉븸�쑝濡� 諛쏆쑝�젮怨� �븿.
      
      return "product/viewAuction";
   }

   
   //寃쎈ℓ 李몄뿬(濡쒓렇�씤 �뿬遺� �솗�씤)
   @RequestMapping("/shop/auction/participateItem.do") 
   public String auctionParticipate(ModelMap model) {
	   System.out.println("넘어옴");
	   
	   return "product/viewAuction";
   }
   
	/*
	 * @RequestMapping("/shop/auction/participateItem.do") public String
	 * auctionParticipate(@RequestParam("price") int price, ModelMap model) {
	 * System.out.println("입력 가격 : " + price);
	 * 
	 * return "Product/viewAuction"; }
	 */
      
   //寃쎈ℓ 異붽�(濡쒓렇�씤 �뿬遺� �솗�씤)
   @RequestMapping("/shop/auction/addItem.do")
   public String goItem(@RequestParam("productId") int productId) {
      return "redirect:/shop/item/addItem.do?productId=" + productId;
   }
   
   
   
   //寃쎈ℓ �닔�젙(濡쒓렇�씤 �뿬遺� �솗�씤)
   @RequestMapping("/shop/auction/updateItem.do") 
   public String auctionUpdate(@RequestParam("productId") int productId, ModelMap model) {
	   
	   return "product/item";
   }
   
   
   //寃쎈ℓ �궘�젣(濡쒓렇�씤 �뿬遺� �솗�씤)
   @RequestMapping("/shop/auction/deleteItem.do") 
   public String auctionDelete(@RequestParam("productId") int productId, ModelMap model) {
	   
	   return "product/auction";
   }
}