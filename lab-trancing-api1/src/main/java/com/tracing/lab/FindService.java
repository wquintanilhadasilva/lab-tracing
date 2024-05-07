package com.tracing.lab;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings({"rawtypes"})
public interface FindService<T extends RequestParams<?>> {

    boolean match(String model);
    Optional<GetResult<?>> getById(String model, String tipo, String id);
    SearchResult filter(String model, String tipo, T params);
    T params(Map<String, List<String>> params);
}
