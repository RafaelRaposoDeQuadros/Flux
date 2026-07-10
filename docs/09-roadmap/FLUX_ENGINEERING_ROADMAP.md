# Flux Engineering Roadmap

> Documento vivo de planejamento técnico, arquitetura e acompanhamento do desenvolvimento do Flux — Caixa Inteligente.

---

## 1. Objetivo do Documento

Este roadmap organiza o desenvolvimento do Flux em épicos, sprints, histórias técnicas e tarefas verificáveis.

Ele serve para:

- orientar a ordem de desenvolvimento;
- registrar o que já foi concluído;
- estimar a carga de trabalho;
- reduzir decisões improvisadas;
- documentar dependências entre funcionalidades;
- facilitar retomadas futuras do projeto;
- demonstrar maturidade de engenharia no portfólio;
- apoiar revisões técnicas e planejamento de versões.

Este documento deve ser atualizado sempre que:

- uma sprint for concluída;
- uma decisão arquitetural relevante for tomada;
- uma estimativa mudar significativamente;
- uma nova dependência for descoberta;
- uma funcionalidade entrar ou sair do MVP;
- uma tarefa for dividida, adiada ou cancelada.

---

# 2. Visão do Produto

## 2.1 Nome

**Flux — Caixa Inteligente**

## 2.2 Proposta

O Flux será um SaaS de gestão financeira e operacional para pequenos negócios prestadores de serviços.

O produto busca substituir controles fragmentados em:

- planilhas;
- WhatsApp;
- cadernos;
- anotações manuais;
- aplicativos sem integração.

## 2.3 Público-alvo inicial

- barbearias;
- salões de beleza;
- clínicas de estética;
- estúdios de tatuagem;
- pequenos negócios com profissionais autônomos;
- pequenos negócios com profissionais comissionados.

## 2.4 Princípio central

> O Flux é um sistema financeiro com agenda integrada.  
> Não é uma agenda com financeiro.

## 2.5 Objetivo do MVP

Permitir que uma pequena empresa:

1. cadastre sua organização;
2. cadastre usuários e profissionais;
3. cadastre clientes;
4. cadastre serviços;
5. agende atendimentos;
6. conclua ou cancele atendimentos;
7. gere movimentações financeiras relacionadas aos atendimentos;
8. registre receitas e despesas manuais;
9. acompanhe indicadores básicos;
10. opere com autenticação e isolamento lógico entre empresas.

---

# 3. Stack Técnica

## Backend

- Java 25
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Bean Validation
- Flyway
- Maven

## Banco de dados

- PostgreSQL 17

## Frontend

- React
- TypeScript

## Infraestrutura planejada

- Docker
- Docker Compose
- CI/CD
- ambiente de homologação
- ambiente de produção
- HTTPS
- domínio

## Ferramentas

- IntelliJ IDEA Community
- DBeaver
- Postman
- Git
- GitHub

---

# 4. Princípios de Desenvolvimento

A ordem de desenvolvimento adotada será:

```text
Regra de negócio
        ↓
Modelagem
        ↓
Documentação
        ↓
Código
        ↓
Banco de dados
        ↓
Testes
        ↓
Revisão
        ↓
Commit
```

## 4.1 Regras gerais

- Entender antes de implementar.
- Justificar decisões arquiteturais.
- Evitar abstrações prematuras.
- Evitar entidades JPA como contratos HTTP.
- Manter migrations versionadas.
- Fazer commits pequenos e coerentes.
- Registrar decisões relevantes em ADRs.
- Tratar segurança e isolamento entre empresas como requisitos obrigatórios.
- Não considerar uma tarefa concluída apenas porque “funciona na máquina”.

---

# 5. Estratégia de Versionamento

## Branches

Durante o desenvolvimento solo inicial:

- branch principal: `main`;
- commits pequenos;
- uma entrega lógica por commit;
- tags para versões relevantes.

## Conventional Commits

- `feat`: nova funcionalidade;
- `fix`: correção;
- `docs`: documentação;
- `refactor`: reorganização interna;
- `test`: testes;
- `chore`: manutenção;
- `build`: build ou dependências;
- `ci`: automação e pipelines.

## Exemplos

```text
feat: add company registration
feat: add global exception handling
docs: document exception handling architecture
test: add company service tests
refactor: extract company mapper
```

---

# 6. Definition of Done Global

Uma tarefa funcional só poderá ser marcada como concluída quando cumprir os itens aplicáveis:

- [ ] regra de negócio compreendida;
- [ ] modelagem revisada;
- [ ] impacto multi-tenant analisado;
- [ ] DTOs definidos;
- [ ] validações definidas;
- [ ] tratamento de erro definido;
- [ ] migration criada, quando necessária;
- [ ] implementação concluída;
- [ ] testes automatizados criados;
- [ ] teste manual realizado, quando aplicável;
- [ ] documentação atualizada;
- [ ] ADR criado, quando necessário;
- [ ] código revisado;
- [ ] commit realizado;
- [ ] aplicação inicia sem erros;
- [ ] endpoint responde conforme o contrato;
- [ ] nenhum dado sensível é exposto.

---

# 7. Status Geral

| Épico | Status | Estimativa |
|---|---|---:|
| Fundação técnica | Quase concluído | 30–40 h |
| Empresa | Em andamento | 20–25 h |
| Qualidade inicial | Pendente | 20–30 h |
| Autenticação e usuários | Pendente | 35–50 h |
| Multi-tenant seguro | Pendente | 20–30 h |
| Clientes | Pendente | 18–25 h |
| Profissionais | Pendente | 20–30 h |
| Serviços | Pendente | 15–25 h |
| Agenda e atendimentos | Pendente | 45–65 h |
| Financeiro | Pendente | 55–80 h |
| Dashboard | Pendente | 25–40 h |
| Frontend | Pendente | 120–180 h |
| Infraestrutura e deploy | Pendente | 35–55 h |
| Observabilidade e produção | Pendente | 25–40 h |

Estimativa total inicial do MVP:

**aproximadamente 480 a 700 horas**, considerando estudo, arquitetura, implementação, testes, documentação e correções.

---

# 8. Épico 0 — Descoberta e Visão do Produto

## Objetivo

Definir o problema, o público e os limites iniciais do produto.

## Status

**Concluído parcialmente.**

## Entregas

- [x] nome do produto definido;
- [x] proposta de valor inicial;
- [x] público-alvo inicial;
- [x] problema principal identificado;
- [x] filosofia “financeiro com agenda integrada”;
- [x] funcionalidades macro mapeadas;
- [x] ideia de assinatura mensal;
- [ ] entrevistas com potenciais usuários;
- [ ] validação com pelo menos três negócios reais;
- [ ] priorização final do MVP;
- [ ] definição de métricas de sucesso;
- [ ] definição de persona;
- [ ] mapa de jornada do usuário;
- [ ] definição formal do que não entra no MVP.

## Estimativa restante

8–16 horas.

## Critérios de conclusão

- pelo menos três conversas estruturadas com potenciais clientes;
- lista de problemas validada;
- MVP reduzido às funcionalidades essenciais;
- decisões registradas em documento de visão.

---

# 9. Épico 1 — Fundação Técnica

## Objetivo

Criar a base do backend com estrutura profissional e ambiente reproduzível.

## Status

**Quase concluído.**

## Sprint 1.1 — Inicialização do backend

### Tarefas

- [x] criar projeto Spring Boot;
- [x] configurar Maven;
- [x] configurar Java 25;
- [x] adicionar Spring Web;
- [x] adicionar Spring Data JPA;
- [x] adicionar Bean Validation;
- [x] adicionar Flyway;
- [x] adicionar PostgreSQL Driver;
- [x] adicionar Spring Security;
- [x] validar execução local;
- [x] versionar no GitHub.

### Estimativa

6–8 horas.

### Status

Concluído.

---

## Sprint 1.2 — Banco e ambientes

### Tarefas

- [x] instalar e validar PostgreSQL 17;
- [x] criar usuário `flux`;
- [x] criar banco `flux_db`;
- [x] configurar conexão;
- [x] criar `application.properties`;
- [x] criar profile `dev`;
- [x] criar profile `test`;
- [x] criar profile `prod`;
- [x] validar Flyway;
- [x] criar migration inicial;
- [ ] revisar segredos e credenciais;
- [ ] criar `.env.example`;
- [ ] garantir que credenciais não estejam no Git;
- [ ] definir estratégia de configuração para produção.

### Estimativa restante

2–4 horas.

### Critérios de conclusão

- aplicação sobe em `dev`;
- migrations são executadas automaticamente;
- repositório não contém senhas reais;
- configuração de ambiente está documentada.

---

## Sprint 1.3 — Arquitetura base

### Tarefas

- [x] adotar Package by Feature;
- [x] criar pacotes `auth`, `config`, `empresa`, `shared`;
- [x] separar Controller, Service, Repository, DTO e Entity;
- [x] definir uso de DTOs;
- [x] decidir não expor entidades JPA;
- [x] definir Empresa como raiz do domínio;
- [x] adotar multi-tenant lógico;
- [ ] documentar arquitetura completa;
- [ ] criar diagrama de contexto;
- [ ] criar diagrama de containers;
- [ ] criar documento de modelo de domínio;
- [ ] revisar dependências entre pacotes.

### Estimativa restante

6–10 horas.

---

# 10. Épico 2 — Empresa

## Objetivo

Implementar o ciclo de vida básico da empresa, que será a raiz do isolamento dos dados.

## Status

**Em andamento.**

## Sprint 2.1 — Cadastro de empresa

### Entregas concluídas

- [x] entidade `Empresa`;
- [x] enum `EmpresaStatus`;
- [x] DTO `CreateEmpresaRequest`;
- [x] DTO `EmpresaResponse`;
- [x] `EmpresaRepository`;
- [x] `EmpresaService`;
- [x] `EmpresaController`;
- [x] migration `tb_empresa`;
- [x] validação de nome;
- [x] validação de e-mail;
- [x] empresa nasce `ACTIVE`;
- [x] `createdAt` definido pelo sistema;
- [x] e-mail único;
- [x] endpoint `POST /empresas`;
- [x] retorno `201 Created`;
- [x] teste no Postman;
- [x] validação no PostgreSQL;
- [x] commit da funcionalidade.

### Status

Concluído.

---

## Sprint 2.2 — Tratamento global de exceções

### Entregas concluídas

- [x] `ApiError`;
- [x] `ValidationError`;
- [x] `BusinessException`;
- [x] `ResourceNotFoundException`;
- [x] `GlobalExceptionHandler`;
- [x] tratamento de validação;
- [x] tratamento de e-mail duplicado;
- [x] tratamento de recurso não encontrado;
- [x] fallback para erro inesperado;
- [x] logging de erros inesperados;
- [x] retorno `409 Conflict`;
- [x] retorno `422 Unprocessable Entity`;
- [x] retorno `404 Not Found`;
- [x] retorno `500 Internal Server Error`;
- [x] documentação de exceções;
- [x] ADR do tratamento global.

### Status

Concluído.

---

## Sprint 2.3 — Consulta de empresa por ID

### Objetivo

Implementar o primeiro caso de uso de leitura individual.

### Tarefas

- [ ] estudar `Optional`;
- [ ] implementar `findById`;
- [ ] lançar `ResourceNotFoundException`;
- [ ] criar `GET /empresas/{id}`;
- [ ] retornar `EmpresaResponse`;
- [ ] testar ID existente;
- [ ] testar ID inexistente;
- [ ] criar teste unitário do service;
- [ ] criar teste de integração do endpoint;
- [ ] documentar contrato;
- [ ] atualizar changelog;
- [ ] commit.

### Estimativa

4–7 horas.

### Dependências

- tratamento global de exceções;
- `EmpresaRepository`;
- `EmpresaResponse`.

### Critérios de conclusão

- ID existente retorna `200 OK`;
- ID inexistente retorna `404 Not Found`;
- entidade JPA não é exposta;
- testes automatizados passam.

---

## Sprint 2.4 — Listagem de empresas

### Tarefas

- [ ] decidir se endpoint será administrativo;
- [ ] implementar listagem paginada;
- [ ] estudar `Page`, `Pageable` e `Sort`;
- [ ] criar `GET /empresas`;
- [ ] converter entidades para DTO;
- [ ] definir ordenação padrão;
- [ ] impedir listagem irrestrita no futuro ambiente multi-tenant;
- [ ] criar testes;
- [ ] documentar endpoint;
- [ ] commit.

### Estimativa

6–10 horas.

### Risco arquitetural

Depois da autenticação, usuários comuns não deverão listar todas as empresas. Esse endpoint provavelmente será restrito a administração da plataforma.

---

## Sprint 2.5 — Atualização de empresa

### Tarefas

- [ ] definir campos editáveis;
- [ ] decidir entre `PUT` e `PATCH`;
- [ ] criar DTO de atualização;
- [ ] validar e-mail duplicado ignorando a própria empresa;
- [ ] atualizar `name`;
- [ ] atualizar `email`;
- [ ] impedir alteração direta de campos internos;
- [ ] testar recurso inexistente;
- [ ] testar conflito de e-mail;
- [ ] criar testes automatizados;
- [ ] documentar;
- [ ] commit.

### Estimativa

8–12 horas.

---

## Sprint 2.6 — Inativação e reativação

### Tarefas

- [ ] definir regras de `ACTIVE`;
- [ ] definir regras de `INACTIVE`;
- [ ] definir regras de `SUSPENDED`;
- [ ] diferenciar inativação voluntária de suspensão administrativa;
- [ ] criar caso de uso de inativação;
- [ ] criar caso de uso de reativação;
- [ ] decidir endpoints;
- [ ] evitar exclusão física;
- [ ] adicionar auditoria básica;
- [ ] criar testes;
- [ ] documentar;
- [ ] ADR sobre soft delete/status.

### Estimativa

8–14 horas.

---

# 11. Épico 3 — Qualidade Automatizada Inicial

## Objetivo

Evitar que o projeto cresça sem uma base de testes.

## Prioridade

**Alta. Deve começar antes de muitas novas entidades.**

## Sprint 3.1 — Testes unitários

### Tarefas

- [ ] revisar JUnit 5;
- [ ] revisar Mockito;
- [ ] criar testes de `EmpresaService`;
- [ ] testar cadastro bem-sucedido;
- [ ] testar e-mail duplicado;
- [ ] testar busca por ID;
- [ ] testar recurso inexistente;
- [ ] definir padrão de nomes de testes;
- [ ] definir estrutura Arrange–Act–Assert;
- [ ] documentar convenções.

### Estimativa

8–12 horas.

---

## Sprint 3.2 — Testes de integração

### Tarefas

- [ ] estudar `@SpringBootTest`;
- [ ] estudar `MockMvc`;
- [ ] testar `POST /empresas`;
- [ ] testar validação;
- [ ] testar conflito;
- [ ] testar `GET /empresas/{id}`;
- [ ] definir banco de testes;
- [ ] avaliar Testcontainers;
- [ ] evitar dependência de banco local manual;
- [ ] documentar execução dos testes.

### Estimativa

10–16 horas.

---

## Sprint 3.3 — Padronização de qualidade

### Tarefas

- [ ] configurar formatter;
- [ ] definir convenção de imports;
- [ ] definir política de warnings;
- [ ] avaliar Checkstyle ou Spotless;
- [ ] configurar cobertura;
- [ ] definir meta inicial de cobertura;
- [ ] evitar perseguir cobertura artificial;
- [ ] adicionar comando de testes ao README.

### Estimativa

6–10 horas.

---

# 12. Épico 4 — Autenticação e Usuários

## Objetivo

Garantir acesso autenticado e permissões adequadas.

## Risco

É uma das áreas mais sensíveis do sistema. Deve ser implementada antes de expor funcionalidades com dados reais.

## Sprint 4.1 — Modelagem de usuário

### Tarefas

- [ ] definir tipos de usuário;
- [ ] definir relação com Empresa;
- [ ] definir e-mail único global ou por empresa;
- [ ] definir status do usuário;
- [ ] definir senha;
- [ ] definir data de criação;
- [ ] criar entidade;
- [ ] criar migration;
- [ ] criar repository;
- [ ] criar DTOs;
- [ ] criar testes;
- [ ] documentar modelo.

### Estimativa

10–16 horas.

---

## Sprint 4.2 — Perfis e permissões

### Perfis iniciais sugeridos

- `OWNER`;
- `MANAGER`;
- `PROFESSIONAL`;
- `PLATFORM_ADMIN`.

### Tarefas

- [ ] validar necessidade de cada perfil;
- [ ] definir matriz de permissões;
- [ ] criar enum;
- [ ] definir autorização por endpoint;
- [ ] documentar regras;
- [ ] criar ADR.

### Estimativa

8–12 horas.

---

## Sprint 4.3 — Cadastro e senha

### Tarefas

- [ ] definir fluxo de criação do primeiro usuário;
- [ ] decidir se empresa e proprietário são criados juntos;
- [ ] adicionar BCrypt;
- [ ] impedir senha em texto puro;
- [ ] definir política mínima de senha;
- [ ] criar endpoint de cadastro;
- [ ] testar;
- [ ] documentar.

### Estimativa

10–14 horas.

---

## Sprint 4.4 — Login com JWT

### Tarefas

- [ ] estudar autenticação stateless;
- [ ] estudar JWT;
- [ ] definir claims;
- [ ] definir expiração;
- [ ] implementar login;
- [ ] gerar access token;
- [ ] criar filtro;
- [ ] configurar Spring Security;
- [ ] proteger endpoints;
- [ ] tratar credenciais inválidas;
- [ ] criar testes.

### Estimativa

14–22 horas.

---

## Sprint 4.5 — Refresh token e logout

### Tarefas

- [ ] decidir se refresh token entra no MVP;
- [ ] definir armazenamento;
- [ ] definir revogação;
- [ ] criar endpoint de refresh;
- [ ] criar logout;
- [ ] criar testes;
- [ ] documentar ameaças e limitações.

### Estimativa

10–16 horas.

---

# 13. Épico 5 — Multi-Tenant Seguro

## Objetivo

Garantir que dados de uma empresa nunca sejam acessados por outra.

## Princípio

Todo recurso de negócio pertence a uma empresa.

## Sprint 5.1 — Contexto da empresa autenticada

### Tarefas

- [ ] definir como obter `empresaId` do usuário;
- [ ] incluir informação segura no contexto autenticado;
- [ ] evitar confiar em `empresaId` enviado pelo cliente;
- [ ] criar componente de contexto;
- [ ] documentar fluxo;
- [ ] criar testes.

### Estimativa

8–12 horas.

---

## Sprint 5.2 — Consultas isoladas

### Tarefas

- [ ] alterar repositories para filtrar por empresa;
- [ ] revisar todos os `findById`;
- [ ] usar consultas como `findByIdAndEmpresaId`;
- [ ] impedir enumeração de IDs;
- [ ] padronizar respostas;
- [ ] criar testes cruzados entre empresas;
- [ ] documentar regras obrigatórias.

### Estimativa

10–16 horas.

---

## Sprint 5.3 — Testes de isolamento

### Cenários obrigatórios

- [ ] usuário da Empresa A acessa recurso da Empresa A;
- [ ] usuário da Empresa A tenta acessar recurso da Empresa B;
- [ ] usuário da Empresa B tenta atualizar recurso da Empresa A;
- [ ] listagens retornam apenas dados da empresa autenticada;
- [ ] endpoints administrativos são separados.

### Estimativa

8–12 horas.

---

# 14. Épico 6 — Clientes

## Objetivo

Permitir cadastro e histórico básico de clientes.

## Modelagem inicial

Campos candidatos:

- id;
- empresa;
- nome;
- telefone;
- e-mail opcional;
- observações;
- status;
- data de criação.

## Regras iniciais

- cliente pertence a uma única empresa;
- exclusão física não será permitida se houver histórico;
- inativação deve preservar atendimentos;
- telefone pode ser o principal identificador operacional;
- duplicidade deve ser analisada por empresa.

## Sprints

### 6.1 Modelagem e documentação — 4–6 h
- [ ] regras;
- [ ] entidade;
- [ ] DTOs;
- [ ] migration;
- [ ] ADR se necessário.

### 6.2 Cadastro — 4–6 h
- [ ] POST;
- [ ] validações;
- [ ] conflitos;
- [ ] testes.

### 6.3 Consulta e paginação — 4–7 h
- [ ] GET por ID;
- [ ] listagem;
- [ ] busca por nome/telefone;
- [ ] paginação.

### 6.4 Atualização e inativação — 5–8 h
- [ ] update;
- [ ] inativação;
- [ ] regras de histórico;
- [ ] testes.

Estimativa total:

18–27 horas.

---

# 15. Épico 7 — Profissionais

## Objetivo

Cadastrar profissionais que executam serviços e podem receber comissões.

## Questões de domínio a resolver

- profissional sempre é usuário?
- pode existir profissional sem acesso ao sistema?
- comissão é por profissional, serviço ou combinação?
- profissional pode trabalhar em mais de uma empresa?
- existe agenda individual?
- existe status de disponibilidade?

## Sprints

### 7.1 Descoberta e modelagem — 5–8 h
### 7.2 Cadastro e consulta — 6–9 h
### 7.3 Comissão — 7–12 h
### 7.4 Disponibilidade — 6–10 h
### 7.5 Testes e documentação — 4–6 h

Estimativa total:

28–45 horas.

---

# 16. Épico 8 — Serviços

## Objetivo

Cadastrar os serviços comercializados pela empresa.

## Campos candidatos

- id;
- empresa;
- nome;
- descrição;
- preço padrão;
- duração estimada;
- status;
- data de criação.

## Regras

- serviço pertence à empresa;
- preço histórico do atendimento não deve mudar quando o preço padrão for atualizado;
- duração deve ser positiva;
- serviço inativo não pode ser usado em novos agendamentos;
- atendimentos antigos devem manter referência histórica.

## Estimativa

18–28 horas.

---

# 17. Épico 9 — Agenda e Atendimentos

## Objetivo

Gerenciar o ciclo operacional do serviço prestado.

## Status possíveis candidatos

- `SCHEDULED`;
- `CONFIRMED`;
- `IN_PROGRESS`;
- `COMPLETED`;
- `CANCELED`;
- `NO_SHOW`.

## Questões de domínio

- quando a receita é criada?
- cancelamento após conclusão é permitido?
- reagendamento cria histórico?
- pode haver dois atendimentos no mesmo horário?
- conflito é por profissional, recurso ou empresa?
- duração vem do serviço, mas pode ser alterada?
- preço pode ser personalizado?
- quem pode concluir um atendimento?

## Sprints

### 9.1 Modelagem do atendimento — 8–12 h
### 9.2 Criação de agendamento — 8–12 h
### 9.3 Validação de conflitos — 8–14 h
### 9.4 Reagendamento — 6–10 h
### 9.5 Cancelamento — 6–10 h
### 9.6 Conclusão — 8–12 h
### 9.7 Histórico e auditoria — 6–10 h
### 9.8 Testes de integração — 8–12 h

Estimativa total:

58–92 horas.

---

# 18. Épico 10 — Financeiro

## Objetivo

Registrar e consolidar as movimentações financeiras da empresa.

## Tipos iniciais

- receita;
- despesa;
- comissão;
- reembolso;
- ajuste.

## Questões de domínio

- movimentação pode ser editada?
- toda edição gera auditoria?
- exclusão é permitida?
- quando usar estorno?
- comissão é despesa ou obrigação separada?
- receita é reconhecida no agendamento, conclusão ou pagamento?
- haverá contas a receber?
- haverá formas de pagamento?
- haverá competência e caixa?

## Sprints

### 10.1 Modelo financeiro — 10–16 h
### 10.2 Receita manual — 6–10 h
### 10.3 Despesa manual — 6–10 h
### 10.4 Integração com atendimento — 10–16 h
### 10.5 Comissão — 8–14 h
### 10.6 Reembolso e estorno — 8–12 h
### 10.7 Edição e auditoria — 8–14 h
### 10.8 Relatórios básicos — 8–12 h
### 10.9 Testes — 10–16 h

Estimativa total:

74–120 horas.

---

# 19. Épico 11 — Metas e Dashboard

## Objetivo

Exibir indicadores que ajudem o gestor a tomar decisões.

## Indicadores iniciais

- receita do período;
- despesas do período;
- lucro estimado;
- meta mensal;
- percentual da meta;
- número de atendimentos;
- ticket médio;
- serviços mais vendidos;
- profissionais com maior receita;
- comissões acumuladas.

## Sprints

### 11.1 Definição dos KPIs — 4–8 h
### 11.2 Consultas agregadas — 8–14 h
### 11.3 Endpoint de dashboard — 6–10 h
### 11.4 Performance e índices — 6–10 h
### 11.5 Testes — 5–8 h

Estimativa total:

29–50 horas.

---

# 20. Épico 12 — Frontend React

## Objetivo

Criar uma interface funcional, responsiva e clara para o MVP.

## Sprints principais

### 12.1 Fundação do frontend — 12–18 h
- [ ] React;
- [ ] TypeScript;
- [ ] roteamento;
- [ ] estrutura de pastas;
- [ ] cliente HTTP;
- [ ] variáveis de ambiente;
- [ ] tratamento global de erros.

### 12.2 Design system mínimo — 12–20 h
- [ ] cores;
- [ ] tipografia;
- [ ] botões;
- [ ] inputs;
- [ ] tabelas;
- [ ] modais;
- [ ] feedback visual;
- [ ] acessibilidade básica.

### 12.3 Autenticação — 12–18 h
### 12.4 Empresa — 10–15 h
### 12.5 Clientes — 15–22 h
### 12.6 Profissionais — 15–22 h
### 12.7 Serviços — 12–18 h
### 12.8 Agenda — 25–40 h
### 12.9 Financeiro — 25–40 h
### 12.10 Dashboard — 18–28 h
### 12.11 Responsividade e revisão — 15–25 h
### 12.12 Testes — 15–25 h

Estimativa total:

186–291 horas.

---

# 21. Épico 13 — Infraestrutura e Deploy

## Objetivo

Disponibilizar o sistema em ambiente reproduzível e seguro.

## Sprints

### 13.1 Docker backend — 6–10 h
### 13.2 Docker frontend — 4–8 h
### 13.3 Docker Compose — 6–10 h
### 13.4 Banco de produção — 6–10 h
### 13.5 CI — 6–12 h
### 13.6 CD — 8–14 h
### 13.7 HTTPS e domínio — 5–8 h
### 13.8 Backup e recuperação — 6–10 h

Estimativa total:

47–82 horas.

---

# 22. Épico 14 — Observabilidade e Produção

## Objetivo

Tornar a aplicação diagnosticável e operável.

## Tarefas

- [ ] logs estruturados;
- [ ] níveis de log;
- [ ] correlation ID;
- [ ] métricas;
- [ ] health checks;
- [ ] monitoramento;
- [ ] alertas;
- [ ] rastreamento de erros;
- [ ] política de retenção;
- [ ] auditoria;
- [ ] documentação operacional.

Estimativa:

25–45 horas.

---

# 23. Épico 15 — Segurança e Privacidade

## Objetivo

Reduzir riscos de acesso indevido, vazamento e abuso.

## Tarefas

- [ ] revisão de autenticação;
- [ ] revisão de autorização;
- [ ] testes de isolamento;
- [ ] rate limiting;
- [ ] validação de entrada;
- [ ] proteção contra exposição de dados;
- [ ] política de senha;
- [ ] rotação de segredos;
- [ ] backups;
- [ ] LGPD básica;
- [ ] política de privacidade;
- [ ] exclusão/anomização de dados;
- [ ] revisão de dependências.

Estimativa:

25–45 horas.

---

# 24. Documentação Obrigatória

## Documentos atuais e planejados

```text
docs/
├── architecture/
│   ├── exception-handling.md
│   ├── api.md
│   ├── domain-model.md
│   ├── multi-tenancy.md
│   ├── security.md
│   └── diagrams/
├── adr/
│   ├── ADR-001-package-by-feature.md
│   ├── ADR-002-use-dtos.md
│   ├── ADR-003-logical-multi-tenancy.md
│   ├── ADR-004-global-exception-handling.md
│   └── ...
├── product/
│   ├── vision.md
│   ├── mvp-scope.md
│   └── personas.md
├── api/
│   └── endpoints.md
└── roadmap/
    └── FLUX_ENGINEERING_ROADMAP.md
```

## Checklist contínuo

- [ ] README atualizado;
- [ ] CHANGELOG atualizado;
- [ ] ADRs numerados;
- [ ] roadmap atualizado;
- [ ] endpoints documentados;
- [ ] instruções de execução válidas;
- [ ] diagrama de domínio atualizado;
- [ ] decisões obsoletas marcadas como substituídas.

---

# 25. Plano Sugerido por Dias

Considerando sessões de aproximadamente 2 horas.

## Próximas 10 sessões

### Dia 1 — Revisão e preparação
- [ ] salvar este roadmap;
- [ ] revisar estrutura de `docs`;
- [ ] atualizar status real dos commits;
- [ ] revisar pendências da fundação;
- [ ] criar commit de documentação.

### Dia 2 — Testes: fundamentos
- [ ] entender JUnit 5;
- [ ] entender Mockito;
- [ ] criar primeiro teste simples;
- [ ] definir convenção de testes.

### Dia 3 — Testes do cadastro de empresa
- [ ] testar criação;
- [ ] testar e-mail duplicado;
- [ ] revisar mocks;
- [ ] commit.

### Dia 4 — GET empresa por ID
- [ ] entender `Optional`;
- [ ] implementar Service;
- [ ] implementar Controller;
- [ ] testar manualmente.

### Dia 5 — Testes do GET por ID
- [ ] teste de sucesso;
- [ ] teste de recurso inexistente;
- [ ] teste do endpoint;
- [ ] documentação;
- [ ] commit.

### Dia 6 — Paginação
- [ ] estudar `Pageable`;
- [ ] implementar listagem;
- [ ] definir ordenação;
- [ ] testar.

### Dia 7 — Revisão multi-tenant
- [ ] analisar riscos da listagem;
- [ ] definir futuro endpoint administrativo;
- [ ] criar ADR ou nota arquitetural;
- [ ] corrigir contrato se necessário.

### Dia 8 — Atualização de empresa
- [ ] definir DTO;
- [ ] definir regras;
- [ ] implementar atualização;
- [ ] testar conflito de e-mail.

### Dia 9 — Status da empresa
- [ ] definir semântica dos status;
- [ ] documentar inativação;
- [ ] implementar caso de uso inicial.

### Dia 10 — Fechamento do épico Empresa
- [ ] revisão geral;
- [ ] testes;
- [ ] documentação;
- [ ] changelog;
- [ ] tag de versão, se aplicável.

---

# 26. Indicadores de Evolução Técnica

A cada mês, avaliar:

## Backend

- [ ] consigo explicar o fluxo completo de uma requisição?
- [ ] consigo criar um endpoint sem copiar?
- [ ] consigo justificar o status HTTP?
- [ ] consigo modelar uma regra antes de codar?
- [ ] consigo escrever testes?
- [ ] consigo investigar logs e stack traces?
- [ ] consigo identificar responsabilidade de cada camada?

## Banco

- [ ] consigo criar migrations seguras?
- [ ] entendo constraints?
- [ ] entendo índices?
- [ ] consigo analisar uma consulta?
- [ ] entendo concorrência básica?

## Arquitetura

- [ ] consigo reconhecer acoplamento excessivo?
- [ ] consigo explicar DTOs?
- [ ] consigo explicar multi-tenancy?
- [ ] consigo registrar decisões em ADRs?
- [ ] consigo distinguir domínio de infraestrutura?

## Git

- [ ] commits são pequenos?
- [ ] mensagens são claras?
- [ ] mudanças não relacionadas foram separadas?
- [ ] documentação acompanha o código?
- [ ] consigo reverter uma mudança?

---

# 27. Marcos do Projeto

## Marco 1 — Backend básico de Empresa
Critérios:

- [ ] CRUD controlado;
- [ ] testes;
- [ ] documentação;
- [ ] tratamento de erros;
- [ ] migrations;
- [ ] commits organizados.

## Marco 2 — Autenticação e isolamento
Critérios:

- [ ] usuários;
- [ ] JWT;
- [ ] autorização;
- [ ] multi-tenant seguro;
- [ ] testes cruzados.

## Marco 3 — Operação básica
Critérios:

- [ ] clientes;
- [ ] profissionais;
- [ ] serviços;
- [ ] agenda.

## Marco 4 — Núcleo financeiro
Critérios:

- [ ] receitas;
- [ ] despesas;
- [ ] comissões;
- [ ] integração com atendimento;
- [ ] relatórios.

## Marco 5 — MVP utilizável
Critérios:

- [ ] frontend;
- [ ] autenticação;
- [ ] dashboard;
- [ ] deploy;
- [ ] monitoramento;
- [ ] documentação;
- [ ] validação com usuário real.

---

# 28. Backlog Pós-MVP

Itens que não devem bloquear a primeira versão:

- integração com WhatsApp;
- cobrança automática;
- múltiplas unidades;
- aplicativo mobile nativo;
- inteligência artificial;
- emissão fiscal;
- integração bancária;
- conciliação automática;
- marketplace;
- chat interno;
- automações complexas;
- BI avançado;
- relatórios personalizados;
- white label;
- multi-idioma.

---

# 29. Próxima Ação

A próxima etapa recomendada é:

> Criar a base de testes automatizados para a feature Empresa antes de expandir o domínio.

Ordem sugerida:

1. JUnit 5;
2. Mockito;
3. teste de criação de empresa;
4. teste de e-mail duplicado;
5. implementação de `GET /empresas/{id}`;
6. testes do novo caso de uso;
7. documentação;
8. commit.

---

# 30. Registro de Atualizações

| Data | Alteração | Autor |
|---|---|---|
| 2026-07-10 | Criação da primeira versão do roadmap de engenharia | Rafael / Projeto Flux |

---

# 31. Observações Finais

Este roadmap é uma referência, não uma prisão.

Estimativas poderão mudar conforme:

- novas regras forem descobertas;
- funcionalidades forem simplificadas;
- problemas técnicos surgirem;
- o MVP for validado com usuários;
- o nível de experiência da equipe aumentar.

A prioridade deve ser sempre:

1. proteger o domínio;
2. manter os dados consistentes;
3. garantir isolamento entre empresas;
4. entregar valor real ao usuário;
5. aprender com cada decisão;
6. evitar complexidade sem necessidade.
