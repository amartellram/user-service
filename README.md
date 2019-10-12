# **USER SERVICE**

## Requisitos
- Java 11
- Maven
- Docker

## Ejecución
### MongoDB
`docker-compose up`
### Aplicación
`mvn user-service spring-boot:run`

## **Pruebas**
### Registrar usuario 
`curl -X POST 
  http://localhost:8091/users 
  -H 'Content-Type: application/json' 
  -d '{
	"documentType": "DNI",
	"documentNumber": "46887058",
	"firstName": "firstName",
	"lastName": "lastName"
}'`

### Consultar Usuarios

`curl -X GET 
  http://localhost:8091/users 
  -H 'Content-Type: application/json'`
