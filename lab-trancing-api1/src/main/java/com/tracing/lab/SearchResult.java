package com.tracing.lab;

import java.time.LocalDateTime;
import java.util.List;

public record SearchResult<T>(
        List<T> content,
//        RequestParams<?> params,
        String model,
        String tipo,
        LocalDateTime time,
        String filter){}
