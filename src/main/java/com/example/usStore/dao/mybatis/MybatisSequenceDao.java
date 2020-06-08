package com.example.usStore.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.stereotype.Repository;

import com.example.usStore.dao.SequenceDao;
import com.example.usStore.dao.mybatis.mapper.SequenceMapper;
import com.example.usStore.domain.Sequence;

@Repository
public class MybatisSequenceDao implements SequenceDao {
	@Autowired
	protected SequenceMapper sequenceMapper;
	
	  /**
	   * This is a generic sequence ID generator that is based on a database
	   * table called 'SEQUENCE', which contains two columns (NAME, NEXTID).
	   * This approach should work with any database.
	   * @param name the name of the sequence
	   * @return the next ID
	   */
	
	@Override
	public int getSequence(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		Sequence sequence = new Sequence(name, -1);
//	    sequence = (Sequence) sequenceMapper.getSequence(sequence);
	    if (sequence == null) {
	    	throw new DataRetrievalFailureException(
	    		"Error: A null sequence was returned from the database "
	    		+ "(could not get next " + name + " sequence).");
	    }
	    Sequence parameterObject = new Sequence(name, sequence.getNextId()+1);
//	    sequenceMapper.updateSequence(parameterObject);
	    return sequence.getNextId();
	}
	
	@Override
	public void updateSequence(int nextId, int name) throws DataAccessException {
		// TODO Auto-generated method stub
		sequenceMapper.updateSequence(nextId, name);
	}
}