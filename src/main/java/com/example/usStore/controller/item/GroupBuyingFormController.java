package com.example.usStore.controller.item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes("GroupBuying")	
public class GroupBuyingFormController {
	private static final String GoAddItemFORM = "redirect:/shop/item/addItem.do?productId=";
	private static final String ADD_GroupBuying_FORM = "product/addGroupBuying";
	private static final String CHECK_FORM3 = "product/checkGroupBuying";
	private static final String DetailPage = "product/viewGroupBuying";
	
	@Autowired
	private ItemFacade itemFacade; 
	
	@RequestMapping("/shop/groupBuying/listItem.do") 
    public String groupBuyingList(@RequestParam("productId") int productId, ModelMap modelMap, Model model) {
	 List<GroupBuying> groupBuyingList = this.itemFacade.getGroupBuyingList();
		
	 model.addAttribute("productId", productId);
	 modelMap.put("groupBuyingList", groupBuyingList);
	 return "product/groupBuying";
   }
	
	@ModelAttribute("GroupBuying")		  
	public GroupBuyingForm formBacking() {  // accessor method 
		System.out.println("formBacking");
		
		return new GroupBuyingForm();
	}
	
	@RequestMapping(value="/shop/groupBuying/addItem2.do", method = RequestMethod.GET)
	public String step2(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
			@RequestParam("productId") int productId, Model model) {
		
		System.out.println("groupBuyingForm controller");	//print toString
		
		model.addAttribute("productId", productId);
		return ADD_GroupBuying_FORM;	// addGroupBuying.jsp
	}

	@RequestMapping("/shop/groupBuying/gobackItem.do")		// go back to item.jsp
	public String step1(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
			@RequestParam("productId") int productId) {
		System.out.println("go back to item.jsp");
		return GoAddItemFORM + productId;	// step1(item.jsp) form step2(addGroupBuying.jsp)
	}
	
	@GetMapping("/step2")		// step3 -> step2
	public String step2FromStep3() {
		return ADD_GroupBuying_FORM;	// step2 form view
	}
	
	@PostMapping("/shop/groupBuying/step3.do")		// step2 -> step3
	public String step3(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
			HttpServletRequest rq, ItemForm itemForm, Model model) {	
		System.out.println("step3.do(before check form)");
		HttpSession session = rq.getSession(false);
		
		itemForm = (ItemForm) session.getAttribute("itemForm");
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemForm);	//print itemformSession toString
		}
		
		System.out.println(groupBuyingForm);	//print command toString
	
		int calDiscount;
		double listPrice = groupBuyingForm.getListPrice();
		double unitCost = itemForm.getUnitCost();
		if(listPrice <= unitCost) {
			calDiscount = (int) ((listPrice / unitCost) * 100.0);	//calulate discount
		}
		else {
			calDiscount = -999;	// 이부분은 나중에 error로 고치기
		}
		
		System.out.println("calDiscount: " + calDiscount);
		
		groupBuyingForm.setDiscount(calDiscount);
		
		model.addAttribute(itemForm);

		return CHECK_FORM3;		// step3(CHECK_FORM3)
	}
	
	@PostMapping("/shop/groupBuying/detailItem.do")		// step3 -> done
	public String finalAddGroupBuying(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingform, 
			ItemForm itemformSession, BindingResult result, Model model, HttpServletRequest rq, 
			SessionStatus sessionStatus, GroupBuying groupBuying) {
		System.out.println("detailItem.do");
		
		HttpSession session = rq.getSession(false);
		itemformSession = (ItemForm) session.getAttribute("itemForm");
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemformSession);	//print itemformSession toString
		}
		System.out.println(groupBuyingform);
	
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
		
//		String from = "2013-04-08 10:10:10";
//
//		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//		Date to = transFormat.parse(from);



//		String resultDate = dateToString.substring(2, 10);	//yy-MM-dd
//		System.out.println("dateToString : " + resultDate);
		
//		SimpleDateFormat StringToDate = new SimpleDateFormat("yy-MM-dd");
		Date today = new Date();
		
		System.out.println("date : " + groupBuyingform.getDeadLine());
		groupBuying.setItemId(item.getItemId());
		groupBuying.setDiscount(groupBuyingform.getDiscount());
		groupBuying.setListPrice(groupBuyingform.getListPrice());
		groupBuying.setDeadLine(today);//임의 date삽입
		
		itemFacade.insertGroupBuying(groupBuying);	// insert DB
		
		model.addAttribute("gb", groupBuying);
		
//		List<GroupBuying> gb = itemFacade.getGroupBuyingList();
		model.addAttribute("productId", item.getProductId());
		
		sessionStatus.setComplete();	// session close
		return DetailPage;
	}
	
	@RequestMapping("/shop/groupBuying/viewItem.do") 
	public String viewSecondHand(@RequestParam("itemId") int itemId,
			@RequestParam("productId") int productId, ModelMap model) {
		  GroupBuying gb = this.itemFacade.getGroupBuyingItem(itemId);
	      model.addAttribute("gb", gb);
	      model.addAttribute("productId", productId);
	      return "product/viewGroupBuying";
	}

	
}