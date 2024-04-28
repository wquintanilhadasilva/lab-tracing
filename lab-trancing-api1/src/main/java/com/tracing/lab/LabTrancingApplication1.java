package com.tracing.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LabTrancingApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(LabTrancingApplication1.class, args);
	}

	@RestController
	@RequestMapping("/api")
	class HttpController {
		@GetMapping
		String publicRoute() {
			return "<h1>Rota livre app 1</h1>";
		}
	}

}
