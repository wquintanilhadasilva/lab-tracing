package com.tracing.lab;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@SuppressWarnings({"rawtypes"})
public class ServiceCatalog {

    private Map<String, FindService> servicesMap = new HashMap<>();

    public ServiceCatalog(final List<FindService> servicesList){
        servicesList.forEach(s -> {
            var tipo = s.getTipo();
            var modelo = s.getModelo();
            var key = key(modelo, tipo);
            if (servicesMap.containsKey(key)) {
                throw new RuntimeException(STR."Já existe uma implementação para o modelo \{modelo} e \{tipo}");
            }
            servicesMap.put(key,s);
        });
    }

    private String key(String modelo, String tipo) {
        return STR."\{modelo}:\{tipo}";
    }

    public Optional<FindService> getService(String modelo, String tipo) {
        var key = key(modelo,tipo);
        return Optional.ofNullable(servicesMap.getOrDefault(key, null));
    }

}
