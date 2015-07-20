package org.instedd.hub.client.service;

import org.instedd.hub.client.AvailabilityStatus;
import org.instedd.hub.client.form.FormData;

/**
 * @author Kakada Chheang
 *
 */
public interface HubClientService {
	AvailabilityStatus ping(String url, String username, String password);
	void doPost(String url, String username, String password, FormData formData);
}
