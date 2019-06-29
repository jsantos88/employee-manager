# Employee Manager API

## Dependências
* java 8
* maven

## Executar aplicação
No diretório raiz da aplicação, executar os seguintes comandos:
```
mvn clean package
java -jar target/employees-api-1.0.0-RELEASE.jar
```

# Como usar a API:

## Cadastrar um novo employee
```
curl -X POST \
  http://localhost:8000/employee \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 5bce2020-95b9-4395-9b0e-b40d1e07a655' \
  -H 'cache-control: no-cache' \
  -d '{
	"name":"Jadson Santos",
	"email":"jadsontkd@gmail.com",
	"department":"Development"
}'
```

## Listar employees
```
curl -X GET \
  http://localhost:8000/employee \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 37de16e0-850d-47de-8d53-fa772e1ee2ff' \
  -H 'cache-control: no-cache'
```

## Deletar um employee (employee/1 significa employee com id 1, caso deseje deletar outro employee, passar o id correspondente)
```
curl -X DELETE \
  http://localhost:8000/employee/1 \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 0abdb00f-b194-4c10-8e4b-5791d66cae82' \
  -H 'cache-control: no-cache'
```