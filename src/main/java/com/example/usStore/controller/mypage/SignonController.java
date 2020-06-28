package com.example.usStore.controller.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.usStore.domain.Account;
import com.example.usStore.domain.Product;
import com.example.usStore.service.facade.UsStoreFacade;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.ui.Model;

/**
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified-by Changsup Park
 */
@Controller
public class SignonController { 

	private UsStoreFacade usStore;
	@Autowired
	public void setusStore(UsStoreFacade usStore) {
		this.usStore = usStore;
	}

	@RequestMapping("/shop/signon.do")
	public ModelAndView handleRequest(HttpServletRequest request,
			@RequestParam("userId") String userId,
			@RequestParam("password") String password,
			@RequestParam(value="forwardAction", required=false) String forwardAction,
			Model model) throws Exception {
		Account account = usStore.getAccountByUserIdAndPassword(userId, password);
		if (account == null) {
			// return "redirect:shop/signonForm.do";
			return new ModelAndView("Error", "message", 
					"Invalid username or password.  Signon failed.");
		}
		else {
			UserSession userSession = new UserSession(account);
			HttpSession session = request.getSession();
			session.setAttribute("userSession", userSession);	
			
			if (forwardAction != null) {
				return new ModelAndView("redirect:" + forwardAction);
			} else { //신고기능 로그인 안되어있을 때 여기로 들어옴 
				if(session.getAttribute("accuseItemId") != null) {
					int itemId = (int)session.getAttribute("accuseItemId");
					int productId = (int)session.getAttribute("accuseProductId");
				
					session.removeAttribute("accuseItemId");
					session.removeAttribute("accuseProductId");
				
					if(productId == 0)
			           	return new ModelAndView("redirect:" + "/shop/groupBuying/viewItem.do?itemId=" + itemId + "&productId=" + productId);
			        else if(productId ==1)
			        	return new ModelAndView("redirect:" + "/shop/auction/viewItem.do?itemId=" + itemId + "&productId=" + productId);  
			        else if(productId ==2)
			        	return new ModelAndView("redirect:" + "/shop/secondHand/viewItem.do?itemId=" + itemId + "&productId=" + productId);  
			        else if(productId ==3)
			        	return new ModelAndView("redirect:" + "/shop/handMade/viewItem.do?itemId=" + itemId + "&productId=" + productId);  
				}
				return new ModelAndView("index");
			}
		}
	}
}
