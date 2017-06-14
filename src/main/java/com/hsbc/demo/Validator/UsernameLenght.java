package com.hsbc.demo.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
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
		// TODO Auto-generated method stub
		User user = (User)target;
		int length = user.getUserName().length();
		if (length > 20) {
			errors.reject("user.userName.too_long");
			return;
		}
	}

}
