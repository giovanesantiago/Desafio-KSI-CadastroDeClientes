# Desafio KSI

- Repositório para demonstração do desafio da KSI Consultas

- ##  Definição do projeto

  - Nome : Cadastro de Clientes KSI
  - Descrição : Formulario para cadastro de dados
  - Objetivo : Cadastrar dados (Nome, cpf, Data de Nascimento) com validações de informações e armazenamento em banco.

- ### Definição da tecnologia

  - HTML5, CSS3, Bootstrap, Javascript
  - Java, Spring boot, Thymeleaf
  - PostgreSQL
- ### Requisitos

    1. Ter instalado em sua máquina alguma IDE Java e postgreSQl instalado e configurado

---

- ## Executar projeto

1. Clone este repositorio em sua maquina utilizando o gitbash:

```bash

 git clone "https://github.com/giovanesantiago/Desafio-KSI-CadastroDeClientes"

```

2.Abra o Projeto com a IDE :

3.Criar arquivo *application.properties* dentro do diretorio **"src/main/resources/"**

4.Abra o aquivo *application.properties* cole as configurações abaixo dentro do arquivo.

### Obs: Altere as informações que contem a palavra **configure** de acordo com as configurações de seu Banco PostgreSQL

```properties
spring.mvc.pathmatch.matching-strategy = ANT_PATH_MATCHER
server.error.include-exception=false
server.error.include-message=always


spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update


spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://configure.URL.do.banco.local
spring.datasource.username=configure.usuario.do.banco
spring.datasource.password=configure.senha.do.banco
```

5.Execute o projeto pela Classe principal DesafioKsiCadastroDeClientesApplication.java.

6.Abra http://localhost:8080/ no seu navegador.
