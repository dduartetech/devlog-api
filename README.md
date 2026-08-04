# 📝 Devlog API

API REST desenvolvida em Java com Spring Boot para gerenciamento de posts e comentários, com autenticação e autorização via JWT.

## 🛠️ Tecnologias

- Java 17
- Spring Boot 4.1.0
- Spring Security + JWT
- Spring Data JPA
- Spring Validation
- PostgreSQL
- Lombok
- MapStruct
- Springdoc OpenAPI (Swagger)
- Docker
- Maven

## 📦 Entidades

- **User** — usuários com autenticação via email e senha
- **Post** — posts criados por usuários autenticados
- **Coment** — comentários vinculados a posts e usuários

## 🔐 Autenticação

A API utiliza **JWT (JSON Web Token)** para autenticação. O fluxo é:

1. Cadastre um usuário em `POST /user`
2. Faça login em `POST /user/login` e receba o token
3. Use o token no header `Authorization: Bearer {token}` nas demais requisições
4. No Swagger, clique em **Authorize** 🔒 e cole o token

## 🚀 Como rodar localmente

### Pré-requisitos

- Java 17+
- PostgreSQL
- Maven

### Configuração

1. Clone o repositório:
```bash
git clone https://github.com/dduartetech/devlog-api.git
```

2. Crie o banco de dados no PostgreSQL:
```sql
CREATE DATABASE db_devlog;
```

3. Configure as credenciais no `application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/db_devlog
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

4. Rode o projeto:
```bash
./mvnw spring-boot:run
```

## 🐳 Rodando com Docker

Sem precisar instalar Java ou PostgreSQL na máquina, basta ter o Docker instalado:

```bash
docker-compose up --build
```

A API estará disponível em `http://localhost:8081/swagger-ui.html`

## 📄 Documentação

Com o projeto rodando, acesse o Swagger em:

```
http://localhost:8081/swagger-ui.html
```

## 🔗 Endpoints

| Método | Endpoint | Descrição | Auth |
|--------|----------|-----------|------|
| POST | /user | Cadastrar usuário | ❌ |
| POST | /user/login | Login e geração do token | ❌ |
| GET | /user | Listar usuários | ✅ |
| GET | /user/{id} | Buscar usuário por id | ✅ |
| PUT | /user/{id} | Atualizar usuário | ✅ |
| DELETE | /user/{id} | Desativar usuário (soft delete) | ✅ |
| POST | /post | Criar post | ✅ |
| GET | /post | Listar posts | ✅ |
| GET | /post/{id} | Buscar post por id | ✅ |
| PUT | /post/{id} | Atualizar post | ✅ |
| DELETE | /post/{id} | Deletar post | ✅ |
| POST | /coments | Criar comentário | ✅ |
| GET | /coments/post/{id} | Listar comentários de um post | ✅ |
| DELETE | /coments/{id} | Deletar comentário | ✅ |

## 👤 Autor

Diego Duarte — [GitHub](https://github.com/dduartetech) • [LinkedIn](https://www.linkedin.com/in/diego-duarte-7797a3369/)
