# Changelog

Todas as alterações relevantes deste projeto serão documentadas neste arquivo.

O formato deste arquivo é baseado em **Keep a Changelog** e o projeto segue os princípios de **Semantic Versioning**.

## [Unreleased]

### Added

* Estrutura inicial do backend utilizando Spring Boot.
* Integração com PostgreSQL.
* Versionamento do banco de dados com Flyway.
* Organização da aplicação utilizando arquitetura Package by Feature.
* Health check da aplicação.
* Modelagem da entidade `Empresa`.
* Enum `EmpresaStatus`, com os estados `ACTIVE`, `INACTIVE` e `SUSPENDED`.
* DTO `CreateEmpresaRequest` para cadastro de empresas.
* DTO `UpdateEmpresaRequest` para atualização de empresas.
* DTO `EmpresaResponse` para respostas da API.
* Endpoint para cadastro de empresas (`POST /empresas`).
* Endpoint para consulta de empresa por ID (`GET /empresas/{id}`).
* Endpoint para listagem de empresas (`GET /empresas`).
* Endpoint para atualização de empresas (`PUT /empresas/{id}`).
* Endpoint para desativação lógica de empresas (`DELETE /empresas/{id}`).
* Regra de unicidade de e-mail no cadastro de empresas.
* Regra de validação de e-mail durante a atualização, permitindo que a empresa mantenha o próprio e-mail.
* Desativação lógica de empresas por meio da alteração do status para `INACTIVE`.
* Comportamento idempotente na desativação de empresas.
* Validação de dados de entrada utilizando Bean Validation.
* Tratamento global de exceções com `GlobalExceptionHandler`.
* Classe `ApiError` para respostas padronizadas de erro.
* Classe `ValidationError` para respostas de erros de validação.
* Classe `BusinessException` para violações de regras de negócio.
* Classe `ResourceNotFoundException` para recursos inexistentes.
* Tratamento dos status HTTP `404 Not Found`, `409 Conflict`, `422 Unprocessable Entity` e `500 Internal Server Error`.
* Registro em log das exceções inesperadas tratadas como erro `500 Internal Server Error`.
* Testes unitários do serviço de empresas utilizando JUnit 5 e Mockito.
* Testes automatizados para cadastro, consulta, listagem, atualização e desativação de empresas.
* Documentação inicial da arquitetura do projeto.
* Roadmap inicial de desenvolvimento.
* Documentação das regras de negócio do módulo Empresa.

### Changed

* Configuração do banco de dados passou a utilizar variáveis de ambiente.
* Injeção de dependências migrada para construtores.
* Documentação principal do projeto revisada e reorganizada.
* Atualização de empresas passou a verificar se o novo e-mail pertence a outra empresa.
* Exclusão física de empresas foi substituída por desativação lógica.
* Paginação da listagem de empresas foi adiada para depois da conclusão do MVP.
* Fluxo de desenvolvimento foi padronizado com commits separados para funcionalidades e testes.

### Security

* Removidas as credenciais do banco de dados dos arquivos versionados.
* Configuração da senha do PostgreSQL realizada por meio da variável de ambiente `DB_PASSWORD`.
* Preservação dos dados de empresas desativadas para evitar perda de histórico e problemas de integridade referencial.

