package com.samsung.training.oauth2.utility.Tokens;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GoogleToken {

	@SerializedName("access_token")
	@Expose
	private String access_token;
	@SerializedName("refresh_token")
	@Expose
	private String refresh_token;
	@SerializedName("expires_in")
	@Expose
	private Integer expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}

	public String getToken_type() {
		return token_type;
	}

	public void setToken_type(String token_type) {
		this.token_type = token_type;
	}

	@SerializedName("token_type")
	@Expose
	private String token_type;
}
