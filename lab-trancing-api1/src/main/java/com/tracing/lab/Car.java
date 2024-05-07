package com.tracing.lab;

import java.time.LocalDate;

public record Car(
        String model,
        String tipo,
        Integer year,
        String color
) {}
