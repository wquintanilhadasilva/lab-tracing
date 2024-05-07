package com.tracing.lab;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@SuppressWarnings({"rawtypes"})
public class ServiceCatalog {

    private Map<String, FindService> servicesMap;

    public ServiceCatalog(final List<FindService> servicesList){
        servicesMap = servicesList.stream()
            .collect(Collectors.toMap(
                k -> key(k.getModelo(), k.getTipo()),
                s -> s,
                (existing, replacement) -> {
                    throw new RuntimeException(STR."Já existe uma implementação para o modelo \{existing.getModelo()} e \{existing.getTipo()}");
                },
                HashMap::new
            ));
    }

    private String key(String modelo, String tipo) {
        return STR."\{modelo}:\{tipo}";
    }

    public Optional<FindService> getService(String modelo, String tipo) {
        var key = key(modelo,tipo);
        return Optional.ofNullable(servicesMap.getOrDefault(key, null));
    }

}
