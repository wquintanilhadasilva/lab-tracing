package com.tracing.lab;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CarParams extends RequestParams<CarParams>{
    public CarParams(Map<String, List<String>> params) {
        super(params);
    }

    public String getYear() {
        return String.valueOf(this.getOrDefault("year", null));
    }
    public String getColor() {
        return String.valueOf(this.getOrDefault("color", null));
    }

    @Override
    public String toString() {
        return (String) keySet().stream()
                .map(key -> key + "=" + this.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
