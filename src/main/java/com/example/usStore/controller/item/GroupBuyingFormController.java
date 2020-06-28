package com.example.usStore.controller.item;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.example.usStore.controller.mypage.UserSession;
import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.MyPageFacade;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.usStore.service.GroupBuyingFormValidator;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"GroupBuying", "groupBuyingList"})
public class GroupBuyingFormController {
   
   private static final String ADD_GroupBuying_FORM = "product/addGroupBuying";
   private static final String CHECK_FORM3 = "product/checkGroupBuying";
   private static final String DetailPage = "product/viewGroupBuying";
   
   @Autowired
   private ItemFacade itemFacade; 
   
   @Autowired
   private MyPageFacade myPageFacade;
   
   @ModelAttribute("GroupBuying")        
   public GroupBuyingForm formBacking() {  // accessor method 
      System.out.println("formBacking");
      
      return new GroupBuyingForm();
   }
   
   @RequestMapping("/shop/groupBuying/listItem.do") 
    public String groupBuyingList(@RequestParam("productId") int productId, ModelMap modelMap, Model model) {
      
      PagedListHolder<GroupBuying> groupBuyingList = new PagedListHolder<GroupBuying>(this.itemFacade.getGroupBuyingList());
      groupBuyingList.setPageSize(4);
      
      model.addAttribute("productId", productId);
      modelMap.put("groupBuyingList", groupBuyingList);
      return "product/groupBuying";
   }   
   
   @RequestMapping("/shop/groupBuying/listItem2.do")
   public String groupBuyingList2 (
         @ModelAttribute("groupBuyingList") PagedListHolder<GroupBuying> groupBuyingList,
         @RequestParam("pageName") String page, @RequestParam("productId") int productId, 
         ModelMap modelMap, Model model) throws Exception {
      System.out.println(groupBuyingList);
      if ("next".equals(page)) {
         groupBuyingList.nextPage();
      }
      else if ("previous".equals(page)) {
         groupBuyingList.previousPage();
      }
      
      model.addAttribute("productId", productId);
      modelMap.put("groupBuyingList", groupBuyingList);
      return "product/groupBuying";
   }
   
   @RequestMapping(value="/shop/groupBuying/addItem2.do", method = RequestMethod.GET)
   public String step2(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
         @RequestParam("productId") int productId, Model model, HttpServletRequest rq) {
      System.out.println("groupBuyingForm controller");   //print toString
      
      HttpSession session = rq.getSession(false);
      if(session.getAttribute("status") != null) {   //수정일 경우
         int status = (int) session.getAttribute("status");
         int itemId = status;
         
         System.out.println("from edit - addItem2.do");
         GroupBuying gb = itemFacade.getGroupBuyingItem(itemId);
         groupBuyingForm.setListPrice(gb.getListPrice());   //할인가 기존값으로 초기화
         System.out.println(groupBuyingForm);
      }
      
      model.addAttribute("productId", productId);
      return ADD_GroupBuying_FORM;   // addGroupBuying.jsp
   }

   @RequestMapping(value="/shop/groupBuying/gobackItem.do", method = RequestMethod.GET)      // go back to item.jsp
   public String backToItem(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
         @RequestParam("productId") int productId) {
      System.out.println("go back to item.jsp");
      return "redirect:/shop/item/addItem.do?productId="+productId;   // step1(item.jsp) form step2(addGroupBuying.jsp)
   }
   
   @PostMapping("/shop/groupBuying/step3.do")      // go checkGroupBuying.jsp
   public String goCheck(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, BindingResult result,
         HttpServletRequest rq, ItemForm itemForm, Model model, ModelMap modelMap) {   
      System.out.println("step3.do(before check form)");
      HttpSession session = rq.getSession(false);
      new GroupBuyingFormValidator().validate(groupBuyingForm, result);
      
      if(session.getAttribute("itemForm") != null) {
         itemForm = (ItemForm) session.getAttribute("itemForm");
         System.out.println("itemformSession: " + itemForm);   //print itemformSession toString
      }
      
      if(groupBuyingForm.getListPrice() >= itemForm.getUnitCost()) {   //할인가는 정가보다 낮은 가격이어야 함
         result.rejectValue("listPrice", "mustDiscount");
      }
      
      if (result.hasErrors()) {   //유효성 검증 에러 발생시
         model.addAttribute("productId", itemForm.getProductId());
         return ADD_GroupBuying_FORM;
      }
   
      int calDiscount;   //할인율
      double listPrice = groupBuyingForm.getListPrice();
      double unitCost = itemForm.getUnitCost();
      
      calDiscount = (int) ((unitCost - listPrice) / unitCost * 100);   //할인율 계산
      System.out.println("calDiscount: " + calDiscount);
      
      groupBuyingForm.setDiscount(calDiscount);
       
      String date = groupBuyingForm.getDate();
      String time = groupBuyingForm.getTime();
      String deadLine = date + " " + time + ":00";
      groupBuyingForm.setDeadLine(deadLine);
      
      System.out.println(groupBuyingForm);
      
      model.addAttribute(itemForm);
      modelMap.addAttribute("tags", itemForm.getTags());
      return CHECK_FORM3;      // step3(CHECK_FORM3)
   }
   
   @PostMapping("/shop/groupBuying/detailItem.do")      // step3 -> done
   public String done(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingform, 
         ItemForm itemformSession, BindingResult result, Model model, HttpServletRequest rq, 
         SessionStatus sessionStatus, ModelMap modelMap) {
      int status = 0;
      System.out.println("detailItem.do");
      
      HttpSession session = rq.getSession(false);
      itemformSession = (ItemForm) session.getAttribute("itemForm");
      
      if(session.getAttribute("status") != null) {   //수정으로 들어온 경우
         status = (int) session.getAttribute("status");
      }
      
      if(session.getAttribute("userSession") != null) {
         UserSession userSession = (UserSession) session.getAttribute("userSession");
         System.out.println(userSession);
      }
      
      UserSession userSession = (UserSession) session.getAttribute("userSession");
      String suppId = userSession.getAccount().getUserId();
      System.out.println("suppId: " + suppId);
            
      if(session.getAttribute("itemForm") != null) {
         System.out.println("itemformSession: " + itemformSession);   //print itemformSession toString
      }
      System.out.println(groupBuyingform);
   
      //put itemformSession to item
      Item item = new Item(itemformSession.getUnitCost(), itemformSession.getTitle(), 
            itemformSession.getDescription(), itemformSession.getQty(), suppId,    
            itemformSession.getProductId());
      
      if(status != 0) {   //수정인 경우
         item.setItemId(status);   //status == itemId
         item.setViewCount(itemformSession.getViewCount());   //기존의 조회수 그대로 적용
      
         System.out.println("조회수:" + itemformSession.getViewCount());
         System.out.println("itemId: " + item.getItemId());   //print itemformSession toString
      
         List<Tag> tags = itemFacade.getTagByItemId(status);   //기존 태그 호출
         System.out.println("tag size : " + tags.size());   //0
         
         if(tags.size() > 0) {   //기존 태그 전부 삭제
            itemFacade.deleteTag(status);
            tags.removeAll(tags);   
         }
      }
      
      //generate tags(only have tagName)      
      for(int i = 0; i < itemformSession.getTags().size(); i++) {
         item.makeTags(itemformSession.getTags().get(i));   //if(tag != null && "") then addTags
      }
      System.out.println("최종 태그:" + item.getTags());
   
      System.out.println("deadLine : " + groupBuyingform.getDeadLine());
      GroupBuying gb = new GroupBuying(item, groupBuyingform.getDiscount(), groupBuyingform.getListPrice(), groupBuyingform.getDeadLine());
      
      if(status != 0) {
         itemFacade.updateGroupBuying(gb);   //update DB
      }
      else {
         itemFacade.insertGroupBuying(gb);   // insert DB
      }
      
      System.out.println(gb);
      
      sessionStatus.setComplete();   // groupBuying, editStatus session close
      session.removeAttribute("itemForm");   //itemForm session close
      session.removeAttribute("status");
      
      return "redirect:/shop/groupBuying/viewItem.do?itemId=" + gb.getItemId() + "&productId=" + item.getProductId();
   }
   
   @RequestMapping("/shop/groupBuying/viewItem.do") //click title -> detail Page(viewCount++)
   public String viewGroupBuying(@RequestParam("itemId") int itemId, 
         HttpServletRequest rq, @RequestParam("productId") int productId, Model model, Model modelMap)
   {
      System.out.println("viewItem.do");
      System.out.println("itemId:" + itemId);
      
      String victim = null;
      String isAccuse = "false";
      
      HttpSession session = rq.getSession(false);
      
      if(session.getAttribute("userSession") != null) {
         UserSession userSession = (UserSession) session.getAttribute("userSession");
         victim = userSession.getAccount().getUserId();
         String attacker = this.itemFacade.getUserIdByItemId(itemId);
         isAccuse = this.myPageFacade.isAccuseAlready(attacker, victim);
      }
      
      GroupBuying groupBuying = itemFacade.getGroupBuyingItem(itemId);
      System.out.println("viewCount : " + groupBuying.getViewCount());
      itemFacade.updateViewCount(groupBuying.getViewCount() + 1, itemId);
      System.out.println("object's viewcount ++ ? : " + groupBuying);
      
      System.out.println(groupBuying);
      
      List<Tag> tags = new ArrayList<Tag>();
      tags = itemFacade.getTagByItemId(groupBuying.getItemId());
      
      model.addAttribute("gb", groupBuying);
      model.addAttribute("productId", productId);
      model.addAttribute("isAccuse", isAccuse);
      modelMap.addAttribute("tags", tags);
   
      return DetailPage;
   }
   
   @RequestMapping("/shop/groupBuying/edit.do") //edit Item
   public String editItem(ItemForm itemForm, 
               Item item,   @RequestParam("itemId") int itemId, HttpServletRequest rq)
   {
      HttpSession session = rq.getSession(true);
      session.setAttribute("itemForm", itemForm);
      session.setAttribute("status", itemId);

      int status = (int) session.getAttribute("status");
      System.out.println("edit.do");
      System.out.println("itemId(status) : " + status);
      
      GroupBuying gb = itemFacade.getGroupBuyingItem(itemId);
      
      ItemForm itemFormSession = (ItemForm) session.getAttribute("itemForm");

      itemFormSession.setUnitCost(gb.getUnitCost());
      itemFormSession.setTitle(gb.getTitle());
      itemFormSession.setDescription(gb.getDescription());
      itemFormSession.setQty(gb.getQty());
      itemFormSession.setViewCount(gb.getViewCount());
      itemFormSession.setTags(gb.getTags());
   
      return "redirect:/shop/item/addItem.do?productId=" + item.getProductId();
   }
   
   @RequestMapping("/shop/groupBuying/delete.do") //edit Item
   public String deleteItem(@RequestParam("itemId") int itemId, @RequestParam("productId") int productId)
   {
      itemFacade.deleteItem(itemId);
      
      return "redirect:/shop/groupBuying/listItem.do?productId=" + productId;
   }
   
   @RequestMapping("/shop/groupBuying/index.do") //go index(remove sessions)
   public String goIndex(SessionStatus sessionStatus, HttpServletRequest rq)
   {
      System.out.println("go back index.do From [add / edit product]");
      HttpSession session = rq.getSession(false);
      
      sessionStatus.setComplete();// groupBuying session close
      session.removeAttribute("itemForm");   //itemForm session close
      session.removeAttribute("status");      //edit flag Session close
      
      return "redirect:/shop/index.do";
   }
   
   @RequestMapping("/shop/groupBuying/joint.do") //joint GroupBuying
   public void jointGroupBuying(@RequestParam("itemId") int itemId, @RequestParam("productId") int productId, 
		   HttpServletResponse response) throws IOException
   {
      System.out.println("jointGroupBuying");
      
      PrintWriter out=response.getWriter();
      
      out.println("<script>");
      out.print("if (confirm('Do you want to participate in GroupBuying?') == true){");
      out.print("alert('Go Participate in GroupBuying :)'); location.href='index.do';}");	//공동구매 진행
      out.print("else{location.href='viewItem.do?itemId=" + itemId + "&productId=" + productId + "';}");	//공동구매 진행 취소
      out.println("</script>");
      out.flush();
      out.close();
   }
   
}