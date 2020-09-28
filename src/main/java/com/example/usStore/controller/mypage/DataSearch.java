package com.example.usStore.controller.mypage;

import java.io.Serializable;
import java.util.List;

public class DataSearch implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<Content> dataSearch;

    public DataSearch() {
    }

	public List<Content> getDataSearch() {
		return dataSearch;
	}

	public void setDataSearch(List<Content> dataSearch) {
		this.dataSearch = dataSearch;
	}

	public DataSearch(List<Content> dataSearch) {
		super();
		this.dataSearch = dataSearch;
	}

	@Override
	public String toString() {
		return "DataSearch [dataSearch=" + dataSearch + "]";
	}

    
}
