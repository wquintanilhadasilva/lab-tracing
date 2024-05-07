package com.tracing.lab;

import java.util.HashMap;
import java.util.Map;

public class GenericParams <T extends GenericParams<?>> extends HashMap<String, Object> {
    public GenericParams(Map<String, Object> params) {
        super(params);
    }
}
