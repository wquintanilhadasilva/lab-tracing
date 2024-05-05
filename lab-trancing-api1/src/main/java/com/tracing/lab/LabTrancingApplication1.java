package com.tracing.lab;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static java.lang.StringTemplate.STR;

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

	@RestController
	@RequestMapping("/api/_search")
	@RequiredArgsConstructor
	class SearchController {

		private final List<FindService> findServices;

		@GetMapping("/{id}")
		ResponseEntity<Domain> getById(@PathVariable("id") String id) {
			return ResponseEntity.ok(new Domain(STR."Default - ID: \{id}", LocalDateTime.now()));
		}

		@GetMapping("/{modelo}/{id}")
		ResponseEntity<Domain> getById(@PathVariable("modelo") String modelo, @PathVariable("id") String id) {
			ResponseEntity<Domain> notFound = ResponseEntity.ofNullable(null);
			Optional<Domain> result = findServices.stream()
                    .filter(s -> s.match(modelo))
                    .findFirst()
					.flatMap(c -> c.getById(modelo, id));
			return result.map(ResponseEntity::ok)
					.orElse(notFound);
		}
	}

}
