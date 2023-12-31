package ec.com.orion.learning.springboot.tickets;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(value = NoSuchElementException.class)
	public ErrorResponse notFound(NoSuchElementException ex) {
		return ErrorResponse.create(ex, HttpStatus.NOT_FOUND, ex.getMessage());
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ErrorResponse validationException(MethodArgumentNotValidException ex) {
		return ErrorResponse.create(ex, HttpStatus.BAD_REQUEST, ex.getMessage());
	}

}
