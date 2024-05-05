package com.tracing.lab;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AnimalService implements FindService {
    @Override
    public boolean match(String model) {
        return "animal".equals(model);
    }

    @Override
    public Optional<Domain> getById(String model, String id) {
        var animal = new Animal(STR."Animal: \{model} - ID: \{id}", 5);
        return Optional.of(new Domain(animal, LocalDateTime.now()));
    }
}
