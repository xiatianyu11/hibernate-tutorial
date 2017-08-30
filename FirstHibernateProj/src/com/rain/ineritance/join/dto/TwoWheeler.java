package com.rain.ineritance.join.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle {
	
	private String steeringHandler;

	public String getSteeringHandler() {
		return steeringHandler;
	}

	public void setSteeringHandler(String steeringHandler) {
		this.steeringHandler = steeringHandler;
	}
	
	

}
