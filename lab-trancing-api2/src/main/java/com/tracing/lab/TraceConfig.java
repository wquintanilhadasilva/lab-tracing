package com.tracing.lab;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.trace.InMemoryTraceRepository;
import org.springframework.boot.actuate.trace.TraceProperties;
import org.springframework.boot.actuate.trace.WebRequestTraceFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraceConfig {

    @Value("${tracing.exclude-paths}")
    private String[] excludedEndpoints;
    @Bean
    public WebRequestTraceFilter createTraceFilter(){
        return new RequestTraceFilter(new InMemoryTraceRepository(), new TraceProperties(), excludedEndpoints);
    }
}
