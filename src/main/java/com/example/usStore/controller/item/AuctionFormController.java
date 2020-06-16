package com.example.usStore.controller.item;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.usStore.controller.mypage.UserSession;
import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Bidder;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"userSession", "Auction", "auctionList"})
public class AuctionFormController {
   private static final String ADD_Auction_FORM = "product/addAuction";
   private static final String GoAddItemFORM = "redirect:/shop/item/addItem.do?productId=";
   private static final String CHECK_FORM3 = "product/checkAuction";
   
   @Autowired
   private ItemFacade itemFacade;
   
   private int myItemId;
   private int myProductId;
   
   @Autowired
   public void setUsStore(ItemFacade itemFacade) {
      this.itemFacade = itemFacade;
   }
   
   @ModelAttribute("Auction")		  
	public AuctionForm formBacking() {  // accessor method 
		System.out.println("formBacking");
		
		return new AuctionForm();
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
   public String auctionView(@RequestParam("itemId") int itemId, @RequestParam("productId") int productId, Model model, Model modelMap) {
	  System.out.println("<경매 상세 페이지>"); 
	  
	  Item item = itemFacade.getItem(itemId);
	  item.setViewCount(item.getViewCount() + 1);
	        
	  itemFacade.updateItem(item);   // update : viewCount++
	  
	  myItemId = itemId;
	  
	  Auction auction = this.itemFacade.getAuctionById(myItemId);

	  List<Tag> tags = new ArrayList<Tag>();
	  tags = itemFacade.getTagByItemId(auction.getItemId());
		
	  model.addAttribute("productId", productId);
      model.addAttribute("auction", auction);
      modelMap.addAttribute("tags", tags);

      return "product/viewAuction";
   }

   
   /*로그인 필요*/
   @RequestMapping("/shop/auction/participateItem.do") 
   public String auctionParticipate(HttpServletRequest request, ModelMap model) {
	   System.out.println("<경매 참여>");
	   
	   int price = Integer.parseInt(request.getParameter("price"));
	   System.out.println("입력 가격 : " + price);
	   
	   String rslt = itemFacade.isBidderExist(myItemId);
	   System.out.println("낙찰자 검색 결과 : " + rslt);

	   if (rslt == null) {//낙찰자가 없으면 낙찰자 테이블에 itemId, bidder 넣어주기
		   System.out.println("낙찰자 테이블에 이 아이템이 없었음");
		   
		   Bidder bidder = new Bidder();
		   bidder.setItemId(myItemId);
		   bidder.setBidder("admin"); //로그인이 구현 안되어서 일단 임의로 admin 넣어줌
		   
		   itemFacade.insertBidder(bidder);
	   }
	   else {//이미 낙찰자가 있으면 낙찰자 테이블에 bidder 수정
		   System.out.println("낙찰자 테이블에 이 아이템이 있음");
		   
		   itemFacade.updateBidder("admin", myItemId); //여기도 로그인 구현이 안되어서 임의로 admin 넣어줌
	   }
	   
	   //파라미터로 받아온 입력 가격(price)을 item 테이블의 unitCost 필드에 update 해주기
	   itemFacade.updateAuctionUnitCost(price, myItemId);
	   System.out.println("Auction UnitCost 수정 완료");
	   
	   return "redirect:/shop/auction/viewItem.do?itemId=" + myItemId + "&productId=" + myProductId;
   }
   

	/*
	 * @RequestMapping("/shop/auction/addItem.do") public String
	 * goItem(@RequestParam("productId") int productId) { return
	 * "redirect:/shop/item/addItem.do?productId=" + productId; }
	 */
   
   @RequestMapping(value="/shop/auction/addItem2.do", method = RequestMethod.GET)
   public String step2(
         @ModelAttribute("Auction") AuctionForm auctionForm, 
         @RequestParam("productId") int productId, Model model) {
      
      System.out.println("AuctionForm controller");   //print toString
      
      model.addAttribute("productId", productId);
      return ADD_Auction_FORM;   // addAuction.jsp
   }
 
   @RequestMapping(value="/shop/auction/gobackItem.do", method = RequestMethod.GET)		// go back to item.jsp
	public String backToItem(@ModelAttribute("Auction") AuctionForm auctionForm, 
			@RequestParam("productId") int productId) {
		System.out.println("go back to item.jsp");
		return GoAddItemFORM + productId;	// step1(item.jsp) form step2(addAuction.jsp)
	}
	
	@GetMapping("/addStep2")		// step3 -> step2
	public String addAuctionFromCheck() {
		return ADD_Auction_FORM;	// step2 form view
	}
   
	
	@PostMapping("/shop/auction/step3.do")		// step2 -> step3
	public String goCheck(@ModelAttribute("Auction") AuctionForm auctionForm, 
			HttpServletRequest rq, ItemForm itemForm, Model model) {	
		System.out.println("step3.do(before check form)");
		HttpSession session = rq.getSession(false);
		
		itemForm = (ItemForm) session.getAttribute("itemForm");
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemForm);	//print itemformSession toString
		}

		System.out.println(auctionForm);
		
		System.out.println("deadLine still null," + auctionForm);	//print command toString
		
		String deadLine = auctionForm.getDate() + " " + auctionForm.getTime() + ":00";
		auctionForm.setDeadLine(deadLine);
		
		model.addAttribute(itemForm);
		
		Date date = new Date();
		model.addAttribute(date);
		
		return CHECK_FORM3;		// step3(CHECK_FORM3)
	}
	
	@PostMapping("/shop/auction/detailItem.do")		// step3 -> done
	public String done(@ModelAttribute("Auction") AuctionForm auctionForm,
			ItemForm itemformSession, BindingResult result, Model model, HttpServletRequest rq, 
			SessionStatus sessionStatus, Auction auction, ModelMap modelMap) throws ParseException {
		System.out.println("detailItem.do");
		
		HttpSession session = rq.getSession(false);
		itemformSession = (ItemForm) session.getAttribute("itemForm");
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemformSession);	//print itemformSession toString
		}
		System.out.println(auctionForm);
	
		//put itemformSession to item
		Item item = new Item(itemformSession.getUnitCost(), itemformSession.getTitle(), 
				itemformSession.getDescription(), itemformSession.getQty(), "A", 	//must change userId -> loginCommand.getUserId()
				itemformSession.getProductId());
		
		itemFacade.insertItem(item);	// -> generate itemId, insert DB
		
		System.out.println("itemId: " + item.getItemId());	//print itemformSession toString
		
		//generate tags(only have tagName)
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag1());	//if(tag != null && "") then addTags
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag2());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag3());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag4());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag5());
			
		List<Tag> tags = new ArrayList<Tag>();
		tags = itemformSession.getTags();
		
		System.out.println("tags: " + tags);
		
		for(Tag t : tags) {
				itemFacade.insertTag(t);	//matching tag - item (via itemId) , insert DB
		}
		
		System.out.println("deadLine : " + auctionForm.getDeadLine());
		
		auction.setItemId(item.getItemId());
		auction.setStartPrice(auctionForm.getStartPrice());
		auction.setDeadLine(auctionForm.getDeadLine());
	
		itemFacade.insertAuction(auction);	// insert DB
		
		sessionStatus.setComplete();	// Auction session close
		session.removeAttribute("itemForm");	//itemForm session close
		
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		Date date = dt.parse(auctionForm.getDeadLine()); 
		
		itemFacade.testScheduler(date);
		
		return "redirect:/shop/auction/viewItem.do?itemId=" + auction.getItemId() + "&productId=" + item.getProductId();
	}
	
   @RequestMapping("/shop/auction/updateItem.do") 
   public String auctionUpdate(@RequestParam("productId") int productId, ModelMap model) {
	   this.itemFacade.updateAuction(this.itemFacade.getAuctionById(myItemId));
	   return "product/item";
   }

  
   @RequestMapping("/shop/auction/deleteItem.do") 
   public String auctionDelete(@ModelAttribute("userSession") UserSession userSession, @RequestParam("itemId") int itemId, ModelMap model, HttpServletResponse response) throws IOException { 
	   String userId = userSession.getAccount().getUserId();
	   String supplier = itemFacade.getAuctionById(myItemId).getUserId();
	   
	   if (!userId.equals(supplier)) {
		   System.out.println("삭제할 수 없습니다.");
		   return "redirect:/shop/auction/viewItem.do?itemId=" + itemId + "&productId=1";
	   }
	   
	   this.itemFacade.deleteItem(itemId);
	   
	   return "redirect:/shop/auction/listItem.do?productId=" + myProductId;
   }
   

   @RequestMapping("/shop/auction/testSchedulerItem.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("keyword")
			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm") Date deadLine) throws Exception {
		System.out.println(deadLine);
		itemFacade.testScheduler(deadLine);
		return new ModelAndView("Scheduled", "deadLine", deadLine);	
	}
}