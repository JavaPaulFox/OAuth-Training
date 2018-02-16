package com.samsung.training.oauth2.utility;

import com.google.gson.Gson;
import com.samsung.training.oauth2.utility.Tokens.GoogleToken;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class GoogleApi {


	public void sendRequestForToken(String code, Environment env) {

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

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
