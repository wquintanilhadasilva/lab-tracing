package com.tracing.lab;

import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
public class AnimalParams extends RequestParams<AnimalParams>{
    public AnimalParams(Map<String, List<String>> params) {
        super(params);
    }

    public String getEspecie() {
        return String.valueOf(this.getOrDefault("especie", null));
    }
}
