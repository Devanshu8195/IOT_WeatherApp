package iot.weather.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	
	public NotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
	public NotFoundException(String msg, Throwable cause) {
		// TODO Auto-generated constructor stub
		super(msg, cause);
	}

}
