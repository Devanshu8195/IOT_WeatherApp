package iot.weather.rest.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@NamedQueries({
	@NamedQuery(name="Weather_details.findAllCities", query="SELECT City FROM Weather_details"),
//	@NamedQuery(name="Weather_details.latestweather", query="SELECT wd from Weather_details wd where wd.id desc"),
//	@NamedQuery(name="Weather_details.latestProperty", query=""),
//	@NamedQuery(name="Weather_details.hrly-avg", query=""),
//	@NamedQuery(name="Weather_details.daily-avg", query="")
})
public class Weather_details {
	
	@Id
	private String Id;
	
	private String City;
	private String Description;
	private String Humidity;
	private String Pressure;
	private String Temperature;
	private String Timestamp;
	
	@OneToOne(cascade = {CascadeType.ALL})
	private Wind wind;
	
	public Weather_details() {
		this.Id = UUID.randomUUID().toString();		
	}
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	public String getHumidity() {
		return Humidity;
	}
	public void setHumidity(String humidity) {
		Humidity = humidity;
	}
	
	public String getPressure() {
		return Pressure;
	}
	public void setPressure(String pressure) {
		Pressure = pressure;
	}
	
	public String getTemperature() {
		return Temperature;
	}
	public void setTemperature(String temperature) {
		Temperature = temperature;
	}
	
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
	
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	
	@Override
	public String toString() {
		return "Weather_details [Id=" + Id + ", City=" + City + ", Description=" + Description + ", Humidity="
				+ Humidity + ", Prssure=" + Pressure + ", Temperature=" + Temperature + ", Timestamp=" + Timestamp
				+ ", wind=" + wind + "]";
	}

}
