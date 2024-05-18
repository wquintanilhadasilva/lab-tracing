package com.tracing.lab;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalParams extends RequestParams<AnimalParams>{
    public AnimalParams(Map<String, List<String>> params) {
        super(params);
    }

    public String getEspecie() {
        return String.valueOf(this.getOrDefault("especie", null));
    }

    @Override
    public String toString() {
        return (String) keySet().stream()
                .map(key -> key + "=" + this.get(key))
                .collect(Collectors.joining(", ", "{", "}"));
    }
}
