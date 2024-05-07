package com.tracing.lab;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings({"unchecked"})
public class ComplexBodyParams extends GenericParams<ComplexBodyParams> {
    public ComplexBodyParams(Map<String, Object> params) {
        super(params);
    }

    public String getEmissao() {
        return String.valueOf(this.getOrDefault("emissao", null));
    }
    public List<String> getEmpresas() {
        return (List<String>) this.getOrDefault("empresas", Collections.emptyList());
    }

    public Complexo getComplexo() {
        return new Complexo((Map<String, Object>) this.getOrDefault("complexo", null));
    }

    @Getter
    public class Complexo {
        private String at1;
        private Boolean at2;
        private Integer at3;

        public Complexo(Map<String, Object> values) {
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
