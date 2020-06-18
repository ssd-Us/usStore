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
import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"handMadeForm", "itemList", "userSession"})
public class HandMadeFormController {

	private static final String ADD_HANDMADE_FORM = "product/addHandMade";
	private static final String CHECK_FORM3 = "product/checkHandMade";
	private static final String DETAIL = "product/viewHandMade";
	private static final String HANDMADE_LIST = "product/handMade";
	
	private ItemFacade itemFacade;

	@Autowired
	public void setitemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}
	
	@ModelAttribute("handMadeForm")
	public HandMadeForm createHandMadeForm() {
		return new HandMadeForm();
	}
	
	////////////////////////////////////////////////
	// HandMade List Controller
	////////////////////////////////////////////////
	
	// HandMade 리스트 초기 화면 출력시 실행되는 Controller
	@RequestMapping("/shop/handMade/listItem.do")
	public String listHandMade (
			@RequestParam("productId") int productId, ModelMap model) throws Exception {
  
		PagedListHolder<HandMade> itemList = new PagedListHolder<HandMade>(this.itemFacade.getHandMadeList());
		itemList.setPageSize(4);
		
		model.put("itemList", itemList);
		model.put("productId", productId);
		return HANDMADE_LIST;
	}
	
	// 아이템 4개마다 페이지 구분, 다음 페이지나 이전 페이지로 전환하도록 해주는 Controller
	@RequestMapping("shop/handMade/listItem2.do")
	public String listHandMade2 (
			@ModelAttribute("itemList") PagedListHolder<HandMade> itemList,
			@RequestParam("pageName") String page,
			ModelMap model) throws Exception {
		if ("next".equals(page)) {
			itemList.nextPage();
		}
		else if ("previous".equals(page)) {
			itemList.previousPage();
		}
		model.put("itemList", itemList);
		return HANDMADE_LIST;
	}
	
	@RequestMapping("/shop/handMade/index.do") // go index(remove sessions)
	public String goIndex(SessionStatus sessionStatus, HttpServletRequest rq) {
		System.out.println("go back index.do From [add / edit product]");
		HttpSession session = rq.getSession(false);

		sessionStatus.setComplete();// groupBuying session close
		session.removeAttribute("itemForm"); // itemForm session close
		session.removeAttribute("status"); // edit flag Session close

		return "redirect:/shop/index.do";
	}
	
	////////////////////////////////////////////////
	// HandMade Add Controller
	////////////////////////////////////////////////
	
	@RequestMapping("/shop/handMade/gobackItem.do")		// item.jsp
	public String step1(@ModelAttribute("HandMade") HandMadeForm handMadeForm, 
			@RequestParam("productId") int productId) {
		System.out.println("go back to item.jsp");
		return "redirect:/shop/item/addItem.do?productId=" + productId;	// step1 form view(item.jsp)
	}
	
	@RequestMapping(value="/shop/handMade/addItem2.do", method = RequestMethod.GET)
	public String step2(
			@ModelAttribute("HandMade") HandMadeForm handMadeForm, 
			@RequestParam("productId") int productId, Model model) {

		System.out.println("handMadeForm controller"); // print toString

		model.addAttribute("productId", productId);
		return ADD_HANDMADE_FORM; // addHandMade.jsp
	}
	
	@GetMapping("handMade/step2")		// step3 -> step2
	public String step2FromStep3() {
		return ADD_HANDMADE_FORM;	// step2 form view
	}

	@PostMapping("/shop/handMade/step3.do")		// step2 -> step3 占쎌뵠占쎈짗
	public String step3(
			@ModelAttribute("HandMade") HandMadeForm handMadeForm, 
			HttpServletRequest rq, ItemForm itemForm, Model model, BindingResult bindingResult) {
		
		System.out.println("step3.do(before check form)");
		HttpSession session = rq.getSession(false);
		
		itemForm = (ItemForm) session.getAttribute("itemForm");
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemForm);	//print itemformSession toString
		}
		
		System.out.println("handMadeCommand: " + handMadeForm);	//print command toString
		
		///// 여기 수정해야 함
//		handMadeForm.setItemId();
		model.addAttribute(itemForm);
		return CHECK_FORM3;	// step3(CHECK_FORM3)
	}
	
	@RequestMapping(value="/shop/handMade/gobackAddHandMade.do", method = RequestMethod.GET)		// step3 -> step2
	public String backToAddHandMade(
			@ModelAttribute("HandMade") HandMadeForm handMadeForm, 
			@RequestParam("productId") int productId, Model model){
		model.addAttribute("productId", productId);
		return ADD_HANDMADE_FORM;	// check.jsp -> addHandMade.jsp
	}
	
	@PostMapping("/shop/handMade/detailItem.do")		// step3 -> done
	public String finalAddHandMade(@ModelAttribute("HandMade") HandMadeForm handMadeForm, 
			ItemForm itemformSession, BindingResult result, Model model, HttpServletRequest rq, 
			SessionStatus sessionStatus, HandMade handMade, ModelMap modelMap) {
		System.out.println("detailItem.do");
		
		HttpSession session = rq.getSession(false);
		itemformSession = (ItemForm) session.getAttribute("itemForm");
		
		int status = (int) session.getAttribute("status");
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemformSession);	// print itemformSession toString
		}
	
		String suppId = userSession.getAccount().getUserId();
		System.out.println("suppId: " + suppId);
		
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemformSession);	//print itemformSession toString
		}
		System.out.println(handMadeForm);
	
		//put itemformSession to item
		Item item = new Item(itemformSession.getUnitCost(), itemformSession.getTitle(), 
				itemformSession.getDescription(), itemformSession.getQty(), suppId, 	// must change userId -> loginCommand.getUserId()
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
			itemFacade.insertTag(t);	// matching tag - item (via itemId) , insert DB
		}
		
		handMade.setItemId(item.getItemId());
		handMade.setListPrice(handMadeForm.getListPrice());
		
		if(status != 0) {
			itemFacade.updateHandMade(handMade); // update DB
		}
		else {
			itemFacade.insertHandMade(handMade);	// insert DB
		}
		
		handMade.setItemId(status);
		handMade.setListPrice(handMadeForm.getListPrice());
		
		if(status != 0) {
			itemFacade.updateHandMade(handMade);
		}
		else {
			itemFacade.insertHandMade(handMade);	// insert DB
		}
	
		sessionStatus.setComplete();	// groupBuying, editStatus session close
		session.removeAttribute("itemForm");	//itemForm session close
		
		return DETAIL;
	}
	
	////////////////////////////////////////////////
	// HandMade View Controller
	////////////////////////////////////////////////
	
	@RequestMapping("/shop/handMade/viewItem.do")
	public String handMadeView(@RequestParam("itemId") int itemId, 
			@RequestParam("productId") int productId,
			HttpServletRequest rq, Model model, ModelMap modelMap) {
		
		HttpSession session = rq.getSession(false);
		
		if(session.getAttribute("userSession") != null) {
			UserSession userSession = (UserSession) session.getAttribute("userSession");
			String suppId = userSession.getAccount().getUserId();
			
			System.out.println("suppId: " + suppId);
			model.addAttribute("suppId", suppId);
		}
		
		Item item = itemFacade.getItem(itemId);
		item.setViewCount(item.getViewCount() + 1);
		System.out.println("object's viewcount ++ ? : " + item);
		
		itemFacade.updateItem(item);	// update : viewCount++
		System.out.println("updated item data: " + itemFacade.getItem(itemId).toString());
				
		HandMade handMade = this.itemFacade.getHandMadeById(itemId);
		System.out.println(handMade);
		
		List<Tag> tags = new ArrayList<Tag>();
		tags = itemFacade.getTagByItemId(handMade.getItemId());
		
		model.addAttribute("productId", productId);
		modelMap.addAttribute("tags", tags);
		model.addAttribute("handMade", handMade);
		model.addAttribute("productId", productId);
		return DETAIL;
	}
	
	////////////////////////////////////////////////
	// HandMade Edit Controller
	////////////////////////////////////////////////
	
	@RequestMapping("/shop/handMade/edit.do") //edit Item
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
	
	
	////////////////////////////////////////////////
	// HandMade Delete Controller
	////////////////////////////////////////////////
	
	@RequestMapping("/shop/handMade/deleteItem.do")
	public String delete(@RequestParam("productId") int productId, @RequestParam("itemId") int itemId, ModelMap model) {
		this.itemFacade.deleteItem(itemId);
		return "redirect:/shop/handMade/listItem.do?productId=" + productId;
	}
}
