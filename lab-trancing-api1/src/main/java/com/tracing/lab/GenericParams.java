package com.tracing.lab;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

public class GenericParams <T extends GenericParams<?>> extends HashMap<String, Object> {

    protected static final ObjectMapper MAPPER = new ObjectMapper();

    public GenericParams(Map<String, Object> params) {
        super(params);
    }
}
