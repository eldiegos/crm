package io.code.crm.rest.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;




public class CrmRestException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CrmRestExceptionError ee;
	private HttpStatus httpStatus;

	
	
	public CrmRestException(HttpStatus httpStatus, String errorMessage) {
		super(errorMessage);

		this.httpStatus = httpStatus;

		Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, errorMessage);

	}
	
	public CrmRestException(HttpStatus httpStatus, CrmRestExceptionError ee) {
		super(ee.getReasonPhrase());

		this.ee = ee;
		this.httpStatus = httpStatus;

		Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ee.getInfo());
		

	}

	public CrmRestException(CrmRestExceptionError ee, Throwable err) {
		super(ee.getReasonPhrase(), err);

		this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		this.ee = ee;

		Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, ee.getInfo());

	}

	public CrmRestExceptionError getEe() {
		return ee;
	}

	public void setEe(CrmRestExceptionError ee) {
		this.ee = ee;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	

}
