package com.in28minutes.springmvc;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("roman") && password.equals("smile");
	}

}