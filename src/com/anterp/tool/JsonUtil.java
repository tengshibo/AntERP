package com.anterp.tool;

import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	public static <T> T getObject(Class<T> clazz, String json) {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.convertValue(json, clazz);
	}
}
