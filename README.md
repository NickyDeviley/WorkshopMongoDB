# WorkshopMongoDB - Aplicação web RESTful em Java utilizando Spring Boot e banco de dados NoSQL MongoDB.

# Descrição:

Este projeto foi desenvolvido como parte do conteúdo do curso "Java Completo Programação Orientada a Objetos + Projetos" do instrutor Nélio Alves, na plataforma Udemy. O objetivo principal é explorar a persistência de dados em bancos de dados não relacionais (NoSQL) utilizando o ecossistema Spring. O projeto resolve o desafio de modelar, armazenar e consultar dados orientados a documentos, implementando uma API RESTful completa estruturada em camadas, utilizando o Spring Data MongoDB para realizar operações eficientes sem a necessidade de tabelas relacionais tradicionais.

# Pré-requisitos:

    Linguagem: Java (JDK 11 ou superior).

    Banco de Dados: MongoDB (instalado localmente, via container Docker ou utilizando o MongoDB Atlas).

    Gerenciador de Dependências: Maven.

    IDE: Eclipse com Spring Tools Suite (STS), IntelliJ IDEA ou Visual Studio Code.

# Instalação/Uso:

    Clone este repositório em sua máquina local:
    Bash

    git clone https://github.com/seu-usuario/WorkshopMongoDB.git

    Certifique-se de que o MongoDB está ativo e em execução (porta padrão 27017) ou configure a string de conexão correta no arquivo application.properties.

    Abra o projeto na sua IDE de preferência como um projeto Maven.

    Aguarde o download automático das dependências do Spring Boot e do Spring Data MongoDB.

    Localize a classe principal contendo o método main e execute a aplicação como uma Spring Boot App.

    A API estará rodando localmente em http://localhost:8080, e você poderá utilizar clientes REST (como Postman, Insomnia ou cURL) para interagir com os endpoints cadastrados.

# Tecnologias:

    Java (Lógica principal e Orientação a Objetos)

    Spring Boot (Framework para criação de aplicações web e APIs REST)

    Spring Data MongoDB (Mapeamento e persistência orientada a documentos)

    MongoDB (Banco de dados NoSQL)

    Maven (Gerenciamento de dependências e build)

# Licença:

MIT License
