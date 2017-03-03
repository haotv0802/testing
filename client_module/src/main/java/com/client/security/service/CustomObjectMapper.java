/**
 * 
 */
package com.client.security.service;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author haho
 *
 */
@Component("jacksonObjectMapper")
public class CustomObjectMapper extends ObjectMapper {
	public CustomObjectMapper() {
		this.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, true);
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
}
