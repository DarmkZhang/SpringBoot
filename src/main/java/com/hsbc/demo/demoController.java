package com.hsbc.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.demo.Validator.UserValidator;
import com.hsbc.demo.Validator.UsernameLenght;
import com.hsbc.demo.model.User;

@RestController
public class demoController {
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UsernameLenght usernameLenght;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET) 
	public  String validatorUser(@RequestParam("username") String username,@RequestParam("password") String password,@RequestParam("email") String email,User user,  BindingResult result){
		user.setUserName(username);
		user.setPassword(password);
		user.setEmail(email);
		userValidator.validate(user, result);
		usernameLenght.validate(user, result);
		if(result.hasErrors()){
			List<ObjectError>  list = result.getAllErrors();
	           for(ObjectError  error:list){
	           System.out.println(error.getCode());
	           }
			return "验证没有通过";
		}
		return "验证成功";
	}
	@RequestMapping(value = "/userjson", method = RequestMethod.GET) 
	public User getUser(){
		User user = new User();
		user.setUserName("zhangsan");
		user.setPassword("0123456");
		user.setEmail("1229756681@qq.com");
		return user;
	}
	
}
