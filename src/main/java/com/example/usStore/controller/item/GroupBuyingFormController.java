package com.example.usStore.controller.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.GroupBuying;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.usStore.domain.Item;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.service.facade.ItemFacade;
import com.example.usStore.controller.item.ItemForm;

@Controller
@SessionAttributes("gbform")	
public class GroupBuyingFormController {
	private static final String ADD_FORM1 = "Product/item";
	private static final String ADD_FORM2 = "Product/addGroupBuying";
	private static final String CHECK_FORM3 = "Product/checkGroupBuying";
	private static final String DetailPage = "Product/viewGroupBuying";
	
	@Autowired
	private ItemFacade itemFacade;

//	@Autowired
//	private ItemForm itemForm;
	
	/*
	 * @ModelAttribute("gbform") public GroupBuyingForm formBacking(
	 * 
	 * @ModelAttribute("item") Item item, HttpServletRequest rq) { GroupBuyingForm
	 * gbform = new GroupBuyingForm();
	 * 
	 * gbform.setItemId(item.getItemId()); gbform.setUnitCost(item.getUnitCost());
	 * gbform.setTitle(item.getTitle());
	 * gbform.setDescription(item.getDescription());
	 * gbform.setViewCount(item.getViewCount()); gbform.setQuantity(item.getQty());
	 * gbform.setUserId(item.getUserId()); gbform.setProductId(item.getProductId());
	 * 
	 * return gbform; 
	 * }
	 */  
	
 @RequestMapping("/shop/groupBuying/listItem.do") 
   public String groupBuyingList(@RequestParam("productId") int productId, ModelMap model) {
	 List<GroupBuying> groupBuyingList = this.itemFacade.getGroupBuyingList();
		
	 //item값도 받아와야 함
     model.put("groupBuyingList", groupBuyingList);
	 return "Product/groupBuying";
   }
	
	@GetMapping("/shop/groupBuying/step1")		// step1 �슂泥�
	public String step1() {
		return ADD_FORM1;	// step1 form view(item.jsp)濡� �씠�룞
	}
	
	@GetMapping("/step2")		// step3 -> step2 �씠�룞	
	public String step2FromStep3() {
		return ADD_FORM2;	// step2 form view濡� �씠�룞
	}
	
	@RequestMapping(value="step2/{productId}", method = RequestMethod.GET)
	public String form1(
			@ModelAttribute("gbform") GroupBuyingForm gbcommand, 
			BindingResult result) {
		System.out.println("command 媛앹껜: " + gbcommand);
		
		if (result.hasFieldErrors("title") ||
			result.hasFieldErrors("description") ||
			result.hasFieldErrors("unitCost") ||
			result.hasFieldErrors("qty") ||
			result.hasFieldErrors("tag")) {		
				return ADD_FORM1;	// 寃�利� �삤瑜� 諛쒖깮 �떆 step1 form view(item.jsp)濡� �씠�룞
			}
		return ADD_FORM2;
	}//�뤌�쑝濡� �씠�룞
	
	@PostMapping("/shop/groupbuying/step3")		// step2 -> step3 �씠�룞
	public String step3(
			@ModelAttribute("gbform") GroupBuyingForm gbcommand, 
			BindingResult result, Model model) {		
		System.out.println("command 媛앹껜: " + gbcommand);
		
		// session�뿉 ���옣�맂 regReq 媛앹껜�뿉 ���옣�맂 �엯�젰 媛� 寃�利�
		// �쐞�뿉�꽌 @Valid瑜� �넻�빐 Hibernate Validator瑜� �궗�슜�븿
		// MemberRegistValidator瑜� 吏곸젒 援ы쁽�븯�뿬 �궗�슜�븷 寃쎌슦 �븘�옒 肄붾뱶 �떎�뻾
		// new MemberRegistValidator().validate(memRegReq, bindingResult);	
		

		if (result.hasFieldErrors("listPrice") ||
				result.hasFieldErrors("deadLine")) {	
			return ADD_FORM2;		// 寃�利� �삤瑜� 諛쒖깮 �떆 step2 form view(addGroupBuying.jsp)濡� �씠�룞
		}
		return CHECK_FORM3;		// �삤瑜� �뾾�쑝硫� step3 form view(checkGroupBuying.jsp)濡� �씠�룞
	}
	
	@PostMapping("/shop/groupbuying/detailItem/${groupbuying.itemId}")		// step3 -> done �씠�룞
	public String addGroupBuyingItem(
			GroupBuying groupBuying, @ModelAttribute("gbform") GroupBuyingForm gbform, 
			BindingResult result, Model model, SessionStatus sessionStatus, HttpServletRequest request) {
		System.out.println("command 媛앹껜: " + gbform);
		
		HttpSession session = request.getSession(false); //�씠誘� �꽭�뀡�씠 �엳�떎硫� 洹� �꽭�뀡�쓣 �룎�젮二쇨퀬, �꽭�뀡�씠 �뾾�쑝硫� null�쓣 �룎�젮以��떎.
		if(session.getAttribute("itemForm") != null) {	//itemForm �꽭�뀡�씠 議댁옱�븳�떎硫�
			System.out.println("itemForm �꽭�뀡 議댁옱");
			
		/*	((itemForm)session.getAttribute("itemForm"))
			itemImpl.insertItem()*/
		}
		
		/*
		 * groupBuying.s itemImpl.insertGroupBuying(groupBuying);
		 */
		
			/* ItemImpl.insertGroupBuying 硫붿냼�뱶瑜� 
			 * @Override public GroupBuying insertGroupBuying(GroupBuyingForm gbcommand) { // TODO
			 * groupBuyingDao.insertGroupBuying(GroupBuying); 
			 * }
			 * �씠�젃寃� 蹂�寃쏀빐�빞 �븷�벏..?
			 */
		
		model.addAttribute("newGroupBuying", gbform);
		
		List<GroupBuying> gbs = itemFacade.getGroupBuyingList();
		model.addAttribute("groupBuyingList", gbs);
		
		sessionStatus.setComplete();	// session 醫낅즺		
		return DetailPage;
	}
}
