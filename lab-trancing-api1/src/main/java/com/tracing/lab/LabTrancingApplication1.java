package com.tracing.lab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@SpringBootApplication
@Slf4j
@SuppressWarnings({"unchecked","rawtypes"})
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
	@RequestMapping("/api/_search/docs")
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

		@GetMapping("/{modelo}/_filter")
		ResponseEntity<Domain> getWithParams(@PathVariable("modelo") String modelo,
											 @RequestParam Map<String, List<String>> params) {
			log.info("Pesquisando modelo [{}] com os parâmetros: [{}]", modelo, params);
			Domain result = findServices.stream()
					.filter(s -> s.match(modelo))
					.findAny()
					.map(s -> s.filter(modelo, s.params(params)))
					.orElse(null);
			return ResponseEntity.ok(result);
		}

	}

}
