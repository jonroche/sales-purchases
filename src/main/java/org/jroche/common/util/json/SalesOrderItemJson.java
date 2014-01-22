package org.jroche.common.util.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.jroche.common.util.extjs.JsonUtils;
import org.jroche.web.model.order.sales.SalesOrderItemsUI;

public class SalesOrderItemJson extends JsonUtils {
	Logger logger = Logger.getLogger(SalesOrderItemJson.class);

	public String getJSON(List<SalesOrderItemsUI> data) {
		String result = "";
		try {
			ObjectMapper mapper = new ObjectMapper();
			result = mapper.writeValueAsString(data);
		} catch (JsonParseException ex) {
			logger.error(ex);
		} catch (JsonMappingException ex) {
			logger.error(ex);
		} catch (IOException ex) {
			logger.error(ex);
		}
		return result;
	}

	public List<SalesOrderItemsUI> getListFromJSON(String data) {
		List<SalesOrderItemsUI> values = new ArrayList<SalesOrderItemsUI>();

		ObjectMapper mapper = new ObjectMapper();

		try {
			values = mapper.readValue(data,
					new TypeReference<List<SalesOrderItemsUI>>() {
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
