package com.samsung.training.oauth2.entities;

import javax.persistence.*;

@Entity
public class GoogleAccount {

	@Id
	@Column(unique=true)
	private String googleId;

	private String photoUrl;

	private String firstName;

	private String secondName;

	private String location;

	@OneToOne(mappedBy = "googleAccount")
	public String getGoogleId() {
		return googleId;
	}

	public void setGoogleId(String googleId) {
		this.googleId = googleId;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
