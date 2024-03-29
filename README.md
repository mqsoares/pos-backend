
<div align='center'>

<a href="https://www.linkedin.com/in/mq-soares/">
  <img alt="Miqueias Soares" src="https://img.shields.io/badge/-Miqueias Soares-747d8c?style=flat-square&logo=Linkedin&logoColor=black" />
</a>

<a href="https://twitter.com/mqsoares">
  <img alt="mqSoares" src="https://img.shields.io/badge/-mqsoares-747d8c?style=flat-square&logo=Twitter&logoColor=black" />
</a>

<a href="mailto:mqseraos@gmail.com">
  <img alt="Miqueias Soares" src="https://img.shields.io/badge/-mqseraos@gmail.com-747d8c?style=flat-square&logo=Gmail&logoColor=black" />
</a>

<h1> Pós-graduação - Desenvolvimento Web Full Stack <br> Back-End JAVA </h1>
</div>

Projeto desenvolvido a partir do repositorio base para obtenção de nota na pós graduação em Desenvolvimento Web na disciplina Desenvolvimento Back end com Java. 

## Tasks
### 1 - Criar CRUD para entidade Clube contendo as seguintes informações.

```
Id: integer 
Nome : String
Estado: String
Email: String
Cnpj: String
DataCriacao: Date
```

### 2 - Validação de campos
```
- Validar se o e-mail, CNPJ são válidos.
- Não permitir a inclusão de campos em branco.
- Criar um custon validator que não permita incluir no nome do clube a lista de palavras
  (Flamengo, Palmeiras, Fluminense, Botafogo)
```

### 3 - Integração
```
Criar uma integração com um serviço externo da escolha do time utilizando Feing.
```
Aqui foi utilizado a API Pública - Consultando CNPJ, Nela é possível fazer consultas de um CNPJ utilizando o método GET. Ponto negativo é que só
aceita 3 consultas por minuto. 
### 4 - Controle do que é enviado ao usuário
```
Incluir dtos para todas as entidades anotadas com Entity, ou seja, nos controllers
o que é respondido response para o usuário é sempre um dtos
```
### 5 - Listagem ascendente
```
Criar uma chamada no repository de clube uma listagem que ordene pelo nome do clube de forma ascendente.
```

