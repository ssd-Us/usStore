/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.example.usStore.dao.mybatis.mapper;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Sequence;

/**
 * @author Eduardo Macarron
 */
public interface SequenceMapper {
//  Sequence getSequence(Sequence sequence);
//  Sequence getOracleSequence(Sequence sequence);
//  void updateSequence(Sequence sequence);
  
	// 시퀀스 받아오기
<<<<<<< HEAD
	public int getSequence(String name);
	
	// 시퀀스 수정하기
	public void updateSequence(int nextId, int name);
=======
	public int getSequence(String name) throws DataAccessException;
	
	// 시퀀스 수정하기
	public void updateSequence(int nextId, int name) throws DataAccessException;
>>>>>>> branch 'test' of https://github.com/ssd-Us/usStore.git
}
