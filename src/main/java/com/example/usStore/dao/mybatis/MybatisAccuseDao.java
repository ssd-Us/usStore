package com.example.usStore.dao.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.AccuseDao;
import com.example.usStore.dao.mybatis.mapper.AccuseMapper;
import com.example.usStore.domain.Accuse;

@Repository
public class MybatisAccuseDao implements AccuseDao {

	@Autowired
	private AccuseMapper accuseMapper;

	@Override
	public void insertAccuse(Accuse accuse) throws DataAccessException {
		accuseMapper.insertAccuse(accuse);
	}

	@Override
	public int countAccuseById(String attacker) throws DataAccessException {
		return accuseMapper.countAccuseById(attacker);
	}

	@Override
	public String isAccuseAlready(String attacker, String victim) throws DataAccessException {
		return accuseMapper.isAccuseAlready(attacker, victim);
	}

	@Override
	public List<Accuse> selectAccuseList(String victim) throws DataAccessException {
		return accuseMapper.selectAccuseList(victim);
	}
	
}
