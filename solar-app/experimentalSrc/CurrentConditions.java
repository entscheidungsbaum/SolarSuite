package com.entscheidungsbaum.android.solarMonitor.services;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author mschlech
 *
 * CurrentConditions
 */

@XStreamAlias("current_conditions")
public class CurrentConditions {

	DataHolder condition ,wind_condition,humidity, temp_f, temp_c;

	
	public CurrentConditions(DataHolder condition,DataHolder wind_condition, DataHolder humidity, DataHolder temp_f, DataHolder temp_c) {
		super();
		this.condition = condition;
		this.wind_condition = wind_condition;
		this.humidity = humidity;
		this.temp_f = temp_f;
		this.temp_c = temp_c;
	}

	public DataHolder getWind_condition() {
		return wind_condition;
	}

	public DataHolder getHumidity() {
		return humidity;
	}

	public DataHolder getTemp_f() {
		return temp_f;
	}

	public DataHolder getTemp_c() {
		return temp_c;
	}

	public void setWind_condition(DataHolder wind_condition) {
		this.wind_condition = wind_condition;
	}

	public void setHumidity(DataHolder humidity) {
		this.humidity = humidity;
	}

	public void setTemp_f(DataHolder temp_f) {
		this.temp_f = temp_f;
	}

	public void setTemp_c(DataHolder temp_c) {
		this.temp_c = temp_c;
	}

	@Override
	public String toString() {
		return "CurrentConditions [wind_condition=" + wind_condition + ", humidity=" + humidity + ", temp_f=" + temp_f
				+ ", temp_c=" + temp_c + "]";
	}
	
	
	
}
