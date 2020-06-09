package com.example.usStore.controller.item;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.usStore.domain.GroupBuying;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.usStore.domain.Item;
import com.example.usStore.service.impl.ItemImpl;

@Controller
@SessionAttributes({"gbform","item"})	
public class GroupBuyingFormController {
	private static final String ADD_FORM1 = "Product/item";
	private static final String ADD_FORM2 = "Product/addGroupBuying";
	private static final String CHECK_FORM3 = "Product/checkGroupBuying";
	private static final String DetailPage = "Product/viewGroupBuying";
	
	@ModelAttribute("gbform")
	public GroupBuyingForm formBacking(
			@ModelAttribute("item") Item item) {
		GroupBuyingForm gbform = new GroupBuyingForm();
		
		gbform.setItemId(item.getItemId());
		gbform.setSupplierId(item.getSupplierId());
		gbform.setUnitCost(item.getUnitCost());
		gbform.setTitle(item.getTitle());
		gbform.setDescription(item.getDescription());
		gbform.setViewCount(item.getViewCount());
		gbform.setTagId(item.getTagId());
		gbform.setQuantity(item.getQuantity());
		gbform.setUserId(item.getUserId());
		gbform.setProductId(item.getProductId());
		
		return gbform;
	}   
	
	@GetMapping("/step1")		// step1 요청
	public String step1() {
		return ADD_FORM1;	// step1 form view(item.jsp)로 이동
	}
	
	@GetMapping("/step2")		// step3 -> step2 이동	
	public String step2FromStep3() {
		return ADD_FORM2;	// step2 form view로 이동
	}
	
	@RequestMapping(value="step2/0", method = RequestMethod.GET)
	public String form1(
			@Valid @ModelAttribute("gbform") GroupBuyingForm gbcommand, 
			BindingResult result) {
		System.out.println("command 객체: " + gbcommand);
		
		if (result.hasFieldErrors("title") ||
			result.hasFieldErrors("description") ||
			result.hasFieldErrors("unitCost") ||
			result.hasFieldErrors("qty") ||
			result.hasFieldErrors("tag")) {		
				return ADD_FORM1;	// 검증 오류 발생 시 step1 form view(item.jsp)로 이동
			}
		return ADD_FORM2;
	}//폼으로 이동
	
	@PostMapping("/shop/groupbuying/step3")		// step2 -> step3 이동
	public String step3(
			@Valid @ModelAttribute("gbform") GroupBuyingForm gbcommand, 
			BindingResult result, Model model) {		
		System.out.println("command 객체: " + gbcommand);
		
		// session에 저장된 regReq 객체에 저장된 입력 값 검증
		// 위에서 @Valid를 통해 Hibernate Validator를 사용함
		// MemberRegistValidator를 직접 구현하여 사용할 경우 아래 코드 실행
		// new MemberRegistValidator().validate(memRegReq, bindingResult);	
		

		if (result.hasFieldErrors("listPrice") ||
				result.hasFieldErrors("deadLine")) {	
			return ADD_FORM2;		// 검증 오류 발생 시 step2 form view(addGroupBuying.jsp)로 이동
		}
		return CHECK_FORM3;		// 오류 없으면 step3 form view(checkGroupBuying.jsp)로 이동
	}
	
	@PostMapping("/shop/groupbuying/detailItem/${groupbuying.itemId}")		// step3 -> done 이동
	public String regist(
			@ModelAttribute("gbform") GroupBuyingForm gbcommand, BindingResult result,
			Model model, SessionStatus sessionStatus) {	
		System.out.println("command 객체: " + gbcommand);
			
		GroupBuying gb;
		
		gb = ItemImpl.insertGroupBuying(gbcommand);
			/* ItemImpl.insertGroupBuying 메소드를 
			 * @Override public GroupBuying insertGroupBuying(GroupBuyingForm gbcommand) { // TODO
			 * groupBuyingDao.insertGroupBuying(GroupBuying); 
			 * }
			 * 이렇게 변경해야 할듯..?
			 */
		
		model.addAttribute("newGroupBuying", gb);
		
		List<GroupBuying> gbs = ItemImpl.getGroupBuyingList();
		model.addAttribute("groupBuyingList", gbs);
		
		sessionStatus.setComplete();	// session 종료		
		return DetailPage;
	}
}
