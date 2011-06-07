package com.entscheidungsbaum.android.solarMonitor.services;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicitCollection;

/**
 * @author mschlech
 *
 * ForecastConditions
 */

@XStreamAlias("forecast_conditions")
public class ForecastConditions {

	private DataHolder day_of_week,low,high,icon,aCondition;
	
	public ForecastConditions() {
		
	}
	
	public ForecastConditions(DataHolder day_of_week, DataHolder low, DataHolder high, DataHolder icon,
			DataHolder aCondition) {
		super();
		this.day_of_week = day_of_week;
		this.low = low;
		this.high = high;
		this.icon = icon;
		this.aCondition = aCondition;
	}

	public DataHolder getDay_of_week() {
		return day_of_week;
	}

	public DataHolder getLow() {
		return low;
	}

	public DataHolder gethigh() {
		return high;
	}

	public DataHolder getIcon() {
		return icon;
	}

	public DataHolder getCondition() {
		return aCondition;
	}

	public void setDay_of_week(DataHolder day_of_week) {
		this.day_of_week = day_of_week;
	}

	public void setLow(DataHolder low) {
		this.low = low;
	}

	public void sethigh(DataHolder high) {
		this.high = high;
	}

	public void setIcon(DataHolder icon) {
		this.icon = icon;
	}

	public void setCondition(DataHolder condition) {
		this.aCondition = aCondition;
	}
	
	
}
