# Flux — Caixa Inteligente

> SaaS de gestão financeira e operacional para pequenos negócios prestadores de serviços.

![Status](https://img.shields.io/badge/status-em%20desenvolvimento-blue)
![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-17-blue)

---

# Sobre o projeto

O **Flux** é um SaaS desenvolvido para centralizar a gestão financeira e operacional de pequenos negócios prestadores de serviços.

O sistema nasceu para substituir controles realizados em planilhas, WhatsApp, cadernos e outros processos manuais, oferecendo uma plataforma única para gerenciamento financeiro e operacional.

O público inicial é composto por:

* Barbearias
* Salões de beleza
* Clínicas de estética
* Estúdios de tatuagem
* Pequenos negócios com profissionais autônomos e comissionados

A principal filosofia do produto é:

> **O Flux é um sistema financeiro com agenda integrada.**
>
> **Não é uma agenda com financeiro.**

---

# Status do projeto

🚧 Em desenvolvimento

O módulo **Empresa**, primeiro módulo de domínio do Flux, está concluído para o escopo atual do MVP.

## Funcionalidades concluídas

* ✅ Estrutura inicial do backend
* ✅ Integração com PostgreSQL
* ✅ Versionamento do banco com Flyway
* ✅ Arquitetura Package by Feature
* ✅ Health check da aplicação
* ✅ Cadastro de empresas
* ✅ Consulta de empresa por ID
* ✅ Listagem de empresas
* ✅ Atualização de empresas
* ✅ Desativação lógica de empresas
* ✅ Bean Validation
* ✅ DTOs de entrada e saída
* ✅ Tratamento global de exceções
* ✅ Respostas padronizadas de erro
* ✅ Logging de erros inesperados
* ✅ Testes unitários com JUnit 5 e Mockito
* ✅ Documentação do módulo Empresa

## Próximas funcionalidades

* ⏳ Gestão de usuários
* ⏳ Relacionamento entre usuários e empresas
* ⏳ Spring Security
* ⏳ Autenticação
* ⏳ JWT
* ⏳ Gestão de clientes
* ⏳ Gestão de profissionais
* ⏳ Gestão de serviços
* ⏳ Agenda
* ⏳ Financeiro
* ⏳ Dashboard
* ⏳ Frontend React

Funcionalidades como paginação, filtros avançados, Docker, CI/CD, testes de integração e observabilidade foram planejadas para etapas posteriores ao MVP.

---

# Tecnologias

## Backend

* Java 25
* Spring Boot 4
* Spring Web
* Spring Data JPA
* Spring Security
* Bean Validation
* Flyway
* Maven
* JUnit 5
* Mockito
* SLF4J

## Banco de dados

* PostgreSQL 17

## Frontend planejado

* React
* TypeScript

## Ferramentas

* IntelliJ IDEA Community
* DBeaver
* Postman
* Git
* GitHub

---

# Arquitetura

O backend está organizado utilizando **Package by Feature**, agrupando cada funcionalidade do domínio em seu próprio módulo.

Estrutura atual:

```text
backend/
└── src
    ├── main
    │   ├── java/com/flux/backend
    │   │   ├── auth
    │   │   ├── config
    │   │   ├── empresa
    │   │   │   ├── controller
    │   │   │   ├── dto
    │   │   │   ├── entity
    │   │   │   ├── enums
    │   │   │   ├── repository
    │   │   │   └── service
    │   │   ├── shared
    │   │   │   ├── dto
    │   │   │   ├── enums
    │   │   │   ├── exception
    │   │   │   ├── health
    │   │   │   └── util
    │   │   └── BackendApplication
    │   └── resources
    │       ├── application.properties
    │       ├── application-dev.properties
    │       ├── application-test.properties
    │       ├── application-prod.properties
    │       └── db/migration
    │           ├── V1__create_initial_schema.sql
    │           └── V2__create_empresa_table.sql
    └── test
        └── java/com/flux/backend
            └── empresa/service
                └── EmpresaServiceTest
```

Fluxo principal de uma requisição:

```text
HTTP Request
      │
      ▼
Controller
      │
      ▼
Request DTO
      │
      ▼
Service
      │
      ▼
Repository
      │
      ▼
PostgreSQL
      │
      ▼
Response DTO
      │
      ▼
HTTP Response
```

As entidades JPA não são retornadas diretamente pela API. A comunicação externa é realizada por meio de DTOs.

---

# Domínio Empresa

A empresa é a raiz do tenant no Flux.

Todos os futuros recursos do sistema estarão vinculados a uma empresa, como:

* usuários
* clientes
* profissionais
* serviços
* agenda
* movimentações financeiras

O projeto utilizará **multi-tenant lógico**, mantendo os dados de diferentes empresas no mesmo banco, separados pelo identificador da empresa.

## Status da empresa

Uma empresa pode possuir os seguintes estados:

```text
ACTIVE
INACTIVE
SUSPENDED
```

Significados:

* `ACTIVE`: empresa operando normalmente;
* `INACTIVE`: empresa desativada;
* `SUSPENDED`: empresa bloqueada administrativamente.

Empresas não são excluídas fisicamente durante o fluxo normal da aplicação. A desativação altera seu status para `INACTIVE`, preservando os dados e o histórico do tenant.

---

# API

Base local:

```text
http://localhost:8080
```

## Criar empresa

```http
POST /empresas
```

Exemplo de requisição:

```json
{
  "name": "Barbearia Alpha",
  "email": "contato@barbeariaalpha.com"
}
```

Resposta esperada:

```http
201 Created
```

Uma empresa é criada com status `ACTIVE`.

E-mails já utilizados retornam:

```http
409 Conflict
```

---

## Buscar empresa por ID

```http
GET /empresas/{id}
```

Resposta esperada:

```http
200 OK
```

Caso a empresa não exista:

```http
404 Not Found
```

---

## Listar empresas

```http
GET /empresas
```

Resposta esperada:

```http
200 OK
```

A resposta contém uma lista de empresas. A paginação será implementada após o MVP.

---

## Atualizar empresa

```http
PUT /empresas/{id}
```

Exemplo de requisição:

```json
{
  "name": "Barbearia Alpha Prime",
  "email": "contato@barbeariaalpha.com"
}
```

Podem ser alterados:

* nome;
* e-mail.

Não podem ser alterados por esse endpoint:

* ID;
* data de criação;
* status.

O e-mail pode permanecer igual ao atual, mas não pode pertencer a outra empresa.

Respostas possíveis:

```text
200 OK
404 Not Found
409 Conflict
422 Unprocessable Entity
```

---

## Desativar empresa

```http
DELETE /empresas/{id}
```

A operação realiza uma desativação lógica.

O registro não é removido do banco. O status da empresa é alterado para:

```text
INACTIVE
```

Resposta esperada:

```http
204 No Content
```

Caso a empresa não exista:

```http
404 Not Found
```

A operação é idempotente. Desativar novamente uma empresa que já está inativa mantém o mesmo estado e retorna sucesso.

---

# Tratamento de erros

A API possui tratamento global de exceções com respostas padronizadas.

Principais status utilizados:

* `404 Not Found`: recurso não encontrado;
* `409 Conflict`: violação de regra de negócio;
* `422 Unprocessable Entity`: dados inválidos;
* `500 Internal Server Error`: erro inesperado.

Erros inesperados são registrados utilizando SLF4J.

---

# Testes automatizados

Os testes unitários utilizam:

* JUnit 5
* Mockito

Casos de uso atualmente testados:

* criação de empresa;
* rejeição de e-mail duplicado;
* consulta por ID;
* empresa inexistente;
* listagem de empresas;
* listagem vazia;
* atualização de empresa;
* atualização de empresa inexistente;
* conflito de e-mail durante atualização;
* manutenção do próprio e-mail;
* desativação de empresa;
* tentativa de desativar empresa inexistente;
* desativação idempotente.

Para executar todos os testes:

```bash
cd backend
./mvnw test
```

---

# Executando o projeto

## Pré-requisitos

* Java 25
* PostgreSQL 17
* Git

Configure a variável de ambiente:

```text
DB_PASSWORD
```

Depois execute:

```bash
cd backend
./mvnw spring-boot:run
```

A aplicação será iniciada em:

```text
http://localhost:8080
```

---

# Documentação

A documentação técnica do projeto encontra-se na pasta:

```text
docs/
```

Nela estão documentados:

* arquitetura do sistema;
* roadmap de desenvolvimento;
* decisões arquiteturais;
* modelagem do domínio;
* regras de negócio.

---

# Roadmap resumido

```text
✔ Infraestrutura

✔ PostgreSQL

✔ Flyway

✔ Módulo Empresa

✔ Exception Handling

✔ Testes Unitários do módulo Empresa

⬜ Usuários

⬜ Spring Security

⬜ Autenticação

⬜ JWT

⬜ Clientes

⬜ Profissionais

⬜ Serviços

⬜ Agenda

⬜ Financeiro

⬜ Dashboard

⬜ Frontend React
```

---

# Filosofia de desenvolvimento

Cada User Story do Flux segue a seguinte ordem:

```text
Regra de negócio
        │
        ▼
Modelagem
        │
        ▼
Documentação
        │
        ▼
Código
        │
        ▼
Teste manual no Postman
        │
        ▼
Commit FEAT
        │
        ▼
Testes unitários
        │
        ▼
mvn test
        │
        ▼
Commit TEST
```

Cada funcionalidade é versionada com commits separados para implementação e testes.

Exemplo:

```text
feat(empresa): add company deactivation endpoint
test(empresa): add unit tests for company deactivation
```

Essa abordagem garante que as decisões técnicas sejam guiadas pelas regras do domínio e que cada funcionalidade seja implementada, validada, testada e documentada.

---

# Licenciamento

O Flux está em desenvolvimento e, neste momento, não possui uma licença pública definida.

A estratégia de licenciamento será definida conforme a evolução do projeto e sua possível comercialização como SaaS.

