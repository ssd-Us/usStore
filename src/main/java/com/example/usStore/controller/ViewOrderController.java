package com.example.usStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.example.usStore.domain.Orders;
import com.example.usStore.service.UsStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 01.12.2003
 * @modified by Changsup Park
 */
@Controller
@SessionAttributes("userSession")
public class ViewOrderController {

	private UsStoreFacade usStore;

	@Autowired
	public void setusStore(UsStoreFacade usStore) {
		this.usStore = usStore;
	}

	@RequestMapping("/shop/viewOrder.do")
	public ModelAndView handleRequest(
			@ModelAttribute("userSession") UserSession userSession,
			@RequestParam("orderId") int orderId
			) throws Exception {
		Orders order = this.usStore.getOrder(orderId);
		if (userSession.getAccount().getName().equals(order.getShipToName())) {
			return new ModelAndView("ViewOrder", "order", order);
		}
		else {
			return new ModelAndView("Error", "message", "You may only view your own orders.");
		}
	}
}
