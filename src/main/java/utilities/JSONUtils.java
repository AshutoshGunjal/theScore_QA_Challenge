package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import utilities.UtilProperties;

import java.io.FileReader;

public class JSONUtils {

	// this method returns the json array from the json file provided at the given Location
	public static JSONArray getJSONArray(String jsonLocation) throws Exception {
		JSONParser jsonParser = new JSONParser();
		return (JSONArray) jsonParser.parse(new FileReader(jsonLocation));
	}

	public static JSONObject getLeaguesObject(String key) {
		JSONParser jsonParser = new JSONParser();
		try {
			return (JSONObject)((JSONObject) jsonParser.parse(new FileReader(System.getProperty("user.dir") + "/" + UtilProperties.get("test_data_location")))).get(key);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
