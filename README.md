# 📚 Biblioteca Virtual 

## 🧩 Sobre o projeto  
O projeto **Biblioteca Virtual** foi desenvolvido com o objetivo de aplicar e demonstrar boas práticas de desenvolvimento backend em Java com Spring Boot, seguindo uma arquitetura organizada em camadas e padrões de projeto abordados em sala.  

A aplicação simula o funcionamento de uma biblioteca totalmente virtual, permitindo o gerenciamento de entidades relacionadas (como livros, autores, usuários, empréstimos, etc.), além de incluir uma **funcionalidade extra**.

---

## 🚀 Funcionalidades Principais  

✅ **Definição e validação dos requisitos** do sistema de uma biblioteca virtual.  
✅ **Cronograma de entregas**.  
✅ **Desenvolvimento de 05 CRUDs completos**, com as operações:  
- Cadastrar  
- Editar  
- Pesquisar todos  
- Pesquisar por ID  
- Excluir  

✅ **Funcionalidade adicional (sem relação com CRUD):**  
Ao registrar um novo usuário, o sistema envia automaticamente um **e-mail de boas-vindas**, informando que o cadastro foi concluído e que ele agora tem acesso às funcionalidades da biblioteca virtual.  

✅ **Entidades com pelo menos 4 atributos (além do ID)**, conforme o contexto definido.  
✅ **Camadas e padrões de projeto aplicados:**  
- Model  
- DTO  
- Repository  
- Service  
- Controller  

✅ **Tratamento de exceções** e retornos com mensagens amigáveis e **Status Codes adequados**.  
✅ **Integração com banco de dados**, garantindo que todas as operações de CRUD sejam persistidas.  
✅ **Migrações de banco** realizadas via **Flyway** (DDL das tabelas).  
✅ **Documentação completa das rotas** via **Swagger**.

---

## 🧠 Estrutura do Projeto  

biblioteca-virtual/
├── src/
│ ├── main/
│ │ ├── java/br/edu/unichristus/backend/
│ │ │ ├── controller/ # Controladores (endpoints da API)
│ │ │ ├── service/ # Lógica de negócios
│ │ │ ├── repository/ # Comunicação com o banco de dados
│ │ │ ├── dto/ # Objetos de transferência de dados
│ │ │ └── model/ # Entidades e classes de domínio
│ │ └── resources/
│ │ ├── application.properties # Configurações do projeto
│ │ └── db/migration/ # Scripts de migração (Flyway)
│ └── test/ # Testes automatizados
└── pom.xml # Dependências Maven

---

## ⚙️ Tecnologias Utilizadas  

- **Java 17+**  
- **Spring Boot**  
- **Spring Data JPA**  
- **Flyway** (migrações de banco de dados)  
- **Swagger** (documentação da API)  
- **Lombok** (boilerplate reduction)  
- **H2 / PostgreSQL** (banco de dados)  
- **JavaMailSender** (envio de e-mails automáticos)  

---

## 📬 Funcionalidade Extra — Envio de E-mail de Boas-Vindas  

Quando um novo usuário é cadastrado na aplicação, o sistema dispara automaticamente um e-mail personalizado com a seguinte mensagem:  

> Olá *Nome*,
> Bem-vindo(a) à Biblioteca Virtual da Unichristus!  
> Seu cadastro foi realizado com sucesso e agora você pode alugar livros, acompanhar prazos e explorar nosso acervi digital."  
> Atenciosamente,
> Equipe Biblioteca Virtual

Essa funcionalidade foi desenvolvida utilizando o **JavaMailSender** do Spring Framework e configurada para envio assíncrono, garantindo boa performance e uma experiência fluida ao usuário.

---

## 📑 Documentação da API  

Toda a API foi documentada com **Swagger**, permitindo a visualização e o teste das rotas diretamente pelo navegador.  

🔗 Acesse a documentação em:  
http://localhost:8080/swagger-ui.html

---

## 🗃️ Banco de Dados e Migrações  

Todas as entidades possuem scripts de criação (DDL) controlados via **Flyway**.  
Isso garante a rastreabilidade das alterações no banco de dados e consistência entre os ambientes.

---

## 🧪 Tratamento de Erros  

As exceções são tratadas de forma amigável, retornando mensagens claras e **Status Codes** adequados, como:  
- `400 Bad Request` para erros de validação  
- `404 Not Found` para registros inexistentes  
- `200 HTTP 200 OK` para requisições que deram certo 

---

## 👩‍💻 Autores e Contribuições  

O projeto foi desenvolvido em equipe, com **definição de cronograma de entregas por membro** e colaboração nas seguintes etapas:  
- Levantamento e validação dos requisitos  
- Modelagem das entidades  
- Desenvolvimento dos CRUDs  
- Implementação da funcionalidade extra 
- Testes e documentação  

---
