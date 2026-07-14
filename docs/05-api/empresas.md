# Consulta de Empresa por ID

## Endpoint

```http
GET /empresas/{id}
```

## Objetivo

Permitir que uma empresa cadastrada no Flux seja consultada por meio do seu identificador único.

Esse endpoint representa o primeiro caso de uso de consulta individual do módulo de empresas.

---

## Regra de negócio

Ao receber o identificador de uma empresa, o sistema deve buscar o registro correspondente no banco de dados.

Existem dois resultados possíveis:

### Empresa encontrada

Quando existir uma empresa com o identificador informado, o sistema deve retornar:

```http
200 OK
```

O corpo da resposta deve utilizar o DTO:

```text
EmpresaResponse
```

### Empresa não encontrada

Quando não existir uma empresa com o identificador informado, o sistema deve lançar:

```text
ResourceNotFoundException
```

A exceção será tratada pelo:

```text
GlobalExceptionHandler
```

E transformada na resposta:

```http
404 Not Found
```

---

## Comportamento esperado

### Requisição válida com empresa existente

Exemplo:

```http
GET /empresas/1
```

Resposta:

```http
200 OK
```

```json
{
  "id": 1,
  "name": "Empresa Exemplo",
  "email": "contato@empresa.com",
  "status": "ACTIVE",
  "createdAt": "2026-07-13T20:00:00Z"
}
```

---

### Requisição válida com empresa inexistente

Exemplo:

```http
GET /empresas/999
```

Resposta:

```http
404 Not Found
```

```json
{
  "timestamp": "2026-07-13T20:00:00Z",
  "status": 404,
  "error": "Not Found",
  "message": "Empresa não encontrada.",
  "path": "/empresas/999"
}
```

---

## Decisões arquiteturais

### Reutilização do `EmpresaResponse`

O endpoint reutilizará o DTO:

```text
EmpresaResponse
```

Esse DTO já representa os dados que podem ser expostos publicamente pela API:

```text
id
name
email
status
createdAt
```

Não será criado um novo DTO apenas para esse caso de uso, pois isso geraria duplicação sem benefício arquitetural.

Um DTO específico poderá ser criado futuramente caso a consulta detalhada precise retornar informações diferentes.

---

### Utilização de `findById()`

A consulta será realizada por meio do método:

```java
empresaRepository.findById(id)
```

Esse método já é fornecido pelo `JpaRepository`.

Seu retorno é:

```java
Optional<Empresa>
```

O `Optional` representa explicitamente que a empresa pode ou não existir.

---

### Utilização de `orElseThrow()`

A ausência da empresa será tratada com:

```java
orElseThrow()
```

Comportamento esperado:

```text
Optional contém uma Empresa
        ↓
A entidade é retornada
```

```text
Optional está vazio
        ↓
ResourceNotFoundException é lançada
```

Essa abordagem evita o uso desnecessário de verificações manuais com `null`, `isPresent()` ou `isEmpty()`.

---

### Não utilização de `existsById()`

Não será utilizado:

```java
existsById(id)
```

antes de:

```java
findById(id)
```

Essa abordagem poderia gerar duas consultas ao banco de dados:

```text
1. Verificar se a empresa existe
2. Buscar os dados da empresa
```

O método `findById()` já permite verificar a existência e obter a entidade em uma única operação.

---

## Responsabilidades das camadas

### Controller

O Controller será responsável por:

```text
Receber a requisição HTTP
Capturar o ID com @PathVariable
Chamar o Service
Retornar 200 OK com EmpresaResponse
```

O Controller não deverá:

```text
Consultar diretamente o Repository
Converter a entidade manualmente
Tratar ResourceNotFoundException com try/catch
Implementar regras de negócio
```

---

### Service

O Service será responsável por:

```text
Receber o identificador
Consultar o Repository
Tratar a ausência da empresa
Converter Empresa em EmpresaResponse
Retornar o DTO
```

A ausência da empresa será interpretada pela camada de serviço como uma falha do caso de uso.

---

### Repository

O Repository será responsável exclusivamente pelo acesso aos dados.

Método utilizado:

```java
findById(id)
```

O Repository não deverá:

```text
Criar respostas HTTP
Retornar ResponseEntity
Criar EmpresaResponse
Decidir códigos de status HTTP
```

---

### GlobalExceptionHandler

O `GlobalExceptionHandler` continuará responsável por converter:

```text
ResourceNotFoundException
```

em:

```http
404 Not Found
```

Isso permite que o Controller permaneça simples e sem blocos repetitivos de `try/catch`.

---

## Fluxo da requisição

```text
GET /empresas/{id}

↓

EmpresaController

↓

@PathVariable Long id

↓

EmpresaService

↓

EmpresaRepository.findById(id)

↓

Optional<Empresa>

├── Empresa encontrada
│
│   ↓
│
│   EmpresaResponse
│
│   ↓
│
│   200 OK
│
└── Empresa não encontrada

    ↓

    ResourceNotFoundException

    ↓

    GlobalExceptionHandler

    ↓

    404 Not Found
```

---

## Status da empresa

A consulta por ID não será limitada ao status da empresa.

Empresas com os seguintes status poderão ser consultadas:

```text
ACTIVE
INACTIVE
SUSPENDED
```

O status representa a situação operacional da empresa, mas não altera a existência do registro.

Regras de restrição relacionadas ao status serão tratadas em casos de uso futuros.

---

## Impacto arquitetural

Esse caso de uso estabelece o padrão de consulta individual que poderá ser utilizado nos demais módulos do Flux:

```text
Clientes
Profissionais
Serviços
Atendimentos
Movimentações financeiras
Usuários
```

O padrão será:

```text
Repository.findById()

↓

Optional

↓

orElseThrow()

↓

ResourceNotFoundException

↓

DTO Response
```

---

## Critérios de aceitação

O caso de uso será considerado concluído quando:

* O endpoint `GET /empresas/{id}` estiver disponível.
* O ID for recebido por meio de `@PathVariable`.
* Uma empresa existente retornar `200 OK`.
* A resposta utilizar `EmpresaResponse`.
* Uma empresa inexistente retornar `404 Not Found`.
* A ausência for tratada com `ResourceNotFoundException`.
* O Controller não acessar diretamente o Repository.
* O Controller não possuir tratamento manual com `try/catch`.
* O método `findById()` for utilizado sem uma consulta prévia com `existsById()`.
* Os testes automatizados dos dois cenários forem implementados e aprovados.

---

## Testes planejados

### Cenário de sucesso

```text
shouldReturnEmpresaWhenIdExists()
```

Deve validar:

```text
Repository retorna uma Empresa
Service retorna EmpresaResponse
Os dados retornados estão corretos
findById() foi executado uma vez
```

### Cenário de empresa inexistente

```text
shouldThrowResourceNotFoundExceptionWhenIdDoesNotExist()
```

Deve validar:

```text
Repository retorna Optional.empty()
ResourceNotFoundException é lançada
A mensagem da exceção está correta
```

---

## Alterações no banco de dados

Este caso de uso não exige alterações no banco de dados.

Não será criada uma nova migration, pois:

```text
A tabela tb_empresa já existe
A coluna id já existe
O identificador já é a chave primária
```

---

## Próximas etapas

Após a documentação, a implementação seguirá esta ordem:

```text
1. Criar o método de consulta no EmpresaService
2. Criar o endpoint no EmpresaController
3. Testar manualmente no Postman
4. Criar os testes automatizados
5. Atualizar README e CHANGELOG
6. Realizar um commit seguindo Conventional Commits
```

