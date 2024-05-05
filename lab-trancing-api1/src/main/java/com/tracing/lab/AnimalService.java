package com.tracing.lab;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AnimalService implements FindService<AnimalParams> {
    @Override
    public boolean match(String model) {
        return "animal".equals(model);
    }

    @Override
    public Optional<Domain> getById(String model, String id) {
        var animal = new Animal(STR."Animal: \{model} - ID: \{id}", 5);
        return Optional.of(new Domain(animal, LocalDateTime.now()));
    }

    @Override
    public Domain filter(String model, AnimalParams params) {
        String parametros = STR."Filtro aplicado: \{params} - modelo \{model}";
        return new Domain(parametros, LocalDateTime.now());
    }

    @Override
    public AnimalParams params(Map<String, List<String>> params) {
        return new AnimalParams(params);
    }
}
