package org.instedd.hub.client;

/**
 * @author Kakada Chheang
 *
 */
public class AvailabilityStatus {

	private boolean available;

	private String message;

	protected AvailabilityStatus() {
	}

	public AvailabilityStatus(boolean available, String message) {
		this.available = available;
		this.message = message;
	}

	public boolean isAvailable() {
		return available;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "[Available: " + available + ", message: " + message + "]";
	}

}
