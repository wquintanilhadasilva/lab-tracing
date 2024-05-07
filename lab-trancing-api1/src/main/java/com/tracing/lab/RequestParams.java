package com.tracing.lab;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings({"unchecked","rawtypes"})
public class RequestParams<T extends RequestParams<?>> extends GenericParams {

    public RequestParams(Map<String, List<String>> params) {
        super(params);
    }

}
