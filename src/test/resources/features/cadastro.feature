# language: pt
# encoding: UTF-8
Funcionalidade: Cadastro de usuários

  @cadastro
  Cenário: Validar campos obrigatórios ao tentar cadastrar usuário com campos incompletos
    Dado que estou na página de cadastro de usuários
    E não vejo a tabela com usuários cadastrados
    Quando não preencho nenhum dos campos de cadastro de usuário
    E pressiono o botão Cadastrar
    Então vejo a mensagem "O campo Nome é obrigatório." abaixo do campo Nome
    E vejo a mensagem "O campo E-mail é obrigatório." abaixo do campo E-mail
    E vejo a mensagem "O campo Senha é obrigatório." abaixo do campo Senha
    E não vejo a tabela com usuários cadastrados


  Cenário: Validar mensagem ao cadastrar usuário sem preencher o campo nome
    Dado que estou na página de cadastro de usuários
    E não vejo a tabela com usuários cadastrados
    Quando não preencho o campo Nome
    E preencho o campo E-mail com "email@exemplo.com"
    E preencho o campo Senha com "Abcd!0305"
    E pressiono o botão Cadastrar
    Então vejo a mensagem "O campo Nome é obrigatório." abaixo do campo Nome
    E não vejo a tabela com usuários cadastrados


  Cenário: Validar mensagem ao cadastrar usuário sem preencher o campo E-mail
    Dado que estou na página de cadastro de usuários
    E não vejo a tabela com usuários cadastrados
    Quando não preencho o campo E-mail
    E preencho o campo Nome com "João Silva"
    E preencho o campo Senha com "Abcd!0305"
    E pressiono o botão Cadastrar
    Então vejo a mensagem "O campo E-mail é obrigatório." abaixo do campo E-mail
    E não vejo a tabela com usuários cadastrados


  Cenário: Validar mensagem ao cadastrar usuário sem preencher o campo Senha
    Dado que estou na página de cadastro de usuários
    E não vejo a tabela com usuários cadastrados
    Quando não preencho o campo Senha
    E preencho o campo Nome com "João Silva"
    E preencho o campo E-mail com "email@exemplo.com"
    E pressiono o botão Cadastrar
    Então vejo a mensagem "O campo Senha é obrigatório." abaixo do campo Senha
    E não vejo a tabela com usuários cadastrados


  Cenário: Validar mensagem ao cadastrar usuário com apenas o primeiro nome
    Dado que estou na página de cadastro de usuários
    E não vejo a tabela com usuários cadastrados
    Quando preencho o campo Nome com "João"
    E preencho o campo E-mail com "email@exemplo.com"
    E preencho o campo Senha com "Abcd!0305"
    E pressiono o botão Cadastrar
    Então vejo a mensagem "Por favor, insira um nome completo." abaixo do campo Nome
    E não vejo a tabela com usuários cadastrados


  Cenário: Validar mensagem ao cadastrar usuário com e-mail inválido
    Dado que estou na página de cadastro de usuários
    E não vejo a tabela com usuários cadastrados
    Quando preencho o campo Nome com "João Silva"
    E preencho o campo E-mail com "email.exemplo.com"
    E preencho o campo Senha com "Abcd!0305"
    E pressiono o botão Cadastrar
    Então vejo a mensagem "Por favor, insira um e-mail válido." abaixo do campo E-mail
    E não vejo a tabela com usuários cadastrados


  Cenário: Validar mensagem ao cadastrar usuário com senha com menos de 8 caracteres
    Dado que estou na página de cadastro de usuários
    E não vejo a tabela com usuários cadastrados
    Quando preencho o campo Nome com "João Silva"
    E preencho o campo E-mail com "email@exemplo.com"
    E preencho o campo Senha com "Ab!0305"
    E pressiono o botão Cadastrar
    Então vejo a mensagem "A senha deve conter ao menos 8 caracteres." abaixo do campo Senha
    E não vejo a tabela com usuários cadastrados


  Esquema do Cenário: Cadastrar usuário com dados válidos 2222
    Dado que estou na página de cadastro de usuários
    E não vejo a tabela com usuários cadastrados
    Quando cadastro um usuário com sucesso
      | nome   | email   | senha   |
      | <nome> | <email> | <senha> |
    Então vejo a tabela com usuários cadastrados

    Exemplos:
      | nome                    | email                         | senha       |
      | João Silva              | email@exemplo.com             | Abcd!0305   |
      | Roberto Carlos Da Silva | robertinho.carlos@exemplo.com | qwertY!0921 |


  Cenário: Excluir usuário cadastrado
    Dado que estou na página de cadastro de usuários
    E não vejo a tabela com usuários cadastrados
    Quando cadastro um usuário com sucesso
      | nome       | email             | senha     |
      | Joao Silva | email@exemplo.com | Abcd!0305 |
    Então vejo a tabela com usuários cadastrados
    E pressiono o botão excluir na tabela de usuários cadastrados, para o id "1"
    E não vejo a tabela com usuários cadastrados
