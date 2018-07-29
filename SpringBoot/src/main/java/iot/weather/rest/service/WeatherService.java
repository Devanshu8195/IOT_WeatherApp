package iot.weather.rest.service;

import java.util.List;

import iot.weather.rest.entity.Weather_details;

public interface WeatherService {
	
	public List<String> findAllCities();
	
	public Weather_details latestWeather(String city);
	
	public Weather_details create(Weather_details details);
	
	public String latestProperty(String city, String property);
	
	public Weather_details hrly_avg(String city);
	
	public Weather_details daily_avg(String city);
	
}
