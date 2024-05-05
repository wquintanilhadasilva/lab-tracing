package com.tracing.lab;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface FindService<T extends RequestParams<?>> {

    boolean match(String model);
    Optional<Domain> getById(String model, String id);
    Domain filter(String model, T params);
    T params(Map<String, List<String>> params);
}
