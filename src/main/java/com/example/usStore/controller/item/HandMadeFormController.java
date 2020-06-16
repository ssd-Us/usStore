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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.example.usStore.domain.HandMade;
import com.example.usStore.domain.Item;
import com.example.usStore.domain.Tag;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes({"handMadeForm", "itemList"})
public class HandMadeFormController {

	private static final String ADD_HANDMADE_FORM = "product/addHandMade";
	private static final String CHECK_FORM3 = "product/checkHandMade";
	
	private ItemFacade itemFacade;

	@Autowired
	public void setitemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}

	// HandMade 由ъ뒪�듃 珥덇린 �솕硫� 異쒕젰�떆 �떎�뻾�릺�뒗 Controller
	@RequestMapping("/shop/handMade/listItem.do")
	public String listHandMade (
			@RequestParam("productId") int productId, ModelMap model) throws Exception {
  
		PagedListHolder<HandMade> itemList = new PagedListHolder<HandMade>(this.itemFacade.getHandMadeList());
		itemList.setPageSize(4);
		
		model.put("itemList", itemList);
		model.put("productId", productId);
		return "product/handMade";
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
		return "product/handMade";
	}
	
	@RequestMapping("/shop/handMade/gobackItem.do")		// item.jsp
	public String step1() {
		return "redirect:/shop/item/addItem.do?productId=";	// step1 form view(item.jsp)
	}
	
	@RequestMapping("/shop/handMade/addItem.do")
	public String goItem(@RequestParam("productId") int productId) {
	      return "redirect:/shop/item/addItem.do?productId=" + productId;
	}

	@PostMapping("/shop/handMade/step3")		// step2 -> step3 �뜝�럩逾졾뜝�럥吏�
	public String step3(
			@ModelAttribute("HandMade") HandMadeForm handMadeForm, 
			@RequestParam("productId") int productId, ItemForm itemformSession, 
			BindingResult result, Model model, HttpServletRequest rq) {	
		HttpSession session = rq.getSession(false); //占쎌뵠沃섓옙 占쎄쉭占쎈�∽옙�뵠 占쎌뿳占쎈뼄筌롳옙 域뱄옙 占쎄쉭占쎈�∽옙�뱽 占쎈즼占쎌젻雅뚯눊��, 占쎄쉭占쎈�∽옙�뵠 占쎈씨占쎌몵筌롳옙 占쎄퉱嚥≪뮇�뒲 占쎄쉭占쎈�∽옙�뱽 占쎄문占쎄쉐占쎈립占쎈뼄.
		System.out.println("handMadeCommand: " + handMadeForm);	//print command toString
		
		// session�뜝�럥�뱺 �뜝�룞�삕�뜝�럩�궋�뜝�럥彛� regReq �뤆�룇鍮섊뙼�뮋�삕�굢占� �뜝�룞�삕�뜝�럩�궋�뜝�럥彛� �뜝�럩肉��뜝�럩�졑 �뤆�룊�삕 �뇦猿볦삕嶺뚯빢�삕
		// �뜝�럩留꾢뜝�럥�뱺�뜝�럡�맋 @Valid占쎈ご�뜝占� �뜝�럥苑겼뜝�럥�돵 Hibernate Validator占쎈ご�뜝占� �뜝�럡�뀬�뜝�럩�뮔�뜝�럥留�
		// MemberRegistValidator占쎈ご�뜝占� 嶺뚯쉳�궚占쎌젘 占쎈쨨占쎈뿭寃긷뜝�럥由��뜝�럥�뿰 �뜝�럡�뀬�뜝�럩�뮔�뜝�럥留� �뇦猿뗫윪占쎈뮡 �뜝�럥�닡�뜝�럩�굥 占쎄턀�겫�뼔援� �뜝�럥堉꾢뜝�럥六�
		// new MemberRegistValidator().validate(memRegReq, bindingResult);	

//		if (result.hasFieldErrors("listPrice") ||
//				result.hasFieldErrors("deadLine")) {	
//			return ADD_GroupBuying_FORM;		// �뇦猿볦삕嶺뚯빢�삕 �뜝�럩沅롳옙紐닷뜝占� �뛾�룇裕뉑틦占� �뜝�럥六� step2 form view(addGroupBuying.jsp)�슖�댙�삕 �뜝�럩逾졾뜝�럥吏�
//		}
		
		itemformSession = (ItemForm) session.getAttribute("itemForm");
		Item item = new Item(itemformSession.getUnitCost(), itemformSession.getTitle(), 
				itemformSession.getDescription(), itemformSession.getQty(), itemformSession.getUserId(), productId);
		
		itemFacade.insertItem(item);
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag1());	//tag占쎈퓠 itemId, tagName 占쎌읅占쎌뒠 占쎌뜎 �뵳�딅뮞占쎈뱜占쎈퓠 占쎄땜占쎌뿯
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag2());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag3());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag4());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag5());
		
		List<Tag> tags = new ArrayList<Tag>();
		tags = itemformSession.getTags();
		
		for(Tag t : tags) {	//tags �뵳�딅뮞占쎈뱜 占쎄튂占쎄퉳
			if(t.getTagName() != null || t.getTagName().trim() != "") {	//tagName占쎌뵠 null 占쎌굢占쎈뮉 �뜮占� 揶쏅�れ뵠 占쎈툡占쎈빒 占쎈짗占쎈툧
				itemFacade.insertTag(t);	//占쎄묶域뱄옙 占쎄땜占쎌뿯 占쎌끏�뙴占�
			}
		}
		
		return CHECK_FORM3;		// �뜝�럩沅롳옙紐닷뜝占� �뜝�럥�뵪�뜝�럩紐든춯濡녹삕 step3 form view(checkGroupBuying.jsp)�슖�댙�삕 �뜝�럩逾졾뜝�럥吏�
	}
	
	@RequestMapping(value="/shop/handMade/addItem.do", method = RequestMethod.GET)
	public String step2(
			@ModelAttribute("HandMade") HandMadeForm handMadeForm, @RequestParam("productId") int productId,
			Model model) {

		System.out.println("handMadeForm controller"); // print toString

		model.addAttribute("productId", productId);
		return ADD_HANDMADE_FORM; // addHandMade.jsp
	}
	   
	@ModelAttribute("handMadeForm")
	public SecondHandForm createSecondHandForm() {
		return new SecondHandForm();
	}
	
//	@RequestMapping("/shop/handMade/addItem/${itemId}")
//	public ModelAndView handleRequest(
//			@PathVariable int itemId,
//			@ModelAttribute("handMadeForm") HandMade handMade 
//			) throws Exception {
//		/*
//		 * if (cart.containsItemId(workingItemId)) {
//		 * cart.incrementQuantityByItemId(workingItemId); } else { boolean isInStock =
//		 * this.petStore.isItemInStock(workingItemId); Item item =
//		 * this.petStore.getItem(workingItemId); cart.addItem(item, isInStock); } return
//		 * new ModelAndView("Cart", "cart", cart);
//		 */
//		return null;
//    
//	}
	
	@RequestMapping("/shop/handMade/viewItem.do")
	public String handMadeView(@RequestParam("itemId") int itemId, 
			@RequestParam("productId") int productId, ModelMap model) {
		HandMade handMade = this.itemFacade.getHandMadeById(itemId);
		
		model.addAttribute("handMade", handMade);
		model.addAttribute("productId", productId);
		return "product/viewHandMade";
	}
	
	@RequestMapping("/shop/handMade/deleteItem.do")
	public String delete(@RequestParam("productId") int productId, @RequestParam("itemId") int itemId, ModelMap model) {
		this.itemFacade.deleteItem(itemId);
		return "redirect:/shop/handMade/listItem.do?productId=" + productId;
	}
}
