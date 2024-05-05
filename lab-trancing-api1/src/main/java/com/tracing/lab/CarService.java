package com.tracing.lab;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CarService implements FindService {
    @Override
    public boolean match(String model) {
        return "car".equals(model);
    }

    @Override
    public Optional<Domain> getById(String model, String id) {
        var car = new Car(STR."Car Model: \{model} - ID: \{id}", 5, "Red");
        return Optional.of(new Domain(car, LocalDateTime.now()));
    }
}
