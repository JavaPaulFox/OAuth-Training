package com.samsung.training.oauth2.utility;

import com.google.gson.Gson;
import com.samsung.training.oauth2.entities.GoogleAccount;
import com.samsung.training.oauth2.entities.User;
import com.samsung.training.oauth2.models.UserSession;
import com.samsung.training.oauth2.repositories.GoogleAccountRepository;
import com.samsung.training.oauth2.repositories.UserRepository;
import com.samsung.training.oauth2.utility.googleModels.userInfo.UserInfo;
import com.samsung.training.oauth2.utility.tokens.GoogleToken;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleApi {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private GoogleAccountRepository googleAccountRepository;

	@Autowired
	private Environment env;

	public UserSession sendRequestForToken(String code) {
		User user = new User();
		UserSession userSession = new UserSession();
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(env.getProperty("google.api.token_url"));

		List<NameValuePair> arguments = new ArrayList<>(3);
		arguments.add(new BasicNameValuePair("code", code));
		arguments.add(new BasicNameValuePair("client_id", env.getProperty("google.api.client_id")));
		arguments.add(new BasicNameValuePair("client_secret", env.getProperty("google.api.client_secret")));
		arguments.add(new BasicNameValuePair("redirect_uri", env.getProperty("google.api.redirect_uri")));
		arguments.add(new BasicNameValuePair("grant_type", env.getProperty("google.api.grant_type")));

		try {
			post.setEntity(new UrlEncodedFormEntity(arguments));
			HttpResponse response = client.execute(post);
			Gson gson = new Gson();
			GoogleToken token = gson.fromJson(EntityUtils.toString(response.getEntity()), GoogleToken.class);
			if(token != null)
			{
				HttpGet get = new HttpGet(env.getProperty("google.api.google_plus.get_user"));
				get.setHeader("Authorization", token.getToken_type() + " "+token.getAccess_token());
				response = client.execute(get);
				UserInfo userInfo = gson.fromJson(EntityUtils.toString(response.getEntity()), UserInfo.class);
				if(userInfo != null)
				{
						if(googleAccountRepository.findByGoogleId(userInfo.getId()).isEmpty())
						{
							GoogleAccount googleAccount = new GoogleAccount();
							googleAccount.setGoogleId(userInfo.getId());
							googleAccount.setFirstName(userInfo.getName().getGivenName());
							googleAccount.setSecondName(userInfo.getName().getFamilyName());
							googleAccount.setPhotoUrl(userInfo.getImage().getUrl());
							googleAccount.setLocation(userInfo.getPlacesLived()[0].getValue());


							user.setFirstName(userInfo.getName().getGivenName());
							user.setSecondName(userInfo.getName().getFamilyName());
							user.setGoogleAccount(googleAccount);
							user.setEmail(userInfo.getEmails()[0].getValue());

							userRepository.save(user);

						}

					userSession.setUserName(userInfo.getDisplayName());
					return userSession;
					}
				}
				return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
