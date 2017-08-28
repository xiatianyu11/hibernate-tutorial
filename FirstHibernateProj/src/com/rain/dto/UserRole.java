package com.rain.dto;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UserRole {
	@EmbeddedId
	private UserRoleId userRoleId;
	
	private String description;

	public UserRoleId getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(UserRoleId userRoleId) {
		this.userRoleId = userRoleId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
