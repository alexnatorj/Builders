Builders

Ao iniciar este exercício, eu optei pelo uso do banco de banco de dados H2, por ser um banco em memória,
achei mais conveniente para os examinadores testarem a aplicação.

Para a documentação da API, escolhi o swagger. Após início da aplicação, a documentação estará disponível na url:
http://localhost:8080/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config#/

Para listagem por filtro paginado, há duas opções:
 1- objeto Json por parâmetro (RequestParam) na url, na qual exige uma conversão dos caractéres.
 2- objeto Json pelo corpo (RequestBody), na qual é mais simples de enviar o objeto pelo postman.

