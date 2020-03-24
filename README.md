O projeto usa Spring Boot como arcabouço, a fim de evitar configurações desnecessárias de JPA (como o persistence.xml) e de dependências de contexto da aplicação (applicationContext.xml). As configurações ficam centralizadas no application.properties.

As APIs são invocadas a partir de REST Controllers do Spring REST (contido no Spring Boot) que expõem endpoints.

Essa camada de controle (Controllers) acessam diretamente Repositories (equivalentes ao DAO), injetados automaticamente pelo Spring, os quais fazem a conversão objeto-relacional (pegando dados do banco e levando pro banco).

Optou-se não criar uma camada de serviços dada à relativa pouca complexidade da lógica. Uma camada de serviços faria sentido se fosse para orquestrar regras de negócio de vários objetos de Entidade capturados pelas Repositories.

Projeto usa autenticação para todos os endpoints exceto o endpoint de criação. Para acessar os outros endpoints, o usuário acessa com seus dados de login/senha gerando um token basic.
