package com.example.usStore.controller.item;

import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"handMadeForm", "itemList"})
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
	
	// �럹�씠吏� �꽆�뼱媛덈븣 �떎�뻾�릺�뒗 Controller
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
			HttpServletRequest rq, ItemForm itemForm, Model model) {
		
		System.out.println("step3.do(before check form)");
		HttpSession session = rq.getSession(false);
		
		itemForm = (ItemForm) session.getAttribute("itemForm");
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemForm);	//print itemformSession toString
		}
		
		System.out.println("handMadeCommand: " + handMadeForm);	//print command toString
		
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
			SessionStatus sessionStatus, HandMade handMade) {
		System.out.println("detailItem.do");
		
		HttpSession session = rq.getSession(false);
		itemformSession = (ItemForm) session.getAttribute("itemForm");
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemformSession);	// print itemformSession toString
		}
		
		System.out.println(handMadeForm);
	
		//put itemformSession to item
		Item item = new Item(itemformSession.getUnitCost(), itemformSession.getTitle(), 
				itemformSession.getDescription(), itemformSession.getQty(), "A", 	// must change userId -> loginCommand.getUserId()
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
			itemFacade.insertTag(t);	// matching tag - item (via itemId) , insert DB
		}
		
		handMade.setItemId(item.getItemId());
		handMade.setListPrice(handMadeForm.getListPrice());
		
		itemFacade.insertHandMade(handMade);	// insert DB
		
		model.addAttribute("handMade", handMade);
		model.addAttribute("productId", item.getProductId());
		
		sessionStatus.setComplete();	// session close
		return DETAIL;
	}
	
	////////////////////////////////////////////////
	// HandMade View Controller
	////////////////////////////////////////////////
	
	@RequestMapping("/shop/handMade/viewItem.do")
	public String handMadeView(@RequestParam("itemId") int itemId, 
			@RequestParam("productId") int productId, ModelMap model) {
		HandMade handMade = this.itemFacade.getHandMadeById(itemId);
		
		model.addAttribute("handMade", handMade);
		model.addAttribute("productId", productId);
		return DETAIL;
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
