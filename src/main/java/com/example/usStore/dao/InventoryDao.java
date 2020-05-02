package com.example.usStore.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.example.usStore.domain.Inventory;


public interface InventoryDao {
	 List<Inventory> getInventoryList() throws DataAccessException;
}