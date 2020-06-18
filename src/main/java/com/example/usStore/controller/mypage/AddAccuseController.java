package com.example.usStore.controller.mypage;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.domain.Accuse;
import com.example.usStore.service.facade.MyPageFacade;

@Controller
public class AddAccuseController {

   private MyPageFacade myPageFacade;
   
   @Autowired
   public void setMyPageFacade(MyPageFacade myPageFacade) {
      this.myPageFacade = myPageFacade;
   }


   @RequestMapping("/addAccuse.do") 
   public String addAccuse(@RequestParam(value="userId") String userId,
         @RequestParam(value="itemId") int itemId, 
         @RequestParam(value="productId") int productId,
         @RequestParam(value="reason") String reason, HttpServletRequest request, Model model) {
      //신고하고자 하는 판매자 아이디를 파라미터로 받는다.   
        System.out.println("addAccuse 컨트롤러 진입\n");
        System.out.println("이유: " + reason);
        
        if(!reason.equals("") && reason != null && !reason.equals(null)) {
           Accuse accuse = new Accuse(); //여기에 값 저장 ..
           accuse.setAttacker(userId);  // 판매자가 공격자이다. 
           accuse.setReason(reason); //자바스크립트에서 넘어온 신고사유
           accuse.setVictim("A");  // 세션: 로그인아이디가 setVictim();
           
           this.myPageFacade.insertAccuse(accuse);
        }
        
        model.addAttribute("itemId", itemId);
        model.addAttribute("productId", productId);
        if(productId == 0)
           return "redirect:/shop/groupBuying/viewItem.do";
        else if(productId ==1)
           return "redirect:/shop/auction/viewItem.do";
        else if(productId ==2)
           return "redirect:/shop/secondHand/viewItem.do";
        else if(productId ==3)
           return "redirect:/shop/handMade/viewItem.do";
        else
           return "/index";
   }
   
   
}