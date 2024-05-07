package com.tracing.lab;

import lombok.ToString;

import java.util.List;
import java.util.Map;

@ToString
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
}
