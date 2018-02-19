package com.samsung.training.oauth2.controllers;

import com.samsung.training.oauth2.entities.User;
import com.samsung.training.oauth2.models.UserSession;
import com.samsung.training.oauth2.utility.GoogleApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@Scope("session")
@RequestMapping("/authorization")
public class AuthorizationController {

	@Autowired
	private Environment env;

	@Autowired
	private GoogleApi googleApi;

	@Autowired
	private UserSession userSession;

	@RequestMapping(value = "/getcode", method = RequestMethod.GET)
	public  String getCode(HttpServletResponse response, HttpSession session , @RequestParam String state, @RequestParam String code, @RequestParam(required = false) String scope, @RequestParam(required = false) String authuser, @RequestParam(required = false) String session_state, @RequestParam(required = false) String prompt) {
		if(state.equals(env.getProperty("google.api.state")))
		{
			UserSession userSession = (UserSession)session.getAttribute("userSession");
			if(userSession.getUserName() == null)
			{
				userSession = googleApi.sendRequestForToken(code);
				session.setAttribute("userSession", userSession);
				String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
				Cookie cookie = new Cookie("user", sessionId);
				cookie.setPath("/");
				cookie.setMaxAge(3600);
				response.addCookie(cookie);
			}
		}
		return "index";
	}
}
