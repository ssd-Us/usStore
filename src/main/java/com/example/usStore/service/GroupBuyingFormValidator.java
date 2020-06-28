package com.example.usStore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.usStore.controller.item.GroupBuyingForm;


@Component
public class GroupBuyingFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return GroupBuyingForm.class.isAssignableFrom(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validator");
		GroupBuyingForm groupBuyingForm = (GroupBuyingForm)target; 
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listPrice", "required");
		if(groupBuyingForm.getListPrice() <= 0) {
			errors.rejectValue("listPrice", "tooSmall");
		}
		
		String date = groupBuyingForm.getDate();
		String time = groupBuyingForm.getTime();
		
		if(date == null || time == null || date.trim().isEmpty() || time.trim().isEmpty()) {
			errors.rejectValue("deadLine", "required");
		}
	}

}