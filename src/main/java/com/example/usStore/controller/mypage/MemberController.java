package com.example.usStore.controller.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.usStore.service.MemberService;
//////////////////////////
//중간고사 대첵과제 코드 복붙
/////////////////////////
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping("/index")
	public String getSchedule(Model model) {
		List<MemberInfo> members = memberService.getMembers();
		model.addAttribute("members", members);
		return "member/schedule";
	}
	
	@RequestMapping("/members/get")
	public String getMember(@RequestParam("id") String memberId, Model model) {
		MemberInfo mi = memberService.getMemberInfo(memberId);
		if (mi == null) {
			return "member/memberNotFound";
		}
		model.addAttribute("member", mi);
		return "member/memberDetail";
	}
	
	@RequestMapping("/members/delete")
	public String deleteMember(@RequestParam("id") String memberId, Model model, HttpSession session) {
		memberService.deleteMember(memberId);
		session.removeAttribute("loginUserId");		
		session.invalidate();
		return "redirect:/index";
	}
}
