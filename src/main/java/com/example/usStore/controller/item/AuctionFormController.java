package com.example.usStore.controller.item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller
public class AuctionFormController {
   @Autowired
   private ItemFacade itemFacade;
   
   private int myItemId;
   private int myProductId;
   
   @Autowired
   public void setUsStore(ItemFacade itemFacade) {
      this.itemFacade = itemFacade;
   }
   
   @RequestMapping("/shop/auction/listItem.do") 
   public String auctionList(@RequestParam("productId") int productId, ModelMap model) {
      List<Auction> auctionList = this.itemFacade.getAuctionList();
      
      myProductId = productId;
      
      model.addAttribute("productId", productId);
      model.addAttribute("auctionList", auctionList);

      return "product/auction";
   }
   
   @RequestMapping("/shop/auction/viewItem.do") 
   public String auctionView(@RequestParam("itemId") int itemId, @RequestParam("productId") int productId, ModelMap model) {
	  System.out.println("<경매 상세 페이지>"); 
	  myItemId = itemId;
	  
	  Auction auction = this.itemFacade.getAuctionById(myItemId);

	  model.addAttribute("productId", productId);
      model.addAttribute("auction", auction);
      
      return "product/viewAuction";
   }

   
   @RequestMapping("/shop/auction/participateItem.do") 
   public String auctionParticipate(HttpServletRequest request, ModelMap model) {
	   System.out.println("<경매 참여>");
	   
	   int price = Integer.parseInt(request.getParameter("price"));
	   System.out.println("입력 가격 : " + price);
	   
	   //파라미터로 받아온 입력 가격(price)을 unitCost 필드에 update 해주기
	   
	   return "redirect:/shop/auction/viewItem.do?itemId=" + myItemId;
   }
   

   @RequestMapping("/shop/auction/addItem.do")
   public String goItem(@RequestParam("productId") int productId) {
      return "redirect:/shop/item/addItem.do?productId=" + productId;
   }
   
   
   @RequestMapping("/shop/auction/updateItem.do") 
   public String auctionUpdate(@RequestParam("productId") int productId, ModelMap model) {
	   this.itemFacade.updateAuction(this.itemFacade.getAuctionById(myItemId));
	   return "product/item";
   }

  
   @RequestMapping("/shop/auction/deleteItem.do") 
   public String auctionDelete(@RequestParam("itemId") int itemId, ModelMap model) {
	   System.out.println("<경매 삭제>");
	   System.out.println("아이템 아이디는 : " + itemId);
	   
	   this.itemFacade.deleteItem(itemId, myProductId);
	   
	   return "redirect:/shop/auction/listItem.do?productId=" + myProductId;
   }
   
   //add Auction 하기 전에  여기를 거쳐서 다시 add Auction url 으로 가야한다.
   @RequestMapping("/shop/auction/testSchedulerItem.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("keyword")
			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm") Date deadLine) throws Exception {
		System.out.println(deadLine);
		itemFacade.testScheduler(deadLine);
		return new ModelAndView("Scheduled", "deadLine", deadLine);	
	}
}