package com.tracing.lab;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
public class AnimalService implements FindService<AnimalParams, AnimalSearchParams> {

    @Override
    public String getTipo() {
        return "dfe";
    }

    @Override
    public String getModelo() {
        return "nfcom";
    }

    @Override
    public Optional<GetResult<?>> getById(String model, String tipo, String id) {
        log.info("Consultando por ID Animal [{}], Model [{}], Tipo [{}]", id, model, tipo);
        var animal = new Animal(model, tipo, 5);
        return Optional.of(new GetResult<Animal>(animal, LocalDateTime.now()));
    }

    @Override
    public SearchResult<Animal> filter(String model, String tipo, AnimalParams params) {
        log.info("Filtrando Animal [{}], Model [{}], Tipo [{}]", params, model, tipo);
        var animal = new Animal(model, tipo,6);
        return new SearchResult<Animal>(List.of(animal), model, tipo, LocalDateTime.now(), params.toString());
    }

    @Override
    public AnimalParams params(Map<String, List<String>> params) {
        return new AnimalParams(params);
    }

    @Override
    public SearchResult<Animal> filter(String model, String tipo, AnimalSearchParams params) {
        log.info("Filtrando Animal [{}], Model [{}], Tipo [{}]", params, model, tipo);
        var animal = new Animal(model, tipo, 2);
        return new SearchResult<Animal>(List.of(animal), model, tipo, LocalDateTime.now(), params.toString());
    }
}
