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
import com.example.usStore.service.HandMadeFormValidator;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"HandMade", "handMadeList"})
public class HandMadeFormController {

	private static final String ADD_HANDMADE_FORM = "product/addHandMade";
	private static final String CHECK_FORM3 = "product/checkHandMade";
	private static final String HANDMADE_LIST = "product/handMade";
	private static final String DETAIL = "product/viewHandMade";
	
	private ItemFacade itemFacade;

	@Autowired
	public void setitemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}
	
	@ModelAttribute("HandMade")
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
  
		PagedListHolder<HandMade> handMadeList = new PagedListHolder<HandMade>(this.itemFacade.getHandMadeList());
		handMadeList.setPageSize(4);
		
		model.put("handMadeList", handMadeList);
		model.put("productId", productId);
		return HANDMADE_LIST;
	}
	
	// 아이템 4개마다 페이지 구분, 다음 페이지나 이전 페이지로 전환하도록 해주는 Controller
	@RequestMapping("shop/handMade/listItem2.do")
	public String listHandMade2 (
			@ModelAttribute("handMadeList") PagedListHolder<HandMade> handMadeList,
			@RequestParam("pageName") String page,
			ModelMap model) throws Exception {
		if ("next".equals(page)) {
			handMadeList.nextPage();
		}
		else if ("previous".equals(page)) {
			handMadeList.previousPage();
		}
		model.put("handMadeList", handMadeList);
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
			@RequestParam("productId") int productId, Model model, HttpServletRequest rq) {

		System.out.println("handMadeForm controller"); // print toString
		model.addAttribute("handMadeForm", handMadeForm);
		model.addAttribute("productId", productId);
		return ADD_HANDMADE_FORM; // addHandMade.jsp
	}
	
	@GetMapping("handMade/step2")		// step3 -> step2
	public String step2FromStep3() {
		return ADD_HANDMADE_FORM;	// step2 form view
	}

	@PostMapping("/shop/handMade/step3.do")		// step2 -> step3 占쎌뵠占쎈짗
	public String step3(
			@ModelAttribute("HandMade") HandMadeForm handMadeForm, BindingResult bindingResult, 
			HttpServletRequest rq, ItemForm itemForm, Model model) {
		
		System.out.println("step3.do(before check form)");
		HttpSession session = rq.getSession(false);
		new HandMadeFormValidator().validate(handMadeForm, bindingResult);
		System.out.println("요기당!!!");
		if(session.getAttribute("itemForm") != null) {
			itemForm = (ItemForm) session.getAttribute("itemForm");
			System.out.println("itemformSession: " + itemForm);	//print itemformSession toString
		}
		if(handMadeForm.getListPrice() >= itemForm.getUnitCost()) {
			bindingResult.rejectValue("listPrice", "단가보다 높은 가격을 입력해주세요.");
		}
		
		if (bindingResult.hasErrors()) {	//유효성 검증 에러 발생시
			model.addAttribute("productId", itemForm.getProductId());
			return ADD_HANDMADE_FORM;
		}
		
		System.out.println("handMadeForm setting : " + handMadeForm);
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
			ItemForm itemFormSession, BindingResult result, Model model, HttpServletRequest rq, 
			SessionStatus sessionStatus, HandMade handMade, ModelMap modelMap) {
		int status = 0;
		System.out.println("detailItem.do");
		
		HttpSession session = rq.getSession(false);
		itemFormSession = (ItemForm) session.getAttribute("itemForm");	
		if(session.getAttribute("status") != null) {
			status = (int) session.getAttribute("status");
		}
		
		UserSession userSession = (UserSession) session.getAttribute("userSession");
		String suppId = userSession.getAccount().getUserId();
		System.out.println("suppId: " + suppId);
		
		if(session.getAttribute("itemForm") != null) {
			System.out.println("itemformSession: " + itemFormSession);	//print itemformSession toString
		}
		
		System.out.println(handMadeForm);
	
		//put itemformSession to item
		Item item = new Item(itemFormSession.getUnitCost(), itemFormSession.getTitle(), 
				itemFormSession.getDescription(), itemFormSession.getQty(), suppId, 	// must change userId -> loginCommand.getUserId()
				itemFormSession.getProductId());
		
		if(status != 0) {
			item.setItemId(status);
			item.setViewCount(itemFormSession.getViewCount());
			itemFacade.updateItem(item);
			System.out.println("itemUpdated" + item);
			
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
		else {
			itemFacade.insertItem(item);	// -> generate itemId, insert DB
		}

		System.out.println("itemId: " + item.getItemId());	//print itemformSession toString
		
		//generate tags(only have tagName)
		item.makeTags(item.getItemId(), itemFormSession.getTag1());	//if(tag != null && "") then addTags
		item.makeTags(item.getItemId(), itemFormSession.getTag2());
		item.makeTags(item.getItemId(), itemFormSession.getTag3());
		item.makeTags(item.getItemId(), itemFormSession.getTag4());
		item.makeTags(item.getItemId(), itemFormSession.getTag5());
			
		List<Tag> tags = item.getTags();
		item.setTags(tags);
		
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
		
		sessionStatus.setComplete();	// groupBuying, editStatus session close
		session.removeAttribute("itemForm");	//itemForm session close
		session.removeAttribute("status");
		
		return "redirect:/shop/handMade/viewItem.do?itemId=" + handMade.getItemId() + "&productId=" + item.getProductId();
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
		
		System.out.println("View HandMade Controller !!");
		
		HandMade handMade = itemFacade.getHandMadeById(itemId);
//		Item item = itemFacade.getItem(itemId);
		
		System.out.println("viewCount : " + handMade.getViewCount());
		handMade.setViewCount(handMade.getViewCount() + 1);
		System.out.println("object's viewcount ++ ? : " + handMade);
		
		itemFacade.updateHandMade(handMade);// update : viewCount++
//		System.out.println("updated item data: " + itemFacade.getItem(itemId).toString());
				
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
