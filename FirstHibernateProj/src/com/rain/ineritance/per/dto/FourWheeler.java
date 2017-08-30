package com.rain.ineritance.per.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
	
	private String steerWheel;

	public String getSteerWheel() {
		return steerWheel;
	}

	public void setSteerWheel(String steerWheel) {
		this.steerWheel = steerWheel;
	}
	
	

}
