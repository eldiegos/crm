package io.code.crm.rest.exception;



public enum CrmRestExceptionError {

	
	
	UNKNOW_ERROR(2000, "Unknow Error")
	, UNAUTHORIZED_HTTP(2001, "Unauthorized http")
	, FORBIDDEN_HTTP(2002, "Forbiden Http")
	
	
	, BIRT_INTERNAL_ERROR(2003, "Birt Engine Error")
	, BIRT_REPORT_PARAMS_ERROR(2004, "Birt Param Error")
	, BIRT_REPORT_NOT_EXISTS(2005, "Birt Report does not exists")
	
	, BIRT_PARAMS_INCORRECT_TYPE(3003, "Incorrect type of parameter")
	, BIRT_PARAMS_REQUIRED(3005, "Required parameter")
	
	, BIRT_REQUIRED_DATASOURCE_EXCEPTION(3010, "Required Datasource")
	
	;
	
	
	

	private final int value;

	private final String reasonPhrase;


	CrmRestExceptionError(int value, String reasonPhrase) {
		this.value = value;
		this.reasonPhrase = reasonPhrase;
	}


	/**
	 * Return the integer value of this status code.
	 */
	public int value() {
		return this.value;
	}

	/**
	 * Return the reason phrase of this status code.
	 */
	public String getReasonPhrase() {
		return this.reasonPhrase;
	}

	
	public String getInfo() {
		
		return CrmRestExceptionError.class.getCanonicalName() + "[" + this.value + "] " + this.getReasonPhrase();
	}
	
}
