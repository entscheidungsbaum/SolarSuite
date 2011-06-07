package com.entscheidungsbaum.android.solarMonitor.services;

/**
 * @author mschlech
 * 
 *         ForecastInformation
 */

public class ForecastInformation {

	DataHolder city, postal_code, latitude, longitude, forecast_date, current_date_time, unit_system;

	public ForecastInformation() {
		
	}
	
	public ForecastInformation(DataHolder city, DataHolder postal_code, DataHolder latitude, DataHolder longitude, DataHolder forecast_date,
			DataHolder current_date_time, DataHolder unit_system) {
		super();
		this.city = city;
		this.postal_code = postal_code;
		this.latitude = latitude;
		this.longitude = longitude;
		this.forecast_date = forecast_date;
		this.current_date_time = current_date_time;
		this.unit_system = unit_system;
	}

	public DataHolder getCity() {
		return city;
	}

	public DataHolder getPostal_code() {
		return postal_code;
	}

	public DataHolder getLatitude() {
		return latitude;
	}

	public DataHolder getLongitude() {
		return longitude;
	}

	public DataHolder getForecast_date() {
		return forecast_date;
	}

	public DataHolder getCurrent_date_time() {
		return current_date_time;
	}

	public DataHolder getUnit_system() {
		return unit_system;
	}

	public void setCity(DataHolder city) {
		this.city = city;
	}

	public void setPostal_code(DataHolder postal_code) {
		this.postal_code = postal_code;
	}

	public void setLatitude(DataHolder latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(DataHolder longitude) {
		this.longitude = longitude;
	}

	public void setForecast_date(DataHolder forecast_date) {
		this.forecast_date = forecast_date;
	}

	public void setCurrent_date_time(DataHolder current_date_time) {
		this.current_date_time = current_date_time;
	}

	public void setUnit_system(DataHolder unit_system) {
		this.unit_system = unit_system;
	}

	@Override
	public String toString() {
		return "ForecastInformation [city=" + city + ", postal_code=" + postal_code + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", forecast_date=" + forecast_date + ", current_date_time="
				+ current_date_time + ", unit_system=" + unit_system + "]";
	}

	
	
}

