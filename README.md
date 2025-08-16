# ClinicaMedicaVoll
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://github.com/Luis-Parente/ClinicaMedicaVoll/blob/main/LICENSE)

Este projeto foi desenvolvido como parte do desafio proposto pela Alura para aplicar os conceitos de Domain-Driven Design (DDD) e Clean Architecture. Trata-se de um sistema para uma clínica médica, com funcionalidades como login de atendentes, cadastro de médicos e pacientes, além de agendamento e cancelamento de consultas.

O foco principal é a modelagem do domínio, utilizando uma linguagem ubíqua entre o especialista de negócio e o software.

## 📋 Requisitos
- Java 21 ou superior
- Git
- PostgreSQL (rodando localmente ou em container)

## 📦 Tecnologias Utilizadas
- Java 21
- Spring Boot 3.5
- Spring Data JPA
- PostgreSQL
- Spring Security com JWT (para autenticação)
- Lombok
- Swagger/OpenAPI
- Maven Wrapper
- Postman (para testes)

## 🛠️ Como executar

### 1. Clone o repositório:
````bash
git clone https://github.com/Luis-Parente/ClinicaMedicaVoll.git
cd ClinicaMedicaVoll
````
### 2. Configure o banco de dados
Certifique-se de que o PostgreSQL esteja rodando localmente e crie um banco de dados chamado medica_voll.
Você pode executar o seguinte comando SQL no seu cliente favorito ou via terminal:
````sql
CREATE DATABASE medica_voll;
````
⚠️ As credenciais e demais configurações de acesso ao banco de dados devem ser informadas no arquivo application.properties.
#### 📄 Exemplo de configuração:
O projeto inclui um arquivo chamado MODELO-application.properties, que serve como modelo para sua configuração local.
Basta copiá-lo e renomear para application.properties, e então ajustar com os dados do seu ambiente:
````properties
spring.datasource.url=jdbc:postgresql://localhost:5432/medica_voll
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
````
É importante manter o nome do banco como medica_voll, a menos que você também atualize a URL de conexão conforme necessário.
### 3. Construa o projeto
````bash
./mvnw clean install
````
### 4. Rode a aplicação
````bash
./mvnw spring-boot:run
````

## 🔗 Endpoints e Testes
- API Base URL: http://localhost:8080
- Swagger UI: http://localhost:8080/swagger-ui/index.html
- PostgreSQL: A conexão é feita com base nas configs do application.properties

## 🔍 Testando a API
Você pode testar de duas maneiras:
### 1. Swagger UI
Acesse:
http://localhost:8080/swagger-ui/index.html

### 2. Postman
O repositório inclui dois arquivos prontos para importar:
- Arquivo: ClinicaMedicaVoll.postman_collection.json
- Ambiente: ClinicaMedicaVoll.postman_environment.json

Como importar:
- Abra o Postman
- Vá em File > Import
- Selecione os arquivos .json do repositório
- Você pode então enviar requisições diretamente usando os endpoints e dados pré-configurados.

## ✅ Funcionalidades principais
- Login de atendentes
- Cadastro completo de médicos (com especialidade, CRM, endereço, status)
- Cadastro de pacientes (com CPF, email e endereço obrigatórios)
- Agendamento de consultas (médico, paciente, data e horário)
- Cancelamento de consultas com motivo (ex: paciente não compareceu)
