# 🚀 API REST | Spring Boot 3, Java 17 & Railway

![Status do Projeto](https://img.shields.io/badge/Status-Em%20Produção-success)
![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green)
![Railway](https://img.shields.io/badge/Deploy-Railway-blueviolet)
![Licença](https://img.shields.io/badge/Licença-MIT-blue)

## 📊 Sobre o Projeto

Esta API REST foi desenvolvida com Spring Boot 3 e Java 17, seguindo princípios de arquitetura limpa e boas práticas de desenvolvimento. A aplicação está hospedada na plataforma Railway, oferecendo alta disponibilidade e escalabilidade para aplicações em produção.

## 🌟 Características

- **Arquitetura RESTful**: Implementação completa seguindo os princípios REST
- **Documentação Swagger**: API completamente documentada e interativa
- **Autenticação JWT**: Segurança robusta com tokens JWT
- **CI/CD**: Pipeline automatizado para integração e deploy contínuos
- **Monitoramento**: Integração com Spring Actuator para métricas de saúde
- **Validação de Dados**: Implementação de validações robustas com Bean Validation
- **Tratamento de Exceções**: Sistema global de tratamento de exceções

## 🔧 Tecnologias Utilizadas

- **Backend**:
  - Java 17
  - Spring Boot 3.2.0
  - Spring Data JPA
  - Spring Security + JWT
  - Spring Doc (Swagger/OpenAPI)
  - Lombok
  - ModelMapper

- **Banco de Dados**:
  - PostgreSQL
  - Flyway Migration

- **Infraestrutura**:
  - Railway (Deploy)
  - GitHub Actions (CI/CD)
  - Docker

## 📦 Estrutura do Projeto

```
api-rest/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── github/
│   │   │           └── mauriciogonrails/
│   │   │               ├── config/                 # Configurações
│   │   │               │   ├── SecurityConfig.java
│   │   │               │   └── SwaggerConfig.java
│   │   │               ├── controllers/            # Controladores REST
│   │   │               ├── dto/                    # Objetos de Transferência de Dados
│   │   │               ├── exceptions/             # Tratamento de Exceções
│   │   │               ├── model/                  # Entidades JPA
│   │   │               ├── repositories/           # Repositórios Spring Data
│   │   │               ├── security/               # Implementação de Segurança
│   │   │               ├── services/               # Camada de Serviço
│   │   │               │   ├── impl/
│   │   │               │   └── interfaces/
│   │   │               └── Application.java        # Classe Principal
│   │   └── resources/
│   │       ├── application.properties              # Configurações
│   │       ├── application-dev.properties          # Configurações de Desenvolvimento
│   │       ├── application-prod.properties         # Configurações de Produção
│   │       └── db/migration/                       # Scripts de Migração Flyway
│   └── test/                                       # Testes Automatizados
├── .github/
│   └── workflows/                                  # GitHub Actions Workflows
├── docker/                                         # Arquivos Docker
├── .gitignore
├── build.gradle.kts                                # Configuração Gradle
├── Dockerfile                                      # Configuração Docker
├── README.md
└── LICENSE
```

## 🔌 Endpoints da API

| Método | URL | Descrição | Autenticação |
|--------|-----|-----------|--------------|
| POST   | /api/auth/login | Autenticar usuário | Não |
| POST   | /api/auth/register | Registrar novo usuário | Não |
| GET    | /api/users | Listar todos os usuários | Sim (ADMIN) |
| GET    | /api/users/{id} | Obter usuário específico | Sim |
| PUT    | /api/users/{id} | Atualizar usuário | Sim |
| DELETE | /api/users/{id} | Remover usuário | Sim (ADMIN) |
| GET    | /api/resources | Listar recursos | Sim |
| POST   | /api/resources | Criar novo recurso | Sim |
| GET    | /api/resources/{id} | Obter recurso específico | Sim |
| PUT    | /api/resources/{id} | Atualizar recurso | Sim |
| DELETE | /api/resources/{id} | Remover recurso | Sim |

## 📝 Documentação

A documentação completa da API está disponível através do Swagger UI:

- **Produção**: `https://api.railway.app/swagger-ui.html`
- **Desenvolvimento**: `http://localhost:8080/swagger-ui.html`

## 🚀 Como Executar

### Pré-requisitos

- JDK 17
- Maven ou Gradle
- Docker (opcional)
- PostgreSQL (ou Docker)

### Localmente

1. Clone o repositório:
   ```bash
   git clone https://github.com/mauriciogonrails/api-rest.git
   cd api-rest
   ```

2. Configure o banco de dados PostgreSQL no arquivo `application-dev.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/apirest
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   ```

3. Execute a aplicação:
   ```bash
   # Com Gradle
   ./gradlew bootRun --args='--spring.profiles.active=dev'

   # Com Maven
   mvn spring-boot:run -Dspring-boot.run.profiles=dev
   ```

4. Acesse a aplicação em `http://localhost:8080`

### Com Docker

```bash
# Construir a imagem
docker build -t api-rest .

# Executar o container
docker run -p 8080:8080 -e "SPRING_PROFILES_ACTIVE=dev" api-rest
```

### Deploy no Railway

1. Crie uma conta no [Railway](https://railway.app/)
2. Conecte seu repositório GitHub
3. Configure as variáveis de ambiente necessárias:
   - `SPRING_PROFILES_ACTIVE=prod`
   - `JWT_SECRET=seu_segredo_jwt`
   - `DATABASE_URL` (preenchido automaticamente pelo Railway)

## 🧪 Testes

O projeto inclui testes unitários e de integração:

```bash
# Executando todos os testes
./gradlew test

# Executando apenas testes unitários
./gradlew test --tests "com.github.mauriciogonrails.*.unit.*"

# Executando apenas testes de integração
./gradlew test --tests "com.github.mauriciogonrails.*.integration.*"
```

## 📈 Monitoramento

Endpoints de monitoramento via Spring Actuator:

- `/actuator/health` - Status de saúde da aplicação
- `/actuator/info` - Informações sobre a aplicação
- `/actuator/metrics` - Métricas detalhadas

## 🔒 Segurança

A API utiliza autenticação JWT (JSON Web Token):

1. Faça uma solicitação POST para `/api/auth/login` com credenciais válidas
2. Copie o token JWT retornado
3. Inclua o token no cabeçalho Authorization como `Bearer {seu_token}` para requisições subsequentes

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/nova-funcionalidade`)
3. Faça commit das alterações (`git commit -m 'Adiciona nova funcionalidade'`)
4. Envie para o GitHub (`git push origin feature/nova-funcionalidade`)
5. Abra um Pull Request

## 📜 Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).

## 📞 Contato

Para questões, sugestões ou problemas, entre em contato:
- GitHub: [mauriciogonrails](https://github.com/mauriciogonrails)

---

Desenvolvido com ☕ por [Mauricio Gonçalves](https://github.com/mauriciogonrails)
