# Tratamento Global de Exceções

## Objetivo

Centralizar o tratamento de exceções da API para garantir que todas as respostas de erro sigam um contrato único, previsível e consistente.

Sem essa abordagem, cada controller precisaria implementar seu próprio tratamento de erros, gerando duplicação de código, inconsistências nas respostas e maior dificuldade de manutenção.

O tratamento global foi implementado utilizando `@ControllerAdvice`, permitindo separar completamente a lógica de negócio da construção das respostas HTTP.

---

# Arquitetura

Fluxo de tratamento de exceções:

```text
Cliente
    │
    ▼
Controller
    │
    ▼
Service
    │
    ▼
Exceção
    │
    ▼
GlobalExceptionHandler
    │
    ▼
ApiError / ValidationError
    │
    ▼
Resposta HTTP
```

Os controllers não possuem blocos `try/catch`.

Toda exceção propagada é interceptada pelo `GlobalExceptionHandler`, responsável por transformá-la em uma resposta HTTP padronizada.

---

# Estrutura das Respostas de Erro

## ApiError

Classe base utilizada para representar qualquer erro da API.

Campos:

| Campo     | Descrição                       |
| --------- | ------------------------------- |
| timestamp | Momento em que o erro ocorreu   |
| status    | Código HTTP                     |
| error     | Nome oficial do status HTTP     |
| message   | Mensagem legível para o cliente |
| path      | Endpoint responsável pelo erro  |

Exemplo:

```json
{
  "timestamp": "2026-07-10T01:20:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Empresa não encontrada.",
  "path": "/empresas/10"
}
```

---

## ValidationError

Especialização de `ApiError` utilizada exclusivamente para erros de validação de entrada.

Além dos campos herdados, adiciona:

| Campo       | Descrição                                            |
| ----------- | ---------------------------------------------------- |
| fieldErrors | Relação entre campo inválido e mensagem de validação |

Exemplo:

```json
{
  "timestamp": "...",
  "status": 422,
  "error": "Unprocessable Entity",
  "message": "Existem campos inválidos.",
  "path": "/empresas",
  "fieldErrors": {
    "name": "O nome da empresa é obrigatório",
    "email": "Informe um e-mail válido"
  }
}
```

---

# Exceções da Aplicação

## BusinessException

Representa violações de regras de negócio.

Exemplo:

* tentativa de cadastrar uma empresa utilizando um e-mail já existente.

Resposta HTTP:

```text
409 Conflict
```

---

## ResourceNotFoundException

Representa a tentativa de acessar um recurso inexistente.

Exemplo:

* buscar uma empresa por um ID que não existe.

Resposta HTTP:

```text
404 Not Found
```

---

## MethodArgumentNotValidException

Exceção lançada automaticamente pelo Spring quando ocorre falha no Bean Validation.

Exemplos:

* nome obrigatório não informado;
* e-mail inválido;
* qualquer outra violação das anotações de validação.

Resposta HTTP:

```text
422 Unprocessable Entity
```

---

## Exception

Handler genérico utilizado como último recurso para qualquer exceção não prevista.

Resposta HTTP:

```text
500 Internal Server Error
```

A resposta enviada ao cliente nunca expõe detalhes internos da aplicação.

O erro técnico completo permanece disponível nos logs do servidor.

---

# Códigos HTTP Utilizados

| Situação                         |               Status HTTP |
| -------------------------------- | ------------------------: |
| Requisição realizada com sucesso |                    200 OK |
| Recurso criado                   |               201 Created |
| Dados inválidos                  |  422 Unprocessable Entity |
| Regra de negócio violada         |              409 Conflict |
| Recurso inexistente              |             404 Not Found |
| Erro interno inesperado          | 500 Internal Server Error |

---

# Decisões Arquiteturais

## Uso de @ControllerAdvice

Foi adotado para centralizar completamente o tratamento de exceções.

Benefícios:

* elimina duplicação de código;
* padroniza todas as respostas da API;
* simplifica os controllers;
* facilita manutenção e evolução.

---

## DTOs para respostas

A API nunca retorna entidades JPA diretamente.

As respostas de erro utilizam DTOs específicos (`ApiError` e `ValidationError`), desacoplando a camada HTTP da implementação interna.

---

## Validação em duas camadas

As regras são verificadas em níveis diferentes.

### Camada da aplicação

Responsável pelas regras de negócio.

Exemplo:

* impedir cadastro de duas empresas com o mesmo e-mail.

### Banco de dados

Responsável por garantir integridade.

Exemplo:

* constraint `UNIQUE` sobre a coluna `email`.

Essa estratégia evita mensagens técnicas ao usuário e mantém a consistência dos dados mesmo em cenários concorrentes.

---

# Princípios Aplicados

Durante a implementação foram seguidos os seguintes princípios:

* Responsabilidade única (SRP)
* Separação entre regras de negócio e infraestrutura
* Tratamento centralizado de exceções
* Contrato consistente de API
* Fail Fast
* RESTful API
* Defesa em profundidade (Application + Database)

---

# Resultado da Sprint 2

Ao final desta sprint, a API possui um mecanismo profissional de tratamento de erros.

Foram implementados:

* tratamento global utilizando `@ControllerAdvice`;
* resposta padronizada (`ApiError`);
* resposta específica para validação (`ValidationError`);
* tratamento de regras de negócio (`BusinessException`);
* tratamento de recurso inexistente (`ResourceNotFoundException`);
* tratamento de falhas do Bean Validation;
* tratamento de erros inesperados;
* registro de erros internos via logs.

Essa infraestrutura servirá como base para todos os próximos casos de uso implementados no projeto.

