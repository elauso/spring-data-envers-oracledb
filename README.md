# Spring Data Envers Oracledb

Essa aplicação se comunica com banco de dados oracle 19c utilizando o spring-data. É utilizado também o spring-data-envers para realizar auditoria das transações na tabela de produtos.

A subida do banco de dados oracle é feita via docker-compose. Para isso é necessário antes gerar a imagem do oracle-19c: https://github.com/steveswinsburg/oracle19c-docker 

O driver para conexão com o banco de dados encontra-se na pasta libs/compile, que é carregado no buildpath durante a subida da aplicação.

Essa aplicação possui dois endpoints para cadastro e listagem de produtos.

## Stack

Tecnologia                       |  Versão       |
---------------------------------|---------------|
jdk                              | 11
kotlin                           | 1.4.21
spring-boot                      | 2.4.1
map-struct                       | 1.4.0.Beta3
swagger                          | 2.9.2
ojdbc8                           | 12.2

## Dependências

* jdk11
* docker
* docker-compose
* oracle19c-pdb-image

## Instalação

* Realize a instalação e geração da imagem oracle-19c para o docker: https://github.com/steveswinsburg/oracle19c-docker
* Suba o banco de dados (atente-se para aguarda a subida completa): ```docker-compose up```
* Realize o build da aplicação: ```./gradlew build```
* Inicie a aplicação: ```./gradlew bootRun```

## Execução

Utilize a interface do swagger: http://localhost:8080/swagger-ui.html

Para verificar os registros na tabela de histórico será necessário se conectar ao banco de dados utilizando o oracle sql developer: https://www.oracle.com/tools/downloads/sqldev-downloads.html