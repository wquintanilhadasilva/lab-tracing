package com.tracing.lab;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class CarService implements FindService<CarParams> {
    @Override
    public boolean match(String model) {
        return "car".equals(model);
    }

    @Override
    public Optional<Domain> getById(String model, String id) {
        var car = new Car(STR."Car Model: \{model} - ID: \{id}", 5, "Red");
        return Optional.of(new Domain(car, LocalDateTime.now()));
    }

    @Override
    public Domain filter(String model, CarParams params) {
        log.info("Filtrando Car [{}]", params);
        String parametros = STR."Filtro aplicado: \{params} - modelo \{model}";
        return new Domain(parametros, LocalDateTime.now());
    }

    @Override
    public CarParams params(Map<String, List<String>> params) {
        return new CarParams(params);
    }
}
