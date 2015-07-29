package org.instedd.hub.client.http;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;
import org.instedd.hub.client.constants.Constant;
import org.instedd.hub.client.form.FormData;
import org.json.JSONObject;

/**
 * @author Kakada Chheang
 *
 */

public abstract class AbstractHttpJsonRequest {
	
	private FormData formData = new FormData();
	
	public AbstractHttpJsonRequest() {
		setDefaultHeaders();
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
	
	/**
	 * get default header of json request
	 * @return array of basic header
	 */
	public Header[] getDefaultHeaders() {
		Header[] headers = {
				new BasicHeader(Constant.HEADER_ACCEPT, Constant.CONTENT_TYPE_APPLICATION_JSON),
				new BasicHeader(Constant.HEADER_CONTENT_TYPE, Constant.CONTENT_TYPE_APPLICATION_JSON)
		};
		return headers;
	}
	
	/**
	 * send request to target uri
	 * @return
	 * @throws IOException
	 */
	public abstract JSONObject send() throws IOException;
	
	/**
	 * set default header of json request
	 */
	public abstract void setDefaultHeaders();
	
	/**
	 * Set basic authentication to request header
	 * @param username
	 * @param password
	 */
	public abstract void setBasicAuthentication(String username, String password);
	
}
