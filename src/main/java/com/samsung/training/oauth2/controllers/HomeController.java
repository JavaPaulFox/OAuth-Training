package com.samsung.training.oauth2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class HomeController {

	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String greeting()
	{
		return "greeting";
	}

	@Autowired
	private Environment env;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Map<String, Object> model)
	{
		StringBuilder googleAuthUrl = new StringBuilder();
		googleAuthUrl.append(env.getProperty("google.api.auth_url"));
		googleAuthUrl.append("client_id="+env.getProperty("google.api.client_id")+"&");
		googleAuthUrl.append("response_type="+env.getProperty("google.api.response_type")+"&");
		googleAuthUrl.append("redirect_uri="+env.getProperty("google.api.redirect_uri")+"&");
		googleAuthUrl.append("state="+env.getProperty("google.api.state")+"&");
		googleAuthUrl.append("access_type="+env.getProperty("google.api.access_type")+"&");
		googleAuthUrl.append("scope="+env.getProperty("google.api.scope"));
		model.put("googleAuthUrl", googleAuthUrl);
		return "index";
	}
}
