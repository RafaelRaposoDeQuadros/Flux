# ADR-004 — Tratamento Global de Exceções

## Status

Aceito

---

## Contexto

A API do Flux precisava retornar respostas de erro consistentes para todos os clientes.

Sem um tratamento centralizado, cada controller seria responsável por implementar blocos `try/catch`, gerando duplicação de código, inconsistência nas respostas e maior dificuldade de manutenção.

Além disso, erros técnicos do framework ou do banco de dados não deveriam ser expostos diretamente ao consumidor da API.

---

## Decisão

Foi adotado um mecanismo centralizado de tratamento de exceções utilizando `@ControllerAdvice`.

Foram definidos DTOs específicos para representar respostas de erro:

* `ApiError`
* `ValidationError`

Também foram criadas exceções específicas para representar regras do domínio:

* `BusinessException`
* `ResourceNotFoundException`

Erros inesperados são registrados nos logs da aplicação e retornam uma mensagem genérica ao cliente.

---

## Alternativas consideradas

### Tratamento diretamente nos controllers

Vantagens:

* simples para aplicações pequenas.

Desvantagens:

* duplicação de código;
* inconsistência entre endpoints;
* baixa manutenibilidade.

---

### Capturar exceções apenas no banco

Vantagens:

* implementação inicial rápida.

Desvantagens:

* mensagens técnicas;
* forte acoplamento ao banco de dados;
* pior experiência para consumidores da API.

---

## Consequências

### Positivas

* contrato único para respostas de erro;
* controllers mais limpos;
* maior facilidade para manutenção;
* melhor experiência para clientes da API;
* facilidade para evolução futura.

### Negativas

* aumento inicial da quantidade de classes;
* necessidade de manter exceções específicas conforme o domínio evoluir.

---

## Decisão Final

A equipe optou por centralizar completamente o tratamento de exceções através do `GlobalExceptionHandler`, mantendo as regras de negócio independentes da camada HTTP e estabelecendo um contrato consistente para toda a API.

