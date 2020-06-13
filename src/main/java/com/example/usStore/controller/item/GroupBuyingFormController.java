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
@SessionAttributes("gbform")	
public class GroupBuyingFormController {
	private static final String ADD_FORM1 = "product/item";
	private static final String ADD_FORM2 = "product/addGroupBuying";
	private static final String CHECK_FORM3 = "product/checkGroupBuying";
	private static final String DetailPage = "product/viewGroupBuying";
	
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
    public String groupBuyingList(@RequestParam("productId") int productId, ModelMap modelMap, Model model) {
	 List<GroupBuying> groupBuyingList = this.itemFacade.getGroupBuyingList();
		
	 //item값도 받아와야 함
	 model.addAttribute("productId", productId);
	 modelMap.put("groupBuyingList", groupBuyingList);
	 return "product/groupBuying";
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
			result.hasFieldErrors("tag")) 
		{		//에러 검증 발생시
				return ADD_FORM1;	// 寃�利� �삤瑜� 諛쒖깮 �떆 step1 form view(item.jsp) 되돌아감
			}
		return ADD_FORM2;	//item 입력 성공시 다음 groupBuying 입력 폼으로 이동
	}//�뤌�쑝濡� �씠�룞
	
	@PostMapping("/shop/groupbuying/step3")		// step2 -> step3 �씠�룞
	public String step3(
			@ModelAttribute("gbform") GroupBuyingForm gbcommand, @RequestParam("productId") int productId, 
			Item itemformSession, 
			BindingResult result, Model model, HttpServletRequest rq) {	
		HttpSession session = rq.getSession(false); //이미 세션이 있다면 그 세션을 돌려주고, 세션이 없으면 새로운 세션을 생성한다.
		System.out.println("command 媛앹껜: " + gbcommand);
		
		// session�뿉 ���옣�맂 regReq 媛앹껜�뿉 ���옣�맂 �엯�젰 媛� 寃�利�
		// �쐞�뿉�꽌 @Valid瑜� �넻�빐 Hibernate Validator瑜� �궗�슜�븿
		// MemberRegistValidator瑜� 吏곸젒 援ы쁽�븯�뿬 �궗�슜�븷 寃쎌슦 �븘�옒 肄붾뱶 �떎�뻾
		// new MemberRegistValidator().validate(memRegReq, bindingResult);	
		

		if (result.hasFieldErrors("listPrice") ||
				result.hasFieldErrors("deadLine")) {	
			return ADD_FORM2;		// 寃�利� �삤瑜� 諛쒖깮 �떆 step2 form view(addGroupBuying.jsp)濡� �씠�룞
		}
		
		itemformSession = (Item) session.getAttribute("item");
		Item item = new Item(itemformSession.getUnitCost(), itemformSession.getTitle(), 
				itemformSession.getDescription(), itemformSession.getViewCount(), 
				itemformSession.getQty(), itemformSession.getUserId(), productId);
		
		itemFacade.insertItem(item);
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag1());	//tag에 itemId, tagName 적용 후 리스트에 삽입
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag2());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag3());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag4());
		itemformSession.makeTags(item.getItemId(), itemformSession.getTag5());
		
		List<Tag> tags = new ArrayList<Tag>();
		tags = itemformSession.getTags();
		
		for(Tag t : tags) {	//tags 리스트 탐색
			if(t.getTagName() != null || t.getTagName().trim() != "") {	//tagName이 null 또는 빈 값이 아닌 동안
				itemFacade.insertTag(t);	//태그 삽입 완료
			}
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
	
	@RequestMapping("/shop/groupBuying/addItem.do")
	public String goItem(@RequestParam("productId") int productId) {
		System.out.println("item으로 꼬!");
		return "redirect:/shop/item/addItem.do?productId=" + productId;
	}
	
}