package com.hsbc.demo.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hsbc.demo.model.User;
@Component("UsernameLenght")
public class UsernameLenght implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "userName", "user.userName.required", "用户名不能为空");
		// TODO Auto-generated method stub
		String value = (String)target;
		
		
		int length = value.length();
		if (length > 5) {
			errors.reject("user.userName.too_long");
			return;
		}
	}

}
