package org.instedd.hub.client.http;

import java.io.IOException;

import org.instedd.hub.client.form.FormData;
import org.instedd.hub.client.http.response.ResponseStatus;

/**
 * @author Kakada Chheang
 *
 */

public abstract class AbstractHttpRequest {
	
	private FormData formData = new FormData();
	
	public abstract ResponseStatus send() throws IOException;
	
	public abstract void setBasicAuthentication(String username, String password);
	
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
