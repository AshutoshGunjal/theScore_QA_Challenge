package base;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.JSONUtils;
import java.util.HashMap;

public class CapabilitiesReader {

	private static JSONObject getCapability(String capabilityName, String jsonLocation) throws Exception {
		JSONArray capabilitiesArray = JSONUtils.getJSONArray(jsonLocation);
		for (Object jsonObj : capabilitiesArray) {
			JSONObject capability = (JSONObject) jsonObj;
			if (capability.get("deviceName").toString().equalsIgnoreCase(capabilityName)) {
				return capability;
			}
		}
		return null;
	}

	private static HashMap<String, Object> convertCapsToHashMap(String capabilityName, String jsonLocation)
			throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(getCapability(capabilityName, jsonLocation).toString(), HashMap.class);
	}

	public static DesiredCapabilities getDesiredCapabilities(String capabilityName, String capsContentRootLocation)
			throws Exception {
		String jsonLocation = System.getProperty("user.dir") + "/" + capsContentRootLocation;
		HashMap<String, Object> caps = convertCapsToHashMap(capabilityName, jsonLocation);
		return new DesiredCapabilities(caps);
	}
}
