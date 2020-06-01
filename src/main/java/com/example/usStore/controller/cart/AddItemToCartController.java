package com.example.usStore.controller.cart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.example.usStore.domain.Cart;
import com.example.usStore.domain.Item;
import com.example.usStore.service.facade.UsStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
@SessionAttributes("sessionCart")
public class AddItemToCartController { 

	private UsStoreFacade usStore;

	@Autowired
	public void setusStore(UsStoreFacade usStore) {
		this.usStore = usStore;
	}

	@ModelAttribute("sessionCart")
	public Cart createCart() {
		return new Cart();
	}
	
	@RequestMapping("/shop/addItemToCart.do")
	public ModelAndView handleRequest(
			@RequestParam("workingItemId") int workingItemId,
			@ModelAttribute("sessionCart") Cart cart 
			) throws Exception {
		if (cart.containsItemId(workingItemId)) {
			cart.incrementQuantityByItemId(workingItemId);
		}
		else {
			// isInStock is a "real-time" property that must be updated
			// every time an item is added to the cart, even if other
			// item details are cached.
			
			// 없는 함수라 필요하다면 만들어야함
//			boolean isInStock = this.usStore.isItemInStock(workingItemId);
//			Item item = this.usStore.getItem(workingItemId);
//			cart.addItem(item, isInStock);
		}
		return new ModelAndView("Cart", "cart", cart);
	}
}