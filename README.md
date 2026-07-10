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

- Barbearias
- Salões de beleza
- Clínicas de estética
- Estúdios de tatuagem
- Pequenos negócios com profissionais autônomos e comissionados

Nossa principal filosofia é:

> **O Flux é um sistema financeiro com agenda integrada.**
>
> **Não é uma agenda com financeiro.**

---

# Status do projeto

🚧 Em desenvolvimento

## Funcionalidades concluídas

- ✅ Estrutura inicial do backend
- ✅ Integração com PostgreSQL
- ✅ Versionamento do banco com Flyway
- ✅ Arquitetura Package by Feature
- ✅ Cadastro de empresas
- ✅ Bean Validation
- ✅ DTOs de entrada e saída
- ✅ Tratamento global de exceções
- ✅ Respostas padronizadas de erro
- ✅ Logging de erros inesperados

## Próximas funcionalidades

- ⏳ Testes automatizados
- ⏳ Consulta de empresa
- ⏳ Atualização de empresa
- ⏳ Inativação de empresa
- ⏳ Autenticação
- ⏳ Gestão de clientes
- ⏳ Gestão de profissionais
- ⏳ Agenda
- ⏳ Financeiro
- ⏳ Dashboard
- ⏳ Frontend React

---

# Tecnologias

## Backend

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Bean Validation
- Flyway
- Maven

## Banco de Dados

- PostgreSQL 17

## Frontend (planejado)

- React
- TypeScript

## Ferramentas

- IntelliJ IDEA Community
- DBeaver
- Postman
- Git
- GitHub

---

# Arquitetura

O backend está organizado utilizando **Package by Feature**, agrupando cada funcionalidade do domínio em seu próprio módulo.

Estrutura atual:

```text
backend/
└── src/main/java/com/flux/backend
    ├── auth
    ├── config
    ├── empresa
    │   ├── controller
    │   ├── dto
    │   ├── entity
    │   ├── enums
    │   ├── repository
    │   └── service
    ├── shared
    │   ├── dto
    │   ├── enums
    │   ├── exception
    │   ├── health
    │   └── util
    └── BackendApplication
```

Fluxo da requisição:

```text
HTTP Request
      │
      ▼
Controller
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

---

# Executando o projeto

## Pré-requisitos

- Java 25
- PostgreSQL 17
- Git

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

# API

Atualmente o backend possui o seguinte endpoint implementado:

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

Resposta:

```http
201 Created
```

---

# Documentação

A documentação técnica do projeto encontra-se na pasta:

```text
docs/
```

Nela estão documentados:

- Arquitetura do sistema
- Roadmap de desenvolvimento
- Decisões arquiteturais (ADR)
- Modelagem do domínio

---

# Roadmap resumido

```text
✔ Infraestrutura

✔ PostgreSQL

✔ Flyway

✔ Cadastro de Empresa

✔ Exception Handling

⬜ Testes Automatizados

⬜ Consulta de Empresa

⬜ Atualização de Empresa

⬜ Spring Security

⬜ Usuários

⬜ Clientes

⬜ Profissionais

⬜ Agenda

⬜ Financeiro

⬜ Dashboard

⬜ Frontend React
```

---

# Filosofia de desenvolvimento

Todo desenvolvimento do Flux segue a seguinte ordem:

```text
Regra de Negócio
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
Banco de Dados
        │
        ▼
Testes
```

Essa abordagem garante que as decisões técnicas sejam guiadas pelo domínio do problema, e não apenas pela implementação.

---

# Licenciamento

O Flux está em desenvolvimento e, neste momento, não possui uma licença pública definida.

A estratégia de licenciamento será definida conforme a evolução do projeto.
