package com.cts.crm.exception;

public class SubscriptionNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6634799553023538714L;

	public SubscriptionNotFoundException(String message) {
		super(message);
	}
}
