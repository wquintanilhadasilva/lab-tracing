package com.tracing.lab;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GenericParams <T extends GenericParams<?>> extends HashMap<String, Object> {

    protected static final ObjectMapper MAPPER = new ObjectMapper();

    public GenericParams(Map<String, Object> params) {
        super(params);
    }

    @Override
    public String toString() {
        return (String) keySet().stream()
                .map(key -> STR."\{key}=\{this.get(key)}")
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
