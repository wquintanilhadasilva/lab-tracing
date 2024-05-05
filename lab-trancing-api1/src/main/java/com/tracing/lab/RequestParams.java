package com.tracing.lab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestParams<T extends RequestParams<?>> extends HashMap<String, List<String>> {

    public RequestParams(Map<String, List<String>> params) {
        super(params);
    }

}
