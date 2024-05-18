# Getting Started

# Comandos Curl auxiliares

```
curl --request GET \
  --url http://localhost:8081/api/requests/evento/nfcom/1
```

```
curl --request GET \
  --url http://localhost:8081/api/requests/dfe/nfcom/1
```

```
curl --request GET \
  --url 'http://localhost:8081/api/requests/dfe/nfcom?param1=val1&param2=val2&param2=val3'
```

```
curl --request GET \
  --url 'http://localhost:8081/api/requests/evento/nfcom?x1=val1&y=val2'
```

```
curl --request POST \
  --url http://localhost:8081/api/requests/evento/nfcom/_search \
  --header 'Content-Type: application/json' \
  --data '{
	"emissao": "2024-05-01",
	"empresas": ["a","b","c"],
	"complexo": {
		"at1": "valor",
		"at2": false,
		"at3": 123
	}
}'
```

```
curl --request POST \
  --url http://localhost:8081/api/requests/dfe/nfcom/_search \
  --header 'Content-Type: application/json' \
  --data '{
	"emissao": "2024-05-01",
	"empresas": ["a","b","c"],
	"complexo": {
		"at1": "valor",
		"at2": false,
		"at3": 123
	}
}'
```