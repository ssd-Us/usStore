package com.example.usStore.controller.item;

import java.util.ArrayList;
<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> develop
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
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.PathVariable;
>>>>>>> develop
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
<<<<<<< HEAD

import com.example.usStore.controller.mypage.UserSession;
=======
import org.springframework.web.servlet.ModelAndView;

>>>>>>> develop
import com.example.usStore.domain.GroupBuying;
import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;
<<<<<<< HEAD
import com.example.usStore.service.HandMadeFormValidator;
import com.example.usStore.service.facade.ItemFacade;
import com.example.usStore.service.facade.MyPageFacade;

@Controller
@SessionAttributes({"handMadeForm", "handMadeList"})
=======
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"handMadeForm", "itemList"})
>>>>>>> develop
public class HandMadeFormController {

	private static final String ADD_HANDMADE_FORM = "product/addHandMade";
	private static final String CHECK_FORM3 = "product/checkHandMade";
<<<<<<< HEAD
	private static final String HANDMADE_LIST = "product/handMade";
	private static final String DETAIL = "product/viewHandMade";
	
	@Autowired
	private ItemFacade itemFacade;

	@Autowired
	private MyPageFacade myPageFacade;
	
	@Autowired
=======
	private static final String DETAIL = "product/viewHandMade";
	private static final String HANDMADE_LIST = "product/handMade";
	
	private ItemFacade itemFacade;

	@Autowired
>>>>>>> develop
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
<<<<<<< HEAD

=======
	
>>>>>>> develop
	// HandMade 리스트 초기 화면 출력시 실행되는 Controller
	@RequestMapping("/shop/handMade/listItem.do")
	public String listHandMade (
			@RequestParam("productId") int productId, ModelMap model) throws Exception {
  
<<<<<<< HEAD
		PagedListHolder<HandMade> handMadeList = new PagedListHolder<HandMade>(this.itemFacade.getHandMadeList());
		handMadeList.setPageSize(4);
		
		model.put("handMadeList", handMadeList);
=======
		PagedListHolder<HandMade> itemList = new PagedListHolder<HandMade>(this.itemFacade.getHandMadeList());
		itemList.setPageSize(4);
		
		model.put("itemList", itemList);
>>>>>>> develop
		model.put("productId", productId);
		return HANDMADE_LIST;
	}
	
<<<<<<< HEAD
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
	
=======
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
	
>>>>>>> develop
	////////////////////////////////////////////////
	// HandMade Add Controller
	////////////////////////////////////////////////
	
	@RequestMapping("/shop/handMade/gobackItem.do")		// item.jsp
<<<<<<< HEAD
	public String step1(@ModelAttribute("handMadeForm") HandMadeForm handMadeForm, 
=======
	public String step1(@ModelAttribute("HandMade") HandMadeForm handMadeForm, 
>>>>>>> develop
			@RequestParam("productId") int productId) {
		System.out.println("go back to item.jsp");
		return "redirect:/shop/item/addItem.do?productId=" + productId;	// step1 form view(item.jsp)
	}
	
	@RequestMapping(value="/shop/handMade/addItem2.do", method = RequestMethod.GET)
<<<<<<< HEAD
	public String step2(@ModelAttribute("handMadeForm") HandMadeForm handMadeForm, 
			@RequestParam("productId") int productId, Model model, HttpServletRequest rq) {

		HttpSession session = rq.getSession(false);
		if(session.getAttribute("status") != null) {
			int status = (int) session.getAttribute("status");
			int itemId = status;
			
			System.out.println("from edit - addItem2.do");
			HandMade handMade = itemFacade.getHandMadeById(itemId);
			System.out.println("itemFacade : " + itemFacade.getHandMadeById(itemId));
			handMadeForm.setItemId(itemId);
			handMadeForm.setListPrice(handMade.getListPrice());
			System.out.println(handMadeForm);
		}
=======
	public String step2(
			@ModelAttribute("HandMade") HandMadeForm handMadeForm, 
			@RequestParam("productId") int productId, Model model) {

		System.out.println("handMadeForm controller"); // print toString

>>>>>>> develop
		model.addAttribute("productId", productId);
		return ADD_HANDMADE_FORM; // addHandMade.jsp
	}
	
	@GetMapping("handMade/step2")		// step3 -> step2
	public String step2FromStep3() {
		return ADD_HANDMADE_FORM;	// step2 form view
	}

	@PostMapping("/shop/handMade/step3.do")		// step2 -> step3 占쎌뵠占쎈짗
	public String step3(
<<<<<<< HEAD
			@ModelAttribute("handMadeForm") HandMadeForm handMadeForm, BindingResult bindingResult, 
			HttpServletRequest rq, ItemForm itemForm, Model model, ModelMap modelMap) {
		
		System.out.println("step3.do(before check form)");
		HttpSession session = rq.getSession(false);
		new HandMadeFormValidator().validate(handMadeForm, bindingResult);

		System.out.println("step3.do : " + handMadeForm);
		
		if(session.getAttribute("itemForm") != null) {
			itemForm = (ItemForm) session.getAttribute("itemForm");
			System.out.println("itemformSession: " + itemForm);	//print itemformSession toString
		}
		if(handMadeForm.getListPrice() >= itemForm.getUnitCost()) {
			bindingResult.rejectValue("listPrice", "mustDiscount");
		}
		
		if (bindingResult.hasErrors()) {	//유효성 검증 에러 발생시
			model.addAttribute("productId", itemForm.getProductId());
			return ADD_HANDMADE_FORM;
		}
		
		System.out.println("handMadeForm step3.do : " + handMadeForm);
		model.addAttribute(itemForm);
		modelMap.addAttribute("tags", itemForm.getTags());
		return CHECK_FORM3;	// step3(CHECK_FORM3)
	}
	
	@PostMapping("/shop/handMade/detailItem.do")		// step3 -> done
	public String finalAddHandMade(@ModelAttribute("handMadeForm") HandMadeForm handMadeForm, 
			ItemForm itemFormSession, BindingResult result, Model model, HttpServletRequest rq, 
			SessionStatus sessionStatus, ModelMap modelMap) {
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
		
		System.out.println("detail.do : " + handMadeForm);
	
		//put itemformSession to item
		Item item = new Item(itemFormSession.getUnitCost(), itemFormSession.getTitle(), 
				itemFormSession.getDescription(), itemFormSession.getQty(), suppId, 	// must change userId -> loginCommand.getUserId()
				itemFormSession.getProductId());
		
		if(status != 0) {
			//수정 필요
			item.setItemId(status);
			item.setViewCount(itemFormSession.getViewCount());
			itemFacade.updateItem(item);
			System.out.println("itemUpdated" + item);
			
			List<Tag> tags = itemFacade.getTagByItemId(status);
			System.out.println("tag size : " + tags.size());	//0
			
			// 기존 태그 전부 삭제
			if(tags.size() > 0) {
				itemFacade.deleteTag(status);
				tags.removeAll(tags);
			}
		}

		System.out.println("itemId: " + item.getItemId());	//print itemformSession toString
	
		// generate tags(only have tagName)
		for (int i = 0; i < itemFormSession.getTags().size(); i++) {
			item.makeTags(itemFormSession.getTags().get(i)); // if(tag != null && "") then addTags
		}
		System.out.println("최종 태그:" + item.getTags());

		HandMade handMade = new HandMade(item, handMadeForm.getItemId(), handMadeForm.getListPrice());
		System.out.println("detail = " + handMade);
		//transaction
		if(status != 0) {
			itemFacade.updateHandMade(handMade); // update DB
			System.out.println("update = " + handMade);
		}
		else {
			itemFacade.insertHandMade(handMade);	// insert DB
			System.out.println("update = " + handMade);
		}
		System.out.println("finally = " + handMade);
		sessionStatus.setComplete();	// groupBuying, editStatus session close
		session.removeAttribute("itemForm");	//itemForm session close
		session.removeAttribute("status");
		System.out.println("detail ItemId = " + handMade.getItemId());
		return "redirect:/shop/handMade/viewItem.do?itemId=" + handMade.getItemId() + "&productId=" + item.getProductId();
	}
	
	////////////////////////////////////////////////
	// HandMade View Controller
	////////////////////////////////////////////////
	
	@RequestMapping("/shop/handMade/viewItem.do")
	public String handMadeView(@RequestParam("itemId") int itemId,	
			@RequestParam("productId") int productId, 
			HttpServletRequest rq, Model model, ModelMap modelMap) {
		
		System.out.println("viewItem.do");
		System.out.println("itemId:" + itemId);	

		HttpSession session = rq.getSession(false);
		
		if(session.getAttribute("userSession") != null) {
			UserSession userSession = (UserSession) session.getAttribute("userSession");
		
			String suppId = userSession.getAccount().getUserId();
			
			System.out.println("suppId: " + suppId);
			model.addAttribute("suppId", suppId);
		}
		
		System.out.println("View HandMade Controller !!");
		
		HandMade handMade = this.itemFacade.getHandMadeById(itemId);
		handMade.setItemId(itemId);
		System.out.println(handMade);
		
		System.out.println("viewCount : " + handMade.getViewCount());
		this.itemFacade.updateViewCount(handMade.getViewCount() + 1, itemId);
//		handMade = this.itemFacade.getHandMadeById(itemId);
		System.out.println("object's viewcount ++ ? : " + handMade);

		List<Tag> tags = new ArrayList<Tag>();
		tags = itemFacade.getTagByItemId(handMade.getItemId());
		
		model.addAttribute("productId", productId);
		model.addAttribute("handMade", handMade);
		
		modelMap.addAttribute("tags", tags);
		
=======
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
>>>>>>> develop
		return DETAIL;
	}
	
	////////////////////////////////////////////////
<<<<<<< HEAD
	// HandMade Edit Controller
	////////////////////////////////////////////////
	
	@RequestMapping("/shop/handMade/edit.do") //edit Item
	public String editItem(ItemForm itemForm, 
					Item item,	@RequestParam("itemId") int itemId, HttpServletRequest rq)
	{
		HttpSession session = rq.getSession(true);
		
		HandMade handMade = itemFacade.getHandMadeById(itemId);
		List<Tag> tags = new ArrayList<Tag>();
		tags = itemFacade.getTagByItemId(itemId);
		
		System.out.println("edit.do");
		if(session.getAttribute("status") != null) {
			int status = (int) session.getAttribute("status");
			System.out.println("itemId(status) : " + status);
		}
		
		if(session.getAttribute("itemForm") != null) {
			itemForm = (ItemForm) session.getAttribute("itemForm");
		} else {
			itemForm = new ItemForm();
		}
		itemForm.setItemId(itemId);
		itemForm.setUnitCost(handMade.getUnitCost());
		itemForm.setTitle(handMade.getTitle());
		itemForm.setDescription(handMade.getDescription());
		itemForm.setQty(handMade.getQty());
		itemForm.setViewCount(handMade.getViewCount());
		itemForm.setTags(handMade.getTags());

		session.setAttribute("itemForm", itemForm);
		session.setAttribute("status", itemId);
		System.out.println(itemForm);
		
		return "redirect:/shop/item/addItem.do?productId=" + handMade.getProductId();
	}
	
	
=======
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
	
>>>>>>> develop
	////////////////////////////////////////////////
	// HandMade Delete Controller
	////////////////////////////////////////////////
	
	@RequestMapping("/shop/handMade/deleteItem.do")
	public String delete(@RequestParam("productId") int productId, @RequestParam("itemId") int itemId, ModelMap model) {
		this.itemFacade.deleteItem(itemId);
		return "redirect:/shop/handMade/listItem.do?productId=" + productId;
	}
}
