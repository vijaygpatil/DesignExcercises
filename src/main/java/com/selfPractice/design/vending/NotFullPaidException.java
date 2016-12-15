package com.selfPractice.design.vending;

/**
 * An Exception, thrown by Vending Machine when a user tries to collect an item,
 * without paying the full amount.
 * 
 * @author patil
 *
 */
public class NotFullPaidException extends RuntimeException {
	private static final long serialVersionUID = -1692356257270567918L;
	private String message;
	private long remaining;

	public NotFullPaidException(String message, long remaining) {
		this.message = message;
		this.remaining = remaining;
	}

	public long getRemaining() {
		return remaining;
	}

	@Override
	public String getMessage() {
		return message + remaining;
	}
}