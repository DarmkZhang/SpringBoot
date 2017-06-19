package com.hsbc.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.demo.Validator.UsernameLenght;
import com.hsbc.demo.model.User;
@RestController
public class testController {
	
	@Autowired
	private UsernameLenght usernameLenght;
	
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String val(User user,  BindingResult result){
		user.setUserName("zhangsan");
		usernameLenght.validate(user.getUserName(), result);
		String xx = null;
		if(result.hasErrors()){
			List<ObjectError>  list = result.getAllErrors();
	           for(ObjectError  error:list){
	        	   xx = error.getCode();
	           }			
		}
		return xx;

	}
	@RequestMapping(value = "/l", method = RequestMethod.GET) 
	public String vall(User user,  BindingResult result){
		user.setUserName("");
		usernameLenght.validate(user.getUserName(), result);
		String xx = null;
		if(result.hasErrors()){
			List<ObjectError>  list = result.getAllErrors();
	           for(ObjectError  error:list){
	        	   xx = error.getCode();
	           }			
		}
		return xx;

	}

}
