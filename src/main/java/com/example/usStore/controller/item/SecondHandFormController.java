package com.example.usStore.controller.item;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.example.usStore.domain.Auction;
import com.example.usStore.domain.Product;
import com.example.usStore.domain.SecondHand;
import com.example.usStore.service.facade.ItemFacade;

@Controller
@SessionAttributes("secondHandForm")
public class SecondHandFormController {
	
	private ItemFacade itemFacade;
	
	@Autowired
	public void setItemFacade(ItemFacade itemFacade) {
		this.itemFacade = itemFacade;
	}

	//¡ﬂ∞Ì∞≈∑° ∞‘Ω√π∞ ∏Ò∑œ ∫∏ø©¡÷±‚
	@RequestMapping("/shop/secondHand/listItem.do")
	public String secondHandList(@RequestParam("productId") int productId, ModelMap model) throws Exception{
		PagedListHolder<SecondHand> itemList = new PagedListHolder<SecondHand>(this.itemFacade.getSecondHandList());
		itemList.setPageSize(4);
		System.out.println("Ïó¨Í∏∞Îäî Í≤åÏãúÎ¨º Î™©Î°ù Ïª®Ìä∏Î°§Îü¨\n ");

		model.put("itemList", itemList);
		return "product/secondHand"; //∫‰ ≥◊¿”¿∫ ±◊ ∏Ò∑œ ∫∏ø©¡÷¥¬ ∆‰¿Ã¡ˆ 
	}
	
	@RequestMapping("/shop/secondHand/viewItem.do") 
	public String viewSecondHand(@RequestParam("itemId") int itemId, ModelMap model) {
		  SecondHand sh = this.itemFacade.getSecondHandItem(itemId);
		  //µµ∏ﬁ¿Œø°º≠ ∞°¡ÆøÕæﬂ«‘ µ∫Òø°º≠ ∫“∑Øø¬∞… µµ∏ﬁ¿Œø° ¿˙¿Â«ÿ≥ 
	      model.addAttribute("sh", sh);

	      return "product/viewSecondHand";
	}
	 
	@RequestMapping("/shop/secondHand/addItem.do")
	public String goItem(@RequestParam("productId") int productId) {
	      return "redirect:/shop/item/addItem.do?productId=" + productId;
	}
	
	@ModelAttribute("secondHandForm")
	public SecondHandForm createSecondHandForm() {
		return new SecondHandForm();
	}
	
	@RequestMapping("/shop/secondHand/addItem/${itemId}")
	public ModelAndView handleRequest(
			@PathVariable String itemId,
			@ModelAttribute("secondHandForm") SecondHand secondHand 
			) throws Exception {
		/*
		 * if (cart.containsItemId(workingItemId)) {
		 * cart.incrementQuantityByItemId(workingItemId); } else { boolean isInStock =
		 * this.petStore.isItemInStock(workingItemId); Item item =
		 * this.petStore.getItem(workingItemId); cart.addItem(item, isInStock); } return
		 * new ModelAndView("Cart", "cart", cart);
		 */
		return null;
	}
	
	
}
