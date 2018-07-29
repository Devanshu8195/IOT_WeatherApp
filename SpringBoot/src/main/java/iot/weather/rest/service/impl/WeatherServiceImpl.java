package iot.weather.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iot.weather.rest.entity.Weather_details;
import iot.weather.rest.exception.NotFoundException;
import iot.weather.rest.repository.WeatherRepository;
import iot.weather.rest.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{

	private WeatherRepository repository;
	
	public WeatherServiceImpl(WeatherRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<String> findAllCities() {
		// TODO Auto-generated method stub
		return repository.findAllCities();
	}

	@Override
	@Transactional(readOnly = true)
	public Weather_details latestWeather(String city) {
		// TODO Auto-generated method stub
		Weather_details details = repository.latestWeather(city);
		if(details == null) {
			//TODO throw 404 exception.
			throw new NotFoundException("Details for city " + city + " does not exist.");
		}
		return details;
	}

	@Override
	@Transactional
	public Weather_details create(Weather_details details) {
		// TODO Auto-generated method stub
		Weather_details reading = repository.save(details);
		return reading;
	}

	@Override
	@Transactional(readOnly = true)
	public String latestProperty(String city, String property) {
		// TODO Auto-generated method stub
		String latest_details = repository.latestProperty(city, property);
		if(property == null) {
			//TODO throw 404 exception.
			throw new NotFoundException("Property " + property + " does not exist.");
		}
		return latest_details;
	}

	@Override
	@Transactional(readOnly = true)
	public Weather_details hrly_avg(String city) {
		// TODO Auto-generated method stub
		Weather_details hrly_avg = repository.hrly_avg(city);
		return hrly_avg;
	}

	@Override
	@Transactional(readOnly = true)
	public Weather_details daily_avg(String city) {
		// TODO Auto-generated method stub
		Weather_details daily_avg = repository.daily_avg(city);
		return daily_avg;
	}

}
