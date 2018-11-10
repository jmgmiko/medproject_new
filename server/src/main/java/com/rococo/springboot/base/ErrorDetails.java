package com.rococo.springboot.base;

import java.sql.Date;

/**
 * @author RGTC-0039
 *
 */
public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
}