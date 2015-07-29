package org.instedd.hub.client.service;

import java.net.URI;

import org.instedd.hub.client.form.FormData;
import org.json.JSONObject;

/**
 * @author Kakada Chheang
 *
 */
public interface IHubClientService {
	JSONObject doGet(URI uri);
	JSONObject doPost(URI uri, FormData formData);
}
