package com.cg.hospital.exceptions;

public class DoctorDetailsNotFoundException extends Exception{

	public DoctorDetailsNotFoundException() {
		super();
	}

	public DoctorDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DoctorDetailsNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public DoctorDetailsNotFoundException(String message) {
		super(message);
	}

	public DoctorDetailsNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
