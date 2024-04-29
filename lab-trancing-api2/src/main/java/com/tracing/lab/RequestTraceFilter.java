package com.tracing.lab;

import org.springframework.boot.actuate.trace.TraceProperties;
import org.springframework.boot.actuate.trace.TraceRepository;
import org.springframework.boot.actuate.trace.WebRequestTraceFilter;
import org.springframework.util.AntPathMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class RequestTraceFilter extends WebRequestTraceFilter {

    private static final String[] excludedEndpoints = new String[]{"/css/**", "/js/**", "/management"};

    public RequestTraceFilter(TraceRepository repository, TraceProperties properties) {
        super(repository, properties);
    }

    @Override
    protected boolean shouldNotFilter(final HttpServletRequest request) throws ServletException {
        return Arrays
                .stream(excludedEndpoints)
                .anyMatch(e -> new AntPathMatcher().match(e, request.getServletPath()));
    }
}