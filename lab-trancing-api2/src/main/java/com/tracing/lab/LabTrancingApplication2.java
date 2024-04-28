package com.tracing.lab;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@Slf4j
public class LabTrancingApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(LabTrancingApplication2.class, args);
	}

	@RestController
	@RequestMapping("/api")
	class HttpController {
		@GetMapping
		String publicRoute() {
			log.info("Chamando api serviço 2");
			return "<h1>Rota livre app2</h1>";
		}
	}

}
