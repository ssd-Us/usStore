package com.example.usStore.controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.example.usStore.domain.Item;
import com.example.usStore.service.facade.UsStoreFacade;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
public class removeItemSessionController { 

	private UsStoreFacade usStore;

	@Autowired
	public void setusStore(UsStoreFacade usStore) {
		this.usStore = usStore;
	}

	@RequestMapping("/shop/item/indexFromLogo.do") //go index(remove sessions)
	public String Index(SessionStatus sessionStatus, HttpServletRequest rq)
	{
		HttpSession session = rq.getSession(false);
	      System.out.println("들어옴");
	      session.removeAttribute("itemForm");   //itemForm session close
	      session.removeAttribute("status");      //edit flag Session close
	      session.removeAttribute("GroupBuying"); 
	      session.removeAttribute("Auction"); 
	      session.removeAttribute("handMadeForm"); 
	      session.removeAttribute("secondHandForm"); 
	      
	      return "redirect:/shop/index.do";
	}
}
