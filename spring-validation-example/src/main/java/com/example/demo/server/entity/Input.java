package com.example.demo.server.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

public class Input {

	@Min(1)
	@Max(10)
	private int numberBetweenOneAndTen;

	// Note that this is actually not a valid IP address pattern, since
	// it allows values greater than 255 per octet.
	@Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
	private String ipAddress;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getNumberBetweenOneAndTen() {
		return numberBetweenOneAndTen;
	}

	public void setNumberBetweenOneAndTen(int numberBetweenOneAndTen) {
		this.numberBetweenOneAndTen = numberBetweenOneAndTen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberBetweenOneAndTen;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Input other = (Input) obj;
		if (numberBetweenOneAndTen != other.numberBetweenOneAndTen)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Input [numberBetweenOneAndTen=" + numberBetweenOneAndTen + "]";
	}

}
