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
   
   //��� ����Ʈ
   @RequestMapping("/shop/viewProduct.do") 
   public String auctionList(@RequestParam("productId") int productId, ModelMap model) {
//      List<Auction> auctionList = this.itemFacade.getAuctionList();
//      
//      System.out.println(auctionList.get(0).getTitle().toString());
//      
//      model.addAttribute("auctionList", auctionList);
      
	   System.out.println("��Ʈ�ѷ��� �Ѿ��");
      return "Product/auction";
   }
   
   //��� �� ������
   @RequestMapping("/shop/auctionView") 
   public String auctionView(@RequestParam("itemId") int itemId, ModelMap model) {
      Auction auction = this.itemFacade.getAuctionById(itemId);
      List<Tag> tag = this.itemFacade.getTagByItemId(itemId);
      
      model.addAttribute("tag", tag);
      model.addAttribute("auction", auction);
      
      /*
       ���� ��¥ ����ؼ� model �� ��� ������
       */
      
      return "Product/viewAuction";
   }
   
   //��� ����
   //��� ����
   //��� �߰�
   @RequestMapping("/shop/item/addItem/${auctionList.productId}") 
   public String auctionAdd(@PathVariable int productId, ModelMap model) {
	   return "Product/addAuction";
   }
}