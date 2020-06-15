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

	// HandMade 리스트 초기 화면 출력시 실행되는 Controller
	@RequestMapping("/shop/handMade/listItem.do")
	public String listHandMade (
			@RequestParam("productId") int productId, ModelMap model) throws Exception {
  
		PagedListHolder<HandMade> itemList = new PagedListHolder<HandMade>(this.itemFacade.getHandMadeList());
		itemList.setPageSize(4);
		
		model.put("itemList", itemList);
		model.put("productId", productId);
		return "product/handMade";
	}
	
	// 페이지 넘어갈때 실행되는 Controller
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

	@PostMapping("/shop/handMade/step3")		// step2 -> step3 占쎌뵠占쎈짗
	public String step3(
			@ModelAttribute("HandMade") HandMadeForm handMadeForm, 
			@RequestParam("productId") int productId, Item itemformSession, 
			BindingResult result, Model model, HttpServletRequest rq) {	
		HttpSession session = rq.getSession(false); //�씠誘� �꽭�뀡�씠 �엳�떎硫� 洹� �꽭�뀡�쓣 �룎�젮二쇨퀬, �꽭�뀡�씠 �뾾�쑝硫� �깉濡쒖슫 �꽭�뀡�쓣 �깮�꽦�븳�떎.
		System.out.println("handMadeCommand: " + handMadeForm);	//print command toString
		
		// session占쎈퓠 占쏙옙占쎌삢占쎈쭆 regReq 揶쏆빘猿쒙옙肉� 占쏙옙占쎌삢占쎈쭆 占쎌뿯占쎌젾 揶쏉옙 野껓옙筌앾옙
		// 占쎌맄占쎈퓠占쎄퐣 @Valid�몴占� 占쎈꽰占쎈퉸 Hibernate Validator�몴占� 占쎄텢占쎌뒠占쎈맙
		// MemberRegistValidator�몴占� 筌욊낯�젔 �뤃�뗭겱占쎈릭占쎈연 占쎄텢占쎌뒠占쎈막 野껋럩�뒭 占쎈툡占쎌삋 �굜遺얜굡 占쎈뼄占쎈뻬
		// new MemberRegistValidator().validate(memRegReq, bindingResult);	

//		if (result.hasFieldErrors("listPrice") ||
//				result.hasFieldErrors("deadLine")) {	
//			return ADD_GroupBuying_FORM;		// 野껓옙筌앾옙 占쎌궎�몴占� 獄쏆뮇源� 占쎈뻻 step2 form view(addGroupBuying.jsp)嚥∽옙 占쎌뵠占쎈짗
//		}
		
		itemformSession = (Item) session.getAttribute("item");
		Item item = new Item(itemformSession.getUnitCost(), itemformSession.getTitle(), 
				itemformSession.getDescription(), itemformSession.getQty(), itemformSession.getUserId(), productId);
		
		itemFacade.insertItem(item);
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag1());	//tag�뿉 itemId, tagName �쟻�슜 �썑 由ъ뒪�듃�뿉 �궫�엯
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag2());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag3());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag4());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag5());
		
		List<Tag> tags = new ArrayList<Tag>();
		tags = itemformSession.getTags();
		
		for(Tag t : tags) {	//tags 由ъ뒪�듃 �깘�깋
			if(t.getTagName() != null || t.getTagName().trim() != "") {	//tagName�씠 null �삉�뒗 鍮� 媛믪씠 �븘�땶 �룞�븞
				itemFacade.insertTag(t);	//�깭洹� �궫�엯 �셿猷�
			}
		}
		
		return CHECK_FORM3;		// 占쎌궎�몴占� 占쎈씨占쎌몵筌롳옙 step3 form view(checkGroupBuying.jsp)嚥∽옙 占쎌뵠占쎈짗
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
