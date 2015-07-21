package org.instedd.hub.client.http.response;

/**
 * @author Kakada Chheang
 *
 */
public class ResponseStatus {
	
	public static String AVAILABLE = "available";
	public static String MESSAGE = "message";

	private boolean available;

	private String message;

	protected ResponseStatus() {
	}

	public ResponseStatus(boolean available, String message) {
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
