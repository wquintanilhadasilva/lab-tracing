package com.tracing.lab;

import java.time.LocalDateTime;

public record GetResult<T>(T content, LocalDateTime time){}
