package com.anterp.tool;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {

	public static <T> T getObject(Class<T> clazz, String json)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		// return objectMapper.convertValue(json, clazz);
		return objectMapper.readValue(json, clazz);

	}
}
