package com.entscheidungsbaum.android.solarMonitor.services;

import java.util.ArrayList;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author mschlech
 *
 * Weather
 */
@XStreamAlias("weather")
public class Weather {

	
	@XStreamAlias("forecast_information")
	public ArrayList<ForecastInformation> forcast_information;
	
	@XStreamAlias("current_conditions")
	public ArrayList<CurrentConditions> current_conditions;
	
	@XStreamAlias("forecast_conditions")
	public ArrayList<ForecastConditions> forecast_conditions;

	public Weather() {};
	
	public Weather(ArrayList<ForecastInformation> forcast_information, ArrayList<CurrentConditions> current_conditions,
			ArrayList<ForecastConditions> forecast_conditions) {
		super();
		this.forcast_information = forcast_information;
		this.current_conditions = current_conditions;
		this.forecast_conditions = forecast_conditions;
	}

	@Override
	public String toString() {
		return "Weather [forcast_information=" + forcast_information + ", current_conditions=" + current_conditions
				+ ", forecastConditions=" + forecast_conditions + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public ArrayList<ForecastInformation> getForcast_information() {
		return forcast_information;
	}

	public ArrayList<CurrentConditions> getCurrent_conditions() {
		return current_conditions;
	}

	public ArrayList<ForecastConditions> getForecastConditions() {
		return forecast_conditions;
	}

	public void setForcast_information(ArrayList<ForecastInformation> forcast_information) {
		this.forcast_information = forcast_information;
	}

	public void setCurrent_conditions(ArrayList<CurrentConditions> current_conditions) {
		this.current_conditions = current_conditions;
	}

	public void setForecastConditions(ArrayList<ForecastConditions> forecastConditions) {
		this.forecast_conditions = forecastConditions;
	}
	
	
}
