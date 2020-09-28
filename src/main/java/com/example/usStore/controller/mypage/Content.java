package com.example.usStore.controller.mypage;

import java.io.Serializable;
import java.util.List;

public class Content implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private UnivInfo content;

    public Content() {
    }

    
	public Content(UnivInfo content) {
		super();
		this.content = content;
	}


	public UnivInfo getContent() {
		return content;
	}

	public void setContent(UnivInfo content) {
		this.content = content;
	}


	@Override
	public String toString() {
		return "Content [content=" + content + "]";
	}

    

}
