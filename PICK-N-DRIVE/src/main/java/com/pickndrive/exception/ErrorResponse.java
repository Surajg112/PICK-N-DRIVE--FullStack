package com.pickndrive.exception;

import java.util.Date;

public class ErrorResponse {

	private String message;

	private String details;

	private Date timestamp;

	public ErrorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(String message, String details, Date timestamp) {
		super();
		this.message = message;

		this.details = details;
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
