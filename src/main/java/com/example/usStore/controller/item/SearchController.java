package com.example.usStore.controller.item;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SearchController {

	@RequestMapping("/shop/searchItem.do") 
	public String search(HttpServletRequest rq) {
		
		System.out.println("<<검색 컨트롤러>>");
		return "product/search";
	}
}
