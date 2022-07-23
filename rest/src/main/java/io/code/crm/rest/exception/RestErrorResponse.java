package io.code.crm.rest.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class RestErrorResponse {

	private Instant timestamp;

	private int status;
	private HttpStatus httpStatus;
	private String error;

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
		this.status = httpStatus.value();
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}