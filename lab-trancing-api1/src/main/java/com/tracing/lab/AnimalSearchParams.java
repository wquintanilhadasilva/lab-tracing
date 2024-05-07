package com.tracing.lab;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"unchecked"})
public class AnimalSearchParams extends GenericParams<AnimalSearchParams> {
    public AnimalSearchParams(Map<String, Object> params) {
        super(params);
    }

    public String getEmissao() {
        return String.valueOf(this.getOrDefault("emissao", null));
    }
    public List<String> getEmpresas() {
        return (List<String>) this.getOrDefault("empresas", Collections.emptyList());
    }

    public InnerFilters innerFilters() {
        return new InnerFilters((Map<String, Object>) this.getOrDefault("moreFilters", null));
    }

    @Getter
    public class InnerFilters {
        private String at1;
        private Boolean at2;
        private Integer at3;

        public InnerFilters(Map<String, Object> values) {
            Objects.requireNonNull(values, "values não podem ser nulo");
            this.at1 = (String) values.getOrDefault("at1", null);
            this.at2 = (Boolean) values.getOrDefault("at2", null);
            this.at3 = (Integer) values.getOrDefault("at3", null);
        }
    }

    @Override
    public String toString() {
        try {
            return MAPPER.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
