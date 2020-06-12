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
   
   //��� ����Ʈ
   @RequestMapping("/shop/auction/listItem.do") 
   public String auctionList(@RequestParam("productId") int productId, ModelMap model) {
      List<Auction> auctionList = this.itemFacade.getAuctionList();
      
      model.addAttribute("auctionList", auctionList);

      return "Product/auction";
   }
   
   //��� �� ������
   @RequestMapping("/shop/auction/viewItem.do") 
   public String auctionView(@RequestParam("itemId") int itemId, ModelMap model) {
	  Auction auction = this.itemFacade.getAuctionById(itemId);

      model.addAttribute("auction", auction);
      
//      ���� ��¥ ����ؼ� model �� ��� ������        
//      SimpleDateFormat format = new SimpleDateFormat("yy/mm/dd");
//      Date time = new Date();
//      System.out.println("auction deadline : " + auction.getDeadLine().toString() + ", sysdate : " + format.format(time));
      
      
//      unitCost �� ���� �ִ� �ݾ����� �������� ��.
      
      return "Product/viewAuction";
   }

   
   //��� ����(�α��� ���� Ȯ��)
   @RequestMapping("/shop/auction/participateItem.do") 
   public String auctionParticipate(@RequestParam("price") String price, ModelMap model) {
	   System.out.println("���� �ݾ� : " + price.toString());
	   
	   return "Product/viewAuction";
   }
      
   //��� �߰�(�α��� ���� Ȯ��)
   @RequestMapping("/shop/auction/addItem.do")
   public String goItem(@RequestParam("productId") int productId) {
      return "redirect:/shop/item/addItem.do?productId=" + productId;
   }
   
   
   
   //��� ����(�α��� ���� Ȯ��)
   @RequestMapping("/shop/auction/updateItem.do") 
   public String auctionUpdate(@RequestParam("productId") int productId, ModelMap model) {
	   
	   return "Product/item";
   }
   
   
   //��� ����(�α��� ���� Ȯ��)
   @RequestMapping("/shop/auction/deleteItem.do") 
   public String auctionDelete(@RequestParam("productId") int productId, ModelMap model) {
	   
	   return "Product/auction";
   }
}