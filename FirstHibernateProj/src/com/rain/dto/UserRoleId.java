package com.rain.dto;
import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class UserRoleId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int userId;
	
	private int roleId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	

}
