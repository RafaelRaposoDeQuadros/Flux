# Changelog

Todas as alterações relevantes deste projeto serão documentadas neste arquivo.

O formato deste arquivo é baseado em **Keep a Changelog** e o projeto segue **Semantic Versioning**.

## [Unreleased]

### Added

- Estrutura inicial do backend utilizando Spring Boot.
- Integração com PostgreSQL.
- Versionamento do banco de dados com Flyway.
- Arquitetura organizada utilizando Package by Feature.
- Modelagem da entidade `Empresa`.
- Enum `EmpresaStatus`.
- Endpoint para cadastro de empresas (`POST /empresas`).
- DTOs de entrada e saída para o cadastro de empresas.
- Validação de dados utilizando Bean Validation.
- Tratamento global de exceções.
- Classe `ApiError` para respostas padronizadas de erro.
- Classe `ValidationError` para erros de validação.
- Logging de erros inesperados.
- Documentação inicial da arquitetura do projeto.
- Roadmap inicial de desenvolvimento.

### Changed

- Configuração do banco de dados passou a utilizar variáveis de ambiente.
- Injeção de dependências migrada para construtores.
- Documentação principal do projeto revisada e reorganizada.

### Security

- Removidas as credenciais do banco de dados dos arquivos versionados.
- Configuração da senha do PostgreSQL realizada por meio da variável de ambiente `DB_PASSWORD`.
