package org.instedd.hub.client.service;

import java.io.IOException;
import java.net.URI;

import org.instedd.hub.client.form.FormData;
import org.instedd.hub.client.http.AbstractHttpRequest;
import org.instedd.hub.client.http.HttpGetRequest;
import org.instedd.hub.client.http.HttpPostRequest;
import org.instedd.hub.client.http.response.ResponseStatus;

/**
 * @author Kakada Chheang
 *
 */
public class HubClientServiceImpl implements IHubClientService {

	public ResponseStatus doGet(URI uri, String username, String password) {
		ResponseStatus status = null;
		
		AbstractHttpRequest httpGetRequest = new HttpGetRequest(uri, username, password);
		try {
			status = httpGetRequest.send();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	public ResponseStatus doPost(URI uri, String username, String password, FormData formData) {
		ResponseStatus status = null;
		
		AbstractHttpRequest httpPostRequest = new HttpPostRequest(uri, username, password);
		httpPostRequest.setFormData(formData);
		try {
			status = httpPostRequest.send();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
