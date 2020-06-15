package com.example.usStore.controller.item;

import java.util.ArrayList;
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

	@RequestMapping(value="/shop/groupBuying/gobackItem.do", method = RequestMethod.GET)		// go back to item.jsp
	public String backToItem(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
			@RequestParam("productId") int productId) {
		System.out.println("go back to item.jsp");
		return GoAddItemFORM + productId;	// step1(item.jsp) form step2(addGroupBuying.jsp)
	}
	
	@GetMapping("/step2")		// step3 -> step2
	public String addGroupFromCheck() {
		return ADD_GroupBuying_FORM;	// step2 form view
	}
	
	@PostMapping("/shop/groupBuying/step3.do")		// step2 -> step3
	public String goCheck(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
			HttpServletRequest rq, ItemForm itemForm, Model model) {	
		System.out.println("step3.do(before check form)");
		HttpSession session = rq.getSession(false);
		
		itemForm = (ItemForm) session.getAttribute("itemForm");
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemForm);	//print itemformSession toString
		}
		
		System.out.println("deadLine still null," + groupBuyingForm);	//print command toString
	
		int calDiscount;
		double listPrice = groupBuyingForm.getListPrice();
		double unitCost = itemForm.getUnitCost();
		if(listPrice <= unitCost) {
			calDiscount = (int) ((unitCost - listPrice) / unitCost * 100);
		}
		else {
			calDiscount = -999;	// 이부분은 나중에 error로 고치기
		}
		
		System.out.println("calDiscount: " + calDiscount);
		
		groupBuyingForm.setDiscount(calDiscount);
		
		String deadLine = groupBuyingForm.getDate() + " " + groupBuyingForm.getTime() + ":00";
		groupBuyingForm.setDeadLine(deadLine);
		
		model.addAttribute(itemForm);
		return CHECK_FORM3;		// step3(CHECK_FORM3)
	}
	
	@PostMapping("/shop/groupBuying/detailItem.do")		// step3 -> done
	public String done(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingform, 
			ItemForm itemformSession, BindingResult result, Model model, HttpServletRequest rq, 
			SessionStatus sessionStatus, GroupBuying groupBuying, ModelMap modelMap) {
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
		
		System.out.println("deadLine : " + groupBuyingform.getDeadLine());
		
		groupBuying.setItemId(item.getItemId());
		groupBuying.setDiscount(groupBuyingform.getDiscount());
		groupBuying.setListPrice(groupBuyingform.getListPrice());
		groupBuying.setDeadLine(groupBuyingform.getDeadLine());
	
		itemFacade.insertGroupBuying(groupBuying);	// insert DB
//		
//		model.addAttribute("gb", groupBuying);
//		model.addAttribute("item", item);
//		modelMap.addAttribute("tags", tags);
//		
//		List<GroupBuying> gb = itemFacade.getGroupBuyingList();
//		model.addAttribute("productId", item.getProductId());
//		itemFacade.getTagByItemId(groupBuying.getItemId());
		
		sessionStatus.setComplete();	// groupBuying session close
		session.removeAttribute("itemForm");	//itemForm session close
		return "redirect:/shop/groupBuying/viewItem.do?itemId=" + groupBuying.getItemId() + "&productId=" + item.getProductId();
	}
	
	@RequestMapping("/shop/groupBuying/viewItem.do") //click title -> detail Page(viewCount++)
	public String viewGroupBuying(@RequestParam("itemId") int itemId, 
			@RequestParam("productId") int productId, Model model, Model modelMap)
	{
		System.out.println("viewItem.do");
		System.out.println("itemId:" + itemId);
		
		Item item = itemFacade.getItem(itemId);
		item.setViewCount(item.getViewCount() + 1);
		System.out.println("object's viewcount ++ ? : " + item);
		
		itemFacade.updateItem(item);	// update : viewCount++
		System.out.println("updated item data: " + itemFacade.getItem(itemId).toString());
				
		GroupBuying gb = itemFacade.getGroupBuyingItem(itemId);
		
		List<Tag> tags = new ArrayList<Tag>();
		tags = itemFacade.getTagByItemId(gb.getItemId());
		
		model.addAttribute("gb", gb);
		model.addAttribute("productId", productId);
		modelMap.addAttribute("tags", tags);
	      
		return "product/viewGroupBuying";
	}
	
}