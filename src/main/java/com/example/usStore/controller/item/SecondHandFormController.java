package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.usStore.controller.mypage.UserSession;
import com.example.usStore.domain.Account;
import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller /* SecondHandForm 커맨드 객체를 관리하는 컨트롤러 */
@SessionAttributes("secondHandForm")
public class SecondHandFormController {
   
   private ItemFacade itemFacade;
   
   @Autowired
   public void setItemFacade(ItemFacade itemFacade) {
      this.itemFacade = itemFacade;
   }

   @ModelAttribute("secondHandForm")
   public SecondHandForm formBacking() { //accessor method
	   SecondHandForm secondHandForm = new SecondHandForm();
	   //필드 초기화 할것 있으면 여기서 하기 
	   return secondHandForm;
   }
   
   //여기부터 수정  이컨트롤러 공통사항으로 뺴도 되지아나유? 
   @RequestMapping("/shop/secondHand/index.do") //go index(remove sessions)
   public String goIndex(SessionStatus sessionStatus, HttpServletRequest rq)
   {
      HttpSession session = rq.getSession(false);
      
      sessionStatus.setComplete();// groupBuying session close
      session.removeAttribute("itemForm");   //itemForm session close
      session.removeAttribute("status");      //edit flag Session close
      
      return "redirect:/shop/index.do";
   }
   
   @GetMapping("/shop/secondHand/addItem2.do")
   public String step2(@ModelAttribute("secondHandForm") SecondHandForm secondHandForm, 
            @RequestParam("productId") int productId, Model model) {
         
         model.addAttribute("productId", productId);
         return  "product/addSecondHand";  
   }
   
   @GetMapping("/shop/secondHand/gobackItem.do")      // item.jsp
   public String backToStep1(@ModelAttribute("secondHandForm") SecondHandForm secondHandForm, 
			@RequestParam("productId") int productId) {
      return "redirect:/shop/item/addItem.do?productId=";   // step1 form view(item.jsp)
   }
   
   @GetMapping("/shop/secondHand/gobackAddSh.do")     // step3 -> step2
   public String backToStep2(
		 @ModelAttribute("secondHandForm") SecondHandForm secondHandForm, 
         @RequestParam("productId") int productId, Model model){
      model.addAttribute("productId", productId);
      return "prodect/addSecondHand";   // check.jsp -> addGroupBuying.jsp
   }
   
   @PostMapping("/shop/secondHand/step3.do")      // step2 -> step3
   public String goCheck(@ModelAttribute("secondHandForm") SecondHandForm secondHandForm, 
         HttpServletRequest rq, ItemForm itemForm, Model model) {   
      
      HttpSession session = rq.getSession(false);
      
      itemForm = (ItemForm) session.getAttribute("itemForm");
    //  model.addAttribute(secondHandForm); 이건 왜 안해줌..?
      model.addAttribute(itemForm);
      return "product/checkSecondHand";      // step3(CHECK_FORM3)
   }
   
 
	@PostMapping("/shop/secondHand/done.do")		// step3 -> done
	public String done(@ModelAttribute("secondHandForm") SecondHandForm secondHandForm,  
			ItemForm itemform, BindingResult result, Model model, HttpServletRequest rq, 
			SessionStatus sessionStatus) {
		
		int status = 0;
		
		HttpSession session = rq.getSession(false);
		itemform = (ItemForm) session.getAttribute("itemForm");
		if(session.getAttribute("status") != null) {
			status = (int) session.getAttribute("status");
		}
		Account loginAccount = (Account) session.getAttribute("account");
		String suppId = loginAccount.getUserId();
				
		//put itemform to item domain 
		Item item = new Item(itemform.getUnitCost(), itemform.getTitle(), 
				itemform.getDescription(), itemform.getQty(), suppId, itemform.getProductId());
		
		if(status != 0) { //수정할 때.. 왜 url 공유하는지 다시 확인해보기.. 
			item.setItemId(status);
			item.setViewCount(itemform.getViewCount());
			itemFacade.updateItem(item);
		}
		else {
			itemFacade.insertItem(item);	// -> generate itemId, insert DB
		}
		
		if(status != 0) { //수정할 때.. ?? 
			List<Tag> tags = itemFacade.getTagByItemId(status);
			System.out.println("tag size : " + tags.size());	//0
			if(tags.size() > 0) {
				itemFacade.deleteTag(status);
				tags.removeAll(tags);
				
				System.out.println("removed tags, tag size : " + tags.size());
				List<Tag> t = itemFacade.getTagByItemId(status);
				System.out.println("deleted, tag size : " + t.size());
			}
		}
		//generate tags(only have tagName)
		itemform.makeTags(item.getItemId(), itemform.getTag1());	//if(tag != null && "") then addTags
		itemform.makeTags(item.getItemId(), itemform.getTag2());
		itemform.makeTags(item.getItemId(), itemform.getTag3());
		itemform.makeTags(item.getItemId(), itemform.getTag4());
		itemform.makeTags(item.getItemId(), itemform.getTag5());
		
		List<Tag> tags = itemform.getTags();
		
		
		//put secondHandForm to SecondHand domain 
		SecondHand secondHand = new SecondHand();
		secondHand.setItemId(item.getItemId());
		secondHand.setDiscount(secondHandForm.getDiscount());
		secondHand.setListPrice(secondHandForm.getListPrice());
	
		if(status != 0) { //수정일 때 
			itemFacade.updateSecondHand(secondHand);
		}
		else { // 처음 디비에 저장할 떄 ,, 트랜젝션으로 묶기 
			itemFacade.insertSecondHand(item, secondHand, tags);	// insert DB
		}
		
		sessionStatus.setComplete();	// groupBuying, editStatus session close
		session.removeAttribute("itemForm");	//itemForm session close
		session.removeAttribute("status");
		
		return "redirect:/shop/secondHand/viewItem.do?itemId=" + secondHand.getItemId() + "&productId=" + item.getProductId();
	} 
	
   
}