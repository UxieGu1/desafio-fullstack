# 🛒 Desafio: Lista de Produtos Full Stack (com Paginação)

Crie uma aplicação full stack simples, mas completa, que lista produtos com suporte a paginação no backend e navegação interativa no frontend.

Este desafio é ideal para quem está estudando desenvolvimento web com **Spring Boot (Java)** no backend e **HTML + JavaScript puro** no frontend, com um toque de integração real entre as camadas.

---

## 📦 Contexto

Imagine que você trabalha em uma pequena empresa e foi encarregado de criar uma interface simples para listar os produtos cadastrados em um banco de dados. O problema é que a base de dados já conta com centenas de registros, então a ideia de listar "tudo de uma vez" está fora de cogitação.

**Seu objetivo é:**  
Desenvolver um backend paginado usando Spring Boot + JPA, e um frontend navegável que se comunica via API REST.

---

## 🎯 Objetivo

O desafio consiste em implementar (ou entender e adaptar) a seguinte estrutura:

### ⚙️ Backend (Java + Spring Boot)
- **Modelo de Domínio:** Classe `Product` persistida via JPA.
- **DTO (Data Transfer Object):** Para expor apenas os campos `name` e `price`.
- **Repositório:** Utilizar `JpaRepository` para acesso aos dados.
- **Serviço (Service):** Aplicar um limite de paginação de segurança de até **100 itens por página**.
- **Controller REST:** Acessível via endpoint `/api/v1/product`.
- **Paginação:** Criar uma classe `PageResponse<T>` que encapsula as informações de paginação no retorno da API.

### 💻 Frontend (HTML + JavaScript)
- **Página simples que:**
  - Lista os produtos consumidos vindos da API.
  - Exibe os campos `name`, `price` e `createdAt`.
  - Permite navegação entre as páginas utilizando botões **"Anterior"** e **"Próxima"**.
  - Atualiza dinamicamente a interface (DOM) a cada mudança de página, sem recarregar o navegador.

---

## 🧪 Requisitos Técnicos

### 🗄️ Banco de Dados
- **SGBD:** PostgreSQL
- **Nome do banco:** `produtos`
- **Credenciais padrão:**
  - Usuário: `postgres`
  - Senha: `manager`

> ⚠️ **Atenção:** Lembre-se de rodar o PostgreSQL localmente e criar o banco de dados `produtos` manualmente (via pgAdmin, DBeaver ou CLI) antes de iniciar a aplicação.

### 📝 Configuração do `application.properties`
Sua configuração do Spring Boot deve seguir este padrão:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/produtos
spring.datasource.username=postgres
spring.datasource.password=manager

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
