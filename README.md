# Projeto de Automação para Cadastro de Usuários

Este projeto foi desenvolvido como parte de uma prova técnica para a Stefanini e tem como objetivo automatizar o processo de registro de usuários em um sistema.


## Tecnologias Utilizadas

- Java
- Selenium WebDriver
- Cucumber
- Padrão de Projeto Page Object Model (POM)

## Estrutura do Projeto

O projeto segue uma estrutura organizada utilizando o padrão Page Object Model (POM). As principais pastas são:

src/main/java: Contém as classes Java relacionadas ao Page Object Model.
src/test/java: Contém os testes de automação escritos em Cucumber.
src/test/resources: Contém os arquivos de features escritos em Gherkin.


## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas antes de executar os testes:

- JDK (Java Development Kit)
- Maven
- WebDriver (por exemplo, ChromeDriver) compatível com o navegador que será utilizado nos testes.

## Configuração do Projeto

1- Clone o repositório para o seu ambiente local.
2- Certifique-se de ter as dependências do Maven instaladas. Execute o comando mvn clean install na raiz do projeto.
3- Configure o WebDriver apontando para o local correto no arquivo de configuração.

## Executando os Testes
Execute os testes utilizando o seguinte comando:
```
mvn test
```

## Estrutura das Features

As features estão localizadas em src/test/resources/features e são escritas em Gherkin. Elas descrevem os cenários de teste em uma linguagem natural.

## Estrutura do Código

A estrutura do código segue o padrão POM, com cada página da aplicação representada por uma classe Java no pacote pages. As interações com essas páginas são realizadas nas classes de passos definidas em steps.
