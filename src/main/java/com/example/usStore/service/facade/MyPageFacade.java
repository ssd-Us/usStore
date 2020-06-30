package com.example.usStore.service.facade;

import java.util.List;
import com.example.usStore.domain.Accuse;

public interface MyPageFacade {
	/////////////////////////////////////////////////////////////////////////
	/* accuse */
	/////////////////////////////////////////////////////////////////////////
	void insertAccuse(Accuse accuse);
	
	int countAccuseById(String accounId);
	
	String isAccuseAlready(String attacker, String victim);

	List<Accuse> selectAccuseList(String victim);
}
