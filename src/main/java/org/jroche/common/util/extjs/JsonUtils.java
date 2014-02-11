package org.jroche.common.util.extjs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JsonUtils {
	private static Logger logger = Logger.getLogger(JsonUtils.class);

	public static List<FilterRequest> getListFromJsonArray(String data) {

		List<FilterRequest> values = new ArrayList<FilterRequest>();

		try {
			ObjectMapper mapper = new ObjectMapper();

			values = mapper.readValue(data,
					new TypeReference<List<FilterRequest>>() {
					});
		} catch (JsonParseException ex) {
			logger.error(ex);
		} catch (JsonMappingException ex) {
			logger.error(ex);
		} catch (IOException ex) {
			logger.error(ex);
		}
		return values;
	}
}
