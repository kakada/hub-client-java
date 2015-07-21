/**
 * 
 */
package org.instedd.hub.client.http.response.parser;

import java.io.BufferedReader;
import java.io.IOException;

import org.json.JSONObject;

/**
 * @author mac
 *
 */
public class JsonParser {
	
	public static JSONObject parse(BufferedReader reader) throws IOException {
		StringBuffer responseText = new StringBuffer();
		String line = "";
		while ((line = reader.readLine()) != null) {
			responseText.append(line);
		}
		
		return new JSONObject(responseText.toString());
	}

}
