package com.example;

public class Email {

	private String toAddress;
	private String body;
	
	public Email() {
		super();
	}

	public Email(String toAddress, String body) {
		super();
		this.toAddress = toAddress;
		this.body = body;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Email [toAddress=" + toAddress + ", body=" + body + "]";
	}
	
	
}
