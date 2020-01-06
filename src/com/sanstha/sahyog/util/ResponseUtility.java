package com.sanstha.sahyog.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ResponseUtility {

	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	public static String objectToString(Object targetObject) throws JsonProcessingException {
		String response = null;
		response = objectMapper.writeValueAsString(targetObject);
		return response;
	}
}
