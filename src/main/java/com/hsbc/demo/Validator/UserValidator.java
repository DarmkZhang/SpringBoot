package com.hsbc.demo.Validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hsbc.demo.model.User;

@Component("UserValidator")
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {

		ValidationUtils.rejectIfEmpty(errors, "userName", "user.userName.required", "用户名不能为空");
		ValidationUtils.rejectIfEmpty(errors, "password","user.password.required", "密码不能为空");
	    ValidationUtils.rejectIfEmpty(errors, "email", "user.email.required","邮箱不能为空");

		User user = (User) target;
		// check not number
		String str = user.getUserName();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) <= 48 || str.charAt(i) >= 57) {
				errors.reject("user.userName.num");
			}
			break;

		}
		for(int i=0;i<str.length();i++){
			if(ChenckAccount(str,i)){
				errors.reject("我也不知");
			}else{
				errors.reject("我也不知道在检查什么");
			}
			break;
		}
		//check account id
	   for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 45) {
				if (i == str.length() - 1 || i == 0) {
					errors.reject("我也不知道在检查什么");
				} else if (!ChenckAccountInput(str, i - 1) || !ChenckAccountInput(str, i + 1)) {
					errors.reject("我也不知道在检查什么");
				}
			} else if (ChenckAccountInput(str, i)) {
				continue;
			} else {
				errors.reject("我也不知道在检查什么");
			}
		}
	   //check password length
	   int password = user.getPassword().length();
	   if(password >=15  || password <=5){
		   errors.reject("我必须在5和15中间");
	   }
	   //check email forct
	  
	}

	public boolean ChenckAccountInput(String x, int i) {
		if ((x.charAt(i) >= 39 && x.charAt(i) <= 58) || (x.charAt(i) >= 65 && x.charAt(i) <= 90)
				|| (x.charAt(i) >= 97 && x.charAt(i) <= 122) || (x.charAt(i) == 32 || x.charAt(i) == 63)) {
			return true;
		} else {
			return false;
		}
	}
	public boolean ChenckAccount(String x, int i) {
		if (x.charAt(i) == 48 || x.charAt(i) == 57) {
			return true;
		} else {
			return false;
		}
	}
	/*
	 * @Override public void validate(Object target, Errors errors) {
	 * ValidationUtils.rejectIfEmpty(errors, "userName",
	 * "user.userName.required", "用户名不能为空");
	 * ValidationUtils.rejectIfEmpty(errors, "password",
	 * "user.password.required", "密码不能为空");
	 * ValidationUtils.rejectIfEmpty(errors, "email", "user.email.required",
	 * "邮箱不能为空"); User user = (User)target; int length =
	 * user.getUserName().length(); if(length>20){
	 * errors.rejectValue("userName", "user.userName.too_long",
	 * "用户名不能超过{20}个字符"); } length = user.getPassword().length(); if(length <6){
	 * errors.rejectValue("password", "user.password.too_short",
	 * "密码太短，不能少于{6}个字符"); }else if(length>20){ errors.rejectValue("password",
	 * "user.password.too_long", "密码太长，不能长于{20}个字符"); } int index =
	 * user.getEmail().indexOf("@"); if(index == -1){
	 * errors.rejectValue("email", "user.email.invalid_email", "邮箱格式错误"); } }
	 */

}