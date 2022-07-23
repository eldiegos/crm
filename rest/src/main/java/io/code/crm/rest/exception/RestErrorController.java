package io.code.crm.rest.exception;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestErrorController extends ResponseEntityExceptionHandler {

	// Let Spring BasicErrorController handle the exception, we just override the
	// status code
	@ExceptionHandler(CrmRestException.class)
	public ResponseEntity<RestErrorResponse> customHandleNotFound(CrmRestException ex, WebRequest request) {

		RestErrorResponse errors = new RestErrorResponse();
		errors.setTimestamp(Instant.now());
		errors.setError(ex.getMessage());
		errors.setHttpStatus(ex.getHttpStatus());

		return new ResponseEntity<>(errors, ex.getHttpStatus());

	}
}