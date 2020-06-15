package com.example.usStore.controller.item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"auctionForm", "auctionList"})
public class AuctionFormController {
   private static final String ADD_Auction_FORM = "product/addAuction";
   
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
      myProductId = productId;
      
      PagedListHolder<Auction> auctionList = new PagedListHolder<Auction>(this.itemFacade.getAuctionList());
      auctionList.setPageSize(4);
      
      model.addAttribute("productId", productId);
      model.addAttribute("auctionList", auctionList);

      return "product/auction";
   }
   
   
   	// �럹�씠吏� �꽆�뼱媛덈븣 �떎�뻾�릺�뒗 Controller
	@RequestMapping("shop/auction/listItem2.do")
	public String auctionList2 (
			@ModelAttribute("auctionList") PagedListHolder<Auction> auctionList,
			@RequestParam("pageName") String page,
			ModelMap model) throws Exception {
		if ("next".equals(page)) {
			auctionList.nextPage();
		}
		else if ("previous".equals(page)) {
			auctionList.previousPage();
		}
		model.addAttribute("productId", myProductId);
	    model.addAttribute("auctionList", auctionList);
		return "product/auction";
	}
	
   @RequestMapping("/shop/auction/viewItem.do") 
   public String auctionView(@RequestParam("itemId") int itemId, @RequestParam("productId") int productId, ModelMap model) {
	  System.out.println("<경매 상세 페이지>"); 
	  
	  Item item = itemFacade.getItem(itemId);
	  item.setViewCount(item.getViewCount() + 1);
	        
	  itemFacade.updateItem(item);   // update : viewCount++
	  
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
	   
	   //�뙆�씪誘명꽣濡� 諛쏆븘�삩 �엯�젰 媛�寃�(price)�쓣 unitCost �븘�뱶�뿉 update �빐二쇨린
	   
	   return "redirect:/shop/auction/viewItem.do?itemId=" + myItemId;
   }
   

	/*
	 * @RequestMapping("/shop/auction/addItem.do") public String
	 * goItem(@RequestParam("productId") int productId) { return
	 * "redirect:/shop/item/addItem.do?productId=" + productId; }
	 */
   
   @RequestMapping(value="/shop/auction/addItem.do", method = RequestMethod.GET)
   public String step2(
         @ModelAttribute("Auction") AuctionForm auctionForm, 
         @RequestParam("productId") int productId, Model model) {
      
      System.out.println("AuctionForm controller");   //print toString
      
      model.addAttribute("productId", productId);
      return ADD_Auction_FORM;   // addGroupBuying.jsp
   }
 
   
   @RequestMapping("/shop/auction/updateItem.do") 
   public String auctionUpdate(@RequestParam("productId") int productId, ModelMap model) {
	   this.itemFacade.updateAuction(this.itemFacade.getAuctionById(myItemId));
	   return "product/item";
   }

  
   @RequestMapping("/shop/auction/deleteItem.do") 
   public String auctionDelete(@RequestParam("itemId") int itemId, ModelMap model) { 
	   this.itemFacade.deleteItem(itemId);
	   
	   return "redirect:/shop/auction/listItem.do?productId=" + myProductId;
   }
   
   //add Auction �븯湲� �쟾�뿉  �뿬湲곕�� 嫄곗퀜�꽌 �떎�떆 add Auction url �쑝濡� 媛��빞�븳�떎.
   @RequestMapping("/shop/auction/testSchedulerItem.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("keyword")
			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm") Date deadLine) throws Exception {
		System.out.println(deadLine);
		itemFacade.testScheduler(deadLine);
		return new ModelAndView("Scheduled", "deadLine", deadLine);	
	}
}