package com.example.usStore.controller.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.domain.Item;
import com.example.usStore.service.facade.UsStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
public class ViewItemController { 

	private UsStoreFacade usStore;

	@Autowired
	public void setusStore(UsStoreFacade usStore) {
		this.usStore = usStore;
	}

//	@RequestMapping("/shop/viewItem.do")
//	public String handleRequest(
//			@RequestParam("itemId") int itemId,
//			ModelMap model) throws Exception {
//		Item item = this.usStore.getItem(itemId);
//		model.put("item", item);
//		//.put("product", item.getProduct());
//		return "Item";
//	}

}
