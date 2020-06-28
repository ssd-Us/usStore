package com.example.usStore.controller.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.example.usStore.domain.Account;
import com.example.usStore.service.facade.UsStoreFacade;

@Controller
@SessionAttributes("userSession")
@RequestMapping("/shop/viewAccount.do")
public class ViewAccountController {

	@Autowired
	private UsStoreFacade usStore;
	public void setusStore(UsStoreFacade usStore) {
		this.usStore = usStore;
	}

	@ModelAttribute("accountForm")
	public AccountForm formBackingObject(HttpServletRequest request) 
			throws Exception {
		System.out.println("formBackingObject");
		UserSession userSession = 
			(UserSession) WebUtils.getSessionAttribute(request, "userSession");
		if (userSession != null) {	// edit an existing account
			return new AccountForm(
					usStore.getAccountByUserId(userSession.getAccount().getUserId()));
		}
		else {	// create a new account
			return new AccountForm();
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return "account/mypage";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String goEdit() {
		return "redirect:/shop/editAccount.do";
	}
}
