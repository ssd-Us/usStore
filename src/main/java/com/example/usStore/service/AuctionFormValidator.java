package com.example.usStore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.usStore.controller.item.AuctionForm;


@Component
public class AuctionFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AuctionForm.class.isAssignableFrom(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validator");
		AuctionForm auctionForm = (AuctionForm)target; 
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startPrice", "required");
		if(auctionForm.getStartPrice() <= 0) {
			errors.rejectValue("startPrice", "tooSmall");
		}
		
		String date = auctionForm.getDate();
		String time = auctionForm.getTime();
		
		if(date == null || time == null || date.trim().isEmpty() || time.trim().isEmpty()) {
			errors.rejectValue("deadLine", "required");
		}
	}

}