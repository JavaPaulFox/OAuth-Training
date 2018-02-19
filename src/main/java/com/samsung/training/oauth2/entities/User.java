package com.samsung.training.oauth2.entities;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;

	private String firstName;

	private String secondName;

	@Column(nullable = false)
	private String email;

	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "googleId")
	private GoogleAccount googleAccount;

	public Integer getId() {
		return id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public GoogleAccount getGoogleAccount() {
		return googleAccount;
	}

	public void setGoogleAccount(GoogleAccount googleId) {
		this.googleAccount = googleId;
	}
}
