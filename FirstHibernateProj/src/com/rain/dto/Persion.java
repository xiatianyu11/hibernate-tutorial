package com.rain.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Persion {
	
	@Id @GeneratedValue
	private int persionId;
	
	private String persionName;
	
	@ManyToOne
	//@JoinColumn(name="USER_ID")
	private User user;

	public int getPersionId() {
		return persionId;
	}

	public void setPersionId(int persionId) {
		this.persionId = persionId;
	}

	public String getPersionName() {
		return persionName;
	}

	public void setPersionName(String persionName) {
		this.persionName = persionName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
