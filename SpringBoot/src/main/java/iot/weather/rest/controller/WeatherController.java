package iot.weather.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import iot.weather.rest.entity.Weather_details;
import iot.weather.rest.service.WeatherService;

//@Controller
//@ResponseBody

@RestController
public class WeatherController {
	
	private WeatherService service;
	
	public WeatherController(WeatherService service) {
		this.service = service;
	}
	
	@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 100)
	@ResponseBody
	@RequestMapping(method=RequestMethod.POST, value="/details")
	public Weather_details create(@RequestBody Weather_details details) {
		return service.create(details);
	}

	@RequestMapping(method=RequestMethod.GET, value="/details")
	public List<String> findAllCities(){
		return service.findAllCities();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/details/{citylatest}")
	public Weather_details latestWeather(@PathVariable("citylatest") String citylatest) {
		return service.latestWeather(citylatest);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/details/{city}/{property}")
	public String latestProperty(@PathVariable("city") String city, @PathVariable("property") String property) {
		return service.latestProperty(city, property);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/details/hrly-avg/{city_hrly}")
	public Weather_details hrly_avg(@PathVariable("city_hrly") String city_hrly) {
		return service.hrly_avg(city_hrly);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/details/daily-avg/{city_daily}")
	public Weather_details daily_avg(@PathVariable("city_daily") String city_daily) {
		return service.daily_avg(city_daily);
	}
	
}
