# Modelagem — Empresa

## 1. Conceito

Empresa representa o negócio que utiliza o Flux.

No sistema, cada empresa possui seus próprios usuários, clientes, profissionais, serviços, atendimentos e dados financeiros.

A Empresa é a raiz do modelo multiempresa do Flux.

---

## 2. Responsabilidade

A entidade Empresa será responsável por identificar a qual negócio cada dado pertence.

Ela permite que várias empresas usem o mesmo sistema, mantendo os dados separados.

---

## 3. Atributos iniciais

- id
- nome
- cnpj
- email
- telefone
- status
- createdAt
- updatedAt

---

## 4. Campos obrigatórios

- nome
- status

---

## 5. Campos opcionais

- cnpj
- email
- telefone

---

## 6. Status possíveis

- ATIVA
- INATIVA
- SUSPENSA

---

## 7. Regras de negócio

- Uma empresa inicia com status ATIVA.
- Uma empresa pode possuir vários usuários.
- Uma empresa pode possuir vários clientes.
- Uma empresa pode possuir vários profissionais.
- Uma empresa pode possuir vários serviços.
- Uma empresa pode possuir vários atendimentos.
- Uma empresa pode possuir várias movimentações financeiras.
- Dados de uma empresa não podem ser acessados por usuários de outra empresa.

---

## 8. Relacionamentos futuros

Empresa se relacionará com:

- Usuário
- Cliente
- Profissional
- Serviço
- Atendimento
- Movimentação Financeira
- Categoria Financeira

---

## 9. Decisão de arquitetura

Todas as entidades principais do Flux deverão possuir vínculo com uma Empresa.

Isso garante o modelo SaaS multiempresa.
