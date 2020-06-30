package com.example.usStore.service;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.usStore.controller.item.SecondHandForm;

public class SecondHandFormValidator implements Validator  {

	@Override
	public boolean supports(Class<?> clazz) {
		return SecondHandForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		SecondHandForm secondHandForm = (SecondHandForm)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listPrice", "required");
		if(secondHandForm.getListPrice() <= 0) {
			errors.rejectValue("listPrice", "tooSmall");
		}
	}
}
