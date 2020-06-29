package com.example.usStore.controller.event;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewEventController {

	@RequestMapping("/shop/event/viewEvent.do") 
	public String auctionList(@RequestParam("catId") int catId, ModelMap model, HttpServletRequest rq) {
		
		System.out.println("카테고리 아이디 : " + catId);
	    if (catId == 4) {
	    	return "event/roulette";
	    }
	    return "";
	}
}
