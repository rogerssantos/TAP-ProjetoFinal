# TAP-ProjetoFinal

Este projeto é um trabalho final para a matéria "Tópicos avançados de programação", no qual devemos utilizar Java e JavaFX para o desenvolvimento.

## Projeto

Realizar um aplicativo no qual o professor de determinada materia possua o controle de cadastrar quantas perguntas, alternativas e respostas para aplicar em uma determinada turma de alunos.

## Java

* Como funciona:

  - (1) Cadastro da materia;
  - (2) Cadastro de professor;
  - (3) Cadastro das questões;
  - (4) Cadastro das alternativas e repostas;
  - (5) Cadastro da pontuação de cada pergunta;
  - (6) Cadastro do aluno;
  - (7) Selecionar qual materia jogar;
  - (8) Mostrar a pergunta e depois de um tempo mostrar as alternativas; e
  - (9) Ao finalizar o jogo mostrar pontuação.

* Fluxos:

  - Cadastros:
    - (1) Para poder cadastrar um professor a materia do mesmo já deve estar cadastrada antes.
    - (2) Não deverá ser permitido o cadastro do mesmo professor, aluno, materia, pergunta e resposta.
  
  - Apresentação das perguntas e respostas:
    - (1) Após o aluno selecionar qual materia ele deseja jogar. 
    - (2) Mostrar um botão para dar inicio ao jogo.
    - (3) Deve ser mostrado na primeira tela somente a pergunta e na segunda tela deve ser mostrado a pergunta junto com as alternativas.
    
  - Pontuação Final:
    - (1) A pontuação final segue o cálculo: (Soma dos pontos por questão)/Quantidade de Questões.
  
  - Configurações:
    - (1) As configurações selecionadas somente terão efeitos dentro do jogo.

* Telas:

  - Inicial:
    - Jogar:
    - Alunos:
    - Professores:
    - Criação e Ajustes:
    - Configurações:
  
  - Cadastro do Aluno:
    - Nome;
    - Idade; e
    - Serie/Turma.
  
  - Cadastro do Professor:
    - Nome;
    - Idade;
    - Qual materia leciona; e
    - Login e senha.
  
  - Cadastro da Materia:
    - Nome.
  
  - Cadastro das Perguntas:
    - Texto; e
    - Imagens.
  
  - Cadastro das Questões:
    - Texto.
  
  - Cadastro das Alternativas e Respostas:
    - Frase ou Imagem; e
    - Qual é a correta.
  
  - Cadastro das Configurações no Arquivo conf.properties:
    - Mostrar as configurações do arquivo.

* Regras: As regras devem ser adicionadas em um arquivo conf.properties

  - Opções de regras:
    - Quanto tempo por pergunta;

## Banco

* Como funciona:

* Fluxos:

* Tabelas:
  [Script das tabelas](https://github.com/rogerssantos/TAP-ProjetoFinal/blob/master/bd/script_projeto.sql)
* Regras:
