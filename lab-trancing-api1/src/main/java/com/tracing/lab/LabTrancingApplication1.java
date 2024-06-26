package com.tracing.lab;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
	@RequestMapping("/api/requests/{tipo}/{modelo}")
	@RequiredArgsConstructor
	class SearchController {

		private final ServiceCatalog serviceCatalog;

		@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		ResponseEntity<GetResult> getById(@PathVariable("modelo") String modelo,
											 @PathVariable("tipo") String tipo,
											 @PathVariable("id") String id) {
			log.info("Consultando modelo [{}] tipo [{}] com id: [{}]", modelo, tipo, id);
			ResponseEntity<GetResult> notFound = ResponseEntity.ofNullable(null);
			Optional<GetResult> result = serviceCatalog.getService(modelo, tipo)
					.flatMap(c -> c.getById(modelo, tipo, id));
			return result.map(ResponseEntity::ok)
					.orElse(notFound);
		}

		@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
		ResponseEntity<SearchResult> getWithParams(@PathVariable("modelo") String modelo,
												   @PathVariable("tipo") String tipo,
												   @RequestParam(required = false) Map<String, List<String>> params) {
			log.info("Pesquisando modelo [{}] Tipo [{}] com os parâmetros: [{}]", modelo, tipo, params);
			SearchResult result = serviceCatalog.getService(modelo, tipo)
					.map(s -> s.filter(modelo, tipo, s.params(params)))
					.orElse(null);
			return new ResponseEntity<SearchResult>(result, HttpStatus.OK);
		}

		@PostMapping(path="/_search", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		ResponseEntity<SearchResult> post(@PathVariable("modelo") String modelo,
									      @PathVariable("tipo") String tipo,
									      @RequestBody (required = true) Map<String, Object> params) {
			log.info("Pesquisa POST modelo [{}] Tipo [{}] com os parâmetros: [{}]", modelo, tipo, params);
			SearchResult result =  serviceCatalog.getService(modelo, tipo)
					.map(s -> s.filter(modelo, tipo, params))
					.orElse(null);
			return new ResponseEntity<SearchResult>(result, HttpStatus.OK);

		}

	}

}
