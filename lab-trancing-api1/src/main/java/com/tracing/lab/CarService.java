package com.tracing.lab;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class CarService implements FindService<CarParams, CarSearchParams> {
    @Override
    public boolean match(String model) {
        return "evento".equals(model);
    }

    @Override
    public Optional<GetResult<?>> getById(String model, String tipo, String id) {
        log.info("Consultando por ID Car [{}], Model [{}], Tipo [{}]", id, model, tipo);
        var car = new Car(model, tipo, 2018, "Green");
        return Optional.of(new GetResult<Car>(car, LocalDateTime.now()));
    }

    @Override
    public SearchResult<Car> filter(String model, String tipo, CarParams params) {
        log.info("Filtrando Car [{}], Model [{}], Tipo [{}]", params, model, tipo);
        var car = new Car(model, tipo, 2017, "red");
        return new SearchResult<Car>(List.of(car), model, tipo, LocalDateTime.now(), params.toString());
    }

    @Override
    public CarParams params(Map<String, List<String>> params) {
        return new CarParams(params);
    }

    @Override
    public SearchResult<Car> filter(String model, String tipo, CarSearchParams params) {
        log.info("Filtrando Car [{}], Model [{}], Tipo [{}]", params, model, tipo);
        var car = new Car(model, tipo, 2017, params.getComplexo().getAt1());
        return new SearchResult<Car>(List.of(car), model, tipo, LocalDateTime.now(), params.toString());
    }
}
