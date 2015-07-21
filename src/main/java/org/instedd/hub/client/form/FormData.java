/**
 * 
 */
package org.instedd.hub.client.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 * @author Kakada Chheang
 *
 */
public class FormData {
	
	private Map<String, String> params = new HashMap<String, String>();
	
	/**
	 * add new param to request body
	 * @param key
	 * @param value
	 */
	public void addParam(String key, String value) {
		params.put(key, value);
	}
	
	
	/**
	 * return: list of NameValuePair that is used for url parameter in http post request
	 */
	public List<NameValuePair> getParams() {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		
		for(Entry<String, String> entry : this.params.entrySet()) {
			params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		
		return params;
	}
}
