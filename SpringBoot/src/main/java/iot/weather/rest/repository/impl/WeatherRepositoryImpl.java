package iot.weather.rest.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import iot.weather.rest.entity.Weather_details;
import iot.weather.rest.repository.WeatherRepository;

@Repository
public class WeatherRepositoryImpl implements WeatherRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<String> findAllCities() {
		// TODO Auto-generated method stub
		TypedQuery<String> query = em.createNamedQuery("Weather_details.findAllCities", String.class);
		return query.getResultList();
//		return null;
	}

	@Override
	public Weather_details latestWeather(String city) {
		// TODO Auto-generated method stub
		Query query1 = em.createNativeQuery("SELECT * FROM weatherapp.weather_details WHERE weatherapp.weather_details.city= " + '"' + city + '"' + " order by weatherapp.weather_details.Timestamp desc limit 1", Weather_details.class);
		return (Weather_details) query1.getSingleResult();
		//return null;
	}
	
	@Override
	public String latestProperty(String city, String property) {
		// TODO Auto-generated method stub
		Query query2 = em.createNativeQuery("SELECT " + property + " FROM weatherapp.weather_details WHERE weatherapp.weather_details.city= " + '"' + city + '"' + " order by weatherapp.weather_details.Timestamp desc limit 1", String.class);
		return (String) query2.getSingleResult();
	}

	@Override
	public Weather_details hrly_avg(String city) {
		// TODO Auto-generated method stub
		Query query3 = em.createNativeQuery("SELECT weatherapp.weather_details.Id, weatherapp.weather_details.City, weatherapp.weather_details.Description, AVG(weatherapp.weather_details.humidity) AS Humidity, AVG(weatherapp.weather_details.pressure) AS Pressure, AVG(weatherapp.weather_details.temperature) AS Temperature, weatherapp.weather_details.Timestamp, weatherapp.weather_details.wind_Id  FROM weatherapp.weather_details WHERE weatherapp.weather_details.city= " + '"' + city + '"' + " GROUP BY HOUR( weatherapp.weather_details.Timestamp )", Weather_details.class);
		return (Weather_details) query3.getSingleResult();
	}

	@Override
	public Weather_details daily_avg(String city) {
		// TODO Auto-generated method stub
		Query query4 = em.createNativeQuery("SELECT weatherapp.weather_details.Id, weatherapp.weather_details.City, weatherapp.weather_details.Description, AVG(weatherapp.weather_details.humidity) AS Humidity, AVG(weatherapp.weather_details.pressure) AS Pressure, AVG(weatherapp.weather_details.temperature) AS Temperature, weatherapp.weather_details.Timestamp, weatherapp.weather_details.wind_Id  FROM weatherapp.weather_details WHERE weatherapp.weather_details.city= " + '"' + city + '"' + " GROUP BY DATE( weatherapp.weather_details.Timestamp )", Weather_details.class);
		return (Weather_details) query4.getSingleResult();
	}

	@Override
	public Weather_details save(Weather_details details) {
		return null;
	}

}
