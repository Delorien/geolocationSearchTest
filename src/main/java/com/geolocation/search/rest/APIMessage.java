package com.geolocation.search.rest;

public class APIMessage {

	public enum Status {
		SUCCESS, DECLINED
	}

	private Status status;
	private String message;
	private Object target;

	public APIMessage(Status status, String message) {
		this.status = status;
		this.message = message;
	}

	public APIMessage(Status status, String message, Object target) {
		this.status = status;
		this.message = message;
		this.target = target;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getTarget() {
		return target;
	}

	public void setTarget(Object target) {
		this.target = target;
	}
}
