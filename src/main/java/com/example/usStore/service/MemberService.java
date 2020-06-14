package com.example.usStore.service;
//////////////////////////
//중간고사 대첵과제 코드 복붙
/////////////////////////
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.usStore.controller.mypage.LoginCommand;
import com.example.usStore.controller.mypage.MemberCommand;
import com.example.usStore.controller.mypage.MemberInfo;

@Service
public class MemberService {
	private Map<String, MemberInfo> memberMap = new HashMap<String, MemberInfo>();

	public MemberService() {}

	public List<MemberInfo> getMembers() {
		return new ArrayList<MemberInfo>(memberMap.values());
	}

	public MemberInfo getMemberInfo(String memberId) {
		return memberMap.get(memberId);
	}

	public MemberInfo registNewMember(MemberCommand memRegReq) throws ExistUserIdException {
		if (memberMap.containsKey(memRegReq.getId())) 
			throw new ExistUserIdException();

		MemberInfo mi = new MemberInfo(memRegReq.getId(),
								memRegReq.getName(),  
								memRegReq.getPassword(),
								memRegReq.getPhone(),
								memRegReq.getTitle(), 
								memRegReq.getLength(),
								memRegReq.isNewPerformer(),
								new Date());
		memberMap.put(mi.getId(), mi);
		return mi;
	}

	public void deleteMember(String memberId) {
		memberMap.remove(memberId);
	}
	
	public void authenticate(LoginCommand loginCommand)
			throws AuthenticationException {
		MemberInfo mi = getMemberInfo(loginCommand.getUserId());		
		if (mi == null || 
			!mi.getPassword().equals(loginCommand.getPassword())) {	        
			throw new AuthenticationException();
		}
	}
}
