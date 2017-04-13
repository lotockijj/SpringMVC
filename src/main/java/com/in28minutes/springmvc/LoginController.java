package com.in28minutes.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {

	//Set the loginService - Auto Wiring
	@Autowired
	LoginService loginService;

	@RequestMapping(value="/login", method = RequestMethod.GET)
	//@ResponseBody // -> was putting off in order that I wouldn't like to print "Hello World" 
	public String showLoginPage(){
		return "login";
	}

	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String handlingLoginRequest(ModelMap model, @RequestParam String name, 
			@RequestParam String password){
		if(!loginService.validateUser(name, password)){
			model.put("errorMessage", "Invalid Credentials");
			return "login";
		}
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}
}
