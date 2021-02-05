@login
Feature: Login

  @login
  Scenario Outline: <cenario>
    Given eu acesso o site seu barriga
    When insiro <usuario> e <senha>
    And clico no botao "Entrar"
    Then exibe a mensagem: <mensagem>

    Examples: 
      |cenario																| usuario  						| senha 			| mensagem													|
      |Realizar login													| "luis@qa.com.br" 		|"123@teste"	|"Bem vindo, Luis!" 								|
      |Tentativa de login com senha errada		| "luis@qa.com.br"		|"123@TT" 		|"Problemas com o login do usuário"	|      
			|Tentativa de login sem preecher a senha| "luis@qa.com.br"		|""						|"Senha é um campo obrigatório"			|
			|Tentativa de login sem preecher o email| ""									|"123@teste"	|"Email é um campo obrigatório"			|