package iot.weather.rest.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Wind {

	@Id
	private String Id;
	private String Speed;
	private String Degree;
	
	public Wind(){
		this.Id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	
	public String getSpeed() {
		return Speed;
	}
	public void setSpeed(String speed) {
		Speed = speed;
	}
	
	public String getDegree() {
		return Degree;
	}
	public void setDegree(String degree) {
		Degree = degree;
	}
	
}
