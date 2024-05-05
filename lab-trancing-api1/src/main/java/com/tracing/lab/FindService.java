package com.tracing.lab;

import java.util.Optional;

public interface FindService {

    boolean match(String model);
    Optional<Domain> getById(String model, String id);
}
