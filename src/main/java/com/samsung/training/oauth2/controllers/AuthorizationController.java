package com.samsung.training.oauth2.controllers;

import com.samsung.training.oauth2.utility.GoogleApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

	@Autowired
	private Environment env;

	@RequestMapping(value = "/getcode", method = RequestMethod.GET)
	public  String getCode(@RequestParam String state, @RequestParam String code, @RequestParam(required = false) String scope, @RequestParam(required = false) String authuser, @RequestParam(required = false) String session_state, @RequestParam(required = false) String prompt) {
		if(state.equals(env.getProperty("google.api.state")))
		{
			GoogleApi googleApi = new GoogleApi();
			googleApi.sendRequestForToken(code, env);
		}
		return "index";
	}
}
