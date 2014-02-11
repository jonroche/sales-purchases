package org.jroche.common.util.extjs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ResponseMap<T> {

	private static final String MESSAGE = "message";
	private static final String SUCCESS = "success";
	private static final String DATA = "data";
	private static final String TOTAL = "total";


	public Map<String, Object> mapOK(List<T> items) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put(TOTAL, items.size());
		modelMap.put(DATA, items);
		modelMap.put(SUCCESS, true);

		return modelMap;
	}

	public Map<String, Object> mapOK(List<T> items, long total) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put(TOTAL, total);
		modelMap.put(DATA, items);
		modelMap.put(SUCCESS, true);

		return modelMap;
	}
	
	public Map<String, Object> mapOK(List<T> items, String message) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put(MESSAGE, message);
		modelMap.put(DATA, items);
		modelMap.put(SUCCESS, true);

		return modelMap;
	}

	public Map<String, Object> mapOK(T item) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put(DATA, item);
		modelMap.put(SUCCESS, true);

		return modelMap;
	}
	
	public Map<String, Object> mapOK(T item, String msg) {

		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put(DATA, item);
		modelMap.put(MESSAGE, msg);
		modelMap.put(SUCCESS, true);

		System.out.println("Model Map -- " + modelMap);
		
		return modelMap;
	}


	public Map<String, Object> mapError(String msg) {
		
		Map<String, Object> modelMap = new HashMap<String, Object>(2);
		modelMap.put(MESSAGE, msg);
		modelMap.put(SUCCESS, false);

		return modelMap;
	}
}
