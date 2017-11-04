API CRUD REST

Segue um exemplo de uma API padrão REST para utilizar um CRUD de Cliente e Produto. 
Aqui estou utilizando tecnologia Spring, com JPA, Maven e na parte de gerenciamento do banco de dados o MySql.
Para fazer os testes de como ela está sendo consumida estou utilizando o Postman, 
que simula muito bem o cadastro e retorno de um JSON com as informações relacionadas com as duas tabelas.

Então vamos lá, primeiramente baixe o projeto e descompacte o mesmo dentro do workspace do Eclipse(ou IDE de sua preferencia), 
dentro da IDE importe ele como um projeto Maven existente. 
Antes de iniciar a aplicação abra o MySql WorkBench e crie um novo schema com o nome de mobile_service_db,
e pronto, agora a aplicação já pode ser iniciada clicando com o botão direito na pasta
principal do projeto(mobile-webservice), "run as" e "Spring Boot App". 

Note agora que dentro do WorkBench já foram criadas as tabelas "client" e "product". 
Agora chegou a hora de usar o Postman para popular essas duas tabelas. 

Como exemplo vamos utilizar a tabela "client", pois o procedimento é o mesmo para a outra tabela, ou qualquer
uma que deseje criar.

Abra o Postman, e crie uma nova requisição POST com o endereço "http://localhost:8080/customer", note que o  
"end point" que estou usando é "/customer", mas isso voce pode dar o nome que achar mais conveniente. Clique em "Body", depois marque a 
opção "Raw" e selecione o tipo "JSON(application/json)". No campo de entrada de dados crie um novo JSON como no exemplo: 
{
    
"name" : "Batman",
	
"address" : "Unknown",
	
"email" : "batman@hotbat.com",
	
"city" : "Gothan City",
	
"state" : "NJ",
	
"country" : "USA",
	
"active" : true

}

Perceba que todos os atributos que passamos na classe Client.java(package com.leporonitech.model) estão presentes.
Agora clique em "Send" e note que no canto inferior direito no Postman o status "201 Created" apareceu, isso quer
dizer que populamos essa tabela "client" com esse objeto. 

Chegou a hora de vermos se vai retornar mesmo. 
Onde está escrito POST, clique e mude para GET, e altere o endereço para "http://localhost:8080/customers", 
e aperte novamente no "Send". Veja que nos retornou todos os dados que cadastramos antes e agora com o campo 
"id" : 1, ou seja, ele gerou automaticamente o id necessário, e o "Status 200 OK" dizendo que tudo deu certo. 
Veja também no WorkBench que os dados estão salvos no banco de dados criado, no caso o "mobile_service_db", na tabela "client".

OBS: Como estou usando o "spring.jpa.hibernate.ddl-auto=create-drop", quando reiniciar a aplicação os dados serão descartados, juntamente com as tabelas, para mante-los altere somente o trecho da linha acima "create-drop" para "update" em (src/main/resources/application.properties).

Se quiser alterar algum dado cadastrado, copie os dados junto com as chaves "{}" e mude para uma requisição PUT e digite o endereço "http://localhost:8080/customer", novamente vá em "Body", "Raw" e tipo de arquivo "JSON(application/json)". Altere algo e depois de um "Send". 
Novamente o "Status 200 OK" aparece, voltamos a requisição GET, e vemos que ele nos traz o registro já com as alterações feitas. Note que o campo "id" continua o mesmo. 

Caso tenhamos mais de um cadastro e quisermos que ele nos traga somente um, vamos utilizar o GET pelo id. No GET é só alterarmos o endereço para "http://localhost:8080/customer/1", ou o id que queira que seja buscado, aqui usamos o "/customer/1". Novamente o "Status 200 OK" indicando que tudo correu bem. 

Agora a ultima parte que é para deletarmos algum registro. Chame uma requisição DELETE e no endereço passe "http://localhost:8080/customer/1" (ou com o id que deseje apagar), e pronto, somente isso, após o "Send" o "Status 200 OK" é mostrado e quando voltamos ao GET, o registro que escolhemos apagar não consta mais na listagem. 



