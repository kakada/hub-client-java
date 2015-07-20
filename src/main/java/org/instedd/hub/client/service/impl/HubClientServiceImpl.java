package org.instedd.hub.client.service.impl;

import org.instedd.hub.client.AvailabilityStatus;
import org.instedd.hub.client.Server;
import org.instedd.hub.client.form.FormData;
import org.instedd.hub.client.service.HubClientService;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author Kakada Chheang
 *
 */
public class HubClientServiceImpl implements HubClientService {

	public HubClientServiceImpl() { }

	public AvailabilityStatus ping(String url, String username,
			String password) {
		
		AvailabilityStatus status = null;
		
		try {
			Server server = new Server(url, username, password);
			server.connect();
			if(server.isAvailable()) {
				JSONObject jsonObject = new JSONObject(server.getResponseText());
				if (jsonObject.length() > 0) {
					status = new AvailabilityStatus(jsonObject.getBoolean("available"), jsonObject.getString("message"));
				}
			} else {
				status = new AvailabilityStatus(false, server.getResponseText());
			}
		} catch(JSONException je) {
			je.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;
	}

	public void doPost(String url, String username, String password,
			FormData formData) {

	}

}
