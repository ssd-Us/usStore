package com.example.usStore.service;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.example.usStore.controller.item.HandMadeForm;

@Component
public class HandMadeFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return HandMadeForm.class.isAssignableFrom(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validator");
		HandMadeForm handMadeForm = (HandMadeForm)target; 
		if(handMadeForm == null) {
			System.out.println("thisisfuckingnull!!!");
		} else {
			System.out.println(handMadeForm.toString());
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listPrice", "required");
		if(handMadeForm.getListPrice() <= 0) {
			errors.rejectValue("listPrice", "tooSmall");
		}
	}
}
