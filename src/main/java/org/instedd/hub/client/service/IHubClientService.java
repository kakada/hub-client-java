package org.instedd.hub.client.service;

import java.net.URI;

import org.instedd.hub.client.form.FormData;
import org.instedd.hub.client.http.response.ResponseStatus;

/**
 * @author Kakada Chheang
 *
 */
public interface IHubClientService {
	ResponseStatus doGet(URI uri);
	ResponseStatus doPost(URI uri, FormData formData);
}
