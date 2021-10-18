package com.pazienza.friendsapi.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String playerAlias;

	private String firstName;

	private String lastName;

	private String emailAddress;

	private String password;

	public Integer getId() {
		return id;
	}

	public String getPlayerAlias() {
		return playerAlias;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmailAddress() {
		return emailAddress;
	}
}
