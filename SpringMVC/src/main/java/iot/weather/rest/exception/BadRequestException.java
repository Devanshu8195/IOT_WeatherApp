package iot.weather.rest.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
	
	public BadRequestException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
	public BadRequestException(String msg, Throwable cause) {
		// TODO Auto-generated constructor stub
		super(msg, cause);
	}

}
