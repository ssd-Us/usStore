package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"GroupBuying", "groupBuyingList", "editStatus"})
public class GroupBuyingFormController {
	
	private static final String ADD_GroupBuying_FORM = "product/addGroupBuying";
	private static final String CHECK_FORM3 = "product/checkGroupBuying";
	private static final String DetailPage = "product/viewGroupBuying";
	
	@Autowired
	private ItemFacade itemFacade; 
	
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
		System.out.println("groupBuyingForm controller");	//print toString
		
		HttpSession session = rq.getSession(false);
		if(session.getAttribute("status") != null) {
			int status = (int) session.getAttribute("status");
			int itemId = status;
			
			System.out.println("from edit - addItem2.do");
			GroupBuying gb = itemFacade.getGroupBuyingItem(itemId);
			groupBuyingForm.setListPrice(gb.getListPrice());
			System.out.println(groupBuyingForm);
			
		}
		
		model.addAttribute("productId", productId);
		return ADD_GroupBuying_FORM;	// addGroupBuying.jsp
	}

	@RequestMapping(value="/shop/groupBuying/gobackItem.do", method = RequestMethod.GET)		// go back to item.jsp
	public String backToItem(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
			@RequestParam("productId") int productId) {
		System.out.println("go back to item.jsp");
		return "redirect:/shop/item/addItem.do?productId=" + productId;	// step1(item.jsp) form step2(addGroupBuying.jsp)
	}
	
	@RequestMapping(value="/shop/groupBuying/gobackAddGb.do", method = RequestMethod.GET)		// step3 -> step2
	public String backToAddGroupBuying(
			@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
			@RequestParam("productId") int productId, Model model){
		model.addAttribute("productId", productId);
		return ADD_GroupBuying_FORM;	// check.jsp -> addGroupBuying.jsp
	}
	
	@PostMapping("/shop/groupBuying/step3.do")		// go checkGroupBuying.jsp
	public String goCheck(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
			HttpServletRequest rq, ItemForm itemForm, Model model, 
			BindingResult bindingResult) {	
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
		else {	calDiscount = -999;	}	// 이부분은 나중에 error로 고치기
		
		System.out.println("calDiscount: " + calDiscount);
		
		groupBuyingForm.setDiscount(calDiscount);
		
		
		
		String deadLine = groupBuyingForm.getDate() + " " + groupBuyingForm.getTime() + ":00";
		groupBuyingForm.setDeadLine(deadLine);
		System.out.println("setting : " + groupBuyingForm);
		
		model.addAttribute(itemForm);
		return CHECK_FORM3;		// step3(CHECK_FORM3)
	}
	
	@PostMapping("/shop/groupBuying/detailItem.do")		// step3 -> done
	public String done(@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingform, 
			ItemForm itemformSession, BindingResult result, Model model, HttpServletRequest rq, 
			SessionStatus sessionStatus, GroupBuying groupBuying, ModelMap modelMap) {
	//	boolean flag = false;
		System.out.println("detailItem.do");
		
		HttpSession session = rq.getSession(false);
		itemformSession = (ItemForm) session.getAttribute("itemForm");
		int status = (int) session.getAttribute("status");
		
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemformSession);	//print itemformSession toString
		}
		System.out.println(groupBuyingform);
	
		//put itemformSession to item
		Item item = new Item(itemformSession.getUnitCost(), itemformSession.getTitle(), 
				itemformSession.getDescription(), itemformSession.getQty(), "A", 	//must change userId -> loginCommand.getUserId()
				itemformSession.getProductId());
		
		if(status != 0) {
			item.setItemId(status);
			item.setViewCount(itemformSession.getViewCount());
			itemFacade.updateItem(item);
			System.out.println("itemUpdated" + item);
		}
		else {
			itemFacade.insertItem(item);	// -> generate itemId, insert DB
		}
		
		System.out.println("itemId: " + item.getItemId());	//print itemformSession toString
		
		if(status != 0) {
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
		
		groupBuying.setItemId(status);
		groupBuying.setDiscount(groupBuyingform.getDiscount());
		groupBuying.setListPrice(groupBuyingform.getListPrice());
		groupBuying.setDeadLine(groupBuyingform.getDeadLine());
	
		if(status != 0) {
			itemFacade.updateGroupBuying(groupBuying);
		}
		else {
			itemFacade.insertGroupBuying(groupBuying);	// insert DB
		}
		
		sessionStatus.setComplete();	// groupBuying, editStatus session close
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
		System.out.println(gb);
		
		List<Tag> tags = new ArrayList<Tag>();
		tags = itemFacade.getTagByItemId(gb.getItemId());
		
		model.addAttribute("gb", gb);
		model.addAttribute("productId", productId);
		modelMap.addAttribute("tags", tags);
	
		return DetailPage;
	}
	
	@RequestMapping("/shop/GroupBuying/index.do") //go index(remove sessions)
	public String goIndex(SessionStatus sessionStatus, HttpServletRequest rq)
	{
		System.out.println("gb - index.do");
		HttpSession session = rq.getSession(false);
		
		sessionStatus.setComplete();	// groupBuying session close
		session.removeAttribute("itemForm");	//itemForm session close
		
		return "redirect:/shop/index.do";
	}
	
	@RequestMapping("/shop/groupBuying/edit.do") //edit Item
	public String editItem(ItemForm itemForm, 
					Item item,	@RequestParam("itemId") int itemId, HttpServletRequest rq)
	{
		HttpSession session = rq.getSession(true);
		session.setAttribute("itemForm", itemForm);
		session.setAttribute("status", itemId);
		
		List<Tag> tags = new ArrayList<Tag>();
		tags = itemFacade.getTagByItemId(itemId);
		
		int status = (int) session.getAttribute("status");
		System.out.println("edit.do");
		System.out.println("itemId(status) : " + status);
		
		item = itemFacade.getItem(itemId);
		
		ItemForm itemFormSession = (ItemForm) session.getAttribute("itemForm");
		itemFormSession.setUnitCost(item.getUnitCost());
		itemFormSession.setTitle(item.getTitle());
		itemFormSession.setDescription(item.getDescription());
		itemFormSession.setQty(item.getQty());
		itemFormSession.setViewCount(item.getViewCount());
				
		switch(tags.size()) {
			case 1: itemFormSession.setTag1(tags.get(0).getTagName());
					break;
					
			case 2: itemFormSession.setTag1(tags.get(0).getTagName());
					itemFormSession.setTag2(tags.get(1).getTagName());
					break;
					
			case 3: itemFormSession.setTag1(tags.get(0).getTagName());
					itemFormSession.setTag2(tags.get(1).getTagName());
					itemFormSession.setTag3(tags.get(2).getTagName());
					break;
			
			case 4: itemFormSession.setTag1(tags.get(0).getTagName());
					itemFormSession.setTag2(tags.get(1).getTagName());
					itemFormSession.setTag3(tags.get(2).getTagName());
					itemFormSession.setTag4(tags.get(3).getTagName());
					break;
			
			case 5: itemFormSession.setTag1(tags.get(0).getTagName());
					itemFormSession.setTag2(tags.get(1).getTagName());
					itemFormSession.setTag3(tags.get(2).getTagName());
					itemFormSession.setTag4(tags.get(3).getTagName());
					itemFormSession.setTag5(tags.get(4).getTagName());
					break;
		}
		System.out.println(itemFormSession);
		
		return "redirect:/shop/item/addItem.do?productId=" + item.getProductId();
	}
	
	@RequestMapping("/shop/groupBuying/delete.do") //edit Item
	public String deleteItem(@RequestParam("itemId") int itemId, @RequestParam("productId") int productId)
	{
		itemFacade.deleteItem(itemId);
		
		return "redirect:/shop/groupBuying/listItem.do?productId=" + productId;
	}
}