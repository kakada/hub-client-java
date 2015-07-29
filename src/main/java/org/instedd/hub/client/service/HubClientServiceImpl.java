package org.instedd.hub.client.service;

import java.io.IOException;
import java.net.URI;

import org.instedd.hub.client.form.FormData;
import org.instedd.hub.client.http.AbstractHttpJsonRequest;
import org.instedd.hub.client.http.HttpJsonGetRequest;
import org.instedd.hub.client.http.HttpJsonPostRequest;
import org.json.JSONObject;

/**
 * @author Kakada Chheang
 *
 */
public class HubClientServiceImpl implements IHubClientService {
	
	private String username;
	private String password;
	
	public HubClientServiceImpl(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public JSONObject doGet(URI uri) {
		JSONObject json = new JSONObject();
		
		AbstractHttpJsonRequest httpGetRequest = new HttpJsonGetRequest(uri);
		httpGetRequest.setBasicAuthentication(username, password);
		
		try {
			json = httpGetRequest.send();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}

	public JSONObject doPost(URI uri, FormData formData) {
		JSONObject json = new JSONObject();
		
		AbstractHttpJsonRequest httpPostRequest = new HttpJsonPostRequest(uri);
		httpPostRequest.setBasicAuthentication(username, password);
		httpPostRequest.setFormData(formData);
		
		try {
			json = httpPostRequest.send();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
}
