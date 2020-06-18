package com.example.usStore.controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.usStore.controller.mypage.UserSession;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.service.facade.ItemFacade;
import com.example.usStore.service.facade.MyPageFacade;

@Controller
@SessionAttributes({"secondHandForm", "secondHandList"})
/* 세컨핸드 리스트를 세션에 저장하는거 어디 출신..? */
public class SecondHandFormController {
   
   private ItemFacade itemFacade;
   private MyPageFacade myPageFacade;
   
   @Autowired
   public void setItemFacade(ItemFacade itemFacade) {
      this.itemFacade = itemFacade;
   }
   
   @Autowired
   public void setMyPageFacade(MyPageFacade myPageFacade) {
      this.myPageFacade = myPageFacade;
   }

   @ModelAttribute("secondHandForm")
   public SecondHandForm createSecondHandForm() {
      //accessor method
      return new SecondHandForm();
   }

   @RequestMapping("/shop/secondHand/listItem.do")
   public String secondHandList(
         @RequestParam("productId") int productId, 
         ModelMap model) throws Exception{
      
      System.out.println("여기는 게시물 목록 컨트롤러\n ");
      
      PagedListHolder<SecondHand> secondHandList = new PagedListHolder<SecondHand>(this.itemFacade.getSecondHandList());
      secondHandList.setPageSize(4);
   
      model.addAttribute("secondHandList", secondHandList);
      model.addAttribute("productId", productId);
      
      return "product/secondHand"; 
   }   
   
   @RequestMapping("/shop/secondHand/listItem2.do")
   public String secondHandList2(
         @ModelAttribute("secondHandList") PagedListHolder<Item> secondHandList,
         @RequestParam("pageName") String page, ModelMap model) throws Exception {
      if ("next".equals(page)) {
    	  secondHandList.nextPage();
      }
      else if ("previous".equals(page)) {
    	  secondHandList.previousPage();
      }
      model.addAttribute("secondHandList", secondHandList);
      return "product/secondHand";
   }
   
   @RequestMapping("/shop/secondHand/viewItem.do") 
   public String viewSecondHand(@RequestParam("itemId") int itemId,
         @RequestParam("productId") int productId, ModelMap model,
         HttpServletRequest request) {
	   /*뷰를 띄어줄때는 인터셉터를 걸면 안되는게..무조건 컨트롤러 보내줘야하니까,,
	    * 그대신 신고기능을 로그인이 안되있으면 못하도록.. */
	   HttpSession session =  request.getSession(false);
	   UserSession userSession = (UserSession) session.getAttribute("userSession");
	   String victim = userSession.getAccount().getUserId();
	   String isAccuse = "false";       //attacker = 판매자 아이디, victim = 세션 유저 아이디 
	   String attacker = this.itemFacade.getUserIdByItemId(itemId); 
	   if(victim != null) {
		   System.out.println("session null !! : " + victim);
		   isAccuse = this.myPageFacade.isAccuseAlready(attacker, victim); 
	   }

      SecondHand sh = this.itemFacade.getSecondHandItem(itemId);
         model.addAttribute("sh", sh);
         model.addAttribute("productId", productId);
         model.addAttribute("isAccuse", isAccuse);
         return "product/viewSecondHand";
   }
   
   
   //여기부터 수정 
   @RequestMapping("/shop/product/index.do") //go index(remove sessions)
   public String goIndex(SessionStatus sessionStatus, HttpServletRequest rq)
   {
      System.out.println("go back index.do From [add / edit product]");
      HttpSession session = rq.getSession(false);
      
      sessionStatus.setComplete();// groupBuying session close
      session.removeAttribute("itemForm");   //itemForm session close
      session.removeAttribute("status");      //edit flag Session close
      
      return "redirect:/shop/index.do";
   }
   
   @RequestMapping("/shop/secondHand/gobackItem.do")      // item.jsp
   public String step1() {
      return "redirect:/shop/item/addItem.do?productId=";   // step1 form view(item.jsp)
   }
   
   @RequestMapping("/shop/secondHand/addItem.do")
   public String goItem(@RequestParam("productId") int productId) {
         return "redirect:/shop/item/addItem.do?productId=" + productId;
   }
   
   @RequestMapping(value="/shop/secondHand/addItem2.do", method = RequestMethod.GET)
   public String step2(
            @ModelAttribute("SecondHand") SecondHandForm secondHandForm, 
            @RequestParam("productId") int productId, Model model) {
         
         System.out.println("step2 controller");   //print toString
         model.addAttribute("productId", productId);
         return  "product/addSecondHand";  
   }
   
   //여기서부터 수정하기 
   @RequestMapping(value="/shop/secondHand/gobackItem.do", method = RequestMethod.GET)      // go back to item.jsp
   public String backToItem(@ModelAttribute("SecondHand") SecondHandForm secondHandForm, 
         @RequestParam("productId") int productId) {
      
      System.out.println("backToItem 컨트롤러 진입 ");
      return "redirect:/shop/item/addItem.do?productId=" + productId;   // step1(item.jsp) form step2(addGroupBuying.jsp)
   }
   
   @RequestMapping(value="/shop/secondHand/gobackAddSh.do", method = RequestMethod.GET)      // step3 -> step2
   public String backToAddSecondHand(
         @ModelAttribute("SecondHand") SecondHandForm secondHandForm, 
         @RequestParam("productId") int productId, Model model){
      model.addAttribute("productId", productId);
      return "prodect/addSecondHand";   // check.jsp -> addGroupBuying.jsp
   }
   
   @PostMapping("/shop/secondHand/step3.do")      // step2 -> step3
   public String goCheck(@ModelAttribute("SecondHand") SecondHandForm secondHandForm, 
         HttpServletRequest rq, ItemForm itemForm, Model model) {   
      
      System.out.println("goCheck 컨트롤러 진입");
      HttpSession session = rq.getSession(false);
      
      itemForm = (ItemForm) session.getAttribute("itemForm");
      if(session.getAttribute("itemForm") != null) {
         System.out.println("itemformSession: " + itemForm);   //print itemformSession toString
      }
      
      System.out.println("deadLine still null," + secondHandForm);   //print command toString
   
      int calDiscount;
      double listPrice = secondHandForm.getListPrice();
      double unitCost = itemForm.getUnitCost();
      if(listPrice <= unitCost) {
         calDiscount = (int) ((unitCost - listPrice) / unitCost * 100);
      }
      else {
         calDiscount = -999;   // 이부분은 나중에 error로 고치기
      }
      
      System.out.println("calDiscount: " + calDiscount);
      
      /*
       * secondHandForm.setDiscount(calDiscount);
       * 
       * String deadLine = secondHandForm.getDate() + " " + groupBuyingForm.getTime()
       * + ":00"; secondHandForm.setDeadLine(deadLine);
       */
      model.addAttribute(itemForm);
      return "product/checkSecondHand";      // step3(CHECK_FORM3)
   }
   
   @RequestMapping("/shop/secondHand/deleteItem.do")
   public String delete(@RequestParam("productId") int productId, 
         @RequestParam("itemId") int itemId, ModelMap model) {
      
      this.itemFacade.deleteItem(itemId);
      return "redirect:/shop/secondHand/listItem.do?productId=" + productId;
   }
   
}