package com.rain.ineritance.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Prosic")
public class FourWheeler extends Vehicle {
	
	private String steerWheel;

	public String getSteerWheel() {
		return steerWheel;
	}

	public void setSteerWheel(String steerWheel) {
		this.steerWheel = steerWheel;
	}
	
	

}
