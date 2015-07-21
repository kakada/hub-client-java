package org.instedd.hub.client.http;

import java.io.IOException;
import java.net.URI;

import org.instedd.hub.client.constants.Constant;
import org.instedd.hub.client.form.FormData;
import org.instedd.hub.client.http.response.ResponseStatus;

/**
 * @author Kakada Chheang
 *
 */

public abstract class AbstractHttpRequest {
	
	private URI uri;
	private String username;
	private String password;
	private String method;
	private FormData formData;
	
	public AbstractHttpRequest(URI uri, String username, String password) {
		this(uri, username, password, Constant.HTTP_METHOD_GET);
	}
	
	public AbstractHttpRequest(URI uri, String username, String password, String method) {
		this.uri = uri;
		this.username = username;
		this.password = password;
		this.method = method;
	}
	
	public abstract ResponseStatus send() throws IOException;
	
	/**
	 * @return the uri
	 */
	public URI getUri() {
		return uri;
	}

	/**
	 * @param url the uri to set
	 */
	public void setUri(URI uri) {
		this.uri = uri;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return the formData
	 */
	public FormData getFormData() {
		return formData;
	}

	/**
	 * @param formData the formData to set
	 */
	public void setFormData(FormData formData) {
		this.formData = formData;
	}
	
}
