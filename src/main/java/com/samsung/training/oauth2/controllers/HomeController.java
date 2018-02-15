package com.samsung.training.oauth2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/greeting", method=RequestMethod.GET)
	public String greeting()
	{
		return "greeting";
	}

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index()
	{
		return "index";
	}
}
