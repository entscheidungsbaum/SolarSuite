package com.entscheidungsbaum.android.solarMonitor.services;

/**
 * @author mschlech
 *
 * Condition
 */

public class Condition {

	String day_of_week, low, high, condition;

	
	
	public Condition(String day_of_week, String low, String high, String condition) {
		super();
		this.day_of_week = day_of_week;
		this.low = low;
		this.high = high;
		this.condition = condition;
	}

	public String getDay_of_week() {
		return day_of_week;
	}

	public String getLow() {
		return low;
	}

	public String getHigh() {
		return high;
	}

	public String getCondition() {
		return condition;
	}

	public void setDay_of_week(String day_of_week) {
		this.day_of_week = day_of_week;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	@Override
	public String toString() {
		return "Condition [day_of_week=" + day_of_week + ", low=" + low + ", high=" + high + ", condition=" + condition
				+ "]";
	}
	
	
}
