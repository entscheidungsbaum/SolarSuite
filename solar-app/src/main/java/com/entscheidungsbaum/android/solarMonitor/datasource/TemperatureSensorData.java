package com.entscheidungsbaum.android.solarMonitor.datasource;

import java.sql.Timestamp;

/**
 * @author mschlech
 *
 * TemperatureSensorData
 */

public class TemperatureSensorData {

	private  Timestamp timeStamp;
	
	private double temperature ;

	private Number temperatureLong ;
	
	public TemperatureSensorData(Timestamp timeStamp, long temperature) {
		super();
		this.timeStamp = timeStamp;
		this.temperature = temperature;
	}

	public Timestamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(long temperature) {
		this.temperature = temperature;
	}
	
	
	
}
