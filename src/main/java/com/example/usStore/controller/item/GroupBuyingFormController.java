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
import com.example.usStore.domain.SecondHand;
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
@SessionAttributes("gbform")	
public class GroupBuyingFormController {
	private static final String GoItemFORM = "redirect:/shop/item/addItem.do?productId=";
	private static final String ADD_GroupBuying_FORM = "product/addGroupBuying";
	private static final String CHECK_FORM3 = "product/checkGroupBuying";
	private static final String DetailPage = "product/viewGroupBuying";
	
	@Autowired
	private ItemFacade itemFacade; 
	
	@RequestMapping("/shop/groupBuying/listItem.do") 
    public String groupBuyingList(@RequestParam("productId") int productId, ModelMap modelMap, Model model) {
	 List<GroupBuying> groupBuyingList = this.itemFacade.getGroupBuyingList();
		
	 //item媛믩룄 諛쏆븘���빞 �븿
	 model.addAttribute("productId", productId);
	 modelMap.put("groupBuyingList", groupBuyingList);
	 return "product/groupBuying";
   }
	
	@RequestMapping("/shop/groupBuying/gobackItem.do")		// item.jsp
	public String step1() {
		return GoItemFORM;	// step1 form view(item.jsp)
	}
	
	@GetMapping("/step2")		// step3 -> step2
	public String step2FromStep3() {
		return ADD_GroupBuying_FORM;	// step2 form view
	}
	
	@RequestMapping(value="/shop/groupBuying/addItem.do", method = RequestMethod.GET)
	public String step2(
			@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
			@RequestParam("productId") int productId, Model model) {
		System.out.println("groupBuyingForm controller");	//print toString
//		
//		if (result.hasFieldErrors("title") ||
//			result.hasFieldErrors("description") ||
//			result.hasFieldErrors("unitCost") ||
//			result.hasFieldErrors("qty") ||
//			result.hasFieldErrors("tag")) 
//		{		
//				return GoItemFORM;	
//			}
		model.addAttribute("productId", productId);
		return ADD_GroupBuying_FORM;	// addGroupBuying.jsp
	}
	
	@PostMapping("/shop/groupbuying/step3")		// step2 -> step3 占쎌뵠占쎈짗
	public String step3(
			@ModelAttribute("GroupBuying") GroupBuyingForm groupBuyingForm, 
			@RequestParam("productId") int productId, Item itemformSession, 
			BindingResult result, Model model, HttpServletRequest rq) {	
		HttpSession session = rq.getSession(false); //�씠誘� �꽭�뀡�씠 �엳�떎硫� 洹� �꽭�뀡�쓣 �룎�젮二쇨퀬, �꽭�뀡�씠 �뾾�쑝硫� �깉濡쒖슫 �꽭�뀡�쓣 �깮�꽦�븳�떎.
		System.out.println("GroupBuyingCommand: " + groupBuyingForm);	//print command toString
		
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
	
	@PostMapping("/shop/groupbuying/detailItem/${groupbuying.itemId}")		// step3 -> done 占쎌뵠占쎈짗
	public String addGroupBuyingItem(
			GroupBuying groupBuying, @ModelAttribute("gbform") GroupBuyingForm gbform, 
			BindingResult result, Model model, SessionStatus sessionStatus, HttpServletRequest request) {
		System.out.println("command 揶쏆빘猿�: " + gbform);
		
		HttpSession session = request.getSession(false); //占쎌뵠沃섓옙 占쎄쉭占쎈�∽옙�뵠 占쎌뿳占쎈뼄筌롳옙 域뱄옙 占쎄쉭占쎈�∽옙�뱽 占쎈즼占쎌젻雅뚯눊��, 占쎄쉭占쎈�∽옙�뵠 占쎈씨占쎌몵筌롳옙 null占쎌뱽 占쎈즼占쎌젻餓ο옙占쎈뼄.
		if(session.getAttribute("itemForm") != null) {	//itemForm 占쎄쉭占쎈�∽옙�뵠 鈺곕똻�삺占쎈립占쎈뼄筌롳옙
			System.out.println("itemForm 占쎄쉭占쎈�� 鈺곕똻�삺");
			
		/*	((itemForm)session.getAttribute("itemForm"))
			itemImpl.insertItem()*/
		}
		
		/*
		 * groupBuying.s itemImpl.insertGroupBuying(groupBuying);
		 */
		
			/* ItemImpl.insertGroupBuying 筌롫뗄�꺖占쎈굡�몴占� 
			 * @Override public GroupBuying insertGroupBuying(GroupBuyingForm gbcommand) { // TODO
			 * groupBuyingDao.insertGroupBuying(GroupBuying); 
			 * }
			 * 占쎌뵠占쎌쟽野껓옙 癰귨옙野껋�鍮먲옙鍮� 占쎈막占쎈쾹..?
			 */
	
		model.addAttribute("newGroupBuying", gbform);
		
		List<GroupBuying> gbs = itemFacade.getGroupBuyingList();
		model.addAttribute("groupBuyingList", gbs);
		
		sessionStatus.setComplete();	// session �넫�굝利�		
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
	
	@RequestMapping("/shop/groupBuying/addItem.do")
	public String goItem(@RequestParam("productId") int productId) {
		System.out.println("item�쑝濡� 瑗�!");
		return "redirect:/shop/item/addItem.do?productId=" + productId;
	}
	
}