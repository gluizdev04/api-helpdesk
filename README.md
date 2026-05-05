**API Helpdesk**

API REST simples para gerenciamento de chamados (tickets).

**Status:**
     Em desenvolvimento.
     Estrutura inicial pronta (entidades, banco e migrations).

**Tecnologias**
* Java 21
* Spring Boot
* Spring Data JPA
* Flyway
* MySQL
* Lombok

O projeto usa Flyway para controle de versão do banco.

**As migrations ficam em:** src/main/resources/db/migration

Para rodar o projeto, basta ter um banco MySQL criado (ex: api_helpdesk).
As tabelas são criadas automaticamente ao subir a aplicação.

Como rodar
Clonar o repositório
Configurar o banco no application.properties:

    spring.datasource.url=jdbc:mysql://localhost:3306/api_helpdesk
    spring.datasource.username=SEU_USUARIO
    spring.datasource.password=SUA_SENHA

Run.
