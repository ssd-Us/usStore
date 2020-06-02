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

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Account;

/**
 * @author Eduardo Macarron
 *
 */
public interface AccountMapper {

	// userId로 Account 가져오기
	Account getAccountByUsername(String userId);
	
	// userId랑 password로 Account 가져오기
	Account getAccountByUsernameAndPassword(String username, String password);
	
	// 계정 추가
	void insertAccount(Account account);
	
	// 계정 수정
	void updateAccount(Account account);
}
